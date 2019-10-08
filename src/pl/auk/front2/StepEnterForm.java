package pl.auk.front2;


import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.OfferEnti;

public class StepEnterForm extends JFrame implements FocusListener {
	
	private static Set<Integer> stepSet = new HashSet<>();
	
	private int minPost;
	
	private HashMap<String, Integer> mapOffer;
	
	private HashMap<String, JLabel> mapMessage;
	
	private JLabel message;
	
	
	private StepEnterForm(int stepNr, List<OfferEnti> lastStep, int minPost)	{
		super("wprowadzanie ofert dla kroku "+(stepNr));
		stepSet.add(stepNr);
		this.minPost = minPost;
		this.mapOffer = new HashMap<>();
		this.mapMessage = new HashMap<>();
		this.message = new JLabel("                              ");
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		
		add(panel);
		panel.add(new JLabel("Oferty dla kroku "+(stepNr)), "wrap");
		panel.add(new JLabel(" "), "wrap");
		int j = 0;
		for (OfferEnti el: lastStep)	{
			mapOffer.put(el.getOferent(), el.getCena());
			mapMessage.put(el.getOferent(), new JLabel("                                                    "));
			JLabel oferent = new JLabel(el.getOferent());
			oferent.setHorizontalAlignment(SwingConstants.RIGHT);
			panel.add(oferent, "gapleft 30");
			JTextField cena = new JTextField(el.getCena()+"",120);
			cena.setHorizontalAlignment(SwingConstants.RIGHT);
			cena.setPreferredSize(new Dimension(15, 20));
			cena.setName(String.valueOf(el.getOferent()));
			cena.addFocusListener(this);
			panel.add(cena);
			
//			message.setPreferredSize(new Dimension(200,15));
//			odstep = new JLabel("                              ");
			panel.add(mapMessage.get(el.getOferent()), "wrap");
			j++;
		}
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (stepSet.contains(stepNr)) stepSet.remove(stepNr);
            }
        });

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		int height = lastStep.size()*30+150;
		setBounds(100, 100, 400, height);
		
	}
	
	public static synchronized StepEnterForm getInstance(int stepNr, List<OfferEnti> lastStep, int minPost)	{
		if (stepSet.contains(stepNr))	{
			return null;
		}
		return new StepEnterForm(stepNr, lastStep, minPost);
	}

	@Override
	public void focusGained(FocusEvent fg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent fl) {
		System.out.println(fl.getComponent().getName());
		mapMessage.get(fl.getComponent().getName()).setText("nieprawid³owa wartoœæ!");
		System.out.println();
		
	}
}
