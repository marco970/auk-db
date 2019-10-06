package pl.auk.front2;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.OfferEnti;

public class StepsView extends JPanel {
	
	private List<List<OfferEnti>> stepList;
	
	public StepsView(List<List<OfferEnti>> stepList)	{
		super();
		this.stepList = stepList;
//		System.out.println("StepsView - construct");
		drawPanel(stepList);
		
	}
	
	
	public void drawPanel(List<List<OfferEnti>> stepList)	{
		
		int stepNr = stepList.size();
		String migRow = "10";
		for (int i = stepNr; i<1; i--)	{
			migRow=migRow+"[grow]20";
		}
		this.setLayout(new MigLayout(
				"",
				"30[grow]10[grow]100",
				migRow
				));

		
		for (int i = stepNr; i>0; i--)	{	//tyle tabel ile krok�w
			System.out.println("first loop "+i);
			
//			add(new JLabel("step nr "+i), "cell 0 "+(stepNr-i));
			String start;
			if (i==stepNr)	{
				add(new JLabel("buttons"), "cell 1 0");
				start = "<html><body><table style=\"width: 100%; height: 0; border: 1px solid #000000; background-color: #FFFFFF;\" cellpadding=\"1\" cellspacing=\"0\">";
			}
			else {
				start = "<html><body><table style=\"width: 100%; height: 0; border: 1px solid #000000;\" cellpadding=\"1\" cellspacing=\"0\">";
				
			}
			String stepHeader = "<tr><td colspan=\"4\" style=\"height: 30px; vertical-align: top;\"><p><b>step nr "+(i-1)+"</b><br />minimalne post�pienie "+100+"<br /></p></td></tr>";
			String naglowki = "<tr><td style=\"width: 100px;\"><b>Oferent</b>"
					+ "</td><td style=\"width: 60px;\"><b>Cena</b></td>"
					+ "</td><td style=\"width: 100px\"><b>Cena z domiarem</b></td>"
					+ "</td><td style=\"width: 100px\"><b>Pozycja</b></td></tr>";
			String end = "</table></body></html>";
			String middle = "";
			
		      DecimalFormat myFormatter = new DecimalFormat("CUR ###,###");
		      
			
			for (int j=0; j<stepList.get(i-1).size(); j++)	{
				String output = myFormatter.format(stepList.get(i-1).get(j).getCena());
				System.out.println("--> "+stepList.get(i-1).get(j));
				middle = middle +"<tr><td>"+stepList.get(i-1).get(j).getOferent().toString()+"</td>"
						+ "<td style=\"text-align: right;\">"+output+"</td></tr>";
			}

			JLabel html = new JLabel(start+stepHeader+naglowki+middle+end);
			html.setFont(new Font("SanSerif", Font.PLAIN, 12));
//			html.setForeground(new Color(0xffffdd));
			add(html, "cell 0 "+(stepNr-i));	
		}
	}
	
	
	
	

}
