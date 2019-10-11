package pl.auk.jd.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class EnterForm extends JFrame implements ActionListener {
	 
	private JButton setStep;
	private JTextField pole;
	private int stepNr;
	
	public EnterForm(int stepN)	{
		super("zmieniam krok");
		this.stepNr = stepNr;
		
		System.out.println(stepNr);
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		panel.add(new JLabel("Formularz zmiany"), "wrap, gapbottom 20, gapleft 20");
		
		pole = new JTextField(stepNr+"");
		
		setStep = new JButton("zapisz");
		setStep.addActionListener(this);
		
		panel.add(pole, "wrap, gapleft 20");
		panel.add(setStep, "wrap, gapleft 20, gaptop 10");
		
	
		
		
		
		
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		int height = 200;
		setBounds(100, 100, 400, height);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("zapisz"))	{
			System.out.println("zapisujê "+ pole.getText());
		}
		
	}
	
	

}
