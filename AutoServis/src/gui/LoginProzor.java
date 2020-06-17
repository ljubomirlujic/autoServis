package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import autoServis.AutoServis;
import net.miginfocom.swing.MigLayout;
import osnovneKlase.Administratori;
import osnovneKlase.Musterije;
import osnovneKlase.Serviseri;
public class LoginProzor extends JFrame {

	private JLabel lblPozdrav = new JLabel("Dobrodosli.Molimo da se prijavite.");
	private JLabel lblKorsicnikoIme = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JButton btnPrijava = new JButton("Prijava");
	private JButton btnOtkazi = new JButton("Otkazi");
	
	private AutoServis autoServis;
	private Serviseri serviser;
	private Musterije musterija;
	private Administratori administrator;
	
	public LoginProzor(AutoServis autoServis) {
		this.autoServis = autoServis;
		setTitle("Prijava na sistem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	private void initGUI(){
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblPozdrav,"span 2");
		add(lblKorsicnikoIme);
		add(txtKorisnickoIme);
		add(lblLozinka);
		add(pfLozinka);
		add(new JLabel());
		add(btnPrijava, "split 2");
		add(btnOtkazi);
		
		txtKorisnickoIme.setText("uros");
		pfLozinka.setText("123");
		getRootPane().setDefaultButton(btnPrijava);
	}
	
	private void initActions(){
		btnOtkazi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
			}
		});
		
		btnPrijava.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnikoIme = txtKorisnickoIme.getText().trim();
				String lozinka = new String(pfLozinka.getPassword()).trim();
				
				if(korisnikoIme.equals("") || lozinka.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste unijeli sve podatke za prijavu.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					Serviseri prijavljenServiser = autoServis.prijavaServiser(korisnikoIme, lozinka);
					Administratori prijavljenAdmin = autoServis.prijavaAdmin(korisnikoIme, lozinka);
					Musterije prijavljenMusterija = autoServis.prijavaMusterija(korisnikoIme, lozinka);
					if(prijavljenServiser == null && prijavljenAdmin == null && prijavljenMusterija == null) {
						JOptionPane.showMessageDialog(null, "Pogresni podaci prijave.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else if(prijavljenMusterija != null){
						LoginProzor.this.dispose();
						LoginProzor.this.setVisible(false);
						GlavniProzor mp = new GlavniProzor(autoServis, prijavljenMusterija);
						mp.setVisible(true);
					}
					else if(prijavljenAdmin != null){
						LoginProzor.this.dispose();
						LoginProzor.this.setVisible(false);
						GlavniProzor mp = new GlavniProzor(autoServis, prijavljenAdmin);
						mp.setVisible(true);
					}
					else if(prijavljenServiser != null){
						LoginProzor.this.dispose();
						LoginProzor.this.setVisible(false);
						GlavniProzor mp = new GlavniProzor(autoServis, prijavljenServiser);
						mp.setVisible(true);
					}
				}

			}
		});
	}
}
