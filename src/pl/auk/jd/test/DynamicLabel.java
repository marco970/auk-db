package pl.auk.jd.test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;

public class DynamicLabel extends JLabel implements PropertyChangeListener {
	
	public DynamicLabel(int stepNr) {
		super(""+stepNr);
		System.out.println("dl - odpalam siê");
		
		
		
	}
	
	public void setDl(int stepNr)	{
		setText(""+stepNr);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		setText(""+event.getNewValue());
		System.out.println("dl - s³ucham "+event.getNewValue());
		
	}

}
