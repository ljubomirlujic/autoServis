package osnovneKlase;

import enumeracije.Pol;

public abstract class Osoba {
	protected int id;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected Pol pol;
	protected String adresa;
	protected String brojTelefona;
	protected boolean obrisan;  
	
	public Osoba() {
		this.id = 0;
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = Pol.MUSKI;
		this.adresa = "";
		this.brojTelefona = "";
		this.obrisan = false;
	}


	public Osoba(int id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			boolean obrisan) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.obrisan = obrisan;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public Pol getPol() {
		return pol;
	}


	public void setPol(Pol pol) {
		this.pol = pol;
	}


	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	
	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}


	@Override
	public String toString() {
		return "Osoba [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol
				+ ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}

	
	
	
}
