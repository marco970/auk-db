package pl.auk.front;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

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
		
		int width = 100;
		int height=	200;	
		setSize(width, height);
//		frame.setIconImage(img.getImage());
		
		JScrollPane scroll = new JScrollPane();
		
		add(scroll);
		
	}

}
