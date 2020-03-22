package pl.auk.back;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Aukcje;
import pl.auk.entities.Steps;
import pl.auk.start.DBConnect;
import pl.auk.start.SeFaStart;

public class StepAdd {
	
	private Steps step;
	
	public StepAdd (int krokNr, double minPost, int idAukcja)	{
		
		this.step = new Steps(krokNr, minPost, idAukcja);
		
		SessionFactory factory = SeFaStart.getFactory();
		System.out.println("Session Factory(AuckAdd) : " + factory.hashCode());
		
		if (factory.equals(null))	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(step);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}	
		
		
	}
	
	
	public static void main(String[] args) {
		String log4jConfPath = "D:\\git\\mk-Asap-DB\\AsapDB_3\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		DBConnect dbc = new DBConnect();
		System.out.println("**********START-> "+Class.class);
		

		
		
		SessionFactory factory = SeFaStart.getFactory();
		
		new StepAdd(3, 200, 1);
//		new StepsRead (1);

		factory.close();
	}

}
