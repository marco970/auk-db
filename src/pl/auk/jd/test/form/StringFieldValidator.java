package pl.auk.jd.test.form;

import java.util.regex.Pattern;

public class StringFieldValidator implements FieldValidator {


	public StringFieldValidator() {
		super();
	}
	
	@Override
	public boolean validate(FormFieldData testedValue) {
		String testedString = testedValue.getTestedStr();
		String patt = "\\s+";
		Pattern pattern = Pattern.compile(patt);
		if(!(pattern.matcher(testedString).matches() || "".equals(testedString)))	{
			return true;
		}else return false;
	}

	@Override
	public String getErrMessage(FormFieldData testedValue) {
		if (validate(testedValue)) return "";
		else return "pole nie może byc puste";
	}

	public static void main(String[] args) {
		
		FormFieldData testedValue = new FormFieldData("", 0, "");
		StringFieldValidator str = new StringFieldValidator();
		System.out.println(str.getErrMessage(testedValue));
		System.out.println(str.validate(testedValue));


	}
}
