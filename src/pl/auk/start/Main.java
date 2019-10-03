package pl.auk.start;

import java.util.ArrayList;
import java.util.List;

import pl.auk.front.ListBean;
import pl.auk.front.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		new MainWindow();
		
		List<List<Object>> krok = new ArrayList<>();
		List<Object> row1 = new ArrayList<>();
		row1.add(1);
		row1.add("Nokia");
		row1.add(1000);
		List<Object> row2 = new ArrayList<>();
		row2.add(1);
		row2.add("Huawei");
		row2.add(900);
		List<Object> row3 = new ArrayList<>();
		row3.add(1);
		row3.add("Oracle");
		row3.add(2000);
		krok.add(row1);
		krok.add(row2);
		krok.add(row3);
		
		ListBean lb = new ListBean(krok);
		

	}

}
