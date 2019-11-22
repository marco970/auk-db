package pl.auk.back;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Aukcje;
import pl.auk.start.SeFaStart;

public class ReadAukcje {
	
	public ReadAukcje(SessionFactory factory) {
		
		if (factory==null)	{
			factory = new SeFaStart().getFactory();
		}
		
		
		try	{
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			List<Aukcje> aukcje = session
					.createQuery("from Aukcje")
					.getResultList();
		
			session.getTransaction().commit();	
			
			for(Aukcje el: aukcje)	{
				System.out.println(el);
		}
			
			
			
		}
		finally {
			factory.close();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String log4jConfPath = "D:\\git\\mk-Asap-DB\\AsapDB_3\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		SessionFactory factory = new SeFaStart().getFactory();
		new ReadAukcje(factory);
		
	}

}
