package pl.auk.front2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PropertyTest implements PropertyChangeListener {
	
	public PropertyTest()	{
		System.out.println("hi -pt");
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		System.out.println("propertyTest "+e.getNewValue().getClass());
		
		
	}

}
