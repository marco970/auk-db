package pl.auk.java.beans.front2;

import java.util.ArrayList;
import java.util.List;

import pl.auk.back.OfferEnti;


public class Main {

	public static void main(String[] args) {
		

		

		List<OfferEnti> krok0 = new ArrayList<>();
		krok0.add(new OfferEnti(0, "Nokia", 1000));
		krok0.add(new OfferEnti(0, "Huawei", 900));
		krok0.add(new OfferEnti(0, "Computaris", 1100));

		List<OfferEnti> krok1 = new ArrayList<>();
		krok1.add(new OfferEnti(1, "Nokia", 900));
		krok1.add(new OfferEnti(1, "Huawei", 800));
		krok1.add(new OfferEnti(1, "Computaris", 800));
		
		List<List<OfferEnti>> aukcja = new ArrayList<>();
		aukcja.add(krok0);
		aukcja.add(krok1);
		
		ListBean lb = new ListBean(aukcja);
		
		System.out.println("main lb "+lb.toString());
		
		PropertyTest pt = new PropertyTest();
//		
		lb.addPropertyChangeListener(pt);
		StepsView sv = new StepsView(lb);
		
		lb.addPropertyChangeListener(sv);

		MainWindow mw = new MainWindow(sv);
		lb.addPropertyChangeListener(mw);
		
		lb.getPCListeners();


	}

}
