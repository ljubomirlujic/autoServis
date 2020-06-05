package osnovneKlase;

import enumeracije.Pol;
import enumeracije.Specijalizacija;

public class Serviseri extends Zaposleni {
	private Specijalizacija specijalizacija;
	
	public Serviseri() {
		super();
		this.specijalizacija = Specijalizacija.AUTO_MEHANICAR;
	}


	public Serviseri(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, double plata, Specijalizacija specijalizacija,boolean obrisan) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, obrisan, korisnickoIme, lozinka, plata);
		this.specijalizacija = specijalizacija;
	}



	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}


	@Override
	public String toString() {
		return "Serviser [specijalizacija=" + specijalizacija + ", plata=" + plata + ", korisnickoIme=" + korisnickoIme
				+ ", lozinka=" + lozinka + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg
				+ ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan
				+ "]";
	}
	
	
}
