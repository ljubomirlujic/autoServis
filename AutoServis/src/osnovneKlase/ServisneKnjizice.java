package osnovneKlase;

import java.util.ArrayList;
public class ServisneKnjizice {
	private int id;
	private Automobili automobil;
	private ArrayList<Servisi> servisi;
	
	public ServisneKnjizice() {
		this.id = 0;
		this.automobil = null;
		this.servisi = new ArrayList<Servisi>();
	}
	public ServisneKnjizice(int id, Automobili automobil) {
		super();
		this.id = id;
		this.automobil = automobil;
		this.servisi = new ArrayList<Servisi>();
	}
	
	public ServisneKnjizice(int id, Automobili automobil, ArrayList<Servisi> servisi) {
		super();
		this.id = id;
		this.automobil = automobil;
		this.servisi = servisi;
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
	@Override
	public String toString() {
		return "ServisnaKnjiga [id=" + id + ", automobil=" + automobil + ", servisi=" + servisi + "]";
	}
	
}
