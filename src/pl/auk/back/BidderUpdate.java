package pl.auk.back;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.*;
import pl.auk.start.SeFaStart;


public class BidderUpdate {

	
	public BidderUpdate(Bidders bidder)	{
		
		
		SessionFactory factory = SeFaStart.getFactory();

		if (factory==null)	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
		
			Bidders bidderMod = session.get(Bidders.class, bidder.getIdBidder());

			bidderMod.setName(bidder.getName());
			bidderMod.setEmail(bidder.getEmail());
			bidderMod.setDomiar(bidder.getDomiar());
			
			session.getTransaction().commit();		

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
