package pl.auk.jd.test.form;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormInput extends RawForm {
	
//	do wywalenia?
	
	private String nazwa;
	
	private JComponent component;
	
	private List<Method> methValidacji;
	
	private List<String> errMessages;
	
	private static String[] start = {"Start", "Exit"};

	public FormInput(String nazwa, JComponent component) {
		super("formularz testowy", start);
		this.nazwa = nazwa;
		this.component = component;
		
		System.out.println("konstruktor a");
			
		JPanel panelInherited = super.panelM;
		
		

	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public JComponent getComponent() {
		return component;
	}

	public void setComponent(JComponent component) {
		this.component = component;
	}

	public List<Method> getMethValidacji() {
		return methValidacji;
	}

	public void setMethValidacji(List<Method> methValidacji) {
		this.methValidacji = methValidacji;
	}

	public List<String> getErrMessages() {
		return errMessages;
	}

	public void setErrMessages(List<String> errMessages) {
		this.errMessages = errMessages;
	}
	
	
	public static void main(String[] args) {
		
		
		String nazwa = "test 1";
		JTextField ta = new JTextField(15);
		
		
		new FormInput(nazwa, ta);

	}


}
