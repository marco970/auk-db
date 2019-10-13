package pl.auk.java.beans.front2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.policy.Policy;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame implements PropertyChangeListener {
	
	private StepsView sv;
	
	public MainWindow(StepsView sv) 	{
		
		super("Aukcja - okno g��wne");
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
		panelM.add(new JLabel("G��wne Info o aukcji"), "cell 0 0");
		JScrollPane scroll = new JScrollPane(sv);
		panelM.add(scroll, "cell 0 1");
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll);


		
		
		

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		System.out.println("MaiWindow s�yszy "+evt.getPropertyName());
		
	}

}
