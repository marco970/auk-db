package pl.auk.front;

import javax.swing.JFrame;
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
//		frame.setIconImage(img.getImage());
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new MigLayout("[grow]", "[grow]", "[grow]"));
		
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
		
		setContentPane(contentPane);
		
		JScrollPane scroll = new JScrollPane();
		
		add(scroll);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
