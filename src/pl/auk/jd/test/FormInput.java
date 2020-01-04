package pl.auk.jd.test;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JComponent;

public class FormInput {
	
	private String nazwa;
	
	private JComponent component;
	
	private List<Method> methValidacji;
	
	private List<String> errMessages;

	public FormInput(String nazwa, JComponent component, List<Method> methValidacji, List<String> errMessages) {
		super();
		this.nazwa = nazwa;
		this.component = component;
		this.methValidacji = methValidacji;
		this.errMessages = errMessages;
		
		if (methValidacji.size()!=errMessages.size()) {
			System.out.println("******* Błędne dane walidacji");
		}

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
		// TODO Auto-generated method stub

	}


}
