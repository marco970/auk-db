package pl.auk.java.beans.front2;

import java.util.ArrayList;
import java.util.List;

public class OfferCollect {
	
	
	private List<OfferRaw> offers;
	
	public OfferCollect(int nrOferent�w)	{
		this.offers = new ArrayList<>();
		
	}
	
	public void addOffer(OfferRaw singleOffer)	{
		offers.add(singleOffer);
	}
	
	
	
	

}
