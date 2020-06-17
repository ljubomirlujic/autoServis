package main;

import autoServis.AutoServis;
import gui.LoginProzor;


public class ServisMain {

	public static void main(String[] args) {
		AutoServis autoServis = new AutoServis();
		autoServis.ucitajAdministratore();
		autoServis.ucitajMusterije();
		autoServis.ucitajServisere();
		autoServis.ucitajAutomobile();
		autoServis.ucitajDelove();
		autoServis.ucitajServisneKnjizice();
		autoServis.ucitajServise();
		System.out.println(autoServis.getServisi());
		LoginProzor lp = new LoginProzor(autoServis);
		lp.setVisible(true);

	}

}
