package radSaFajlovima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;



import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import enumeracije.Pol;
import enumeracije.Specijalizacija;
import enumeracije.StatusServisa;
import enumeracije.VrstaGoriva;
import osnovneKlase.Administratori;
import osnovneKlase.Automobili;
import osnovneKlase.Delovi;
import osnovneKlase.Musterije;
import osnovneKlase.Serviseri;
import osnovneKlase.Servisi;
import osnovneKlase.ServisneKnjizice;
import radSaDatumima.RadSaDatumima;
public class RadSaFajlovima {
	private ArrayList<Administratori> administratori;
	private ArrayList<Musterije> musterije;
	private ArrayList<Serviseri> serviseri;
	private ArrayList<Automobili> automobili;
	private ArrayList<Delovi> delovi;
	private ArrayList<ServisneKnjizice> servisneKnjizice;
	private ArrayList<Servisi> servisi;
	

//---------------------------Konstruktor----------------------------------//
	public RadSaFajlovima() {
		administratori = new ArrayList<Administratori>();
		musterije = new ArrayList<Musterije>();
		serviseri = new ArrayList<Serviseri>();
		automobili = new ArrayList<Automobili>();
		delovi = new ArrayList<Delovi>();
		servisneKnjizice = new ArrayList<ServisneKnjizice>();
		servisi = new ArrayList<Servisi>();
		
		}
//---------------------------Pomocne metode----------------------------------//
	public  Musterije odrediVlasnika(String vlasnik) {
		for(Musterije el:musterije) {
			if(el.getId() == Integer.parseInt(vlasnik)) {
				return  el;
			}
		}
		return null;
	}
	
	public Automobili pronadjiAutomobil(String automobil) {
		for(Automobili el:automobili) {
			if(el.getId() == Integer.parseInt(automobil)) {
				return el;
			}
		}
		return null;
	}
	public Serviseri pronadjiServisera(String serviserId) {
		for(Serviseri serviser:serviseri) {
			if(serviser.getId() == Integer.parseInt(serviserId)) {
				return serviser;
			}
		}
		return null;
	}
	public Servisi nadjiServis(String id) {
		ucitajServise();
		for (Servisi servis : servisi) {
			if(servis.getId() == Integer.parseInt(id)) {
				servisi.clear();
				return servis;
				
			}
		}
		
		return null;
	}
	public Delovi nadjiDeo(String id) {
		for (Delovi deo : delovi) {
			if(deo.getId() == Integer.parseInt(id)) {
				return deo;
			}
		}
		return null;
	}
	public Automobili nadjiAutoPrekoKnjizice(String id) {
		for (ServisneKnjizice knjiga : servisneKnjizice) {
			if(knjiga.getAutomobil().getId() == Integer.parseInt(id)) {
				return knjiga.getAutomobil();
			}
		}
		return null;
	}
	public String deloviUString(ArrayList<Delovi> delovi) {
		String sadrzaj = "";
		for(int i = 0;i<delovi.size();i++) {
			if(i != delovi.size() -1) {
				sadrzaj += delovi.get(i).getId() + ";";
			}
			else {
				sadrzaj += delovi.get(i).getId();
			}
		}
		return sadrzaj;
	}
	public String serviseUString(ArrayList<Servisi> servisi) {
		String sadrzaj = "";
		for(int i = 0;i<servisi.size();i++) {
			if(i != servisi.size() -1) {
				sadrzaj += servisi.get(i).getId() + ";";
			}
			else {
				sadrzaj += servisi.get(i).getId();
			}
		}
		return sadrzaj;
	}
	public static String ucitajSadrzaj(String putanja) {
		String sadrzaj = "";
		try {
			File file = new File(putanja);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				sadrzaj += line + "\n";
			}
			reader.close();
		}catch(IOException e) {
			System.out.println("Greska prilikom citanja datoteke " + putanja);
		}
		return sadrzaj;
	}
