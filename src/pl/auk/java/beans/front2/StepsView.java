package pl.auk.java.beans.front2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import pl.auk.back.OfferEnti;
import pl.auk.email.test.EmailDo;
import pl.auk.java.beans.front2.minPost.NextMinPostBean;
import pl.auk.java.beans.front2.minPost.NextMinPostLab;

@SuppressWarnings("serial")
public class StepsView extends JPanel implements ActionListener {
	
	private List<List<OfferEnti>> stepList;
	private List<OfferEnti> lastStep;
	private int stepNr;
	private List<Double> minPostList;
	
	private double minPost;
	
	private MainWindowAukcja mw = null;
	
	private NextMinPostBean minPostBean; 
	private NextMinPostLab minPostLab;
	
	public StepsView(ListBean lb, List<Double> minPostList, NextMinPostBean minPostBean, NextMinPostLab minPostLab)	{
		super();
		System.out.println("konstruktor 1 "+this.getClass().getSimpleName());
		this.stepList = lb.getListBean();
		this.minPostList = minPostList;
		this.minPostBean = minPostBean;
		this.minPostLab = minPostLab;
		this.minPost = minPostList.get(stepList.size()-1);	
//		System.out.println("I - konstr - minPostSize: "+ minPostList.size() );
//		System.out.println("I - konstr - stepListSize: "+stepList.size());
		
		
		drawPanel(stepList);
		this.lastStep = stepList.get(stepList.size()-1);
		this.stepNr = stepList.size()-1;

	}
//	public StepsView(List<Double> minPostList, NextMinPostBean minPostBean, NextMinPostLab minPostLab)	{
//		super();
//		System.out.println("konstruktor 2 "+this.getClass().getSimpleName());
//		List<List<OfferEnti>> aukcjaLoc = new ArrayList<>();
//		ListBean lb = new ListBean(aukcjaLoc);
//		
//		this.stepList = lb.getListBean();
//		
//		this.minPostList = minPostList;
//		this.minPostBean = minPostBean;
//		this.minPostLab = minPostLab;
//		this.minPost = minPostList.get(0);	
//
//		drawPanel(stepList);
//		this.lastStep = stepList.get(stepList.size()-1);
//		this.stepNr = stepList.size()-1;
//		
//		
//		
//	}
	
	public void setDynamicContent(List<List<OfferEnti>> newStepList)	{
		this.removeAll();            
		this.drawPanel(newStepList);
		this.setStepList(newStepList);
		this.setStepNr(stepList.size()-1);
		this.lastStep = stepList.get(stepList.size()-1);
	}
//	public void setDynamicContend(List<List<OfferEnti>> newStepList, double minPost)	{
//		setMinPost(minPost);
//		this.removeAll();
//		this.drawPanel(newStepList);
//		this.setStepList(newStepList);
//	}
	
	public void setMainWindowInstance(MainWindowAukcja mw)	{
		this.mw = mw;
	}

	public void setStepList(List<List<OfferEnti>> stepList) {
		this.stepList = stepList;
	}

	public void setStepNr(int stepNr) {
		this.stepNr = stepNr;
	}
	
	public void addMinPost(double minPost)	{
		
//		System.out.println("add - minPostSize: "+ minPostList.size() );
//		System.out.println("add - stepListSize: "+stepList.size());
		
		if (minPostList.size()<= stepList.size())	{
			minPostList.add(minPost);
			this.minPost = minPost;
		}
		
		
		
	}

	public void setMinPost(double minPost) {
//		System.out.println(this.getClass().getSimpleName()+"  krokNr " + (minPostList.size()-1) + " minPost: "+minPost);
		this.minPost = minPost;
		minPostBean.setMinPost(minPost);
//		System.out.println("z bean "+minPostBean.getMinPost());
//		System.out.println("set - minPostSize: "+ minPostList.size() );
//		System.out.println("set - stepListSize: "+stepList.size());
		
		minPostList.set(minPostList.size()-1, minPost);

	}

	public MainWindowAukcja getMainWindowInstance() {
		return mw;
	}

