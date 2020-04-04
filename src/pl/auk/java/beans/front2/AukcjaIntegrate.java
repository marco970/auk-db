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

public class AukcjaIntegrate  {
	
	/**
	 * działanie klasy:
	 * klasa musi wywołać (od końca):
	 * - MainWindowAukcja(sv)
	 * - StepsView sv = new StepsView(lb);
	 * - ListBean lb = new ListBean(aukcja);
	 * - List<List<OfferEnti>> aukcja = new ArrayList<>();
	 * - aukcję robimy tak, że do Listy dodajemy 
	 * 	- List<OfferEnti> (krokNr) 
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
//			tu uruchamiamy StepEnterForm
//			trzeba w kodzie utworzyć pierwszy krok
//			trzeba potworzyć w ten sam sposób obiekty, które są potrzebne do uruchomienia tego formularza
//			
//			
		}
		else	{
			maxKrokNr = Collections.max(kroki);
			new StepsRead (aukcja.getIdAukcja());
			new StepSingleRead(aukcja.getIdAukcja(), maxKrokNr);
//			tu odpalamy widok auckcji - MainWindowAukcja
//			reszta j.w.
		}
		System.out.println("ostatni krok ma numer: "+ maxKrokNr);
		
		List<OfferRaw> krok0 = new ArrayList<>();
		krok0.add(new OfferRaw(1000, "Nokia", 0));
		krok0.add(new OfferRaw(1000, "Huawei", 0));
		krok0.add(new OfferRaw(1000, "Computaris", 0));
		krok0.add(new OfferRaw(1000, "EPO", 0));

//		List<OfferRaw> krok1 = new ArrayList<>();
//		krok1.add(new OfferRaw(1, "Nokia", 900));
//		krok1.add(new OfferRaw(1, "Huawei", 800));
//		krok1.add(new OfferRaw(1, "Computaris", 800));
//		krok1.add(new OfferRaw(1, "EPO", 1100));
//		
//		List<OfferRaw> krok2 = new ArrayList<>();
//		krok2.add(new OfferRaw(2, "Nokia", 900));
//		krok2.add(new OfferRaw(2, "Huawei", 600));
//		krok2.add(new OfferRaw(2, "Computaris", 900));
//		krok2.add(new OfferRaw(2, "EPO", 1100));
		
		List<List<OfferEnti>> aukcjaLoc = new ArrayList<>();

//		aukcja.add(krok0);
//		aukcja.add(krok1);
//		aukcja.add(krok1);
		
		OfferCalc oc = new OfferCalc();
		
		aukcjaLoc.add(oc.getOfferEntiList(krok0));
//		aukcjaLoc.add(oc.getOfferEntiList(krok1));
//		aukcjaLoc.add(oc.getOfferEntiList(krok2));
		
		ListBean lb = new ListBean(aukcjaLoc);
		
//		System.out.println("main lb "+lb.toString());

		StepsView sv = new StepsView(lb);
		
//		lb.addPropertyChangeListener(sv);
		

		MainWindowAukcja mw = new MainWindowAukcja(sv);
		

		
		
		
//		new StepAdd(maxKrokNr+1, 200, aukcja.getIdAukcja());
		
		
		
		
		
	}
	
	
	
	
	
}
