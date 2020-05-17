package pl.auk.java.beans.front2;


import java.awt.Color;
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

public class StepEnterForm extends JFrame implements ActionListener {
	
	private int stepNr;
	
	private List<List<OfferEnti>> stepList;
	
	private static Set<Integer> stepSet = new HashSet<>();
	
	private HashMap<String, Integer> mapOffer;
	
	private HashMap<String, JLabel> mapMessage;
	
	private HashMap<String, JTextField> mapJtf;		//JTextField - mapa z okienkami
	
	private StepsView stepsView;
	
	private JLabel message;
	
	private JButton zapisz;
	
	private JButton anuluj;
	
	private static String name;
	
	
	private StepEnterForm(int stepNr, List<OfferEnti> lastStep, double minPost, List<List<OfferEnti>> stepList, StepsView stepsView)	{
		
		super();
		stepSet.add(stepNr);
		this.stepNr = stepNr;
		this.stepList = stepList;
		this.stepsView = stepsView;
		
		System.out.println("SEF - nr kroku "+stepNr);
		
		this.mapOffer = new HashMap<>();
		this.mapMessage = new HashMap<>();
		this.mapJtf = new HashMap<>();
		
		this.message = new JLabel("");
		
		this.zapisz = new JButton("Zapisz");
		this.anuluj = new JButton("Anuluj");
		
		StepEnterForm.name = this.getClass().getSimpleName();
		this.setTitle("wprowadzanie ofert dla kroku "+(stepNr)+" "+name);
		
		zapisz.addActionListener(this);
		anuluj.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		
		add(panel);
		panel.add(new JLabel("Oferty dla kroku "+(stepNr)), "wrap");
		panel.add(new JLabel("Minimalne postąpienie "+(minPost)), "wrap");
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
			
			panel.add(cena, "w 100!");
			
			message.setPreferredSize(new Dimension(200,15));
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
	
	public static synchronized StepEnterForm getInstance(
			int stepNr, List<OfferEnti> lastStep, 
			double minPost2, 
			List<List<OfferEnti>> stepList, 
			StepsView stepsView)	{
		if (stepSet.contains(stepNr))	{
			return null;
		}
		return new StepEnterForm(stepNr, lastStep, minPost2, stepList, stepsView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("zapisz"));	{
			List<OfferEnti> nextStep = new ArrayList<>();
			List<OfferRaw> nextStepRaw = new ArrayList<>();
			boolean err = false;
//			System.out.println("SEF error 1 "+err+"--> "+lb.getClass().getSimpleName());
			for(String el: mapJtf.keySet())	{
				String newOffer=  mapJtf.get(el).getText();
//				System.out.println("aaa- > "+el+" "+newOffer);
				int value = Integer.valueOf(newOffer);

				if (value <= mapOffer.get(el))	{		
					OfferRaw or = new OfferRaw(stepNr, el, value);
					
//					OfferEnti oe = oc.getOfferEntiList(oc);
					
//					OfferEnti oe = new OfferEnti(stepNr, el, value);
					
					nextStepRaw.add(or);
//					nextStep.add(oe);
//					System.out.println("SEF error 2 "+err+"--> "+lb.getClass().getSimpleName()+" "+or.getCena());
					mapMessage.get(el).setText("");
				}
				else	{
					mapMessage.get(el).setText("nieprawidłowa wartość!");
					mapMessage.get(el).setForeground(Color.RED);
					err = true;
				}
			}
			
			if (!err) {
				nextStep = OfferCalc.getOfferEntiList(nextStepRaw);
				stepList.add(nextStep); 
//				stepsView.addMinPost(minPost);

//				lb.setListBean(stepList);
				
//				tu zapiszemy krok w bazie danych
				
				stepsView.setDynamicContent(stepList);
				stepsView.getMainWindowInstance().setDynamicView(stepsView);

				this.dispose();
				if (stepSet.contains(stepNr)) stepSet.remove(stepNr);
			}
			else {
				//czy potrzebne?
				
			}
			

		}
		
	}
}
