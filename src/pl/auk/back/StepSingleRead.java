package pl.auk.back;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pl.auk.entities.Steps;
import pl.auk.start.SeFaStart;

public class StepSingleRead {
	
	
	private Steps step;
	private List<Steps> steps;
	private static String name;
	

	public StepSingleRead(int idAukcja, int krokNr) {
		
		this.name = this.getClass().getSimpleName(); 

		
		SessionFactory factory = SeFaStart.getFactory();
		if (factory==null)	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			this.steps = session
					.createQuery("from Steps s where s.idAukcja = '"+idAukcja+"' and s.krokNr = '"+krokNr+"'")
					.getResultList();

			session.getTransaction().commit();	
			displayResults(steps);

//			displayResults(bidders);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		System.out.println("**********START-> "+name);
		
		
	}
	private <T> void displayResults(List<T> wynik) {
		for(T el: wynik)	{
			System.out.println("krok o zadanym numerze: "+el);
		}
	}
	
	public List<Steps> getSteps() {
		return steps;
	}

	public void setSteps(List<Steps> steps) {
		this.steps = steps;
	}

	public Steps getStep() {
		return step;
	}

	public void setStep(Steps step) {
		this.step = step;
	}

	public static void main(String[] args) {

	}

}
