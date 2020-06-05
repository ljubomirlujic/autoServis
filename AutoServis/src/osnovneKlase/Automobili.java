package osnovneKlase;


import java.util.GregorianCalendar;

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import enumeracije.VrstaGoriva;
import radSaDatumima.RadSaDatumima;

public class Automobili {
	private int id;
	private Musterije vlasnik;
	private MarkaAutomobila marka;
	private ModelAutomobila model;
	private GregorianCalendar godinaProizvodnje;
	private double zapreminaMotora;
	private int snagaMotora;
	private VrstaGoriva vrstaGoriva;
	private boolean obrisan;
	
	public Automobili() {
		this.id = 0;
		this.vlasnik = null;
		this.marka = MarkaAutomobila.BMW;
		this.model = ModelAutomobila.BMW_320D;
		this.godinaProizvodnje = new GregorianCalendar();
		this.zapreminaMotora = 0;
		this.snagaMotora = 0;
		this.vrstaGoriva = VrstaGoriva.BENZIN;
		this.obrisan = false;
	}


	public Automobili(int id, Musterije vlasnik, MarkaAutomobila marka, ModelAutomobila model,
			GregorianCalendar godinaProizvodnje, double zapreminaMotora, int snagaMotora, VrstaGoriva vrstaGoriva,
			boolean obrisan) {
		super();
		this.id = id;
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.zapreminaMotora = zapreminaMotora;
		this.snagaMotora = snagaMotora;
		this.vrstaGoriva = vrstaGoriva;
		this.obrisan = obrisan;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Musterije getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Musterije vlasnik) {
		this.vlasnik = vlasnik;
	}

	public MarkaAutomobila getMarka() {
		return marka;
	}

	public void setMarka(MarkaAutomobila marka) {
		this.marka = marka;
	}

	public ModelAutomobila getModel() {
		return model;
	}

	public void setModel(ModelAutomobila model) {
		this.model = model;
	}

	public GregorianCalendar getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(GregorianCalendar godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public double getZapreminaMotora() {
		return zapreminaMotora;
	}

	public void setZapreminaMotora(double zapreminaMotora) {
		this.zapreminaMotora = zapreminaMotora;
	}

	public int getSnagaMotora() {
		return snagaMotora;
	}

	public void setSnagaMotora(int snagaMotora) {
		this.snagaMotora = snagaMotora;
	}

	public VrstaGoriva getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(VrstaGoriva vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}
	

	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}


	@Override
	public String toString() {
		return "Automobil [id=" + id + ", vlasnik=" + vlasnik + ", marka=" + marka + ", model=" + model
				+ ", godinaProizvodnje=" + RadSaDatumima.datumUString(godinaProizvodnje) + ", zapreminaMotora=" + zapreminaMotora + ", snagaMotora="
				+ snagaMotora + ", vrstaGoriva=" + vrstaGoriva + ", obrisan=" + obrisan + "]";
	}


	
	
}
