package pl.auk.jd.test.form;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import pl.auk.java.beans.front2.RawForm;

public interface FormUtils {
	
	static JPanel createForm(List<FieldBean> formBeanList)	{
		
		JPanel localPanel = new JPanel();
		localPanel.setLayout(new MigLayout());
		
		for (FieldBean el: formBeanList)	{
			
			localPanel.add(el.getNazwa(), "right");
			localPanel.add(el.getComponent());
			localPanel.add(el.getErrMessage(), "wrap");
			
		}
		return localPanel;	
	}
	
	public static JLabel labelDef(String name, Color color, int aligment ) {
		JLabel label = new JLabel(name);		
		label.setHorizontalAlignment(aligment);

		label.setForeground(color);
		label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		return label;
	}
	
	public static JTextField textFieldDef(int length, RawForm form, Font font) {
		JTextField tfNazwa = new JTextField(length);
		tfNazwa.addFocusListener(form);
		tfNazwa.setFont(new Font("Tahoma", Font.PLAIN, 9));
		return tfNazwa;
	}

}