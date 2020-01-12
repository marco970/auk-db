package pl.auk.jd.test.form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMouseAdapter extends MouseAdapter implements ActionListener {
	
	private JLabel label;
	
	public PopupMouseAdapter(JLabel label) {
		super();
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("from PMA "+ e.getActionCommand());
		
	}
    @Override
    public void mouseEntered(MouseEvent me) {
        label.setForeground(Color.RED);
        label.setBackground(Color.YELLOW);
        label.setOpaque(true);
    }
    public void mouseExited(MouseEvent me)	{
    	label.setForeground(Color.BLACK);
    }
	@Override
	public void mousePressed(MouseEvent me) {
		//System.out.println(el.getIdAukcja()+" --> "+el.getNazwaAuk());
		JPopupMenu popup = new JPopupMenu();
		addMenuItem(popup, "edycja danych ukcji", "editData");
		addMenuItem(popup, "edycja dostawców", "editBidder");
		addMenuItem(popup, "rozpocznij aukcje", "startAuction");
		addMenuItem(popup, "usuń aukcję", "deleteAuction");

		popup.show(label, me.getX(), me.getY());
		
	}
	private void addMenuItem(JPopupMenu popup, String miNazwa, String miActioCommand) {
		JMenuItem mit = new JMenuItem(miNazwa);
		mit.setActionCommand(miActioCommand);
		mit.addActionListener(this);
		popup.add(mit);
	}
	
	 
	

}
