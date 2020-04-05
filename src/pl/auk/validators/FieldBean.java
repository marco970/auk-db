package pl.auk.validators;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FieldBean {
	
	private JLabel nazwa;
	
	private JComponent component;
	
	
	private JLabel errMessage;
	
	
	public FieldBean(JLabel nazwa, JComponent component, JLabel errMessage) {
		super();
		this.nazwa = nazwa;
		this.component = component;
		this.errMessage = errMessage;
	}
	



	public JLabel getNazwa() {
		return nazwa;
	}


	public void setNazwa(JLabel nazwa) {
		this.nazwa = nazwa;
	}


	public JComponent getComponent() {
		return component;
	}


	public void setComponent(JComponent component) {
		this.component = component;
	}


	public JLabel getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(JLabel errMessage) {
		this.errMessage = errMessage;
	}


	@Override
	public String toString() {
		return "FieldBean [nazwa=" + nazwa + ", component=" + component + ", errMessage=" + errMessage + "]";
	}
	
	
	

}
