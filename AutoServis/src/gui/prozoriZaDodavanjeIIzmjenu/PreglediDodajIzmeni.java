package gui.prozoriZaDodavanjeIIzmjenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import autoServis.AutoServis;
import enumeracije.StatusServisa;
import net.miginfocom.swing.MigLayout;
import osnovneKlase.Administratori;
import osnovneKlase.Automobili;
import osnovneKlase.Delovi;
import osnovneKlase.Musterije;
import osnovneKlase.Serviseri;
import osnovneKlase.Servisi;
import osnovneKlase.ServisneKnjizice;
import radSaDatumima.RadSaDatumima;

public class PreglediDodajIzmeni extends JFrame {
	private JLabel lblID = new JLabel("ID");
	private JTextField txtID = new JTextField(10);
	private JLabel lblAutomobil = new JLabel("Automobil");
	private JComboBox<Integer> cbAutomobil = new JComboBox<Integer>();
	private JLabel lblServiser = new JLabel("Serviser");
	private JComboBox<Integer> cbServiser = new JComboBox<Integer>();
	private JLabel lblTermin = new JLabel("Termin");
	private JTextField txtTermin = new JTextField(15);
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblDelovi = new JLabel("Delovi");
	private JTextField txtDelovi = new JTextField(20);
	private JLabel lblStatus = new JLabel("Status");
	private JTextField txtStatus = new JTextField(10);
	private JLabel lblCena = new JLabel("Cena");
	private JTextField txtCena = new JTextField(10);
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnOtkazi = new JButton("Otkazi");
	
	private Servisi servis;
	private AutoServis autoServis;
	private Musterije musterija;
	private Serviseri serviser;
	private Administratori admin;
	
