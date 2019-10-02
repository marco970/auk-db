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
		
		super("Aukcja - okno g��wne");
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		        createGui();
		      }
		    });
	}
	
	public void createGui()	{
		
		
//		JFrame frame = new JFrame("Aukcja - okno g��wne");
		
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
		panelM.add(new JLabel("G��wne Info o aukcji"), "cell 0 0");
		
		
		
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
		 * do pojedy�czej kom�rki b�dzie dodawany JPanel
		 * b�dzie on zawiera� List� obiek�w,
		 * obiekt b�dzie wierszem z r�nymi polami...
		 * a mo�e tabel�? - to chyba dobry pomys�
		 * 
		 * property to b�dzie Lista<JTable> 
		 * 
		 * czyli w kom�rce panel
		 * w panelu JTable
		 * w ostatnim panelu tak�e button (a mo�e w kolejen kom�rce wiersza)
		 * 	- raczej kilka button�w:
		 * 		wy�lij maile,
		 * 		cofnij
		 * 		dodaj komunikat
		 * 		itd
		 * 
		 * testowo, zanim zrob� BD i transakcje, b�dzie potrzebna klasa tworzaca potrzebne obiekty
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
