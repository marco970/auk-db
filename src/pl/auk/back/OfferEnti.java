package pl.auk.back;

public class OfferEnti {
	
	private int offerId;
	
	
	private int stepNr;
	
	
	private String oferent;
	
	
	private int cena;


	public OfferEnti(int stepNr, String oferent, int cena) {
		this.stepNr = stepNr;
		this.oferent = oferent;
		this.cena = cena;
	}


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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
