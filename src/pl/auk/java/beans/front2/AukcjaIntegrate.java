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
import pl.auk.java.beans.front2.minPost.NextMinPostBean;
import pl.auk.java.beans.front2.minPost.NextMinPostLab;
import pl.auk.jd.test.form.StartEnterForm;

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
		
		List<OfferRaw> krok0 = new ArrayList<>();

		StepsRead sr = new StepsRead (aukcja.getIdAukcja());
		List<Steps> listSteps = sr.getSteps();
		List<Integer> kroki = new ArrayList<>();
		
		for (Steps el: listSteps)	{
			kroki.add(el.getKrokNr());
		}
		
		int maxKrokNr = 0;
		
		if (kroki.isEmpty())	{
			
			System.out.println("Aukcja "+ aukcja.getNazwaAuk() + " jeszcze się nie rozpoczęła");
			
//			trzeba zrobić nowy formularz do wprowadzania wartości począttkowych
			List<String> biddersStr = new ArrayList();
			for (Bidders el: bidders) {
				System.out.println("--> "+el.getName()+" "+el.getIdBidder());
				biddersStr.add(el.getName());

				
				krok0.add(new OfferRaw(0, el.getName(), 0)); 
				
			}
			
//			tu uruchamiamy nowy formularz do wprowadzenia początkowych wartości.
			
			new StartEnterForm("heja", biddersStr); 
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
			
			krok0.add(new OfferRaw(1000, "Nokia", 5000000));
			krok0.add(new OfferRaw(1000, "Huawei", 3900000));
			krok0.add(new OfferRaw(1000, "Computaris", 6100000));
			krok0.add(new OfferRaw(1000, "EPO", 4850000));
		}
		System.out.println("ostatni krok ma numer: "+ maxKrokNr);
		
//		List<OfferRaw> krok0 = new ArrayList<>();

		
		List<Double> minPostList = new ArrayList();
		/**
		 *  do tej listy będziemy wrzucać minimalne postąpienia z bazy danych
		 */
		minPostList.add(0.0);

		NextMinPostBean minPostBean = new NextMinPostBean(minPostList.get(minPostList.size()-1));
		NextMinPostLab minPostLab = new NextMinPostLab(minPostBean.getMinPost()+""); 
		minPostBean.addPropertyChangeListener(minPostLab);
		
		List<List<OfferEnti>> aukcjaLoc = new ArrayList<>();
		aukcjaLoc.add(OfferCalc.getOfferEntiList(krok0));
		ListBean lb = new ListBean(aukcjaLoc);


		StepsView sv = new StepsView(lb, minPostList, minPostBean, minPostLab);	

//		lb.addPropertyChangeListener(sv);
		MainWindowAukcja mw = new MainWindowAukcja(sv);


		
		

		
		
		
		
		
	}
	
	
	
	
	
}
