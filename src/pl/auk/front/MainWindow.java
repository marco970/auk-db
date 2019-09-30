package pl.auk.front;

import javax.swing.JFrame;
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
//		frame.setIconImage(img.getImage());
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new MigLayout("[grow]", "[grow]", "[grow]"));
		
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
		
		setContentPane(contentPane);
		
		JScrollPane scroll = new JScrollPane();
		
		add(scroll);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
