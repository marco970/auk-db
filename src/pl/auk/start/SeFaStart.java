package pl.auk.start;

import org.hibernate.*;
import org.hibernate.cfg.*;
import pl.auk.entities.*;


public class SeFaStart {
	
	

	private static SessionFactory factory;
	
	private SeFaStart() {
	}
	
	
	public static synchronized SessionFactory getFactory() {
		
		

		 if (factory == null) {
			 
			 
			 Configuration configuration = new Configuration();
			 configuration.configure("hibernate.cfg.xml");
			 configuration.addAnnotatedClass(Aukcje.class);
			 configuration.addAnnotatedClass(Bidders.class);
			 factory =  configuration.buildSessionFactory();
			 System.out.println("Session Factory(SeFa) : " + factory.hashCode());
		 }
		 return factory;
	}

	
	
	
}
