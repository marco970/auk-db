package pl.auk.java.beans.front2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import pl.auk.back.BiddersRead;
import pl.auk.back.OfferEnti;
import pl.auk.back.StepAdd;
import pl.auk.back.StepSingleRead;
import pl.auk.back.StepsRead;
import pl.auk.entities.Aukcje;
import pl.auk.entities.Bidders;
import pl.auk.entities.Steps;

public class AukcjaIntegrate {
	
	/**
	 * działanie klasy:
	 * klasa musi wywołać (od końca):
	 * - MainWindowAukcja(sv)
	 * - StepsView sv = new StepsView(lb);
	 * - ListBean lb = new ListBean(aukcja);
	 * - List<List<OfferEnti>> aukcja = new ArrayList<>();
	 * 
	 * 
	 * 
	 */

	private Aukcje aukcja;
	private List<Bidders>bidders;
	
	public AukcjaIntegrate(Aukcje aukcja)		{
		
		this.aukcja = aukcja;

		System.out.println("robimy: "+aukcja.getNazwaAuk());
		
		BiddersRead br = new BiddersRead(aukcja.getIdAukcja());
		this.bidders = br.getBidders();
		
		for (Bidders el: bidders) {
			System.out.println(el.getName()+" "+el.getIdBidder());
		}
		StepsRead sr = new StepsRead (aukcja.getIdAukcja());
		List<Steps> listSteps = sr.getSteps();
		List<Integer> kroki = new ArrayList<>();
		
		for (Steps el: listSteps)	{
			kroki.add(el.getKrokNr());
		}
		
		int maxKrokNr = 0;
		
		if (kroki.isEmpty())	{
			
			System.out.println("Aukcja "+ aukcja.getNazwaAuk() + " jeszcze się nie rozpoczęła");
		}
		else	{
			maxKrokNr = Collections.max(kroki);
			new StepsRead (aukcja.getIdAukcja());
			new StepSingleRead(aukcja.getIdAukcja(), maxKrokNr);
		}
		System.out.println("ostatni krok ma numer: "+ maxKrokNr);
		
		
		

		
		
		
//		new StepAdd(maxKrokNr+1, 200, aukcja.getIdAukcja());
		
		
		
		
		
	}
	
	
	
	
	
}