	public PreglediDodajIzmeni(AutoServis autoServis, Servisi servis, Musterije musterija) {
		this.autoServis = autoServis;
		this.servis = servis;
		this.musterija = musterija;
		
		
		if(this.servis == null) {
			setTitle("Dodavanje pregleda: " + musterija.getKorisnickoIme());
		}else {
			setTitle("Izmena podataka - " + this.servis.getId());

		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
		pack();
		
	}
	
	public PreglediDodajIzmeni(AutoServis autoServis, Servisi servis, Serviseri serviser) {
		this.autoServis = autoServis;
		this.servis = servis;
		this.serviser = serviser;
		
		
		if(this.servis == null) {
			setTitle("Dodavanje pregleda" + serviser.getKorisnickoIme());
		}else {
			setTitle("Izmena podataka - " + this.servis.getId());

		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
		pack();
		
	}
	public PreglediDodajIzmeni(AutoServis autoServis, Servisi servis, Administratori admin) {
		this.autoServis = autoServis;
		this.servis = servis;
		this.admin = admin;
		
		
		if(this.servis == null) {
			setTitle("Dodavanje pregleda" + admin.getKorisnickoIme());
		}else {
			setTitle("Izmena podataka - " + this.servis.getId());

		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
		pack();
		
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2");
		setLayout(layout);
		
		if(this.servis != null) {
			popuniPolja();
		}
		if(musterija != null) {
			for(Automobili auto:autoServis.getAutomobili()) {
				if(auto.getVlasnik().equals(auto.getVlasnik())) {
					cbAutomobil.addItem(auto.getId());
				}
			}
			add(lblID);
			add(txtID);
			add(lblAutomobil);
			add(cbAutomobil);
			add(lblOpis);
			add(txtOpis);
			add(new JLabel());
			add(btnOtkazi);
			add(btnOk, "split");
			add(btnCancel);
			if(servis == null) {
				btnOtkazi.setVisible(false);
			}
			else {
				cbAutomobil.setEnabled(false);
				txtOpis.setEditable(false);
				btnOk.setVisible(false);
				txtID.setEditable(false);
			}
		}
		else if(serviser != null){
			for(ServisneKnjizice knjiga:autoServis.getServisneKnjizice()) {			
				cbAutomobil.addItem(knjiga.getId());
			}
		}
		else {
			for(Automobili auto:autoServis.getAutomobili()) {			
				cbAutomobil.addItem(auto.getId());
			}
			for(Serviseri serv:autoServis.getServiseri()) {
				cbServiser.addItem(serv.getId());
				}
		}
		
			add(lblID);
			add(txtID);
			add(lblAutomobil);
			add(cbAutomobil);
			add(lblServiser);
			add(cbServiser);
			add(lblTermin);
			add(txtTermin);
			add(lblOpis);
			add(txtOpis);
			add(lblDelovi);
			add(txtDelovi);
			add(lblStatus);
			add(txtStatus);
			add(lblCena);
			add(txtCena);
            add(new JLabel());
			
			add(btnOk, "split");
			add(btnCancel);
			
			if(servis == null) {
				cbServiser.setEnabled(false);
				txtStatus.setEditable(false);
			}
		}
	private void initActions() {
		btnOtkazi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				servis.setStatus(StatusServisa.OTKAZAN);
				PreglediDodajIzmeni.this.dispose();
				PreglediDodajIzmeni.this.setVisible(false);
				autoServis.snimiServise();
			}
		});
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(musterija != null) {
					if(validacijaMusterija()) {
						int id = Integer.parseInt(txtID.getText());
						Automobili automobil = autoServis.pronadjiAutomobil(cbAutomobil.getSelectedItem().toString());
						String opis = txtOpis.getText();
						if(servis == null) {
							Servisi servis = new Servisi(id,automobil, opis);
							autoServis.dodajServis(servis);
						}
						PreglediDodajIzmeni.this.dispose();
						PreglediDodajIzmeni.this.setVisible(false);
						autoServis.snimiServise();					
					}
				}
				if(serviser != null) {
					if(validacija()) {
						int id = Integer.parseInt(txtID.getText());
						Automobili automobil = autoServis.nadjiAutoPrekoKnjizice(cbAutomobil.getSelectedItem().toString());
						Serviseri servisera = serviser;
						GregorianCalendar termin = RadSaDatumima.stringUDatum(txtTermin.getText());
						String opis = txtOpis.getText();
						String delovi = txtDelovi.getText();
						String[] deloviSPlit = delovi.split(",");
						ArrayList<Delovi> deo = new ArrayList<Delovi>();
						for (String sif : deloviSPlit) {
							Delovi k = autoServis.nadjiDeo(sif);
							if(k != null) {
								deo.add(k);
							}
						}
						StatusServisa status = StatusServisa.ZAKAZAN;
						double cena = Double.parseDouble(txtCena.getText());
						if(servis == null) {
							Servisi servis = new Servisi(id, automobil, servisera, termin, opis, deo, status, cena, false);
							System.out.println(servis);
							autoServis.dodajServis(servis);
						}
						PreglediDodajIzmeni.this.dispose();
						PreglediDodajIzmeni.this.setVisible(false);
						System.out.println(autoServis.getServisi());
//						autoServis.snimiServise();	
					}
					
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PreglediDodajIzmeni.this.dispose();
				PreglediDodajIzmeni.this.setVisible(false);
				
			}
		});
	}
	private void popuniPolja() {
		if(musterija != null) {
			txtID.setText(String.valueOf(this.servis.getId()));
			cbAutomobil.setSelectedItem(this.servis.getAutomobil());
			txtOpis.setText(this.servis.getOpis());
			txtStatus.setText(String.valueOf(this.servis.getStatus()));
		}
		else {
			txtID.setText(String.valueOf(this.servis.getId()));
			cbAutomobil.setSelectedItem(this.servis.getAutomobil());
			cbServiser.setSelectedItem(this.servis.getServiser());
			txtTermin.setText(RadSaDatumima.datumUString(this.servis.getTermin()));
			txtOpis.setText(this.servis.getOpis());
			txtDelovi.setText(autoServis.deloviUString(this.servis.getDelovi()));
			txtStatus.setText(String.valueOf(this.servis.getStatus()));
			txtCena.setText(String.valueOf(this.servis.getCena()));
		}
	}
	private boolean validacijaMusterija() {
		Boolean ispravno = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ispravno = false;
		}else if(servis == null) {
		String id = txtID.getText().trim();
		Servisi pronadjen = autoServis.pronadjiServis(id);
		if(pronadjen != null) {
			poruka += "- Servis sa unetim ID vec postoji\n";
			ispravno = false;
		}
	}
		if(txtOpis.getText().trim().equals("")){
			poruka += "Morate uneti opis";
			ispravno = false;
		}
		if(ispravno == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ispravno;
	}
	private boolean validacija() {
		Boolean ispravno = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ispravno = false;
		}else if(servis == null) {
			String id = txtID.getText().trim();
			Servisi pronadjen = autoServis.pronadjiServis(id);
			if(pronadjen != null) {
				poruka += "- Servis sa unetim ID vec postoji\n";
				ispravno = false;
			}
		}
		GregorianCalendar datum = new GregorianCalendar();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
		datum.setTime(formatter.parse(txtTermin.getText()));
		} catch (ParseException e) {
		poruka += "- Unesite datum u formatu dd.MM.yyyy";
		ispravno = false;
		}
//		GregorianCalendar datumUnos = RadSaDatumima.stringUDatum(txtTermin.getText());
//		if(datumUnos.before(datum)) {
//			poruka += "Datum ne moze biti stariji od danas";
//			ispravno = false;
//		}
		if(txtCena.getText().trim().equals("")) {
			poruka += "Morate uneti cenu";
			ispravno = false;
		}
		try {
			Double.parseDouble(txtCena.getText());
		}catch(Exception e){
			poruka += "Morate uneti cenu";
			ispravno = false;
		}
		if(txtOpis.getText().trim().equals("")){
			poruka += "Morate uneti opis";
			ispravno = false;
		}
		if(ispravno == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ispravno;
	}
	
}
