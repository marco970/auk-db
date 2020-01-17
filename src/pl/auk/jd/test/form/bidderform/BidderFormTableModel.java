package pl.auk.jd.test.form.bidderform;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import pl.auk.back.BiddersRead;
import pl.auk.entities.Bidders;

public class BidderFormTableModel extends AbstractTableModel {
	
	private String[] columnNames = {"nazwa","email","domiar"}; 
	private List<Bidders> dane;
	
	
	public BidderFormTableModel(int idAukcji)	{
		//wyciągnąć z BD dla danej aukcji
		//potrzebne ID aukcji
		BiddersRead rb = new BiddersRead(idAukcji);
		dane = rb.getBidders();
		
		
	}

	@Override
	public int getRowCount() {
		return dane.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

    Bidders bidder = dane.get(rowIndex);
    switch (columnIndex) {
            case 0: 
                return bidder.getName();
            case 1:
                return bidder.getEmail();
            case 2:
                return bidder.getDomiar();
           }
           return null;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex){
	          switch (columnIndex){
	             case 0: 
	            	 return String.class;
	             case 1:
	            	 return Object.class;
	             case 2:
	            	 return String.class;

	             }
	             return null;
	}
	@Override
	public String getColumnName(int columnIndex)	{
		return columnNames[columnIndex];
	}
	
	public void recordAdd(Bidders bidder)	{
		dane.add(bidder);
		fireTableRowsInserted(dane.size()-1, dane.size()-1);
		fireTableDataChanged();
		
	}
	
	

}
