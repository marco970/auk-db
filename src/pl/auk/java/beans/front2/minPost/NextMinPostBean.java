package pl.auk.java.beans.front2.minPost;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NextMinPostBean {
	
	private double minPost;
	


	private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);



	
	public NextMinPostBean()	{
		this(0);
	}
	
	public NextMinPostBean(double minPost)	{
		setMinPost(minPost);
//		getPCListeners();
	}
	
	
//	public void getPCListeners()	{
//		PropertyChangeListener[] pcl = propertyChange.getPropertyChangeListeners();
//		
//		for(PropertyChangeListener el: pcl) {
//			System.out.println("NextMinPostBean-PCListeners  ---> "+el.getClass().getSimpleName());
//		}
//	}
	
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.addPropertyChangeListener(listener);
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.removePropertyChangeListener(listener);
	}
	
	public double getMinPost() {
		return minPost;
	}

	public void setMinPost(double minPost) {
		double oldMinPost = this.minPost;
		this.minPost = minPost;
		
		propertyChange.firePropertyChange("minPost", oldMinPost, minPost);
	}
	
	

}
 