package pl.auk.java.beans.front2;

public class OfferRaw implements Comparable<OfferRaw> {
	
	private int stepNr;
	
	private String oferent;
	
	private int cena;
	
	public OfferRaw(int stepNr, String oferent, int cena) {
		this.stepNr = stepNr;
		this.oferent = oferent;
		this.cena = cena;
	}
	
	//tu chyba tylko getters, setters do wywalenia

	public int getStepNr() {
		return stepNr;
	}

	public void setStepNr(int stepNr) {
		this.stepNr = stepNr;
	}

	public String getOferent() {
		return oferent;
	}

	public void setOferent(String oferent) {
		this.oferent = oferent;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	@Override
	public int compareTo(OfferRaw o) {
		return this.cena - o.cena;
	}

}
