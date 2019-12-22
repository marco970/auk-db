package pl.auk.java.beans.front2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class RawForm extends JFrame implements ActionListener {
	
	protected JPanel panelM;
	private String[] start;
	
	public RawForm(String title, String[] start)	{
		super(title);
		this.start = start;
		int width = 900;
		int height=	400;	
		setSize(width, height);
		
		
		
		this.panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelM.setLayout(new MigLayout());
		setContentPane(panelM);

		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		menuBarMenuCreate(mb, start);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void menuBarMenuCreate(JMenuBar mb, String[] start) {
		JMenu menu = new JMenu(start[0]);
		for (int i = 1; i<start.length; i++)	{
			JMenuItem mi = new JMenuItem(start[i]);
			mi.addActionListener(this);
			mi.setActionCommand(start[i]);
			menu.add(mi);
		}
		mb.add(menu);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String u = e.getActionCommand();
		System.out.println(start.length);
		if (u.equals(start[start.length-1]))	{
			this.dispose();
		}
		
	}

}
