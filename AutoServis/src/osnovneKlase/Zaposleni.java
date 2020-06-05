package osnovneKlase;

import enumeracije.Pol;

public abstract class Zaposleni extends Korisnik {
	protected double plata;
		
	
	public Zaposleni() {
		super();
		this.plata = 0;
	}



	public Zaposleni(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			boolean obrisan, String korisnickoIme, String lozinka, double plata) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, obrisan, korisnickoIme, lozinka);
		this.plata = plata;
	}





	public double getPlata() {
		return plata;
	}


	public void setPlata(double plata) {
		this.plata = plata;
	}


	@Override
	public String toString() {
		return "Zaposleni [plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id=" + id
				+ ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa
				+ ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}

	
}
