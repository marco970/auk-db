package pl.auk.jd.test;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public interface WindowUtils {
	
	static void setFrame(JFrame frame, int width, int height, String[] start)	{

		frame.setSize(width, height);
		
		JMenuBar mb = new JMenuBar();
		frame.setJMenuBar(mb);
		
		menuBarMenuCreate(mb, start);
		
		JPanel panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));

		panelM.setLayout(new MigLayout());
		frame.setContentPane(panelM);
	}
	
	
	static void menuBarMenuCreate(JMenuBar mb, String[] start) {
		JMenu menu = new JMenu(start[0]);
		for (int i = 1; i<start.length; i++)	{
			JMenuItem mi = new JMenuItem(start[i]);
			//mi.addActionListener(this);
			mi.setActionCommand(start[i]);
			menu.add(mi);
		}
		mb.add(menu);
	}

}
