package pl.auk.jd.test;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;
import pl.auk.entities.Aukcje;
import pl.auk.java.beans.front2.AukcjomatView;
import pl.auk.jd.test.form.FormMouseListener;
import pl.auk.jd.test.form.FormUtils;
import pl.auk.jd.test.form.bidderform.BidderFormTableModel;
import pl.auk.jd.test.form.bidderform.BiddersForm;

public class StandardWindow extends JFrame implements ActionListener, FormUtils {
	
	private String[] start = {"Start", "Dodaj Oferenta", "Exit"};
	private Aukcje aukcja;
	private JTable tableBidders;
	private BidderFormTableModel modelBidders;
	
	private String[][] matrix = {
			{"edycja danych dostawcy", "editBidderData"},
			{"usuń dostawcę", "deleteBidder"},
			}; 
	
	
	
	public StandardWindow(String title, Aukcje aukcja)	{
		super(title);
		this.aukcja = aukcja;
		
		int width = 900;
		int height=	60+20*30;	
		setSize(width, height);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		menuBarMenuCreate(mb, start);
	
		JPanel panelM = new JPanel();
		panelM.setBorder(new EmptyBorder(5, 5, 5, 5));

		panelM.setLayout(new MigLayout());
		setContentPane(panelM);
		
		panelM.add(new JLabel("Tabelka poniżej"), "wrap");
		
		JPanel panelTable = new JPanel();
		panelM.add(panelTable, "wrap");
		
		modelBidders = new BidderFormTableModel(aukcja.getIdAukcja());
		
		tableBidders = new JTable(modelBidders);
		
		JScrollPane sp = new JScrollPane(tableBidders);
		
		panelTable.add(sp, "wrap");
		
		FormMouseListener fml = new FormMouseListener(tableBidders);
		
		tableBidders.addMouseListener(fml);
		
		
	    JPopupMenu popup = new JPopupMenu();
	    
		for (int i=0; i<matrix.length; i++)	{
			FormUtils.addMenuItem(popup, matrix[i][0],matrix[i][1], this);
		}
		
		tableBidders.setComponentPopupMenu(popup);
		
		panelM.add(new JLabel("Tabelka powyżej"), "wrap");
		
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
		
		int selectedRow = tableBidders.getSelectedRow();
		int realSelectedRow = tableBidders.convertRowIndexToModel(selectedRow);
		
		if (u.equals(start[start.length-1]))	{
			this.dispose();
		}
		if (u.equals(start[start.length-2]))	{
			new BiddersForm(aukcja, modelBidders);
		}
		
		if (e.getActionCommand().equals(matrix[0][1]))	{
			
			new BiddersForm(aukcja, modelBidders, modelBidders.getBidder(realSelectedRow));

			
			System.out.println("update " +selectedRow+" -- "+realSelectedRow);
		}
		
		if (e.getActionCommand().equals(matrix[1][1]))	{
			System.out.println("delete");
		}
		
	}

}
