package pl.auk.back;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Bidders;
import pl.auk.start.SeFaStart;

public class BiddersRead {
	
	private List<Bidders> bidders;
	
	public BiddersRead(int idAukcji )		{
		
		SessionFactory factory = SeFaStart.getFactory();
		if (factory==null)	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			this.bidders = session
					.createQuery("from Bidders b where b.aukcja = '"+idAukcji+"'")
					.getResultList();

			session.getTransaction().commit();	

//			displayResults(bidders);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	
	private <T> void displayResults(List<T> aukcje) {
		for(T el: aukcje)	{
			System.out.println(el);
		}
	}
	
	public List<Bidders> getBidders() {
		return bidders;
	}

	public static void main(String[] args) {
		new BiddersRead(1);

	}

}
