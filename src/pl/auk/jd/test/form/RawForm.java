package pl.auk.jd.test.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import pl.auk.java.beans.front2.AukcjomatView;

@SuppressWarnings("serial")
public class RawForm extends JFrame implements ActionListener, FocusListener {
	
	protected JPanel panelM;
	
	private String[] start;
	protected List<FieldBean> listFieldBean;
	
	protected List<JButton> buttonList;
	
	public RawForm(String title, String[] start)	{
		super(title);
		this.start = start;
		
		this.listFieldBean = new ArrayList<>();
			
		int width = 600;
		int height=	400;	
		setSize(width, height);
		
		this.panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelM.setLayout(new MigLayout());
		setContentPane(panelM);

		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		menuBarMenuCreate(mb, start);
		
		this.buttonList = new ArrayList<>();

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
		
		if (u.equals(start[start.length-1]))	{
			this.dispose();
//			new AukcjomatView();
		}
		
		if (u.equals("anuluj"))	{
			this.dispose();
//			new AukcjomatView();
		}

	}
	@Override
	public void focusGained(FocusEvent e) {
	}
	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("elo");
		
	}
	
	public void  fieldBeanCreate(String name, JComponent field, JLabel errMessage)	{
		JLabel nazwa = FormUtils.labelDef(name, Color.BLACK, SwingConstants.RIGHT);
		FieldBean  fieldBean = new FieldBean(nazwa, field, errMessage);
		listFieldBean.add(fieldBean);		
	}
	
	

}
