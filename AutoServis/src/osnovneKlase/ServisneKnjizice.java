package osnovneKlase;

import java.util.ArrayList;
public class ServisneKnjizice {
	private int id;
	private Automobili automobil;
	private ArrayList<Servisi> servisi;
	private boolean obrisana;
	
	public ServisneKnjizice() {
		this.id = 0;
		this.automobil = null;
		this.servisi = new ArrayList<Servisi>();
		this.obrisana = false;
	}
	public ServisneKnjizice(int id, Automobili automobil, boolean obrisana) {
		super();
		this.id = id;
		this.automobil = automobil;
		this.servisi = new ArrayList<Servisi>();
		this.obrisana = obrisana;
	}
	
	
	public ServisneKnjizice(int id, Automobili automobil, ArrayList<Servisi> servisi, boolean obrisana) {
		super();
		this.id = id;
		this.automobil = automobil;
		this.servisi = servisi;
		this.obrisana = obrisana;
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

	public ArrayList<Servisi> getServisi() {
		return servisi;
	}
	public void setServisi(ArrayList<Servisi> servisi) {
		this.servisi = servisi;
	}
	
	public boolean isObrisana() {
		return obrisana;
	}
	public void setObrisana(boolean obrisana) {
		this.obrisana = obrisana;
	}
	@Override
	public String toString() {
		return "Servisna knjizica [id=" + id + ", automobil=" + automobil + ", servisi=" + servisi + ", obrisana="
				+ obrisana + "]";
	}
	
	
}
