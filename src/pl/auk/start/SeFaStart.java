package pl.auk.start;

import org.hibernate.*;
import org.hibernate.cfg.*;
import pl.auk.entities.*;


public class SeFaStart {
	
	
	private SessionFactory factory;
	
	public SeFaStart()	{
	
	this.factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Aukcje.class)
			.addAnnotatedClass(Bidders.class)
			.addAnnotatedClass(Bids.class)
			.addAnnotatedClass(Steps.class)
			.buildSessionFactory();
	}

	public SessionFactory getFactory() {
		return factory;
	}
	
	
	
}
