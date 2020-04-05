package pl.auk.validators;

import java.util.regex.Pattern;

import pl.auk.jd.test.form.FormFieldData;

public interface FieldValidator {

	boolean validate(FormFieldData testedValue);
	String printErrMessage(FormFieldData testedValue);
	
	static boolean notEmpty(FormFieldData testedValue) {
		String testedString = testedValue.getTestedStr();
		String patt = "\\s+";
		Pattern pattern = Pattern.compile(patt);
		if(!(pattern.matcher(testedString).matches() || "".equals(testedString)))	{
			return true;
		}else return false;
	}

}
