package pl.auk.jd.test.form;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class FormBean {
	
	private String nazwa;
	
	private JComponent component;
	
	private FieldValidator validator;
	
	
	public FormBean(String nazwa, JComponent component, FieldValidator validator) {
		super();
		this.nazwa = nazwa;
		this.component = component;
		this.validator = validator;
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

	
	public FieldValidator getValidator() {
		return validator;
	}

	
	public void setValidator(FieldValidator validator) {
		this.validator = validator;
	}
	

	@Override
	public String toString() {
		return "FormBean [nazwa=" + nazwa + ", component=" + component.getName() + ", validator=" + validator.getClass() + "]";
	}


	public static void main(String[] args) {
		
		FormFieldData testedValue = new FormFieldData("", 0, "");

		FormBean fb = new FormBean("asd", new JTextArea(), new StringFieldValidator(testedValue) );
		System.out.println(fb.toString());
	}

}
