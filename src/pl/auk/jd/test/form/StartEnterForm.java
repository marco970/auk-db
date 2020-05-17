package pl.auk.jd.test.form;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class StartEnterForm extends RawForm {
	
	private static String[] start = {"Start", "Exit"};
	private static Font fontNazwa = new Font("Tahoma", Font.PLAIN, 11);
//	private JLabel errMessageName;

	public StartEnterForm(String title, List<String> bidders) {
		super(title, start);
			
		
		for (String el: bidders)	{
			System.out.println("--- "+el);
		}
		
		for (String el: bidders)	{
			
			
			
//			JLabel nazwa = new JLabel(el);
			JTextField cena = new JTextField();
			cena = FormUtils.textFieldDef(20, this, fontNazwa);
			cena.setName(el);
			
			JLabel errMessageName = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
			errMessageName.setName(el);
			
			fieldBeanCreate(el, cena, errMessageName);
			

			
			
//			panel.add(nazwa, "gapleft 30");
		}
		System.out.println("----- "+super.listFieldBean.size());
		
		JPanel panelInherited = super.panelM;
		panelInherited.add(new JLabel("Dane aukcji:"), "wrap");
		
		JPanel localPanel = FormUtils.createForm(super.listFieldBean);
		panelInherited.add(localPanel, "wrap");
	
		
	}

	public static void main(String[] args) {
		List<String> bidders = new ArrayList<String>();
		bidders.add("epo");
		bidders.add("nokia");
		bidders.add("Huawei");
		bidders.add("InterOp");
		bidders.add("f2f avoiders");
		
		
		new StartEnterForm("heja", bidders); 

	}

}
