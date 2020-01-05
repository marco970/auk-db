package pl.auk.jd.test.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pl.auk.java.beans.front2.RawForm;


public class AukcjaDaneForm extends RawForm implements FormUtils, FocusListener {
	
	private static String[] start = {"Start", "Exit"};
	
	private JTextField tfNazwa;
	private JTextArea taOpis;
	private JTextField tfWaluta;
	private JLabel errMessageNazwa;
	private JLabel errMessageWaluta;
	private JButton saveBtn;
	private StringFieldValidator validateString;
	private NothingValidator noValidation;
	
//	private List<FieldBean> listFieldBean;
	

	public AukcjaDaneForm() {
		super("Dane aukcji - dodaj - edytuj", start);
		
		Font fontNazwa = new Font("Tahoma", Font.PLAIN, 9);
		
		this.tfNazwa = FormUtils.textFieldDef(20, this, fontNazwa);
		
		this.taOpis = new JTextArea(5,20);
		JScrollPane sp = new JScrollPane(taOpis);
		
		this.tfWaluta = FormUtils.textFieldDef(10, this, fontNazwa);

		this.errMessageNazwa = FormUtils.labelDef("", Color.RED, SwingConstants.LEFT);
		System.out.println(errMessageNazwa.toString());
		
		this.errMessageWaluta = FormUtils.labelDef("", Color.RED, SwingConstants.LEFT);
		System.out.println(errMessageWaluta.toString());
		
		
		this.validateString = new StringFieldValidator();
		this.noValidation = new NothingValidator();
		
		fieldBeanCreate("nazwa aukcji", tfNazwa, validateString, errMessageNazwa);
		fieldBeanCreate("opis", sp, noValidation, new JLabel(""));
		fieldBeanCreate("waluta", tfWaluta, validateString, errMessageWaluta);

		JPanel panelInherited = super.panelM;
		panelInherited.add(new JLabel("Dane aukcji:"), "wrap");
		
		JPanel localPanel = FormUtils.createForm(super.listFieldBean);
		panelInherited.add(localPanel, "wrap");

	}

	public static void main(String[] args) {
		new AukcjaDaneForm();
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
