package pl.auk.java.beans.front2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import pl.auk.back.OfferEnti;

public class OfferCollect {
	
	
	private List<OfferRaw> offers;
	
	private SortedSet<OfferRaw> offerSet;
	
	private int stepNr;
	
	private int offerNumber;
	
	
	
	private static Set<Integer> stepSet = new HashSet<>();
	
	private OfferCollect(int stepNr, int offerNumber)	{
		this.offers = new ArrayList<>();
		this.stepNr = stepNr;
		this.offerNumber = offerNumber;
		this.offerSet = new TreeSet<>();
//		this.sm = new TreeMap<>();
		stepSet.add(stepNr);
		
	}
	
	public void addOffer(OfferRaw singleOffer)	{
		offerSet.add(singleOffer);
	}
	
	public static synchronized OfferCollect getInstance(int stepNr, int offerNumber)	{
		if (stepSet.contains(stepNr))	{
			return null;
		}
		return new OfferCollect(stepNr, offerNumber);
	}
	public ArrayList<OfferEnti> getStep()	{
		
		
		
		return null;
	}

	
	
	
	

}
