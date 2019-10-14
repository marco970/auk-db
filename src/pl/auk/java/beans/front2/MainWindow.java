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

public class MainWindow extends JFrame {
	
	private StepsView sv;
	
	public MainWindow(StepsView sv) 	{
		
		super("Aukcja - okno g³ówne");
		setDynamicView(sv);
		sv.setMainWindowInstance(this);
		
		
		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		        createGui();
		      }
		    });
	}
	
	public void setDynamicView(StepsView sv)	{
		this.sv = sv;
		this.invalidate();
		this.validate();
		this.repaint();
	
	}
	
	public void createGui()	{
		
//		System.out.println("CreateGui ");
	
		int width = 900;
		int height=	400;	
		setSize(width, height);
		
		JPanel panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));
//		panelM.setLayout(new MigLayout(
//				"", 
//				"10[grow]10", 
//				"[grow, top]5[grow, top]"));
		panelM.setLayout(new MigLayout());
		setContentPane(panelM);
		panelM.add(new JLabel("G³ówne Info o aukcji"), "wrap");
		JScrollPane scroll = new JScrollPane(sv);
		panelM.add(scroll);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
