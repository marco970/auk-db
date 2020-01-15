package pl.auk.jd.test.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import pl.auk.back.ReadSingleAukcja;
import pl.auk.java.beans.front2.AukcjomatView;

public class PopupMouseAdapter extends MouseAdapter implements ActionListener {
	
	private JLabel label;
	private int idAukcja;
	private String[][] matrix = {
			{"edycja danych aukcji", "editData"},
			{"edycja dostawców", "editBidder"},
			{"rozpocznij aukcje", "startAuction"},
			{"usuń aukcję", "deleteAuction"}
			}; 
	
	private AukcjomatView aukcjomatView;

	public PopupMouseAdapter(JLabel label, int idAukcja, AukcjomatView aukcjomatView ) {
		super();
		this.label = label;
		this.idAukcja = idAukcja;
		this.aukcjomatView = aukcjomatView;
//		System.out.println(matrix.length);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("from PMA "+ e.getActionCommand()+" idAukcji "+idAukcja);
		
		if (e.getActionCommand().equals(matrix[0][1]))	{
//			"edycja danych aukcji", "editData"
			System.out.println(new ReadSingleAukcja(idAukcja).getAukcja().getNazwaAuk());
			aukcjomatView.dispose();
//			ReadSingleAukcja rsa = new ReadSingleAukcja(idAukcja);
			new AukcjaDaneForm(new ReadSingleAukcja(idAukcja).getAukcja());
			 
			
		}
		if (e.getActionCommand().equals(matrix[1][1]))	{
			
		}
		if (e.getActionCommand().equals(matrix[2][1]))	{
			
		}
		if (e.getActionCommand().equals(matrix[3][1]))	{
			
		}
		
	}
    @Override
    public void mouseEntered(MouseEvent me) {
        label.setForeground(Color.RED);
        label.setBackground(Color.LIGHT_GRAY);
        label.setOpaque(true);
    }
    public void mouseExited(MouseEvent me)	{
    	label.setForeground(Color.BLACK);
    	label.setOpaque(false);
    }
	@Override
	public void mousePressed(MouseEvent me) {
		//System.out.println(el.getIdAukcja()+" --> "+el.getNazwaAuk());
		JPopupMenu popup = new JPopupMenu();
		
		for (int i=0; i<matrix.length; i++)	{
			addMenuItem(popup, matrix[i][0],matrix[i][1]);
		}

		popup.show(label, me.getX(), me.getY());
		
	}
	private void addMenuItem(JPopupMenu popup, String miNazwa, String miActioCommand) {
		JMenuItem mit = new JMenuItem(miNazwa);
		mit.setActionCommand(miActioCommand);
		mit.addActionListener(this);
		popup.add(mit);
	}
	
	 
	

}
