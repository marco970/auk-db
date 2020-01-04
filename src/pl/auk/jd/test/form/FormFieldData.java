package pl.auk.jd.test.form;

public class FormFieldData {
	
	private String testedStr;
	
	private int testedInt;
	
	private String testedEmail;

	public FormFieldData(String testedStr, int testedInt, String testedEmail) {
		super();
		this.testedStr = testedStr;
		this.testedInt = testedInt;
		this.testedEmail = testedEmail;
	}

	public String getTestedStr() {
		return testedStr;
	}

	public void setTestedStr(String testedStr) {
		this.testedStr = testedStr;
	}

	public int getTestedInt() {
		return testedInt;
	}

	public void setTestedInt(int testedInt) {
		this.testedInt = testedInt;
	}

	public String getTestedEmail() {
		return testedEmail;
	}

	public void setTestedEmail(String testedEmail) {
		this.testedEmail = testedEmail;
	}
	
	
	
	

}
