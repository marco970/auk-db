package pl.auk.back;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Aukcje;
import pl.auk.entities.Bidders;
import pl.auk.start.SeFaStart;

public class BidderAdd extends FactoryBase{
	
	
	public BidderAdd(Aukcje aukcja, Bidders bidder)		{
		
		super();
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			aukcja.add(bidder);
			session.save(bidder);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}	

	}



	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
