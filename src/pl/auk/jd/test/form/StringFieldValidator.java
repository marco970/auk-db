package pl.auk.jd.test.form;

import java.util.regex.Pattern;

public class StringFieldValidator implements FieldValidator {
	


	private FormFieldData testedValue;


	public StringFieldValidator(FormFieldData testedValue) {
		super();
		this.testedValue = testedValue;

	}
	
	@Override
	public boolean validate() {
		String testedString = testedValue.getTestedStr();
		String patt = "\\s+";
		Pattern pattern = Pattern.compile(patt);
		if(!(pattern.matcher(testedString).matches() || "".equals(testedString)))	{
			return true;
		}else return false;
	}

	@Override
	public String getErrMessage() {
		if (validate()) return "";
		else return "pole nie może byc puste";
	}

	public static void main(String[] args) {
		
		FormFieldData testedValue = new FormFieldData("", 0, "");
		StringFieldValidator str = new StringFieldValidator(testedValue);
		System.out.println(str.getErrMessage());
		System.out.println(str.validate());


	}
}
