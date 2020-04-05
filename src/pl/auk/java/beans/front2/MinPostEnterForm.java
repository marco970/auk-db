package pl.auk.java.beans.front2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pl.auk.back.OfferEnti;
import pl.auk.jd.test.form.FormFieldData;
import pl.auk.jd.test.form.FormUtils;
import pl.auk.jd.test.form.RawForm;
import pl.auk.validators.DoubleValidator;
import pl.auk.validators.EmailFieldValidator;
import pl.auk.validators.StringFieldValidator;

public class MinPostEnterForm extends RawForm implements FormUtils {
	
	private static String[] start = {"Start", "Exit"};
	
	private static String[] buttons = {"Anuluj", "Zapisz"};
	
	private static MinPostEnterForm formInstance = null;
	
	private double prevMinPost = -1000;
	
	private static Font fontNazwa = new Font("Tahoma", Font.PLAIN, 11);
	
	private JTextField minPostVal;
	private JLabel errMessageMinPostVal;
	
	private JButton saveBtn;
	
	private static String name;
	
	/**
	 * Najważniejsze o tej klasie:
	 * ok- singleton
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
	private MinPostEnterForm(double prevMinPost, int krokNr) {
		super("", start);
		
		int newKrokNr = krokNr+1;
		
		this.name = this.getClass().getSimpleName();
		super.setTitle("Zamiana minimalnego postąpienia w kroku "+newKrokNr+" - "+name);
		System.out.println(name);
		this.prevMinPost = prevMinPost;
		this.minPostVal = FormUtils.textFieldDef(20, this, fontNazwa);
		this.errMessageMinPostVal = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		
		minPostVal.setText(""+prevMinPost);
		
		JPanel panelInherited = super.panelM;
		panelInherited.add(new JLabel("Nowa wartość minimalnego postąpienia:"), "wrap");
		
		fieldBeanCreate("podaj minimalną wartość oferty w kroku "+newKrokNr, minPostVal, errMessageMinPostVal);

		
		JPanel localPanel = FormUtils.createForm(super.listFieldBean);
		panelInherited.add(localPanel, "wrap");
		
		List<JButton> buttonList = new ArrayList<>();
		buttonList.add(new JButton("anuluj"));
		buttonList.add(new JButton("dalej"));

		saveBtn = new JButton("zapisz");
		buttonList.add(saveBtn);
		saveBtn.setEnabled(false);

		JPanel buttonPanel = FormUtils.createButtons(buttonList, this);
		panelInherited.add(buttonPanel, "wrap");
		
		
		
		
		
		
	}
	
	
	public static synchronized MinPostEnterForm getInstanceMinPostForm(double prevMinPost, int krokNr)	{
		if (formInstance!=null)	{
			System.out.println("Singleton - instancja już istnieje i nie tworzymy nowej");
			return null;
		}
		System.out.println("Singleton - Nowa instancja");
		return new MinPostEnterForm(prevMinPost, krokNr) ;
	}
	
	@Override
	public void focusLost(FocusEvent e) {
	
		repaint();
		revalidate();
		

		
		DoubleValidator dv = new DoubleValidator();
		boolean resMinStep = dv.validate(new FormFieldData(minPostVal.getText()));
		String messageDomiar = dv.printErrMessage(new FormFieldData(minPostVal.getText()));
		errMessageMinPostVal.setText(messageDomiar);


		saveBtn.setEnabled(resMinStep);
		
		this.repaint();

	}



}
