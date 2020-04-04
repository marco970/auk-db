package pl.auk.java.beans.front2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.AukcjeRead;
import pl.auk.entities.Aukcje;
import pl.auk.jd.test.form.AukcjaDaneForm;
import pl.auk.jd.test.form.PopupMouseAdapter;
import pl.auk.start.DBConnect;
import pl.auk.start.SeFaStart;

public class AukcjomatView extends JFrame implements ActionListener, WindowListener {
	
	private String[] start = {"Start", "Nowa Aukcja", "Exit"};
	private List<Aukcje> aukcje;
//	private List<JButton> editBtn;
//	private List<JButton> startBtn;
//	private List<JButton> deleteBtn;
	
	private int iloscLinii;
	
	private static String name;
	
	public AukcjomatView()	{
		super();
		//this.dbc = DBConnect.get;
		
		AukcjeRead ra = new AukcjeRead();
		this.aukcje = ra.getAukcje();
		this.iloscLinii = 6+aukcje.size();
		this.name = this.getClass().getSimpleName();
		this.setTitle("Aukcje - panel główny "+name);
		
//		editBtn = new ArrayList<>();
//		startBtn = new ArrayList<>();
//		deleteBtn = new ArrayList<>();
		

		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		        createGui();
		      }
		    });
	}
	
	public void createGui()	{
		int width = 900;
		int height=	60+iloscLinii*30;	
		setSize(width, height);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		menuBarMenuCreate(mb, start);
		
		JPanel panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));

		panelM.setLayout(new MigLayout());
		setContentPane(panelM);
		panelM.add(new JLabel("Aukcje - panel główny"), "wrap");
		
		panelM.add(new JLabel("Aukcje aktywne - Nowe:"), "wrap");
		JPanel panelAktywne = new JPanel();
		panelAktywne.setLayout(new MigLayout());
//		tworzymy liste Aktywnych Aukcji
		
		for (Aukcje el: aukcje)	{
			JLabel label = new JLabel(el.getNazwaAuk());
			label.addMouseListener(new PopupMouseAdapter(label, el, this));
			new JButton("edit");
			panelAktywne.add(label, "width 150::200, wrap");
		}
		panelM.add(panelAktywne, "wrap");
		
		
		
		
		panelM.add(new JLabel("Aukcje aktywne - Rozpoczęte:"), "wrap");
//		tu dodac rozpoczęte
		
		panelM.add(new JLabel("Aukcje zakończone:"), "wrap");
//		tu dodac zakończone

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	/**
	 * @param mb
	 * @param start
	 */
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


		

		
		if (u.equals(start[1]))	{
			new AukcjaDaneForm();
			this.dispose();
		}
		

		if (u.equals(start[2]))	{
			try {
				DBConnect.getProcess().destroy();
				System.out.println("---- process destroyed");
			} catch (Exception e2) {
			}
			System.exit(0);
		}

		
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			DBConnect.getProcess().destroy();
			System.out.println("---- process destroyed");
		} catch (Exception e2) {
		}
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	
	}

	@Override
	public void windowActivated(WindowEvent e) {
	
	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}
