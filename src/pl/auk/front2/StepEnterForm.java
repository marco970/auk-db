package pl.auk.front2;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.OfferEnti;

public class StepEnterForm extends JFrame {
	
	private static Set<Integer> stepSet = new HashSet<>();
	
	
	private StepEnterForm(int stepNr, List<OfferEnti> lastStep)	{
		super("wprowadzanie ofert dla kroku "+(stepNr));
		stepSet.add(stepNr);
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]", ""));
		
		add(panel);
		panel.add(new JLabel("Oferty dla kroku "+(stepNr)), "wrap");
		panel.add(new JLabel(" "), "wrap");
		for (OfferEnti el: lastStep)	{
			JLabel oferent = new JLabel(el.getOferent());
			oferent.setHorizontalAlignment(SwingConstants.RIGHT);
			panel.add(oferent, "gapleft 30");
			JTextField cena = new JTextField(el.getCena()+"",120);
			cena.setHorizontalAlignment(SwingConstants.RIGHT);
			cena.setSize(120, 12);
			panel.add(cena);
			panel.add(new JLabel("                                  "), "wrap");
		}
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (stepSet.contains(stepNr)) stepSet.remove(stepNr);
            }
        });
		
		
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 300, 200);
		
	}
	
	public static synchronized StepEnterForm getInstance(int stepNr, List<OfferEnti> lastStep)	{
		if (stepSet.contains(stepNr))	{
			return null;
		}
		return new StepEnterForm(stepNr, lastStep);
	}
}
