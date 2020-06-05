package osnovneKlase;

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;

public class Delovi {
	private int id;
	private String naziv;
	private double cena;
	private MarkaAutomobila markaAutomobila;
	private ModelAutomobila modelAutomobila;
	private boolean obrisan;
	
	public Delovi() {
		this.id = 0;
		this.naziv = "";
		this.cena = 0;
		this.markaAutomobila = MarkaAutomobila.BMW;
		this.modelAutomobila = ModelAutomobila.BMW_320D;
		this.obrisan = false;
	}

	public Delovi(int id, String naziv, double cena, MarkaAutomobila markaAutomobila, ModelAutomobila modelAutomobila,
			boolean obrisan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.markaAutomobila = markaAutomobila;
		this.modelAutomobila = modelAutomobila;
		this.obrisan = obrisan;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public MarkaAutomobila getMarkaAutomobila() {
		return markaAutomobila;
	}

	public void setMarkaAutomobila(MarkaAutomobila markaAutomobila) {
		this.markaAutomobila = markaAutomobila;
	}

	public ModelAutomobila getModelAutomobila() {
		return modelAutomobila;
	}

	public void setModelAutomobila(ModelAutomobila modelAutomobila) {
		this.modelAutomobila = modelAutomobila;
	}
	

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Deo [id=" + id + ", naziv=" + naziv + ", cena=" + cena + ", markaAutomobila=" + markaAutomobila
				+ ", modelAutomobila=" + modelAutomobila + ", obrisan=" + obrisan + "]";
	}

	
	
}
