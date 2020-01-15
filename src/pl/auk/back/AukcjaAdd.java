package pl.auk.back;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Aukcje;
import pl.auk.entities.Bidders;
import pl.auk.start.SeFaStart;

public class AukcjaAdd {
	
	public AukcjaAdd(Aukcje aukcja)	{
		
		SessionFactory factory = SeFaStart.getFactory();
//		System.out.println("Session Factory(AuckAdd) : " + factory.hashCode());
		
		if (factory.equals(null))	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}
		
			try {
				Session session = factory.getCurrentSession();
				session.beginTransaction();
				session.save(aukcja);
				session.getTransaction().commit();
			} catch (HibernateException e) {
				e.printStackTrace();
			}	

	}
	public static void main(String[] args) {
		
		String log4jConfPath = "D:\\git\\mk-Asap-DB\\AsapDB_3\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		SessionFactory factory = SeFaStart.getFactory();
		
		Aukcje aukcja = new Aukcje("ello-tender", "opis opis opis", "", "","EUR");
		new AukcjaAdd(aukcja);

		factory.close();
		
	}
}
