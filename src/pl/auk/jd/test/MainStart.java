package pl.auk.jd.test;

public class MainStart {

	public static void main(String[] args) {
		
		StepBean sb = new StepBean(0);
		TheView tv = new TheView(sb.getStepNr());
		
		sb.addPropertyChangeListener(tv);
		
		
		
		
	
		
		

	}

}
