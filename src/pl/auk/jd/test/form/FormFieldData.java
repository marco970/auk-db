package pl.auk.jd.test.form;

public class FormFieldData {
	
	private String testedStr;
	
	private int testedInt;
	
	private double testedDouble;
	
	
	
	
	public FormFieldData(String testedStr)	{
		this.testedStr = testedStr;
	}
	public FormFieldData(int testedInt)	{
		this.testedInt = testedInt;
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

}
