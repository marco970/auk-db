package pl.auk.back;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Aukcje;
import pl.auk.start.SeFaStart;

public class ReadSingleAukcja {
	
	private Aukcje aukcja;
	
	public ReadSingleAukcja(int idAukcja)	{
		SessionFactory factory = SeFaStart.getFactory();
		System.out.println("Session Factory(ReadSingleAukcja) : " + factory.hashCode());
		
		if (factory==null)	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			aukcja = (Aukcje) session
					.createQuery("from Aukcje a where a.idAukcja ='"+idAukcja+"'")
					.getSingleResult();
			session.getTransaction().commit();	
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public Aukcje getAukcja() {
		return aukcja;
	}
	
	public static void main(String[] args) {
		System.out.println(new ReadSingleAukcja(27).getAukcja().getNazwaAuk());
		
	}
	
	
	

}