//---------------------------Ucitavanje/Upis----------------------------------//
	public void ucitajAdministratore() {
		try {
			File file = new File("fajlovi/administratori");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] linija = line.split("\\|"); 
				int id = Integer.parseInt(linija[0]);
				String ime = linija[1];
				String prezime = linija[2];
				String jmbg = linija[3];
				Pol pol = Pol.valueOf(linija[4]);
				String adresa = linija[5];
				String  brojTelefona = linija[6];		
				String korisnickoIme = linija[7];
				String lozinka = linija[8];
				double plata = Double.parseDouble(linija[9]);			
				Administratori administrator = new Administratori(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata);
				this.administratori.add(administrator);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiAdministratore() {
		String prethodniSadrzaj = ucitajSadrzaj("fajlovi/administratori");
		String sadrzaj = "";
		for(Administratori admin:this.administratori) {
			sadrzaj += admin.getId() + "|" + admin.getIme() + "|" + admin.getPrezime() + "|" + admin.getJmbg() + "|" + admin.getPol() + "|"+
					admin.getAdresa() + "|"+ admin.getBrojTelefona() + "|"+ admin.getKorisnickoIme() + "|"+ admin.getLozinka() + "|" + admin.getPlata() + "\n"; 
		}
		System.out.println(prethodniSadrzaj);
		try {
			File korisniciFile = new File("fajlovi/administratori");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(prethodniSadrzaj + sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void ucitajMusterije() {
		try {
			File file = new File("fajlovi/musterije");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] linija = line.split("\\|"); 
				int id = Integer.parseInt(linija[0]);
				String ime = linija[1];
				String prezime = linija[2];
				String jmbg = linija[3];
				Pol pol = Pol.valueOf(linija[4]);
				String adresa = linija[5];
				String  brojTelefona = linija[6];
				String korisnickoIme = linija[7];
				String lozinka = linija[8];
				int nagradniBodovi = Integer.parseInt(linija[9]);
				Musterije musterija = new Musterije(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, nagradniBodovi);
				this.musterije.add(musterija);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiMusterije() {
		String prethodniSadrzaj = ucitajSadrzaj("fajlovi/musterije");
		String sadrzaj = "";
		for(Musterije musterija:this.musterije) {
			sadrzaj += musterija.getId() + "|" + musterija.getIme() + "|" + musterija.getPrezime() + "|" + musterija.getJmbg() + "|" + musterija.getPol() + "|"+
					musterija.getAdresa() + "|"+ musterija.getBrojTelefona() + "|"+ musterija.getKorisnickoIme() + "|"+ musterija.getLozinka() + "|" + 
					musterija.getNagradniBodovi() + "\n"; 
		}
		System.out.println(prethodniSadrzaj);
		try {
			File korisniciFile = new File("fajlovi/musterije");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(prethodniSadrzaj + sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void ucitajServisere() {
		try {
			File file = new File("fajlovi/serviseri");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] linija = line.split("\\|"); 
				int id = Integer.parseInt(linija[0]);
				String ime = linija[1];
				String prezime = linija[2];
				String jmbg = linija[3];
				Pol pol = Pol.valueOf(linija[4]);
				String adresa = linija[5];
				String  brojTelefona = linija[6];
				String korisnickoIme = linija[7];
				String lozinka = linija[8];
				Specijalizacija specijalizacija = Specijalizacija.valueOf(linija[10]);
				double plata = Double.parseDouble(linija[9]);
				Serviseri serviser = new Serviseri(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata, specijalizacija);
				this.serviseri.add(serviser);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiServisere() {
		String prethodniSadrzaj = ucitajSadrzaj("fajlovi/serviseri");
		String sadrzaj = "";
		for(Serviseri serviser:this.serviseri) {
			sadrzaj += serviser.getId() + "|" + serviser.getIme() + "|" + serviser.getPrezime() + "|" + serviser.getJmbg() + "|" + serviser.getPol() + "|"+
					serviser.getAdresa() + "|"+ serviser.getBrojTelefona() + "|"+ serviser.getKorisnickoIme() + "|"+ serviser.getLozinka() + "|" + 
					serviser.getPlata() + "|" + serviser.getSpecijalizacija() + "\n"; 
		}
		System.out.println(prethodniSadrzaj);
		try {
			File korisniciFile = new File("fajlovi/serviseri");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(prethodniSadrzaj + sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void ucitajAutomobile() {
		try {
			File file = new File("fajlovi/automobili");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] linija = line.split("\\|"); 
				int id = Integer.parseInt(linija[0]);
				Musterije vlasnik = odrediVlasnika(linija[1]);
				MarkaAutomobila marka = MarkaAutomobila.valueOf(linija[2].toUpperCase());
				ModelAutomobila model = ModelAutomobila.valueOf(linija[3].toUpperCase());
				GregorianCalendar godinaProizvodnje = RadSaDatumima.stringUDatum(linija[4]);
				double zapreminaMotora = Double.parseDouble(linija[5]);
				int snagaMotora = Integer.parseInt(linija[6]);
				VrstaGoriva vrstaGoriva = VrstaGoriva.valueOf(linija[7].toUpperCase());
			    Automobili automobil = new Automobili(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva);
			    this.automobili.add(automobil);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiAutomobile() {
		String prethodniSadrzaj = ucitajSadrzaj("fajlovi/automobili");
		String sadrzaj = "";
		for(Automobili automobil:this.automobili) {
			sadrzaj += automobil.getId() + "|" + automobil.getVlasnik().getId() + "|" + automobil.getMarka() +  "|" + automobil.getModel() + "|" +
					RadSaDatumima.datumUString(automobil.getGodinaProizvodnje())  + "|" +
					automobil.getZapreminaMotora() + "|" + automobil.getSnagaMotora() + "|" + automobil.getVrstaGoriva(); 
		}
		System.out.println(prethodniSadrzaj);
		try {
			File korisniciFile = new File("fajlovi/automobili");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(prethodniSadrzaj + sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void ucitajServisneKnjizice() {
		try {
			File file = new File("fajlovi/servisneKnjizice");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] linija = line.split("\\|"); 
				int id = Integer.parseInt(linija[0]);
				Automobili automobil = pronadjiAutomobil(linija[1]);
				if(linija.length == 2) {
					ServisneKnjizice servisnaKnjiga = new ServisneKnjizice(id, automobil);
					servisneKnjizice.add(servisnaKnjiga);
				}
				else {
					String servisi = linija[2];
					String[] servisiSplit = servisi.split(";");
					ArrayList<Servisi> serv = new ArrayList<Servisi>();
					for (String sif : servisiSplit) {
						Servisi k = nadjiServis(sif);
						if(k != null) {
							serv.add(k);
						}
					}
					ServisneKnjizice servisnaKnjiga = new ServisneKnjizice(id, automobil,serv);
					servisneKnjizice.add(servisnaKnjiga);	
				}
			
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiServisneKnjizice() {
		String prethodniSadrzaj = ucitajSadrzaj("fajlovi/servisneKnjizice");
		String sadrzaj = "";
		for(ServisneKnjizice knjiga:this.servisneKnjizice) {
			if(knjiga.getServisi().isEmpty()) {
				sadrzaj += knjiga.getId() + "|" + knjiga.getAutomobil().getId() + "\n";
			}
			else {
				sadrzaj += knjiga.getId() + "|" + knjiga.getAutomobil().getId() + "|" + serviseUString(knjiga.getServisi()) + "\n";
			}
		}
		System.out.println(prethodniSadrzaj);
		try {
			File korisniciFile = new File("fajlovi/servisneKnjizice");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(prethodniSadrzaj + sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void ucitajDelove() {
		try {
			File file = new File("fajlovi/delovi");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] linija = line.split("\\|"); 
				int id = Integer.parseInt(linija[0]);
				String naziv = linija[1];
				double cena = Double.parseDouble(linija[2]);
				MarkaAutomobila markaAutomobila = MarkaAutomobila.valueOf(linija[3].toUpperCase());
				ModelAutomobila modelAutomobila = ModelAutomobila.valueOf(linija[4].toUpperCase());
				Delovi deo = new Delovi(id, naziv, cena, markaAutomobila, modelAutomobila);
				this.delovi.add(deo);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiDelove() {
		String prethodniSadrzaj = ucitajSadrzaj("fajlovi/delovi");
		String sadrzaj = "";
		for(Delovi deo:this.delovi) {
			sadrzaj += deo.getId() + "|" + deo.getNaziv() + "|" + deo.getCena() + "|" + deo.getMarkaAutomobila() + "|" + deo.getModelAutomobila() + "|"+ "\n";
		}
		System.out.println(prethodniSadrzaj);
		try {
			File korisniciFile = new File("fajlovi/delovi");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(prethodniSadrzaj + sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	public void ucitajServise() {
		try {
			File file = new File("fajlovi/servisi");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] linija = line.split("\\|"); 
				int id = Integer.parseInt(linija[0]);
				Automobili automobil = nadjiAutoPrekoKnjizice(linija[1]);
				Serviseri serviser = pronadjiServisera(linija[2]);
				GregorianCalendar termin = RadSaDatumima.stringUDatum(linija[3]);
				String opis = linija[4];
				String delovi = linija[5];
				String[] deloviSPlit = delovi.split(";");
				ArrayList<Delovi> deo = new ArrayList<Delovi>();
				for (String sif : deloviSPlit) {
					Delovi k = nadjiDeo(sif);
					if(k != null) {
						deo.add(k);
					}
			}
				StatusServisa status = StatusServisa.valueOf(linija[6].toUpperCase());
				Servisi servis = new Servisi(id, automobil, serviser, termin, opis, deo, status);
				servisi.add(servis);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiServise() {
		String prethodniSadrzaj = ucitajSadrzaj("fajlovi/servisi");
		String sadrzaj = "";
		for(Servisi servis:this.servisi) {
			sadrzaj += servis.getId() + "|" +  servis.getAutomobil().getId() + "|" +  servis.getServiser().getId() + "|" + 
					RadSaDatumima.datumUString(servis.getTermin())  + "|" + servis.getOpis() + "|" + deloviUString(servis.getDelovi()) + "|" +  servis.getStatus(); 
		}
		System.out.println(prethodniSadrzaj);
		try {
			File korisniciFile = new File("fajlovi/servisi");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(prethodniSadrzaj + sadrzaj);
			writer.close();
		}catch(IOException e){
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}

//---------------------------geteri i seteri----------------------------------//
	public ArrayList<Administratori> getAdministratori() {
		return administratori;
	}

	public void setAdministratori(ArrayList<Administratori> administratori) {
		this.administratori = administratori;
	}

	public ArrayList<Musterije> getMusterije() {
		return musterije;
	}

	public void setMusterije(ArrayList<Musterije> musterije) {
		this.musterije = musterije;
	}

	public ArrayList<Serviseri> getServiseri() {
		return serviseri;
	}

	public void setServiseri(ArrayList<Serviseri> serviseri) {
		this.serviseri = serviseri;
	}

	public ArrayList<Automobili> getAutomobili() {
		return automobili;
	}

	public void setAutomobili(ArrayList<Automobili> automobili) {
		this.automobili = automobili;
	}

	public ArrayList<Delovi> getDelovi() {
		return delovi;
	}

	public void setDelovi(ArrayList<Delovi> delovi) {
		this.delovi = delovi;
	}

	public ArrayList<Servisi> getServisi() {
		return servisi;
	}

	public void setServisi(ArrayList<Servisi> servisi) {
		this.servisi = servisi;
	}

	public ArrayList<ServisneKnjizice> getServisneKnjizice() {
		return servisneKnjizice;
	}

	public void setServisneKnjizice(ArrayList<ServisneKnjizice> servisneKnjizice) {
		this.servisneKnjizice = servisneKnjizice;
	}
	
}
