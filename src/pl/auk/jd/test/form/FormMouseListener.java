package pl.auk.jd.test.form;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

public class FormMouseListener extends MouseAdapter {
	
	private JTable table;
	
	private String[][] matrix = {
			{"edycja danych dostawcy", "editBidderData"},
			{"usuń dostawcę", "deleteBidder"},
			}; 

	public FormMouseListener(JTable table) {
		super();
		this.table = table;
	}
	
	@Override
	    public void mousePressed(MouseEvent event) {
		
	    Point point = event.getPoint();
	    int currentRow = table.rowAtPoint(point);
	    
	    if (currentRow < 0 || currentRow > table.getModel().getRowCount()) currentRow = table.getModel().getRowCount()-1;
	    table.setRowSelectionInterval(currentRow, currentRow);
	       
	    int selectedRow = table.getSelectedRow();
	    int realSelectedRow = table.convertRowIndexToModel(selectedRow);
	       
	    System.out.println("realSelectedRow "+realSelectedRow);
	    
		
		
		
	}
	


	
	

}
