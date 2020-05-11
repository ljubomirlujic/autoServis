package osnovneKlase;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import enumeracije.StatusServisa;
import radSaDatumima.RadSaDatumima;

public class Servisi {
	private int id;
	private Automobili automobil;
	private Serviseri serviser;
	private GregorianCalendar termin;
	private String opis;
	private ArrayList<Delovi> delovi;
	private StatusServisa status;
	
	public Servisi() {
		this.id = 0;
		this.automobil = null;
		this.serviser = null;
		this.termin = new GregorianCalendar();
		this.opis = "";
		this.delovi = new ArrayList<Delovi>();
		this.status = StatusServisa.ZAKAZAN;
	}

	public Servisi(int id, Automobili automobil, Serviseri serviser, GregorianCalendar termin, String opis, ArrayList<Delovi> delovi,
			StatusServisa status) {
		super();
		this.id = id;
		this.automobil = automobil;
		this.serviser = serviser;
		this.termin = termin;
		this.opis = opis;
		this.delovi = delovi;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Automobili getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobili automobil) {
		this.automobil = automobil;
	}

	public Serviseri getServiser() {
		return serviser;
	}

	public void setServiser(Serviseri serviser) {
		this.serviser = serviser;
	}

	public GregorianCalendar getTermin() {
		return termin;
	}

	public void setTermin(GregorianCalendar termin) {
		this.termin = termin;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public ArrayList<Delovi> getDelovi() {
		return delovi;
	}

	public void setDelovi(ArrayList<Delovi> delovi) {
		this.delovi = delovi;
	}

	public StatusServisa getStatus() {
		return status;
	}

	public void setStatus(StatusServisa status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Servis [id=" + id + ", automobil=" + automobil + ", serviser=" + serviser + ", termin=" + RadSaDatumima.datumUString(termin)
				+ ", opis=" + opis + ", delovi=" + delovi + ", status=" + status + "]";
	}
	
	
	
	
}
