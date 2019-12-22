package pl.auk.back;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Aukcje;
import pl.auk.entities.Bidders;
import pl.auk.start.SeFaStart;

public class AukcjaAdd {
	
	public AukcjaAdd(Aukcje aukcja, SessionFactory factory)	{
		
		if (factory==null)	{
			System.out.println("Uwaga, nowe factory");
			factory = new SeFaStart().getFactory();
		}
		
		try	{
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.save(aukcja);

			session.getTransaction().commit();	
		}
		finally {
			factory.close();
		}

	}
	public static void main(String[] args) {
		
		String log4jConfPath = "D:\\git\\mk-Asap-DB\\AsapDB_3\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		SessionFactory factory = new SeFaStart().getFactory();
		
		Aukcje aukcja = new Aukcje("  tender", "opis opis opis", "10.12.2019", "11.12.2019","EUR");
		new AukcjaAdd(aukcja, factory);

		factory.close();
		
	}
}
