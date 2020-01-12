package pl.auk.jd.test.form;

import java.util.regex.Pattern;

public class CurrencyFieldValidator implements FieldValidator {
	
	public CurrencyFieldValidator()	{
		super();
	}
	@Override
	public boolean validate(FormFieldData testedValue) {
		String testedString = testedValue.getTestedStr();
		String patt = "[^\\s]{1,9}";
		Pattern pattern = Pattern.compile(patt);
		if((pattern.matcher(testedString).matches()))	{
			return true;
		}else return false;
	}

	@Override
	public String printErrMessage(FormFieldData testedValue) {
		if (validate(testedValue)) return "";
		else return "nazwa waluty powinna być pojedyńczym słowem do 10 znaków";
	}
	
	public static void main(String[] args) {
		
		FormFieldData testedValue = new FormFieldData("adsfff");
		CurrencyFieldValidator str = new CurrencyFieldValidator();
		System.out.println(str.printErrMessage(testedValue));
		System.out.println(str.validate(testedValue));


	}

}
