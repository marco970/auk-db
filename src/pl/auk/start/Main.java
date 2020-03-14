package pl.auk.start;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.SessionFactory;

import antlr.DocBookCodeGenerator;
import pl.auk.back.OfferEnti;
import pl.auk.back.AukcjeRead;
import pl.auk.java.beans.front2.AukcjomatView;
import pl.auk.java.beans.front2.ListBean;
import pl.auk.java.beans.front2.MainWindowAukcja;
import pl.auk.java.beans.front2.OfferCalc;
import pl.auk.java.beans.front2.OfferRaw;
import pl.auk.java.beans.front2.StepsView;


interface DoKwadratu {
	double doKwadratu(double n);
}

public class Main {

	public static void main(String[] args) {
		String log4jConfPath = "D:\\git\\mk-Asap-DB\\AsapDB_3\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		DBConnect dbc = new DBConnect();
		
		

		List<OfferRaw> krok0 = new ArrayList<>();
		krok0.add(new OfferRaw(0, "Nokia", 1000));
		krok0.add(new OfferRaw(0, "Huawei", 900));
		krok0.add(new OfferRaw(0, "Computaris", 1100));
		krok0.add(new OfferRaw(0, "EPO", 1100));

		List<OfferRaw> krok1 = new ArrayList<>();
		krok1.add(new OfferRaw(1, "Nokia", 900));
		krok1.add(new OfferRaw(1, "Huawei", 800));
		krok1.add(new OfferRaw(1, "Computaris", 800));
		krok1.add(new OfferRaw(1, "EPO", 1100));
		
		List<OfferRaw> krok2 = new ArrayList<>();
		krok2.add(new OfferRaw(2, "Nokia", 900));
		krok2.add(new OfferRaw(2, "Huawei", 600));
		krok2.add(new OfferRaw(2, "Computaris", 900));
		krok2.add(new OfferRaw(2, "EPO", 1100));
		
		List<List<OfferEnti>> aukcja = new ArrayList<>();

//		aukcja.add(krok0);
//		aukcja.add(krok1);
		OfferCalc oc = new OfferCalc();
		
		aukcja.add(oc.getOfferEntiList(krok0));
		aukcja.add(oc.getOfferEntiList(krok1));
		aukcja.add(oc.getOfferEntiList(krok2));
		
		ListBean lb = new ListBean(aukcja);
		
//		System.out.println("main lb "+lb.toString());

		StepsView sv = new StepsView(lb);
		
//		lb.addPropertyChangeListener(sv);

		MainWindowAukcja mw = new MainWindowAukcja(sv);
		

		SessionFactory factory = SeFaStart.getFactory();
		System.out.println("Session Factory : " + factory.hashCode());
		
		
		new AukcjomatView();
//		factory.close();
		
		
		
		
		
		
//		lb.addPropertyChangeListener(mw);
//		
//		lb.getPCListeners();
		//double n = 2;
		
//		DoKwadratu dkw = (n) -> n*n;
//		System.out.println(dkw.doKwadratu(2.1));


	}

}
