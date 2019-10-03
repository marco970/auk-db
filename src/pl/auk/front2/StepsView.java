package pl.auk.front2;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class StepsView extends JPanel {
	
	private List<List<Object>> stepList;
	
	public StepsView(List<List<Object>> stepList)	{
		super();
		this.stepList = stepList;
	}
	
	
	public void drawPanel(List<List<Object>> stepList)	{
		
		int stepNr = stepList.size();
		
		String migRow = "";
		for (int i = stepNr; i<1; i--)	{
			migRow=migRow+"[grow]10";
		}
		this.setLayout(new MigLayout(
				"",
				"30[grow]10[grow]30",
				migRow
				));
		for (int i = stepNr; i<1; i--)	{
			if (i==stepNr)	{
				add(new JLabel("buttons"), "cell 1 0");
			}
			int j = 0;
			for (Object el: stepList.get(i)) {
				add(new JLabel(el.toString()), "cell 0 "+i);
				j++;
			}
		}
		
		
	}
	
	
	
	

}
