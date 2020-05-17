package pl.auk.validators;

import pl.auk.jd.test.form.FormFieldData;

public class NothingValidator implements FieldValidator {

	public NothingValidator()	{
		
	}

	@Override
	public boolean validate(FormFieldData testedValue) {
		return true;
	}

	@Override
	public String printErrMessage(FormFieldData testedValue) {
		return "";
	}
	public static void main(String[] args) {
		

	}
}