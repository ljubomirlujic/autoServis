package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import autoServis.AutoServis;
import gui.prozoriZaPrikaz.ServisiPrikaz;
import osnovneKlase.Administratori;
import osnovneKlase.Musterije;
import osnovneKlase.Serviseri;



public class GlavniProzor extends JFrame {
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu prikazMeni = new JMenu("Prikaz");
	private JMenuItem adminiItem = new JMenuItem("Pregled administratori");
	private JMenuItem serviseriItem = new JMenuItem("Pregled serviseri");
	private JMenuItem musterijeItem = new JMenuItem("Pregled musterije");
	private JMenuItem automobiliItem = new JMenuItem("Pregled automobili");
	private JMenuItem knjiziceItem = new JMenuItem("Pregled knjizice");
	private JMenuItem deloviItem = new JMenuItem("Pregled delovi");
	private JMenuItem servisiItem = new JMenuItem("Pregled servisa");
	
	private AutoServis autoServis;
	private Musterije musterija;
	private Serviseri serviser;
	private Administratori admin;
	
	public GlavniProzor(AutoServis autoServis, Musterije musterija) {
		this.autoServis = autoServis;
		this.musterija = musterija;
		setTitle("Auto Servis(Korisnik: " + musterija.getKorisnickoIme() + ")");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
		
	}
	public GlavniProzor(AutoServis autoServis, Administratori admin) {
		this.autoServis = autoServis;
		this.admin = admin;
		setTitle("Auto Servis(Korisnik: " + admin.getKorisnickoIme() + ")");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
		
	}
	public GlavniProzor(AutoServis autoServis, Serviseri serviser) {
		this.autoServis = autoServis;
		this.serviser = serviser;
		setTitle("Auto Servis(Korisnik: " + serviser.getKorisnickoIme() + ")");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
		
	}
	
	private void initGUI() {
		if(this.musterija != null || this.serviser != null) {
			setJMenuBar(mainMenu);
			mainMenu.add(prikazMeni);
			prikazMeni.add(servisiItem);
		}
		else if(this.admin !=null) {
			setJMenuBar(mainMenu);
			mainMenu.add(prikazMeni);
			prikazMeni.add(adminiItem);
			prikazMeni.add(serviseriItem);
			prikazMeni.add(musterijeItem);
			prikazMeni.add(automobiliItem);
			prikazMeni.add(knjiziceItem);
			prikazMeni.add(deloviItem);
			prikazMeni.add(servisiItem);
		}
		
	}
	private void initActions() {
		servisiItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(musterija != null) {
					ServisiPrikaz sp = new ServisiPrikaz(autoServis, musterija);
					sp.setVisible(true);
				}else if(serviser != null) {
					ServisiPrikaz sp = new ServisiPrikaz(autoServis, serviser);
					sp.setVisible(true);
				}
				else {
					ServisiPrikaz sp = new ServisiPrikaz(autoServis, admin);
					sp.setVisible(true);
				}
			}
		});
		
	}
}
