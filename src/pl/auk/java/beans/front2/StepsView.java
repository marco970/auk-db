package pl.auk.java.beans.front2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.OfferEnti;

public class StepsView extends JPanel implements ActionListener, PropertyChangeListener {
	
	private List<List<OfferEnti>> stepList;
	private List<OfferEnti> lastStep;
	private int stepNr;
	private ListBean lb;
	
	private int minPost;
	
	public StepsView(ListBean lb)	{
		super();
		this.stepList = lb.getListBean();
//		System.out.println("StepsView - construct");
		drawPanel(stepList);
		this.lastStep = stepList.get(stepList.size()-1);
		this.stepNr = stepList.size()-1;
		this.minPost = 100;		//potem odczytamy to z formularza jakiegoœ
		this.lb = lb;
		
	}

	public void drawPanel(List<List<OfferEnti>> stepList)	{
		
		int stepNr = stepList.size();
		System.out.println("sv drawPanel stepNr"+stepNr);
		String migRow = "10";
		for (int i = stepNr; i<1; i--)	{
			migRow=migRow+"[grow, top]20";
		}
		this.setLayout(new MigLayout(
				"",
				"30[grow]10[grow]100",
				migRow
				));

		JPanel buttons = new JPanel();
		buttons.setLayout(new MigLayout("wrap 1"));
//		buttons.add(new JLabel("buttons"));
		JButton maile = new JButton("Utwórz maile");
		JButton krok = new JButton("Kolejny krok");
		JButton popraw = new JButton("Popraw Oferty");
		maile.addActionListener(this);
		krok.addActionListener(this);
		popraw.addActionListener(this);
		popraw.setPreferredSize(new Dimension(120, 10));
		maile.setPreferredSize(new Dimension(120, 10));
		krok.setPreferredSize(new Dimension(120, 10));
		buttons.add(maile);
		buttons.add(krok);
		buttons.add(popraw);
		
		
		for (int i = stepNr; i>0; i--)	{	//tyle tabel ile kroków
//			System.out.println("first loop "+i);
			
//			add(new JLabel("step nr "+i), "cell 0 "+(stepNr-i));
			String start;
			if (i==stepNr)	{
				add(buttons, "cell 1 0");
				start = "<html><body><table style=\"width: 100%; height: 0; border: 0px solid #000000; background-color: #FFFFFF;\" cellpadding=\"1\" cellspacing=\"0\">";
			}
			else {
				start = "<html><body><table style=\"width: 100%; height: 0; border: 0px solid #000000; padding-top: 10px;\" cellpadding=\"1\" cellspacing=\"0\">";
				
			}
			String stepHeader = "<tr><td colspan=\"4\" style=\"height: 30px; vertical-align: top;\"><p><b>step nr "+(i-1)+"</b><br />minimalne post¹pienie "+minPost+"<br /></p></td></tr>";
			String naglowki = "<tr><td style=\"width: 100px;\"><b>Oferent</b>"
					+ "</td><td style=\"width: 60px;\"><b>Cena</b></td>"
					+ "</td><td style=\"width: 100px\"><b>Cena z domiarem</b></td>"
					+ "</td><td style=\"width: 100px\"><b>Pozycja</b></td></tr>";
			String end = "</table></body></html>";
			String middle = "";
			
		      DecimalFormat myFormatter = new DecimalFormat("$ ###,###");

			for (int j=0; j<stepList.get(i-1).size(); j++)	{
				String output = myFormatter.format(stepList.get(i-1).get(j).getCena());
//				System.out.println("--> "+stepList.get(i-1).get(j));
				middle = middle +"<tr><td>"+stepList.get(i-1).get(j).getOferent().toString()+"</td>"
						+ "<td style=\"text-align: right;\">"+output+"</td></tr>";
			}

			JLabel html = new JLabel(start+stepHeader+naglowki+middle+end);
			html.setFont(new Font("SanSerif", Font.PLAIN, 12));
//			html.setForeground(new Color(0xffffdd));
			add(html, "cell 0 "+(stepNr-i));	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		if (e.getActionCommand().equals("Kolejny krok"))	{
			StepEnterForm.getInstance(stepNr+1, lastStep, minPost, stepList, lb);
		}

	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		System.out.println("sv - a kuku???");
		System.out.println("tutestuje sv "+evt.getNewValue().getClass());
		List<List<OfferEnti>> newStepList = (List<List<OfferEnti>>) evt.getNewValue();
		
		System.out.println(this.getClass().toString()+" "+newStepList.size());
		
		this.removeAll();
		drawPanel(newStepList);
		
	}
	
	
	
	

}
