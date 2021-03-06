package pl.auk.jd.test;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StepBean {
	
	private int stepNr = 0;
	
	private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);

	
	public StepBean()	{
		
	}
	
	
	public StepBean(int stepNr) {
		setStepNr(stepNr); 
	}

	
	
	
	
	public int getStepNr() {
		return stepNr;
	}

	public void setStepNr(int stepNr) {
		
		System.out.println("bean: metoda set "+ stepNr);
		int prevStepNr = stepNr;
		this.stepNr = stepNr;
		
		propertyChange.firePropertyChange("stepNr",prevStepNr, stepNr);
	}
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.addPropertyChangeListener(listener);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.removePropertyChangeListener(listener);
	}
	
	

}
