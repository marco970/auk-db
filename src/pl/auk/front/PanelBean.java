package pl.auk.front;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JPanel;

public class PanelBean {
	
	private JPanel panelBean;
	private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
	
	public PanelBean()	{
		panelBean = new JPanel();
	}
	
	public PanelBean(JPanel panelBean)		{
		this.setPanelBean(panelBean);
	}

	public JPanel getPanelBean() {
		return panelBean;
	}

	public void setPanelBean(JPanel thePanelBean) {
		JPanel oldPanel = panelBean;
		panelBean = thePanelBean;
		propertyChange.firePropertyChange("panelBean", oldPanel, panelBean);
	}
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.addPropertyChangeListener(listener);
	}
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChange.removePropertyChangeListener(listener);
	}

}
