package gui.prozoriZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import autoServis.AutoServis;
import enumeracije.StatusServisa;
import gui.prozoriZaDodavanjeIIzmjenu.PreglediDodajIzmeni;
import osnovneKlase.Administratori;
import osnovneKlase.Automobili;
import osnovneKlase.Delovi;
import osnovneKlase.Musterije;
import osnovneKlase.Osoba;
import osnovneKlase.Serviseri;
import osnovneKlase.Servisi;
import radSaDatumima.RadSaDatumima;

public class ServisiPrikaz extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnIzmeni = new JButton();
	private JButton btnObrisi = new JButton();
	private DefaultTableModel tableModel;
	private JTable servisiTabela;
	private AutoServis autoServis;
	private Musterije musterija;
	private Serviseri serviser;
	private Administratori admin;
	private String ulogovan;
	public  ServisiPrikaz(AutoServis autoServis, Musterije musterija) {
		this.autoServis = autoServis;
		this.musterija = musterija;
		this.ulogovan = "musterija";
		setTitle("Servisi prikaz");
		setSize(500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		initActions();
		
	}
	public  ServisiPrikaz(AutoServis autoServis, Serviseri serviser) {
		this.autoServis = autoServis;
		this.serviser = serviser;
		ulogovan = "serviser";
		setTitle("Servisi prikaz");
		setSize(500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		initActions();
	}
	public  ServisiPrikaz(AutoServis autoServis, Administratori admin) {
		this.autoServis = autoServis;
		this.admin= admin;
		ulogovan = "admin";
		setTitle("Servisi prikaz");
		setSize(500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initGUI();
		initActions();
	}
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon izmjeniIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnIzmeni.setIcon(izmjeniIcon);
		ImageIcon obrisiIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnObrisi.setIcon(obrisiIcon);
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnIzmeni);
		mainToolbar.add(btnObrisi);
		add(mainToolbar, BorderLayout.NORTH);
		if(musterija != null) {
			btnObrisi.setVisible(false);
		}
		ArrayList<Servisi> servisim = new ArrayList<Servisi>();
		for(Servisi serv: autoServis.getServisi()) {
			if(this.musterija !=null && serv.getAutomobil().getVlasnik().equals(musterija) && !serv.isObrisan()) {
				servisim.add(serv);
			}
			else if(this.serviser != null && serv.getServiser() != null && serv.getServiser().equals(serviser) &&!serv.isObrisan()) {
				servisim.add(serv);
			}
			else if(this.admin != null && !serv.isObrisan()){
				servisim.add(serv);
			}
		}
//		int id, Automobili automobil, Serviseri serviser, GregorianCalendar termin, String opis,ArrayList<Delovi> delovi, StatusServisa status, boolean obrisan
		String[] zaglavlja = new String[] {"ID", "Auto ID", "Serviser", "Termin", "Opis","Delovi","Cena","Status"};
		Object[][] sadrzaj = new Object[servisim.size()][zaglavlja.length];
		
		int i = 0;
		for (Servisi serv : servisim) {
			if(serv.getServiser() != null) {
				sadrzaj[i][0] = serv.getId();
				sadrzaj[i][1] = serv.getAutomobil().getId();
				sadrzaj[i][2] = serv.getServiser().getIme();
				sadrzaj[i][3] = RadSaDatumima.datumUString(serv.getTermin());
				sadrzaj[i][4] = serv.getOpis();
				sadrzaj[i][5] = autoServis.deloviUStringNaziv(serv.getDelovi());
				sadrzaj[i][6] = serv.getCena();
				sadrzaj[i][7] = serv.getStatus();
				i++;
			}
			else {
				sadrzaj[i][0] = serv.getId();
				sadrzaj[i][1] = serv.getAutomobil().getId();
				sadrzaj[i][2] = "";
				sadrzaj[i][3] =	"";
				sadrzaj[i][4] = serv.getOpis();
				sadrzaj[i][5] = "";
				sadrzaj[i][6] = "";
				sadrzaj[i][7] = serv.getStatus();
				i++;
			}
			
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		servisiTabela = new JTable(tableModel);
		
		servisiTabela.setRowSelectionAllowed(true);
		servisiTabela.setColumnSelectionAllowed(false);
		servisiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisiTabela.setDefaultEditor(Object.class, null);
		servisiTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(servisiTabela);
		add(scrollPane, BorderLayout.CENTER);		
		
	}
	private void initActions() {
		btnObrisi.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = servisiTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = servisiTabela.getValueAt(red, 0).toString();
					Servisi servis = autoServis.pronadjiServis(id);
					int izbor = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da obrisete servis?",
					servis.getId() + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						autoServis.obrisiServis(servis);
						tableModel.removeRow(red);
					}
				}
				
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ulogovan == "serviser") {
					PreglediDodajIzmeni pm = new PreglediDodajIzmeni(autoServis, null, serviser);
					pm.setVisible(true);
				}
				else if(ulogovan == "musterija") {
					PreglediDodajIzmeni pm = new PreglediDodajIzmeni(autoServis, null, musterija);
					pm.setVisible(true);
				}
				else{
					PreglediDodajIzmeni pm = new PreglediDodajIzmeni(autoServis, null, admin);
					pm.setVisible(true);
				}
			}
		});
		btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = servisiTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = servisiTabela.getValueAt(red, 0).toString();
					
					Servisi servis = autoServis.pronadjiServis(id);
					if(servis != null) {
						System.out.println(servis);
						if(ulogovan == "serviser") {
							PreglediDodajIzmeni pm = new PreglediDodajIzmeni(autoServis, servis, serviser);
							pm.setVisible(true);
						}
						else if(ulogovan == "musterija") {
							PreglediDodajIzmeni pm = new PreglediDodajIzmeni(autoServis, servis, musterija);
							pm.setVisible(true);
						}
						else{
							PreglediDodajIzmeni pm = new PreglediDodajIzmeni(autoServis, servis, admin);
							pm.setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci odabran pregled!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}
}
