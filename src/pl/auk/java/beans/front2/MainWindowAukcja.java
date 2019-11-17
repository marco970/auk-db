package pl.auk.java.beans.front2;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;



import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class MainWindowAukcja extends JFrame {
	
	private StepsView sv;
	
	public MainWindowAukcja(StepsView sv) 	{
		
		super("Aukcja - okno główne");
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

	
		int width = 900;
		int height=	400;	
		setSize(width, height);
		
		JPanel panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));

		panelM.setLayout(new MigLayout());
		setContentPane(panelM);
		panelM.add(new JLabel("Główne Info o aukcji"), "wrap");
		JScrollPane scroll = new JScrollPane(sv);
		panelM.add(scroll);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
