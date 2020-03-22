package pl.auk.back;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Bids;
import pl.auk.entities.Steps;
import pl.auk.start.SeFaStart;

public class BidAdd {
	
	
	
	
	public BidAdd(Steps step, Bids bid)	{
		
		
		SessionFactory factory = SeFaStart.getFactory();
		System.out.println("Session Factory(AuckAdd) : " + factory.hashCode());
		
		if (factory.equals(null))	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			step.add(bid);
			session.save(bid);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}	
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
