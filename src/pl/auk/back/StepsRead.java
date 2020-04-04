package pl.auk.back;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Steps;
import pl.auk.start.DBConnect;
import pl.auk.start.SeFaStart;

public class StepsRead extends FactoryBase {
	
	
	private List<Steps> steps;
	private static String name;
	
	public StepsRead (int idAukcji)		{
		
		super();
		
		this.name = this.getClass().getSimpleName();
		

		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			this.steps = session
					.createQuery("from Steps s where s.idAukcja = '"+idAukcji+"'")
					.getResultList();


			session.getTransaction().commit();	
			displayResults(steps);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
//		System.out.println("**********START-> "+name);
		
	}
	

	
	public List<Steps> getSteps()	{
		return steps;
	}
	
	

	public static void main(String[] args) {
		String log4jConfPath = "D:\\git\\mk-Asap-DB\\AsapDB_3\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		DBConnect dbc = new DBConnect();
		System.out.println("**********START-> "+name);
		new StepsRead (1);
		

	}

}
