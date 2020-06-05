package test;



import java.util.ArrayList;
import java.util.GregorianCalendar;

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import enumeracije.Pol;
import enumeracije.Specijalizacija;
import enumeracije.StatusServisa;
import enumeracije.VrstaGoriva;
import radSaFajlovima.RadSaFajlovima;
import osnovneKlase.Administratori;
import osnovneKlase.Automobili;
import osnovneKlase.Delovi;
import osnovneKlase.Musterije;
import osnovneKlase.Serviseri;
import osnovneKlase.Servisi;
import osnovneKlase.ServisneKnjizice;
import radSaDatumima.RadSaDatumima;
public class Test1 {
	

	public static void main(String[] args) {		

		
		RadSaFajlovima fajloviUpisICitanje = new RadSaFajlovima();		
		fajloviUpisICitanje.ucitajAdministratore();
		fajloviUpisICitanje.ucitajMusterije();
		fajloviUpisICitanje.ucitajServisere();
		fajloviUpisICitanje.ucitajAutomobile();
		fajloviUpisICitanje.ucitajDelove();
		fajloviUpisICitanje.ucitajServisneKnjizice();
		fajloviUpisICitanje.ucitajServise();
		
//		System.out.println(fajloviUpisICitanje.getAdministratori());
//		System.out.println(fajloviUpisICitanje.getMusterije());
//		System.out.println(fajloviUpisICitanje.getServiseri());
//		System.out.println(fajloviUpisICitanje.getAutomobili());
//		System.out.println(fajloviUpisICitanje.getDelovi());
//		System.out.println(fajloviUpisICitanje.getServisneKnjizice());
//		System.out.println(fajloviUpisICitanje.getServisi());
//		System.out.println("\n");
		
	
//			Musterije m1 = new Musterije(0, "pero", "peric", "333333", Pol.MUSKI, "BN", "4234244", "pero", "123", 10, false); // Dodavanje
//			fajloviUpisICitanje.dodajMusteriju(m1);
//			fajloviUpisICitanje.snimiMusterije();		
//			Automobili at1 = new Automobili(0, m1, MarkaAutomobila.BMW, ModelAutomobila.BMW_320D, RadSaDatumima.stringUDatum("12.02.2000") , 50, 50, VrstaGoriva.BENZIN, false);
//			fajloviUpisICitanje.dodajAutomobil(at1);
//			fajloviUpisICitanje.snimiAutomobile();
//			
//			ServisneKnjizice knj = new ServisneKnjizice(0, at1,false);
//			fajloviUpisICitanje.dodajKnjizicu(knj);
//			fajloviUpisICitanje.snimiServisneKnjizice();
			
//			fajloviUpisICitanje.izmeniMusteriju(0, "Petar", "Petrovic", "333333", Pol.MUSKI, "BN", "4234244", "pero", "123", 10, false); // Izmjena
		
		
			Musterije musterija = fajloviUpisICitanje.odrediVlasnika("0");
			fajloviUpisICitanje.obrisiMusteriju(musterija); // Brisanje


	}
}


