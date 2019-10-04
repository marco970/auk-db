package pl.auk.front2;

import java.awt.Color;
import java.awt.Font;
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
		
//		System.out.println("StepsView - drawPanel");
		
	    Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("oferent");
	    columnNames.addElement("cena");
		
		int stepNr = stepList.size();
//		System.out.println("drawPanel stepNr "+ stepNr); 
		String migRow = "10";
		for (int i = stepNr; i<1; i--)	{
			migRow=migRow+"[grow]20";
		}
		this.setLayout(new MigLayout(
				"",
				"100[grow]10[grow]10",
				migRow
				));
		for (int i = stepNr; i>1; i--)	{
			System.out.println("testloop "+i);
		}
		
		for (int i = stepNr; i>0; i--)	{	//tyle tabel ile kroków
			Vector<Vector> dane = new Vector<>();
			System.out.println("first loop "+i);
			if (i==stepNr)	{
				add(new JLabel("buttons"), "cell 1 0");
			}
//			for (OfferEnti el: stepList.get(i-1)) {
//				add(new JLabel(el.toString()), "cell 0 "+i);
//				System.out.println(el.toString());
//			}
			String start = "<html><body><table>";
			String naglowki = "<tr><td style=\"width: 100px\"><b>Oferent</b></td><td style=\"width: 100px\"><b>Cena</b></td></tr>";
			String end = "</table></body></html>";
			String middle = "";
			for (int j=0; j<stepList.get(i-1).size(); j++)	{
				System.out.println("--> "+stepList.get(i-1).get(j));
				middle = middle +"<tr><td>"+stepList.get(i-1).get(j).getOferent().toString()+"</td>"
						+ "<td>"+stepList.get(i-1).get(j).getCena()+"</td></tr>";
				
				
			}
			
//			for (int j=0; j<stepList.get(i-1).size(); j++)	{
//				Vector<Object> row = new Vector<>();
//				row.addElement(stepList.get(i-1).get(j).getOferent());
//				row.addElement(stepList.get(i-1).get(j).getCena());
//				dane.addElement(row);
//				System.out.println("--> "+stepList.get(i-1).get(j));
//			}
//			JTable table = new JTable(dane,columnNames);
			JLabel html = new JLabel(start+naglowki+middle+end);
			html.setFont(new Font("SanSerif", Font.PLAIN, 12));
//			html.setForeground(new Color(0xffffdd));
			add(html, "cell 0 "+i);
			
			
		}
		
//		add(new JLabel("drawPanel - test"));
		
		
	}
	
	
	
	

}
