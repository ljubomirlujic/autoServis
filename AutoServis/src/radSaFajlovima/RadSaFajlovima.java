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
//---------------------------metode----------------------------------//
	
	//-------------------------admini-------------------------------//
	public void dodajAdministratora(Administratori administrator) {
		this.administratori.add(administrator);
	}
	public void obrisiAdministratora(Administratori administrator) {
		administrator.setObrisan(true);
		snimiAdministratore();
		this.administratori.remove(administrator);
	}
	public void izmeniAdministratora(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			 String korisnickoIme, String lozinka, double plata,boolean obrisan) {
		for(Administratori admin: administratori) {
			if(admin.getId() == id) {
				admin.setIme(ime);
				admin.setPrezime(prezime);
				admin.setJmbg(jmbg);
				admin.setPol(pol);
				admin.setAdresa(adresa);
				admin.setBrojTelefona(brojTelefona);
				admin.setKorisnickoIme(korisnickoIme);
				admin.setLozinka(lozinka);
				admin.setPlata(plata);
				admin.setObrisan(obrisan);
			}
		}
		snimiAdministratore();
	}
	//---------------------------musterije---------------------------//
	public void dodajMusteriju(Musterije musterija) {  // dodavanje
		this.musterije.add(musterija);
		
	}
	public void obrisiMusteriju(Musterije musterija) { // brisanje
		musterija.setObrisan(true);
		snimiMusterije();
		for(Automobili auto: automobili) {
			if(auto.getVlasnik().equals(musterija)) {
				obrisiAutomobil(auto);
				break;
			}
		}
		this.musterije.remove(musterija);
	}
	public void izmeniMusteriju(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, int nagradniBodovi,boolean obrisan) { // izmjena	
		for(Musterije m: musterije) {
			if(m.getId() == id) {
				m.setIme(ime);
				m.setPrezime(prezime);
				m.setJmbg(jmbg);
				m.setPol(pol);
				m.setAdresa(adresa);
				m.setBrojTelefona(brojTelefona);
				m.setKorisnickoIme(korisnickoIme);
				m.setLozinka(lozinka);
				m.setNagradniBodovi(nagradniBodovi);
				m.setObrisan(obrisan);
			}
		}
		snimiMusterije();
	}
	//---------------------------serviseri---------------------------//
	public void dodajServisera(Serviseri serviser) {
		this.serviseri.add(serviser);
	}
	public void obrisiServisera(Serviseri serviser) {
		serviser.setObrisan(true);
		snimiServisere();
		this.serviseri.remove(serviser);
	}
	public void izmeniServisera(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, double plata, Specijalizacija specijalizacija,boolean obrisan) {
		for(Serviseri serv: serviseri) {
			if(serv.getId() == id) {
				serv.setIme(ime);
				serv.setPrezime(prezime);
				serv.setJmbg(jmbg);
				serv.setPol(pol);
				serv.setAdresa(adresa);
				serv.setBrojTelefona(brojTelefona);
				serv.setKorisnickoIme(korisnickoIme);
				serv.setLozinka(lozinka);
				serv.setPlata(plata);
				serv.setSpecijalizacija(specijalizacija);
				serv.setObrisan(obrisan);
			}
		}
		snimiServise();
	}
	//-------------------------automobili--------------------------//
	public void dodajAutomobil(Automobili automobil) {
		this.automobili.add(automobil);
		
	}
	public void obrisiAutomobil(Automobili automobil) {
		automobil.setObrisan(true);
		snimiAutomobile();
		for(ServisneKnjizice knjiga: servisneKnjizice) {
			if(knjiga.getAutomobil().equals(automobil)) {
				obrisiKnjizicu(knjiga);
				break;
			}
		}
		this.automobili.remove(automobil);
	}
	public void izmeniAutomobil(int id, Musterije vlasnik, MarkaAutomobila marka, ModelAutomobila model,
			GregorianCalendar godinaProizvodnje, double zapreminaMotora, int snagaMotora, VrstaGoriva vrstaGoriva,
			boolean obrisan) {
		for(Automobili auto: automobili) {
			if(auto.getId() == id) {
				auto.setVlasnik(vlasnik);
				auto.setMarka(marka);
				auto.setModel(model);
				auto.setGodinaProizvodnje(godinaProizvodnje);
				auto.setZapreminaMotora(zapreminaMotora);
				auto.setSnagaMotora(snagaMotora);
				auto.setVrstaGoriva(vrstaGoriva);
				auto.setObrisan(obrisan);
			}
		}
		snimiAutomobile();
	}
	//------------------------knjizice------------------------//
	public void dodajKnjizicu(ServisneKnjizice knjizica) {
		this.servisneKnjizice.add(knjizica);
	}
	public void obrisiKnjizicu(ServisneKnjizice knjizica) {
		knjizica.setObrisana(true);
		snimiServisneKnjizice();
		this.servisneKnjizice.remove(knjizica);
	}
	public void izmeniKnjizicu(int id, Automobili automobil, ArrayList<Servisi> servisi, boolean obrisana) {
		for(ServisneKnjizice knjiga: servisneKnjizice) {
			if(knjiga.getId() == id) {
				knjiga.setAutomobil(automobil);
				knjiga.setServisi(servisi);
				knjiga.setObrisana(obrisana);
			}
		}
	}
	//--------------------------Delovi------------------------//
	public void dodajDeo(Delovi deo) {
		this.delovi.add(deo);
	}
	public void obrisiDeo(Delovi deo) {
		deo.setObrisan(true);
		snimiDelove();
		this.delovi.remove(deo);
	}
	public void izmeniDeo(int id, String naziv, double cena, MarkaAutomobila markaAutomobila, ModelAutomobila modelAutomobila,
			boolean obrisan) {
		for(Delovi d: delovi) {
			if(d.getId() == id) {
				d.setNaziv(naziv);
				d.setCena(cena);
				d.setMarkaAutomobila(markaAutomobila);
				d.setModelAutomobila(modelAutomobila);
				d.setObrisan(obrisan);
			}
		}
	}
	//-------------------------Servisi--------------------------//
	public void dodajServis(Servisi servis) {
		this.servisi.add(servis);
	}
	public void obrisiServis(Servisi servis) {
		servis.setObrisan(true);
		snimiServise();
		this.servisi.remove(servis);	
	}
	public void izmeniServis(int id, Automobili automobil, Serviseri serviser, GregorianCalendar termin, String opis,
			ArrayList<Delovi> delovi, StatusServisa status, boolean obrisan) {
		for(Servisi s: servisi) {
			if(s.getId() == id) {
				s.setAutomobil(automobil);
				s.setServiser(serviser);
				s.setTermin(termin);
				s.setOpis(opis);
				s.setDelovi(delovi);
				s.setStatus(status);
				s.setObrisan(obrisan);
			}
		}
	}
	
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
				boolean obrisan = Boolean.parseBoolean(linija[10]);
				Administratori administrator = new Administratori(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata,obrisan);
				this.administratori.add(administrator);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiAdministratore() {	
		try {
			File korisniciFile = new File("fajlovi/administratori");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			String sadrzaj = "";
			for(Administratori admin:this.administratori) {
				sadrzaj += admin.getId() + "|" + admin.getIme() + "|" + admin.getPrezime() + "|" + admin.getJmbg() + "|" + admin.getPol() + "|"+
						admin.getAdresa() + "|"+ admin.getBrojTelefona() + "|"+ admin.getKorisnickoIme() + "|"+ admin.getLozinka() + "|" +
						admin.getPlata() + "|" + admin.isObrisan() + "\n"; 
			}
			writer.write(sadrzaj);
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
				boolean obrisan = Boolean.parseBoolean(linija[10]);
				Musterije musterija = new Musterije(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, nagradniBodovi,obrisan);
				this.musterije.add(musterija);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiMusterije() {
		try {
			File korisniciFile = new File("fajlovi/musterije");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			String sadrzaj = "";
			for(Musterije musterija:this.musterije) {
				sadrzaj += musterija.getId() + "|" + musterija.getIme() + "|" + musterija.getPrezime() + "|" + musterija.getJmbg() + "|" + musterija.getPol() + "|"+
						musterija.getAdresa() + "|"+ musterija.getBrojTelefona() + "|"+ musterija.getKorisnickoIme() + "|"+ musterija.getLozinka() + "|" + 
						musterija.getNagradniBodovi() + "|" + musterija.isObrisan() + "\n"; 
			}
			writer.write(sadrzaj);
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
				boolean obrisan = Boolean.parseBoolean(linija[10]);
				Serviseri serviser = new Serviseri(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata, specijalizacija,obrisan);
				this.serviseri.add(serviser);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiServisere() {
		try {
			File korisniciFile = new File("fajlovi/serviseri");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			String sadrzaj = "";
			for(Serviseri serviser:this.serviseri) {
				sadrzaj += serviser.getId() + "|" + serviser.getIme() + "|" + serviser.getPrezime() + "|" + serviser.getJmbg() + "|" + serviser.getPol() + "|"+
						serviser.getAdresa() + "|"+ serviser.getBrojTelefona() + "|"+ serviser.getKorisnickoIme() + "|"+ serviser.getLozinka() + "|" + 
						serviser.getPlata() + "|" + serviser.getSpecijalizacija() + "|" + serviser.isObrisan() + "\n"; 
			}
			writer.write(sadrzaj);
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
				boolean obrisan = Boolean.parseBoolean(linija[8]);
			    Automobili automobil = new Automobili(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva,obrisan);
			    this.automobili.add(automobil);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiAutomobile() {
		try {
			File korisniciFile = new File("fajlovi/automobili");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			String sadrzaj = "";
			for(Automobili automobil:this.automobili) {
				sadrzaj += automobil.getId() + "|" + automobil.getVlasnik().getId() + "|" + automobil.getMarka() +  "|" + automobil.getModel() + "|" +
						RadSaDatumima.datumUString(automobil.getGodinaProizvodnje())  + "|" +
						automobil.getZapreminaMotora() + "|" + automobil.getSnagaMotora() + "|" + automobil.getVrstaGoriva() + "|" + automobil.isObrisan() + "\n"; 
			}
			writer.write(sadrzaj);
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
				if(linija.length == 3) {
					boolean obrisana = Boolean.parseBoolean(linija[2]);
					ServisneKnjizice servisnaKnjiga = new ServisneKnjizice(id, automobil,obrisana);
					servisneKnjizice.add(servisnaKnjiga);
				}
				else {
					boolean obrisana = Boolean.parseBoolean(linija[3]);
					String servisi = linija[2];
					String[] servisiSplit = servisi.split(";");
					ArrayList<Servisi> serv = new ArrayList<Servisi>();
					for (String sif : servisiSplit) {
						Servisi k = nadjiServis(sif);
						if(k != null) {
							serv.add(k);
						}
					}
					ServisneKnjizice servisnaKnjiga = new ServisneKnjizice(id, automobil,serv,obrisana);
					servisneKnjizice.add(servisnaKnjiga);	
				}
			
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiServisneKnjizice() {
		try {
			File korisniciFile = new File("fajlovi/servisneKnjizice");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			String sadrzaj = "";
			for(ServisneKnjizice knjiga:this.servisneKnjizice) {
				if(knjiga.getServisi().isEmpty()) {
					sadrzaj += knjiga.getId() + "|" + knjiga.getAutomobil().getId() + "|" + knjiga.isObrisana() + "\n";
				}
				else {
					sadrzaj += knjiga.getId() + "|" + knjiga.getAutomobil().getId() + "|" + serviseUString(knjiga.getServisi()) + "|" + knjiga.isObrisana() + "\n";
				}
			}
			writer.write(sadrzaj);
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
				boolean obrisan = Boolean.parseBoolean(linija[5]);
				Delovi deo = new Delovi(id, naziv, cena, markaAutomobila, modelAutomobila,obrisan);
				this.delovi.add(deo);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiDelove() {
		try {
			File korisniciFile = new File("fajlovi/delovi");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			String sadrzaj = "";
			for(Delovi deo:this.delovi) {
				sadrzaj += deo.getId() + "|" + deo.getNaziv() + "|" + deo.getCena() + "|" + deo.getMarkaAutomobila() + "|" + deo.getModelAutomobila() + "|"+
						deo.isObrisan() + "\n";
			}
			writer.write(sadrzaj);
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
				boolean obrisan = Boolean.parseBoolean(linija[7]);
				Servisi servis = new Servisi(id, automobil, serviser, termin, opis, deo, status,obrisan);
				servisi.add(servis);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ocitavanja fajlova");
			}
		}
	public void snimiServise() {
		try {
			File korisniciFile = new File("fajlovi/servisi");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			String sadrzaj = "";
			for(Servisi servis:this.servisi) {
				sadrzaj += servis.getId() + "|" +  servis.getAutomobil().getId() + "|" +  servis.getServiser().getId() + "|" + 
						RadSaDatumima.datumUString(servis.getTermin())  + "|" + servis.getOpis() + "|" + deloviUString(servis.getDelovi()) + "|" +
						servis.getStatus() + "|" +  servis.isObrisan() + "\n"; 
			}
			writer.write(sadrzaj);
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
