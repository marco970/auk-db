package pl.auk.jd.test.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

import net.miginfocom.swing.MigLayout;
import pl.auk.back.AukcjaAdd;
import pl.auk.back.AukcjaUpdate;
import pl.auk.entities.Aukcje;
import pl.auk.java.beans.front2.AukcjomatView;
import pl.auk.validators.CurrencyFieldValidator;
import pl.auk.validators.StringFieldValidator;


public class AukcjaDaneForm extends RawForm implements FormUtils {
	
	private static String[] start = {"Start", "Exit"};
	
	private static String[] buttons = {"Anuluj", "Zapisz"};

	private JTextField tfNazwa;
	private JTextArea taOpis;
	private JTextField tfWaluta;
	private JLabel errMessageNazwa;
	private JLabel errMessageWaluta;
	private JButton saveBtn;
	private JButton toBidders;
	private Aukcje aukcjaMod;
	
	private boolean nowa;
	
	private static Font fontNazwa = new Font("Tahoma", Font.PLAIN, 11);

	public AukcjaDaneForm() {
		super("Dane aukcji - dodaj", start);
		
		this.tfNazwa = FormUtils.textFieldDef(20, this, fontNazwa);
		this.taOpis = new JTextArea(5,20);
		this.tfWaluta = FormUtils.textFieldDef(10, this, fontNazwa);
		this.errMessageNazwa = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		this.errMessageWaluta = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		this.nowa = true;
		
		konstruktorCommon();

	}
	
	public AukcjaDaneForm(Aukcje aukcja) {
		super("Dane aukcji - edytuj", start);
		
		this.tfNazwa = FormUtils.textFieldDef(20, this, fontNazwa);
		this.taOpis = new JTextArea(5,20);
		this.tfWaluta = FormUtils.textFieldDef(10, this, fontNazwa);
		this.errMessageNazwa = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		this.errMessageWaluta = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		this.nowa = false;
		this.aukcjaMod = aukcja;
		
		tfNazwa.setText(aukcja.getNazwaAuk());
		taOpis.setText(aukcja.getOpisAuk());
		tfWaluta.setToolTipText(aukcja.getWaluta());
		
		konstruktorCommon();

	}

	private void konstruktorCommon() {
		JScrollPane sp = new JScrollPane(taOpis);
		tfWaluta.setText("Euro");
			
		fieldBeanCreate("nazwa", tfNazwa, errMessageNazwa);
		fieldBeanCreate("waluta", tfWaluta, errMessageWaluta);
		fieldBeanCreate("opis", sp, new JLabel(""));

		JPanel panelInherited = super.panelM;
		panelInherited.add(new JLabel("Dane aukcji:"), "wrap");
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String u = e.getActionCommand();
		if (u.equals("zapisz"))	{
			Aukcje aukcja = new Aukcje(
					tfNazwa.getText(), 
					taOpis.getText(), 
					"", 
					"", 
					tfWaluta.getText());
			if (nowa) {
				new AukcjaAdd(aukcja);
			}else {
				aukcja.setIdAukcja(aukcjaMod.getIdAukcja());
				new AukcjaUpdate(aukcja);
			}
			new AukcjomatView();
		}

		if (u.equals(start[start.length-1]))	{
			this.dispose();
			new AukcjomatView();
		}
		
		if (u.equals("anuluj"))	{
			this.dispose();
			new AukcjomatView();
		}
		if (u.equals("dalej"))	{
			this.revalidate();
			this.repaint();
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
	
		repaint();
		revalidate();
		
		StringFieldValidator sv1 = new StringFieldValidator();

		boolean resNazwa = sv1.validate(new FormFieldData(tfNazwa.getText())); 

		String messageNazwa = sv1.printErrMessage(new FormFieldData(tfNazwa.getText()));
		
		if (resNazwa)	errMessageNazwa.setText("");
		else errMessageNazwa.setText(messageNazwa);
		
		CurrencyFieldValidator sv2 = new CurrencyFieldValidator();
		
		boolean resWaluta = sv2.validate(new FormFieldData(tfWaluta.getText()));
		
		String messageWaluta = sv2.printErrMessage(new FormFieldData(tfWaluta.getText()));
		
		if (resWaluta) errMessageWaluta.setText("");
		else errMessageWaluta.setText(messageWaluta);

		saveBtn.setEnabled(resNazwa && resWaluta);
		this.repaint();

	}

	
	
	
	
	
	
	
	
	
	
	
}
