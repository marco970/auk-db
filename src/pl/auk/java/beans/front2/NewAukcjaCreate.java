package pl.auk.java.beans.front2;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class NewAukcjaCreate extends RawForm {
	
	private static String[] start = {"Start", "Exit"};

	public NewAukcjaCreate() {
		super("Tworzenie nowej Aukcji", start);
		JPanel panelInherited = super.panelM;
		panelInherited.add(new JLabel("Tworzenie nowej aukcji:"), "wrap");
		
		JPanel panelLocal = new JPanel();
		panelLocal.setLayout(new MigLayout());
		panelInherited.add(panelLocal);
		
		
		
		
	}
	
	

}
