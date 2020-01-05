package pl.auk.jd.test.form;

public class NothingValidator implements FieldValidator {

	public NothingValidator()	{
		
	}

	@Override
	public boolean validate(FormFieldData testedValue) {
		return true;
	}

	@Override
	public String getErrMessage(FormFieldData testedValue) {
		return "";
	}
	public static void main(String[] args) {
		

	}
}
