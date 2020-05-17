package pl.auk.validators;

import java.util.regex.Pattern;

import pl.auk.jd.test.form.FormFieldData;

public class DoublePlusValidator implements FieldValidator {
	
	

	public DoublePlusValidator() {
		super();
	}

	@Override
	public boolean validate(FormFieldData testedValue) {
		/**
		 * ptzerobić w taki sposób, żeby można było dać komunikat, że wartość nie może być ujemna
		 */
		String testedString = testedValue.getTestedStr().replace(',', '.');
		String patt = "[+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
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
				return "nieprawidłowa wartość";
		}else return "pole nie może być puste";
	}
	
	

}
