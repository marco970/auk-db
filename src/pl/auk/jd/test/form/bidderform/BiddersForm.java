package pl.auk.jd.test.form.bidderform;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

import pl.auk.back.BidderAdd;
import pl.auk.back.BidderUpdate;
import pl.auk.entities.Aukcje;
import pl.auk.entities.Bidders;
import pl.auk.jd.test.form.CurrencyFieldValidator;
import pl.auk.jd.test.form.DoubleValidator;
import pl.auk.jd.test.form.EmailFieldValidator;
import pl.auk.jd.test.form.FormFieldData;
import pl.auk.jd.test.form.FormUtils;
import pl.auk.jd.test.form.RawForm;
import pl.auk.jd.test.form.StringFieldValidator;

public class BiddersForm extends RawForm implements FormUtils, ActionListener {

	private static String[] start = {"Start", "Exit"};
	
	private static String[] buttons = {"Anuluj", "Zapisz"};
	
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfDomiar;
	private JLabel errMessageName;
	private JLabel errMessageEmail;
	private JLabel errMessageDomiar;
	
	private JButton saveBtn;
	
	private boolean nowa;
	
	private static Font fontNazwa = new Font("Tahoma", Font.PLAIN, 11);
	
	private Aukcje aukcja;
	
	private BidderFormTableModel modelBidders;
	
	private Bidders bidder;
	

	public BiddersForm(Aukcje aukcja, BidderFormTableModel modelBidders) {
		super("Nowy Oferent", start);
		
		this.tfName = FormUtils.textFieldDef(20, this, fontNazwa);
		this.tfEmail = FormUtils.textFieldDef(20, this, fontNazwa);
		this.tfDomiar = FormUtils.textFieldDef(20, this, fontNazwa);
		this.errMessageName = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		this.errMessageEmail = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		this.errMessageDomiar = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		
		this.nowa = true;
		
		this.aukcja = aukcja;
		
		this.modelBidders =modelBidders;
		
		konstruktorCommon();
	}
	
	public BiddersForm(Aukcje aukcja, BidderFormTableModel modelBidders, Bidders bidder) {
		super("Edycja danych Oferenta", start);
		
		this.bidder = bidder;
		
		this.tfName = FormUtils.textFieldDef(20, this, fontNazwa);
		this.tfEmail = FormUtils.textFieldDef(20, this, fontNazwa);
		this.tfDomiar = FormUtils.textFieldDef(20, this, fontNazwa);
		this.errMessageName = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		this.errMessageEmail = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		this.errMessageDomiar = FormUtils.labelDef(Color.RED, SwingConstants.LEFT);
		
		this.nowa = false;
		
		this.aukcja = aukcja;
		
		this.modelBidders =modelBidders;
		
		tfName.setText(bidder.getName());
		tfEmail.setText(bidder.getEmail());
		tfDomiar.setText(bidder.getDomiar()+"");
		
		
		konstruktorCommon();	
	}
	
	private void konstruktorCommon() {
		
		JPanel panelInherited = super.panelM;
		panelInherited.add(new JLabel("Dane Oferenta:"), "wrap");
		
		fieldBeanCreate("nazwa Oferenta", tfName, errMessageName);
		fieldBeanCreate("e-mail", tfEmail, errMessageEmail);
		fieldBeanCreate("domiar"+"["+aukcja.getWaluta()+"]", tfDomiar, errMessageDomiar);
		
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
		
		if (u.equals("zapisz") && nowa)	{
			
			Bidders bidder= new Bidders(tfName.getText(), tfEmail.getText(), Double.parseDouble(tfDomiar.getText().replace(',', '.')));
			new BidderAdd(aukcja, bidder);
			modelBidders.recordAdd(bidder);
			
			dispose();
		}
		
		if (u.equals("zapisz") && !nowa)	{
			bidder.setName(tfName.getText());
			bidder.setEmail( tfEmail.getText());
			bidder.setDomiar(Double.parseDouble(tfDomiar.getText().replace(',', '.')));
			new BidderUpdate(bidder);

			
			modelBidders.recordUpdate(bidder);
			
			dispose();
			
		}
		
		if (u.equals(start[start.length-1]))	{
			this.dispose();
		}
		
		if (u.equals("anuluj"))	{
			this.dispose();
		}

	}
	
	@Override
	public void focusLost(FocusEvent e) {
	
		repaint();
		revalidate();
		
		StringFieldValidator sv1 = new StringFieldValidator();
		boolean resName = sv1.validate(new FormFieldData(tfName.getText())); 
		String messageName = sv1.printErrMessage(new FormFieldData(tfName.getText()));
		
		if (resName)	errMessageName.setText("");
		else errMessageName.setText(messageName);
		
		EmailFieldValidator ev = new EmailFieldValidator();
		boolean resEmail = ev.validate(new FormFieldData(tfEmail.getText()));
		String messageEmail = ev.printErrMessage(new FormFieldData(tfEmail.getText()));
		errMessageEmail.setText(messageEmail);
		
		DoubleValidator dv = new DoubleValidator();
		boolean resDomiar = dv.validate(new FormFieldData(tfDomiar.getText()));
		String messageDomiar = dv.printErrMessage(new FormFieldData(tfDomiar.getText()));
		errMessageDomiar.setText(messageDomiar);


		saveBtn.setEnabled(resName && resEmail && resDomiar);
		System.out.println(resName +" -- "+ resEmail +" -- "+ resDomiar);
		this.repaint();

	}


}
