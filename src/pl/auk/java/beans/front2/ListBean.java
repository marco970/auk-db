package pl.auk.java.beans.front2;

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

	public synchronized void setListBean(List<List<OfferEnti>> listSteps2) {
//		System.out.println(this.getClass().toString()+" "+listSteps2.size());
		List<List<OfferEnti>> oldListSteps = listSteps;
		listSteps = listSteps2;
		
		System.out.println("tamtestuje"+listSteps2.getClass()+listSteps2.size());
		System.out.println("tamtestuje2"+listSteps.getClass()+listSteps.size());
		
		this.getPCListeners();

		propertyChange.firePropertyChange("listSteps", oldListSteps, listSteps);
	}
	
	
	public void getPCListeners()	{
		PropertyChangeListener[] pcl = propertyChange.getPropertyChangeListeners();
		
		for(PropertyChangeListener el: pcl) {
			System.out.println(el.getClass());
		}
	}
	
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.addPropertyChangeListener(listener);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.removePropertyChangeListener(listener);
	}

}
