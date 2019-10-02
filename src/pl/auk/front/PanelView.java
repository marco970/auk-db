package pl.auk.front;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PanelView extends JPanel implements PropertyChangeListener {
	
	private List<JPanel> listaStepow;
	
	public PanelView(int stepNr)	{
		super();
		listaStepow = new ArrayList<>(); 
		String migRow = "";
		for (int i = stepNr; i<1; i--)	{
			migRow=migRow+"10";
		}
		this.setLayout(new MigLayout(
				"",
				"30[grow]10[grow]30",
				migRow
				));
		for (int i = stepNr; i<1; i--)	{
			JPanel panelG = new JPanel();
			panelG.add(new JLabel("tabela kroku "+i ));
			this.add(panelG, "cell 0 "+(stepNr-i));
			if (i==stepNr) {
				JPanel panelB = new JPanel();
				panelB.add(new JLabel("buttons"));
				this.add(panelB, "cell 1 0");
			}
			
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		
		 
	}
	
	public JPanel reDrawPanel()	{
		
		return null;
	}
	public JPanel drawPanel(int step)		{
		
	}
	

}
