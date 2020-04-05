package pl.auk.java.beans.front2;

import java.util.List;

import pl.auk.back.OfferEnti;
import pl.auk.jd.test.form.FormUtils;
import pl.auk.jd.test.form.RawForm;

public class MinPostEnterForm extends RawForm implements FormUtils {
	
	private static String[] start = {"Start", "Exit"};
	
	private static String[] buttons = {"Anuluj", "Zapisz"};
	
	private static MinPostEnterForm formInstance = null;
	
	private double prevMinPost = -1000;
	
	/**
	 * Najważniejsze o tej klasie:
	 * - singleton
//	 * - co potrzeba w konstruktorze?
//	 * - min_change(minPost); - gdzie jest tworzony nowy step?
	 * Klasa robi:
	 * - jest wywoływana z StepsView
	 * - potrzeba 
	 * 		poprzednią wartość minPost, żeby dać domyślną wartość w JTexField
	 * 		chyba nic więcej?
	 * - formularz waliduje
	 * - ustawia nową wartość pola w klasie StepsView
	 * 
	 * - 
	 */
	private MinPostEnterForm(double prevMinPost) {
		super("Zmiana minimalnej oferty", start);
		this.prevMinPost = prevMinPost;
	}
	
	
	public static synchronized MinPostEnterForm getInstanceMinPostForm(double prevMinPost)	{
		if (formInstance!=null)	{
			System.out.println("Singleton - instancja już istnieje i nie tworzymy nowej");
			return null;
		}
		System.out.println("Singleton - Nowa instancja");
		return new MinPostEnterForm(prevMinPost) ;
	}

	public static void main(String[] args) {
		
		getInstanceMinPostForm(100);
		

	}

}
