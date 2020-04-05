package pl.auk.validators;

import java.util.regex.Pattern;

import pl.auk.jd.test.form.FormFieldData;

public class EmailFieldValidator implements FieldValidator {
	
	
	public EmailFieldValidator() {
		super();
	}

	@Override
	public boolean validate(FormFieldData testedValue) {
		String testedString = testedValue.getTestedStr();
		String patt = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(patt);
		if(pattern.matcher(testedString).matches() && !"".equals(testedString))	{
			return true;
		}else return false;
	}

	@Override
	public String printErrMessage(FormFieldData testedValue) {
		if (FieldValidator.notEmpty(testedValue)) {
			if (validate(testedValue))
				return "";
			else
				return "nieprawidłowy adres email";
		}else return "pole nie może być puste";
	}


}
