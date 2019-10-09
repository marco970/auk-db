package pl.auk.front2;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.OfferEnti;
import pl.auk.front.ListBean;

public class StepEnterForm extends JFrame implements FocusListener, ActionListener {
	
	private int stepNr;
	
	private List<List<OfferEnti>> stepList;
	
	private ListBean lb;
	
	private static Set<Integer> stepSet = new HashSet<>();
	
	private int minPost;
	
	private HashMap<String, Integer> mapOffer;
	
	private HashMap<String, JLabel> mapMessage;
	
	private HashMap<String, JTextField> mapJtf;
	
	
	private JLabel message;
	
	private JButton zapisz;
	
	private JButton anuluj;
	
	
	private StepEnterForm(int stepNr, List<OfferEnti> lastStep, int minPost, List<List<OfferEnti>> stepList, ListBean lb)	{
		super("wprowadzanie ofert dla kroku "+(stepNr));
		stepSet.add(stepNr);
		this.stepNr = stepNr;
		this.minPost = minPost;
		this.stepList = stepList;
		this.lb = lb;
		
//		System.out.println("uwaga "+lb.toString());
		
		this.mapOffer = new HashMap<>();
		this.mapMessage = new HashMap<>();
		this.mapJtf = new HashMap<>();
		
		this.message = new JLabel("");
		
		this.zapisz = new JButton("Zapisz");
		this.anuluj = new JButton("Anuluj");
		
		zapisz.addActionListener(this);
		anuluj.addActionListener(this);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		
		add(panel);
		panel.add(new JLabel("Oferty dla kroku "+(stepNr)), "wrap");
		panel.add(new JLabel(" "), "wrap");
		int j = 0;
		for (OfferEnti el: lastStep)	{
			mapOffer.put(el.getOferent(), el.getCena());
			mapMessage.put(el.getOferent(), new JLabel(""));
			JLabel oferent = new JLabel(el.getOferent());
			oferent.setHorizontalAlignment(SwingConstants.RIGHT);
			panel.add(oferent, "gapleft 30");
			JTextField cena = new JTextField(el.getCena()+"");
			mapJtf.put(el.getOferent(), cena);
			cena.setHorizontalAlignment(SwingConstants.RIGHT);
			cena.setPreferredSize(new Dimension(15, 20));
			cena.setName(String.valueOf(el.getOferent()));
			cena.addFocusListener(this);
			panel.add(cena, "w 100!");
			
//			message.setPreferredSize(new Dimension(200,15));
//			odstep = new JLabel("                              ");
			panel.add(mapMessage.get(el.getOferent()), "wrap, w 150!");
			j++;
		}
		
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (stepSet.contains(stepNr)) stepSet.remove(stepNr);
            }
        });
		
		
		panel.add(anuluj, "gap 30");
		panel.add(zapisz);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		int height = lastStep.size()*30+150;
		setBounds(100, 100, 400, height);
		
	}
	
	public static synchronized StepEnterForm getInstance(int stepNr, List<OfferEnti> lastStep, int minPost, List<List<OfferEnti>> stepList, ListBean lb)	{
		if (stepSet.contains(stepNr))	{
			return null;
		}
		return new StepEnterForm(stepNr, lastStep, minPost, stepList, lb);
	}

	@Override
	public void focusGained(FocusEvent fg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent fl) {
//		System.out.println(fl.getComponent().getName());
//		
////		mapMessage.get(fl.getComponent().getName()).setText("nieprawidłowa wartość!");
//		System.out.println("FocusLost!");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("zapisz"));	{
			List<OfferEnti> nextStep = new ArrayList<>();
			boolean err = false;
			for(String el: mapJtf.keySet())	{
				String newOffer=  mapJtf.get(el).getText();
//				System.out.println("aaa- > "+el+" "+newOffer);
				int value = Integer.valueOf(newOffer);
				if (value == mapOffer.get(el))	{
					OfferEnti oe = new OfferEnti(stepNr, el, mapOffer.get(el));
					nextStep.add(oe);

				}
				else	{
					mapMessage.get(el).setText("nieprawidłowa wartość!");
					err = true;
				}
			}
			if (!err) {
				stepList.add(nextStep);
				System.out.println(lb.toString());
				lb.setListBean(stepList);
			}
			
			
		}
		
	}
}
