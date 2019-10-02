package pl.auk.front;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame {
	
	
	
	public MainWindow() 	{
		
		super("Aukcja - okno g³ówne");
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		        createGui();
		      }
		    });
	}
	
	public void createGui()	{
		
		
//		JFrame frame = new JFrame("Aukcja - okno g³ówne");
		
		int width = 500;
		int height=	400;	
		setSize(width, height);
//		setBounds(100, 100, 450, 600);
		
//		frame.setIconImage(img.getImage());
		
		JPanel panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelM.setLayout(new MigLayout(
				"", 
				"10[grow]10", 
				"[grow]10[grow]"));
		setContentPane(panelM);
		panelM.add(new JLabel("G³ówne Info o aukcji"), "cell 0 0");
		
		
		
		JPanel panelG = new JPanel();
		int krok = 3;
		String migRow = "";
		for (int i = 0; i < krok; i++)	{
			migRow = migRow + "10[grow]";
		}
		migRow=migRow+"10";
		System.out.println(migRow);
		panelG.setLayout(new MigLayout(
				"",
				"10[grow]10",
				migRow				
				));
		for (int i = 0; i < krok; i++)	{
			panelG.add(new JLabel("table "+i), "cell 0 "+i);
			panelG.add(new JLabel("buttons "+i), "cell 1 "+i);
		}
		panelM.add(panelG, "cell 0 1");
		
		/**
		 * do pojedyñczej komórki bêdzie dodawany JPanel
		 * bêdzie on zawiera³ Listê obieków,
		 * obiekt bêdzie wierszem z ró¿nymi polami...
		 * a mo¿e tabelê? - to chyba dobry pomys³
		 * 
		 * property to bêdzie Lista<JTable> 
		 * 
		 * czyli w komórce panel
		 * w panelu JTable
		 * w ostatnim panelu tak¿e button (a mo¿e w kolejen komórce wiersza)
		 * 	- raczej kilka buttonów:
		 * 		wyœlij maile,
		 * 		cofnij
		 * 		dodaj komunikat
		 * 		itd
		 * 
		 * testowo, zanim zrobê BD i transakcje, bêdzie potrzebna klasa tworzaca potrzebne obiekty
		 * 
		 * 
		 * 		
		 * 
		 * 
		 * 
		 */
		
		
		
		JScrollPane scroll = new JScrollPane();
		add(scroll);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
