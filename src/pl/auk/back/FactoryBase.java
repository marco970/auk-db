package pl.auk.back;

import java.util.List;

import org.hibernate.SessionFactory;

import pl.auk.start.SeFaStart;

public class FactoryBase {
	
	protected SessionFactory factory;
	
	private static String name;
	
	public FactoryBase()	{
		this.factory = factoryFix();
		this.name = this.getClass().getSimpleName();
	}
	
	private SessionFactory factoryFix() {
		SessionFactory factory = SeFaStart.getFactory();
		System.out.println("Session Factory(AuckAdd) : " + factory.hashCode());
		
		if (factory.equals(null))	{
			System.out.println("Uwaga, nowe factory");
			factory = SeFaStart.getFactory();
		}
		return factory;
	}
	
	protected <T> void displayResults(List<T> input) {
		for(T el: input)	{
			System.out.println(name +" ---> "+el);
		}
	}

}
