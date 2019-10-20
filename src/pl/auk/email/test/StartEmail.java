package pl.auk.email.test;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class StartEmail {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		Desktop desktop;
		if (Desktop.isDesktopSupported() 
		    && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
		  URI mailto1 = new URI("mailto:john@example.com?subject=Hello%20World");
		  URI mailto2 = new URI("mailto:chriscoyier@gmail.com?subject=Important!&body=Hi,%0ATy%20Chuju,%20gdzie%20by³eœ%20pijaku%20jebany%0APozdrawiam%20Krystyna");
//		  tu se  porobiæ jakieœ fajne metody do budowy tego stringa 
		  desktop.mail(mailto1);
		  desktop.mail(mailto2);
		} else {
		  // TODO fallback to some Runtime.exec(..) voodoo?
		  throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
		}
		

	}

}
