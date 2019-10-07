package pl.auk.front2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.policy.Policy;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame {
	
	private StepsView sv;
	
	public MainWindow(StepsView sv) 	{
		
		super("Aukcja - okno g³ówne");
		this.sv = sv;
		
		
		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		        createGui();
		      }
		    });
	}
	
	public void createGui()	{
		
//		System.out.println("CreateGui ");
	
		int width = 900;
		int height=	400;	
		setSize(width, height);
		
		JPanel panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelM.setLayout(new MigLayout(
				"", 
				"10[grow]10", 
				"[grow, top]5[grow, top]"));
		setContentPane(panelM);
		panelM.add(new JLabel("G³ówne Info o aukcji"), "cell 0 0");
		JScrollPane scroll = new JScrollPane(sv);
		panelM.add(scroll, "cell 0 1");
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll);
		
		
//		JPanel panelG = new JPanel();
//		int krok = 3;
//		String migRow = "";
//		for (int i = 0; i < krok; i++)	{
//			migRow = migRow + "10[grow]";
//		}
//		migRow=migRow+"10";
//		System.out.println(migRow);
//		panelG.setLayout(new MigLayout(
//				"",
//				"10[grow]10",
//				migRow				
//				));
//		for (int i = 0; i < krok; i++)	{
//			panelG.add(new JLabel("table "+i), "cell 0 "+i);
//			panelG.add(new JLabel("buttons "+i), "cell 1 "+i);
//		}
//		panelM.add(panelG, "cell 0 1");

		
		
		

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
