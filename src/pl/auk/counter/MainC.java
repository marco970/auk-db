package pl.auk.counter;


public class MainC {

 public static void main(String[] args)  {

   // Tworzymy obiekty: licznik i jego widok
   Counter counter = new Counter();
   CounterView counterView = new CounterView(""+counter.getCount());

   // Rejestrujemy widok jako s³uchacza zmian licznika
   counter.addPropertyChangeListener(counterView);

   // Tworzymu GUI kontrolera i pokazujemy go
   CounterControlGui gui = new CounterControlGui(counter, counterView);
   gui.pack();
   gui.show();
  }

}

