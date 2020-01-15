package pl.auk.back;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.auk.entities.Aukcje;
import pl.auk.entities.Bidders;
import pl.auk.start.SeFaStart;

public class ReadAukcje {
	
	private List<Aukcje> aukcje;
	
	private List<Bidders> bidders;
	
	@SuppressWarnings("unchecked")
	public ReadAukcje() {
		
		SessionFactory factory = SeFaStart.getFactory();
		
		
		if (factory==null)	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}

			try {
				Session session = factory.getCurrentSession();
				session.beginTransaction();
				this.aukcje = session
						.createQuery("from Aukcje")
						.getResultList();
				String nrAukcji = 1+"";
				this.bidders = session
						.createQuery("from Bidders b where b.aukcja = '"+nrAukcji+"'")
						.getResultList();

				session.getTransaction().commit();	

				displayResults(aukcje);
				displayResults(bidders);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}

	private <T> void displayResults(List<T> aukcje) {
		for(T el: aukcje)	{
			System.out.println(el);
		}
	}

	public List<Aukcje> getAukcje() {
		return aukcje;
	}

	public List<Bidders> getBidders() {
		return bidders;
	}

}
