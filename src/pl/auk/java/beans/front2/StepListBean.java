package pl.auk.front2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class StepListBean {
	
	
	private List<List<Object>> stepList;
	
	private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
	
	public StepListBean()	{
		
	}
	
	public StepListBean(List<List<Object>> stepList)	{
		setStepList(stepList);
	}

	public List<List<Object>> getStepList() {
		return stepList;
	}

	public void setStepList(List<List<Object>> inStepList) {
		List<List<Object>> OldStepList  = stepList;
		this.stepList = inStepList;
		propertyChange.firePropertyChange("stepList", OldStepList, stepList);
	}
	
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.addPropertyChangeListener(listener);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.removePropertyChangeListener(listener);
	}

}
