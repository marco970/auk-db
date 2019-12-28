package pl.auk.java.beans.front2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.SessionFactory;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.AukcjaAdd;
import pl.auk.entities.Aukcje;
import pl.auk.start.SeFaStart;

public class NewAukcjaCreateForm extends RawForm implements ActionListener, FocusListener		{
	
	private static String[] start = {"Start", "Exit"};
	
	private JTextField tfNazwa;
	private JTextArea taOpis;
	private JTextField tfWaluta;
	private JLabel errMessageNazwa;
	private JLabel errMessageWaluta;
	private JButton saveBtn;

	public NewAukcjaCreateForm() {
		super("Tworzenie nowej Aukcji", start);
		JPanel panelInherited = super.panelM;
		panelInherited.add(new JLabel("Tworzenie nowej aukcji:"), "wrap");
		
		JPanel panelLocal = new JPanel();
		panelLocal.setLayout(new MigLayout());
		panelInherited.add(panelLocal);
		tfNazwa = new JTextField(20);
		tfNazwa.addFocusListener(this);
		taOpis = new JTextArea(5,20);
		JScrollPane sp = new JScrollPane(taOpis);
		tfWaluta = new JTextField(10);
		tfWaluta.addFocusListener(this);
		
		
		this.errMessageNazwa = errorMessageDef();
		this.errMessageWaluta = errorMessageDef();
		
		panelLocal.add(new JLabel("<html><p style ='font-weight: normal'>nazwa</p></html>"), "right");
		panelLocal.add(tfNazwa);
		panelLocal.add(errMessageNazwa, "wrap");
		panelLocal.add(new JLabel("<html><p style ='font-weight: normal'>opis</p></html>"), "right");
		panelLocal.add(sp, "wrap");
		panelLocal.add(new JLabel("<html><p style ='font-weight: normal'>waluta</p></html>"), "right");
		panelLocal.add(tfWaluta);
		panelLocal.add(errMessageWaluta, "wrap");
		
		saveBtn = new JButton("zapisz");
		saveBtn.addActionListener(this);
		saveBtn.setEnabled(false);
		JButton cancelBtn = new JButton("anuluj");
		cancelBtn.addActionListener(this);
		
		panelLocal.add(new JLabel(), "wrap");
		panelLocal.add(cancelBtn, "right");
		panelLocal.add(saveBtn, "wrap");
		
	}

	private JLabel errorMessageDef() {
		JLabel errMessage = new JLabel("");		
		errMessage.setHorizontalAlignment(SwingConstants.LEFT);
		errMessage.setForeground(Color.RED);
		errMessage.setFont(new Font("Tahoma", Font.PLAIN, 9));
		return errMessage;
	}
	
	public void actionPerformed(ActionEvent e) {
		String u = e.getActionCommand();
		if (u.equals("anuluj"))	{
			this.dispose();
			new AukcjomatView();
		}
		if (u.equals("zapisz"))	{
			Aukcje aukcja = new Aukcje(tfNazwa.getText(), taOpis.getText(), "", "", tfWaluta.getText());
			SessionFactory factory = SeFaStart.getFactory();
			new AukcjaAdd(aukcja, factory);
			new AukcjomatView();
			
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (tfNazwa.getText().contentEquals(""))	{
			errMessageNazwa.setText("Nazwa aukcji musi zostać podana");
		}
		else {
			errMessageNazwa.setText("");
			stringNotEmpty();
		}
		if (tfWaluta.getText().contentEquals(""))	{
			errMessageWaluta.setText("Waluta aukcji musi zostać podana");
		}
		else {
			errMessageWaluta.setText("");
			stringNotEmpty();
		}
	}

	private void stringNotEmpty() {
		if (tfNazwa.getText().contentEquals("") || tfWaluta.getText().contentEquals(""))	saveBtn.setEnabled(false);
		else saveBtn.setEnabled(true);
	}
	

}
