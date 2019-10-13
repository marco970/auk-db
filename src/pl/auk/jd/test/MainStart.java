package pl.auk.jd.test;

public class MainStart {

	public static void main(String[] args) {
		
		StepBean sb = new StepBean();
		sb.setStepNr(1);
		DynamicLabel dl = new DynamicLabel(sb.getStepNr());
		TheView tv = new TheView(sb, dl);
		
		sb.addPropertyChangeListener(tv);
		
		
		
		
	
		
		

	}

}
