package pl.auk.java.beans.front2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

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
import pl.auk.jd.test.form.FieldBean;
import pl.auk.jd.test.form.FieldValidator;
import pl.auk.jd.test.form.FormUtils;

@SuppressWarnings("serial")
public class RawForm extends JFrame implements ActionListener, FocusListener {
	
	protected JPanel panelM;
	private String[] start;
	protected List<FieldBean> listFieldBean;
	
	public RawForm(String title, String[] start)	{
		super(title);
		this.start = start;
		
		this.listFieldBean = new ArrayList<>();
		
		
		int width = 500;
		int height=	300;	
		setSize(width, height);
		
		System.out.println("konstruktor b");
		
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
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("elo");
		
	}
	
	public void  fieldBeanCreate(String name, JComponent field, FieldValidator validator, JLabel errMessage)	{
		JLabel nazwa = FormUtils.labelDef(name, Color.BLACK, SwingConstants.RIGHT);
		FieldBean  fieldBean = new FieldBean(nazwa, field, validator, errMessage);
		System.out.println("z metody fieldBeanCreate: "+ fieldBean.getErrMessage());
		listFieldBean.add(fieldBean);		
	}

}
