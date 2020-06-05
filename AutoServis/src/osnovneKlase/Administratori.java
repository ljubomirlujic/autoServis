package osnovneKlase;

import enumeracije.Pol;

public class Administratori extends Zaposleni {
	
	
	public Administratori() {
		super();
	}

	
	public Administratori(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			 String korisnickoIme, String lozinka, double plata,boolean obrisan) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, obrisan, korisnickoIme, lozinka, plata);
		
	}


	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa="
				+ adresa + ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}
	
	
}