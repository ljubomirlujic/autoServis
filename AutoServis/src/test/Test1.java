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
public class Test1 {
	

	public static void main(String[] args) {
		ArrayList<Administratori> administratori = new ArrayList<Administratori>();
		ArrayList<Musterije> musterije = new ArrayList<Musterije>();
		ArrayList<Serviseri> serviseri = new ArrayList<Serviseri>();
		ArrayList<Automobili> automobili = new ArrayList<Automobili>();
		ArrayList<ServisneKnjizice> servisneKnjizice = new ArrayList<ServisneKnjizice>();
		ArrayList<Servisi> servisi = new ArrayList<Servisi>();
		RadSaFajlovima fajloviUpisICitanje = new RadSaFajlovima();
		fajloviUpisICitanje.ucitajAdministratore();
		fajloviUpisICitanje.ucitajMusterije();
		fajloviUpisICitanje.ucitajServisere();
		fajloviUpisICitanje.ucitajAutomobile();
		fajloviUpisICitanje.ucitajDelove();
		fajloviUpisICitanje.ucitajServisneKnjizice();
		fajloviUpisICitanje.ucitajServise();
		fajloviUpisICitanje.ucitajServisneKnjizice();
		System.out.println(fajloviUpisICitanje.getAdministratori());
		System.out.println(fajloviUpisICitanje.getMusterije());
		System.out.println(fajloviUpisICitanje.getServiseri());
		System.out.println(fajloviUpisICitanje.getAutomobili());
		System.out.println(fajloviUpisICitanje.getDelovi());
		System.out.println(fajloviUpisICitanje.getServisneKnjizice());
		System.out.println(fajloviUpisICitanje.getServisi());
		System.out.println("\n");
		Administratori a1 = new Administratori(1, "pero", "peric", "3333333333", Pol.MUSKI, "BN", "4234244", "ljubo", "123", 1250.5);
		administratori.add(a1);
		fajloviUpisICitanje.setAdministratori(administratori);
		fajloviUpisICitanje.snimiAdministratore();
		
		Musterije m1 = new Musterije(0, "pero", "peric", "333333", Pol.MUSKI, "BN", "4234244", "pero", "123", 10);
		musterije.add(m1);
		fajloviUpisICitanje.setMusterije(musterije);
		fajloviUpisICitanje.snimiMusterije();
		
		Serviseri s1 = new Serviseri(0, "pero", "peric", "333333", Pol.MUSKI, "BN", "4234244", "pero", "123", 24.25, Specijalizacija.AUTO_MEHANICAR);
		serviseri.add(s1);
		fajloviUpisICitanje.setServiseri(serviseri);
		fajloviUpisICitanje.snimiServisere();
		
		Automobili at1 = new Automobili(0, m1, MarkaAutomobila.BMW, ModelAutomobila.BMW_320D, new GregorianCalendar(2000,2,15), 50, 50, VrstaGoriva.BENZIN);
		automobili.add(at1);
		fajloviUpisICitanje.setAutomobili(automobili);
		fajloviUpisICitanje.snimiAutomobile();
		
	    Delovi d1 = new Delovi(0, "remen", 22.54, MarkaAutomobila.BMW, ModelAutomobila.BMW_320D);
	    Delovi d2 = new Delovi(4, "remen", 22.54, MarkaAutomobila.BMW, ModelAutomobila.BMW_320D);
	    ArrayList<Delovi> delovi = new ArrayList<Delovi>();
	    delovi.add(d1);
	    delovi.add(d2);
	    fajloviUpisICitanje.setDelovi(delovi);
	    fajloviUpisICitanje.snimiDelove();
	    
	    Servisi se1 = new Servisi(0, at1, s1, new GregorianCalendar(2020,2,2), "dobar", delovi, StatusServisa.ZAKAZAN);
		servisi.add(se1);
		fajloviUpisICitanje.setServisi(servisi);
		fajloviUpisICitanje.snimiServise();
		ArrayList<Servisi> serv = new ArrayList<Servisi>();
		serv.add(se1);
		ServisneKnjizice knj = new ServisneKnjizice(0, at1,serv);
		servisneKnjizice.add(knj);
		fajloviUpisICitanje.setServisneKnjizice(servisneKnjizice);
		fajloviUpisICitanje.snimiServisneKnjizice();
		

//		
	}
}
