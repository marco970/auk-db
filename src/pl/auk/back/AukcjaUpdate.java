package pl.auk.back;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Aukcje;
import pl.auk.start.SeFaStart;

public class AukcjaUpdate {
	

public AukcjaUpdate(Aukcje aukcja)	{
	
	SessionFactory factory = SeFaStart.getFactory();

	if (factory==null)	{
		System.out.println("Uwaga, nowe factory");
		factory = SeFaStart.getFactory();
	}
	
	System.out.println(aukcja.toString());
	System.out.println(aukcja.getNazwaAuk());
	
	try {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Aukcje aukcjaMod = session.get(Aukcje.class, aukcja.getIdAukcja());
		aukcjaMod.setNazwaAuk(aukcja.getNazwaAuk());
		aukcjaMod.setOpisAuk(aukcja.getOpisAuk());
		aukcjaMod.setWaluta(aukcja.getWaluta());
		
		session.getTransaction().commit();	
		

	} catch (HibernateException e) {
		e.printStackTrace();
	}
	
	
}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
