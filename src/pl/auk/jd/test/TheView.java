package pl.auk.jd.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class TheView extends JFrame implements ActionListener, PropertyChangeListener {
	
	private JButton next;
	private int stepNr;
	private StepBean sb;
	
	
	public TheView(int stepNr, StepBean sb, DynamicLabel dl)	{
		super("test dymnamicznej Javy");
		this.stepNr = stepNr;
		this.sb = sb;
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		JLabel stepDisplay = new JLabel(""+stepNr);
		panel.add(new JLabel("Witamy na oœrodku!"), "wrap");
//		panel.add(new JLabel(" "), "wrap");
		panel.add(dl, "wrap, gaptop 10, gapleft 10");
		this.next = new JButton("Kolejny Krok");
		next.addActionListener(this);
		panel.add(next, "dock south, gaptop 20");
		
		add(panel);
		int width = 900;
		int height=	400;	
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Kolejny Krok"))	{
			System.out.println(this.getClass().toString()+" akcja "+stepNr);
			new EnterForm((stepNr+1), sb, this);
		}
		
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		int newStep = (int) evt.getNewValue();
		
		System.out.println("propChange ---> newStep = "+newStep);
		
	}
	
	
	
	
}
