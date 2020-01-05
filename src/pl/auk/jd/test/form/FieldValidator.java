package pl.auk.jd.test.form;

public interface FieldValidator {

	boolean validate(FormFieldData testedValue);
	String getErrMessage(FormFieldData testedValue);

}
