package pl.auk.java.beans.front2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.ReadAukcje;
import pl.auk.entities.Aukcje;
import pl.auk.start.DBConnect;
import pl.auk.start.SeFaStart;

public class AukcjomatView extends JFrame implements ActionListener{
	
	private String[] start = {"Start", "Nowa Aukcja", "Exit"};
	private DBConnect dbc;
	private List<Aukcje> aukcje;
	private int iloscLinii;
	
	public AukcjomatView()	{
		super("Aukcje - panel główny");
		//this.dbc = DBConnect.get;
		
		ReadAukcje ra = new ReadAukcje(SeFaStart.getFactory());
		this.aukcje = ra.getAukcje();
		this.iloscLinii = 6+aukcje.size();
		
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
		      @Override
		      public void run() {
		        createGui();
		      }
		    });
		
		
	}
	
	public void createGui()	{
		int width = 900;
		int height=	60+iloscLinii*20;	
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
			panelAktywne.add(label, "wrap");
		}
		panelM.add(panelAktywne, "wrap");
		
		
		panelM.add(new JLabel("Aukcje aktywne - Rozpoczęte:"), "wrap");
		
		
		panelM.add(new JLabel("Aukcje zakończone:"), "wrap");



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
			new NewAukcjaCreateForm();
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
	

}
