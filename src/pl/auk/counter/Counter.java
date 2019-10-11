package pl.auk.counter;




import java.awt.event.*;
import java.beans.*;
import java.io.*;

public class Counter implements Serializable {

  private int count = 0;    // w�a�ciwo�� count

  // Pomocniczy obiekt do prowadzenia listy s�uchaczy zmian w�a�ciwo�ci oraz
  // propagowania zmian  w�r�d zarejestrowanych z�uchaczy
   private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);


  // Konstruktory

  public Counter() {
    this(0);
  }

  public Counter(int aCount) {
    setCount( aCount );
  }


  // Metody przy��czania i od��czania s�uchaczy zmian w�a�ciwo�ci

  public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChange.addPropertyChangeListener(listener);
  }

  public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
    propertyChange.removePropertyChangeListener(l);
  }

  // Proste metody zwi�kszania i zmniejszania licznika

  public void increment() {
    setCount(getCount()+1);
  }

  public void decrement() {
    setCount(getCount()-1);
  }


  // Getter w�a�ciwo�ci "count"
  public int getCount() {
    return count;
  }

  // Setter w�a�ciow�ci "count"
  public synchronized void setCount(int aCount) {
    int oldValue = count;
    count = aCount;

    // wywo�anie metody firePropertChange z klasy PropertyChangeSupport
    // powoduje wygenerowanie zdarzenia PropertyChangeEvent i rozpropagowanie
    // go w�r�d wszystkich przy��czonych s�uchaczy, ale tylko wtedy, gdy nowa
    // warto�� w�a�ciwo�ci r�ni si� od starej warto�ci

    propertyChange.firePropertyChange("count", new Integer(oldValue),
                                            new Integer(aCount));
  }

}
