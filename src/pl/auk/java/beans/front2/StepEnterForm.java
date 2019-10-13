package pl.auk.java.beans.front2;


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

public class StepEnterForm extends JFrame implements FocusListener, ActionListener {
	
	private int stepNr;
	
	private List<List<OfferEnti>> stepList;
	
	private ListBean lb;
	
	private static Set<Integer> stepSet = new HashSet<>();
	
	private int minPost;
	
	private HashMap<String, Integer> mapOffer;
	
	private HashMap<String, JLabel> mapMessage;
	
	private HashMap<String, JTextField> mapJtf;
	
	private StepsView stepsView;
	
	
	private JLabel message;
	
	private JButton zapisz;
	
	private JButton anuluj;
	
	
	private StepEnterForm(int stepNr, List<OfferEnti> lastStep, int minPost, List<List<OfferEnti>> stepList, ListBean lb, StepsView stepsView)	{
		super("wprowadzanie ofert dla kroku "+(stepNr));
		stepSet.add(stepNr);
		this.stepNr = stepNr;
		this.minPost = minPost;
		this.stepList = stepList;
		this.lb = lb;
		this.stepsView = stepsView;
		
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
	
	public static synchronized StepEnterForm getInstance(int stepNr, List<OfferEnti> lastStep, int minPost, List<List<OfferEnti>> stepList, ListBean lb, StepsView stepsView)	{
		if (stepSet.contains(stepNr))	{
			return null;
		}
		return new StepEnterForm(stepNr, lastStep, minPost, stepList, lb, stepsView);
	}

	@Override
	public void focusGained(FocusEvent fg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent fl) {
//		System.out.println(fl.getComponent().getName());
//		
////		mapMessage.get(fl.getComponent().getName()).setText("nieprawid³owa wartoœæ!");
//		System.out.println("FocusLost!");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("zapisz"));	{
			List<OfferEnti> nextStep = new ArrayList<>();
			boolean err = false;
			System.out.println("SEF error 1 "+err+"--> "+lb.toString());
			for(String el: mapJtf.keySet())	{
				String newOffer=  mapJtf.get(el).getText();
//				System.out.println("aaa- > "+el+" "+newOffer);
				int value = Integer.valueOf(newOffer);
				if (true)	{		//value <= mapOffer.get(el)
					OfferEnti oe = new OfferEnti(stepNr, el, value);
					nextStep.add(oe);
					System.out.println("SEF error 2 "+err+"--> "+lb.toString()+" "+oe.getCena());

				}
				else	{
					mapMessage.get(el).setText("nieprawid³owa wartoœæ!");
					err = true;
				}
			}
			
			if (true) {
				stepList.add(nextStep);
				
				for (List<OfferEnti> elD: stepList)	{
					for (OfferEnti eld: elD)	{
//						System.out.println(" stepList "+eld.getOferent()+" "+eld.getCena());
					}
				}
				System.out.println("SEF error 3 "+err+"--> "+lb.toString()+stepList.size());
				lb.setListBean(stepList);
				stepsView.setDynamicContent(stepList);
				stepsView.getMainWindowInstance().setDynamicView(stepsView);
			}
			
			this.dispose();
			if (stepSet.contains(stepNr)) stepSet.remove(stepNr);
		}
		
	}
}
