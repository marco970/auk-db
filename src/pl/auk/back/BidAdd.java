package pl.auk.back;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Bids;
import pl.auk.entities.Steps;
import pl.auk.start.SeFaStart;

public class BidAdd extends FactoryBase {
	
	
	
	
	public BidAdd(Steps step, Bids bid)	{
		
		super();
		

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
