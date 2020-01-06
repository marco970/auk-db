package pl.auk.jd.test.form;

public interface FieldValidator {

	boolean validate(FormFieldData testedValue);
	String printErrMessage(FormFieldData testedValue);

}
