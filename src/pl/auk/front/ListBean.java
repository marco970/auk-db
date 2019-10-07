package pl.auk.front;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import javax.swing.JPanel;

import pl.auk.back.OfferEnti;



public class ListBean {
	
	private List<List<OfferEnti>> listSteps;
	
	private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
	
	public ListBean()	{
		
	}
	
	public ListBean(List<List<OfferEnti>> listSteps)		{
		setListBean(listSteps);
	}

	public List<List<OfferEnti>> getListBean() {
		return listSteps;
	}

	public void setListBean(List<List<OfferEnti>> listSteps2) {
		List<List<OfferEnti>> oldListSteps = listSteps;
		listSteps = listSteps2;

		propertyChange.firePropertyChange("listSteps", oldListSteps, listSteps);
	}
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.addPropertyChangeListener(listener);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.removePropertyChangeListener(listener);
	}

}
