package osnovneKlase;

import enumeracije.Pol;

public class Musterije extends Korisnik {
	private int nagradniBodovi;
	
	public Musterije() {
		super();
		this.nagradniBodovi = 0;
	}


	public Musterije(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, int nagradniBodovi,boolean obrisan) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, obrisan, korisnickoIme, lozinka);
		this.nagradniBodovi = nagradniBodovi;
	}



	public int getNagradniBodovi() {
		return nagradniBodovi;
	}

	public void setNagradniBodovi(int nagradniBodovi) {
		this.nagradniBodovi = nagradniBodovi;
	}


	@Override
	public String toString() {
		return "Musterija [nagradniBodovi=" + nagradniBodovi + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol
				+ ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}
	
}
