package pl.auk.java.beans.front2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import pl.auk.back.ReadAukcje;
import pl.auk.entities.Aukcje;
import pl.auk.jd.test.form.AukcjaDaneForm;
import pl.auk.jd.test.form.PopupMouseAdapter;
import pl.auk.start.DBConnect;
import pl.auk.start.SeFaStart;

public class AukcjomatView extends JFrame implements ActionListener, MouseListener{
	
	private String[] start = {"Start", "Nowa Aukcja", "Exit"};
	private DBConnect dbc;
	private List<Aukcje> aukcje;
	private List<JButton> editBtn;
	private List<JButton> startBtn;
	private List<JButton> deleteBtn;
	
	private int iloscLinii;
	
	public AukcjomatView()	{
		super("Aukcje - panel główny");
		//this.dbc = DBConnect.get;
		
		ReadAukcje ra = new ReadAukcje(SeFaStart.getFactory());
		this.aukcje = ra.getAukcje();
		this.iloscLinii = 6+aukcje.size();
		
		editBtn = new ArrayList<>();
		startBtn = new ArrayList<>();
		deleteBtn = new ArrayList<>();
		

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
			
			 label.addMouseListener(new PopupMouseAdapter(label));
			
			JButton edit = new JButton("edit");
			
			
			
//			edit.setName(el.getIdAukcja()+" edit");
//			edit.addActionListener(this);
//			editBtn.add(edit);
//			JButton start = new JButton("start");
//			start.setName(el.getIdAukcja()+" start");
//			start.addActionListener(this);
//			startBtn.add(edit);
//			JButton delete = new JButton("delete");
//			delete.setName(el.getIdAukcja()+" delete");
//			delete.addActionListener(this);
//			deleteBtn.add(edit);
			panelAktywne.add(label, "width 150::200, wrap");
//			panelAktywne.add(start, "width 80::100");
//			panelAktywne.add(edit, "width 80::100");
//			panelAktywne.add(delete, "width 80::100, wrap");
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
