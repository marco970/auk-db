package pl.auk.front2;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.OfferEnti;

public class StepsView extends JPanel {
	
	private List<List<OfferEnti>> stepList;
	
	public StepsView(List<List<OfferEnti>> stepList)	{
		super();
		this.stepList = stepList;
		System.out.println(" StepsView - construct");
		drawPanel(stepList);
		
	}
	
	
	public void drawPanel(List<List<OfferEnti>> stepList)	{
		
		System.out.println("StepsView - drawPanel");
		
		int stepNr = stepList.size();
		System.out.println("drawPanel stepNr "+ stepNr); 
		String migRow = "10";
		for (int i = stepNr; i<1; i--)	{
			migRow=migRow+"[grow]10";
		}
		this.setLayout(new MigLayout(
				"",
				"10[grow]10[grow]10",
				migRow
				));
		for (int i = stepNr; i>1; i--)	{
			System.out.println("testloop "+i);
		}
		
		for (int i = stepNr; i>0; i--)	{
			System.out.println("first loop "+i);
			if (i==stepNr)	{
				add(new JLabel("buttons"), "cell 1 0");
			}
			int j = 0;
			for (OfferEnti el: stepList.get(i-1)) {
				add(new JLabel(el.toString()), "cell 0 "+i);
				System.out.println(el.toString());
				j++;
			}
		}
		
//		add(new JLabel("drawPanel - test"));
		
		
	}
	
	
	
	

}
