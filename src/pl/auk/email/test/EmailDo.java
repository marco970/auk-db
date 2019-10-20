package pl.auk.email.test;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class EmailDo {
	
	
	public EmailDo(int stepNr, String oferent, String address, int twojaCena, int pos, int min) throws URISyntaxException, IOException	{
		
		
		String to = address;
		String cc ="?cc=email2@example.comb";
		
		String subject = "&subject="
		+oferent+"nazwa%20Aukcji%20"+"numer%20kroku%20"+stepNr;
		
		String emailBody = "&body="
				+ "Dear%20Bidder,%0A"
				+ "%0A"
				+ "Your%20Offer:%20"+twojaCena+"%0A"
				+ "Your%20Position%20after%20step%20"+stepNr+"%20:%20"+pos;
		String uri = "mailto:"+to+cc+subject+emailBody;
		
		System.out.println(uri);
		
		
		Desktop desktop;
		if (Desktop.isDesktopSupported() 
			    && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
			  URI mailto = new URI(uri);
			  desktop.mail(mailto);
			} else {
			  throw new RuntimeException("desktop doesn't support mailto; mail is dead anyway ;)");
			}
		
	}

}
