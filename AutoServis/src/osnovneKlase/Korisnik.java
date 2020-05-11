package osnovneKlase;

import enumeracije.Pol;

public abstract class Korisnik extends Osoba {
	protected String korisnickoIme;
	protected String lozinka;
	
	
	public Korisnik() {
		super();
		this.korisnickoIme = "";
		this.lozinka = "";
	}


	public Korisnik(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona);
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}


	public String getKorisnickoIme() {
		return korisnickoIme;
	}


	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}


	public String getLozinka() {
		return lozinka;
	}


	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


	@Override
	public String toString() {
		return "Korisnik [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id=" + id + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona="
				+ brojTelefona + "]";
	}
	
}
