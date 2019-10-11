package pl.auk.java.beans.front2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PropertyTest implements PropertyChangeListener {
	
	public PropertyTest()	{
		System.out.println("hi - tu pt");
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		System.out.println("propertyTest "+e.getNewValue().getClass());
		
		
	}

}
