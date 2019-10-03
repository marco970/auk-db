package pl.auk.front;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import pl.auk.front2.StepsView;

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
		
		System.out.println("CreateGui ");
//		JFrame frame = new JFrame("Aukcja - okno g³ówne");
		
		int width = 900;
		int height=	400;	
		setSize(width, height);
//		setBounds(100, 100, 450, 600);
		
//		frame.setIconImage(img.getImage());
		
		JPanel panelM = new JPanel();
//		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelM.setLayout(new MigLayout(
				"", 
				"10[grow]10", 
				"[shrink 10, top]5[grow, top]"));
		setContentPane(panelM);
		panelM.add(new JLabel("G³ówne Info o aukcji"), "cell 0 0");
//		JPanel testowy = new JPanel();
//		testowy.add(new JLabel("Panel Testowy"));
//		panelM.add(testowy, "cell 0 1");
		panelM.add(sv, "cell 0 1");
		
		
		
		
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

		
		
		
//		JScrollPane scroll = new JScrollPane();
//		add(scroll);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
