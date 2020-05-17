package pl.auk.java.beans.front2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import pl.auk.validators.DoublePlusValidator;

public class MinPostEnterForm extends RawForm implements FormUtils, ActionListener, WindowListener {
	
	private List<List<OfferEnti>> stepList;
	
	private static String[] start = {"Start", "Exit"};
	
	private static String[] buttons = {"dalej", "anuluj", "zapisz"};
	
	private static MinPostEnterForm formInstance = null;
	
	private double prevMinPost = -1000;
	
	private static Font fontNazwa = new Font("Tahoma", Font.PLAIN, 11);
	
	private JTextField minPostVal;
	private JLabel errMessageMinPostVal;
	
	private JButton saveBtn;
	
	private static String name;
	
	private StepsView sv;
	
	private int newKrokNr;
	
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
	private MinPostEnterForm (StepsView sv, double prevMinPost, int krokNr, List<List<OfferEnti>> stepList) {
		super("", start);
		
		this.sv = sv;
		this.newKrokNr = krokNr+1;
		this.stepList = stepList;
		
		this.name = this.getClass().getSimpleName();
		super.setTitle("Zamiana minimalnego postąpienia w kroku "+newKrokNr+" - "+name);
//		System.out.println(name);
		this.prevMinPost = prevMinPost;
		this.minPostVal = FormUtils.textFieldDef(20, this, fontNazwa);
		this.errMessageMinPostVal = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		
		this.addWindowListener(this);
		
		minPostVal.setText(""+prevMinPost);
		
		JPanel panelInherited = super.panelM;
		panelInherited.add(new JLabel("Nowa wartość minimalnego postąpienia:"), "wrap");
		
		fieldBeanCreate("podaj minimalną wartość oferty w kroku "+newKrokNr, minPostVal, errMessageMinPostVal);

		
		JPanel localPanel = FormUtils.createForm(super.listFieldBean);
		panelInherited.add(localPanel, "wrap");
		
		List<JButton> buttonList = new ArrayList<>();
		buttonList.add(new JButton(buttons[buttons.length-2]));
		buttonList.add(new JButton(buttons[buttons.length-3]));

		saveBtn = new JButton(buttons[buttons.length-1]);
		buttonList.add(saveBtn);
		saveBtn.setEnabled(false);

		JPanel buttonPanel = FormUtils.createButtons(buttonList, this);
		panelInherited.add(buttonPanel, "wrap");
		formInstance = this;
		
	}
	
	
	public static synchronized MinPostEnterForm getInstanceMinPostForm(StepsView sv, double prevMinPost, int krokNr, List<List<OfferEnti>> stepList)	{
		if (formInstance!=null)	{
			System.out.println("Singleton - instancja już istnieje i nie tworzymy nowej");
			return null;
		}
//		System.out.println("Singleton - Nowa instancja");
		return new MinPostEnterForm(sv, prevMinPost, krokNr, stepList) ;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String u = e.getActionCommand();
		System.out.println(u);
		System.out.println(buttons[buttons.length-2]);
//		System.out.println(start[start.length-1]);
//		System.out.println(u);
		if (u.equals(buttons[buttons.length-1]))	{
//			System.out.println(start[start.length-1]);
			String fromFieldString = minPostVal.getText().replace(',', '.');
			double minPostDouble = Double.parseDouble(fromFieldString); 
			sv.setMinPost(minPostDouble);
//			sv.setDynamicContent(stepList);
//			System.out.println(this.getClass().getSimpleName()+"  krokNr "+newKrokNr + " minPost: "+minPostDouble);
			formInstance = null;
			dispose();
			
		}
		if (u.equals(buttons[buttons.length-2]))	{

			formInstance = null;
			this.dispose();
		}
		
		if (u.equals(start[start.length-1]))	{
			formInstance = null;
			this.dispose();
		}
		
	}
	
	
	@Override
	public void focusLost(FocusEvent e) {
	
		repaint();
		revalidate();
		

		
		DoublePlusValidator dv = new DoublePlusValidator();
		boolean resMinStep = dv.validate(new FormFieldData(minPostVal.getText()));
		String message = dv.printErrMessage(new FormFieldData(minPostVal.getText()));
		errMessageMinPostVal.setText(message);


		saveBtn.setEnabled(resMinStep);
		
		this.repaint();

	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		formInstance = null;
//		to przy zamykaniu krzyżykiem
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		formInstance = null;
//		to przy zamykaniu 
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



}
