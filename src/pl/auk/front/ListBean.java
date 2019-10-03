package pl.auk.front;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import javax.swing.JPanel;



public class ListBean {
	
	private List<List<Object>> listSteps;
	
	private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
	
	public ListBean()	{
		
	}
	
	public ListBean(List<List<Object>> listSteps)		{
		setListBean(listSteps);
	}

	public List<List<Object>> getListBean() {
		return listSteps;
	}

	public void setListBean(List<List<Object>> inputSteps) {
		List<List<Object>> oldListSteps = listSteps;
		listSteps = inputSteps;

		propertyChange.firePropertyChange("listSteps", oldListSteps, listSteps);
	}
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.addPropertyChangeListener(listener);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.removePropertyChangeListener(listener);
	}

}