	public void drawPanel(List<List<OfferEnti>> stepList)	{
		
		int stepNr;
		if(stepList.isEmpty())	stepNr = -1;
		else stepNr = stepList.size();

		String migRow = "10";
		for (int i = stepNr; i<1; i--)	{
			migRow=migRow+"[grow, top]20";
		}
		this.setLayout(new MigLayout(
				"",
				"30[grow]10[grow]100",
				migRow
				));

		JPanel buttons = new JPanel();
		buttons.setLayout(new MigLayout());
		
		

		JButton maile = new JButton("Utwórz maile");
		JButton krok = new JButton("Kolejny krok");
		JButton popraw = new JButton("Popraw Oferty");
		JButton minPostButton = new JButton("Zmiana min. oferty");
		
		maile.addActionListener(this);
		krok.addActionListener(this);
		popraw.addActionListener(this);
		minPostButton.addActionListener(this);
		
		popraw.setPreferredSize(new Dimension(120, 10));
		maile.setPreferredSize(new Dimension(120, 10));
		krok.setPreferredSize(new Dimension(120, 10));
		
		buttons.add(new JLabel("minimalne postąpienie w kroku nr "+stepNr+ ":  "));
		buttons.add(minPostLab, "wrap");
		buttons.add(maile, "wrap");
		buttons.add(krok, "wrap");
		buttons.add(popraw, "wrap");
		buttons.add(minPostButton, "wrap");

		if (stepNr>=0) {
		//		tu zaczynam
			for (int i = stepNr; i > 0; i--) {
	
				System.out.println("i= " + i + "   minPost[i] = " + minPostList.get(i - 1));
		
				String start;
				if (i == stepNr) {
					add(buttons, "cell 1 0");
					start = "<html><body><table style=\"width: 100%; height: 0; border: 0px solid #000000; background-color: #FFFFFF;\" cellpadding=\"1\" cellspacing=\"0\">";
				} else {
					start = "<html><body><table style=\"width: 100%; height: 0; border: 0px solid #000000; padding-top: 10px;\" cellpadding=\"1\" cellspacing=\"0\">";
		
				}
				String stepHeader = "<tr><td colspan=\"4\" style=\"height: 30px; vertical-align: top;\">" + "<p><b>step nr "
						+ (i - 1) + "</b>" + "<br />minimalne postąpienie w kroku " + (i - 1) + ": " + minPostList.get(i - 1)
						+ "" + "<br /></p></td></tr>";
				String naglowki = "<tr><td style=\"width: 100px;\"><b>Oferent</b>"
						+ "</td><td style=\"width: 60px; text-align: right;\"><b>Cena</b></td>"
						+ "</td><td style=\"width: 100px; text-align: right;\"><b>Cena z domiarem</b></td>"
						+ "</td><td style=\"width: 100px; text-align: center;\"><b>Pozycja</b></td></tr>";
				String end = "</table></body></html>";
				String middle = "";
		
				DecimalFormat myFormatter = new DecimalFormat("$ ###,###");
		
				for (int j = 0; j < stepList.get(i - 1).size(); j++) {
					String output = myFormatter.format(stepList.get(i - 1).get(j).getCena());
					middle = middle + "<tr><td>" + stepList.get(i - 1).get(j).getOferent().toString() + "</td>"
							+ "<td style=\"text-align: right;\">" + output + "</td>" + "<td style=\"text-align: right;\">"
							+ output + "</td>" + "<td style=\"text-align: center;\">" + stepList.get(i - 1).get(j).getPosition()
							+ "</td>" + "</tr>";
				}
		
				JLabel html = new JLabel(start + stepHeader + naglowki + middle + end);
				html.setFont(new Font("SanSerif", Font.PLAIN, 12));
				add(html, "cell 0 " + (stepNr - i));
			}
				//		tu koniec
		}
		else	{
			
//			String start = "<html><body><table style=\"width: 100%; height: 0; border: 0px solid #000000; padding-top: 10px;\" cellpadding=\"1\" cellspacing=\"0\">";
			JLabel html = new JLabel("aukcja się jeszcze nie rozpoczęła");
			html.setFont(new Font("SanSerif", Font.PLAIN, 12));
			add(html, "cell 0 ");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Utwórz maile"))	{
//			System.out.println("komenda: Utwórz maile");
			for (OfferEnti el: lastStep)	{
				String address = el.getOferent()+"@"+el.getOferent()+".com";
				try {
					new EmailDo(stepNr,
							el.getOferent(),
							address,
							el.getCena(),
							el.getPosition(),
							100);
				} catch (URISyntaxException | IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
		
		
		
		if (e.getActionCommand().equals("Kolejny krok"))	{
//			System.out.println("komenda: Kolejny krok");
//			System.out.println("koleny krok a - minPostSize: "+ minPostList.size() );
//			System.out.println("koleny krok a - stepListSize: "+stepList.size());
			if (stepList.size()==minPostList.size())	{
				minPostList.add(minPost);
			}
			else	{
				
			}
//			System.out.println("koleny krok b - minPostSize: "+ minPostList.size() );
//			System.out.println("koleny krok b - stepListSize: "+stepList.size());
			StepEnterForm.getInstance(stepNr+1, lastStep, minPost, stepList, this);
		}
		
		if (e.getActionCommand().equals("Zmiana min. oferty"))	{
//			System.out.println("komenda: Zmiana min. oferty");
//			System.out.println("Zmiana min. oferty - minPostSize: "+ minPostList.size() );
//			System.out.println("Zmiana min. oferty - stepListSize: "+stepList.size());
			if (minPostList.size()-stepList.size()==0)	{
				minPostList.add(minPost);
			}
//			System.out.println("Zmiana min. oferty b  - minPostSize: "+ minPostList.size() );
//			System.out.println("Zmiana min. oferty b  - stepListSize: "+stepList.size());
			/**
			 * tu dodać nowy formularz zmieniający minimalne postąpienie
			 */
//			setMinPost(300);
//			setDynamicContend(stepList, minPost);
			
			MinPostEnterForm.getInstanceMinPostForm(this, minPost, stepNr, stepList);
		}

	}

//	@Override
//	public void propertyChange(PropertyChangeEvent evt) {
//		System.out.println("jest działanie dziwoląga");
//		addMinPost(minPost);
//		
//	}

}
