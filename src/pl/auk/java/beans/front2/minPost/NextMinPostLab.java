package pl.auk.java.beans.front2.minPost;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;

public class NextMinPostLab extends JLabel implements PropertyChangeListener {

	public NextMinPostLab()	{
		this("0");
		
	}
	public NextMinPostLab(String minPostString)	{
		super(minPostString);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
//		System.out.println("ropertyChangeListener zadziałał");
		
		String nextMinPost = evt.getNewValue()+"";
		this.setText(nextMinPost);
		
//		System.out.println(this.getClass().getSimpleName()+" "+ nextMinPost);
		
	}

}
