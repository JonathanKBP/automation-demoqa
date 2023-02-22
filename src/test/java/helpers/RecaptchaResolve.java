package helpers;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import java.net.URL;

public class RecaptchaResolve {
	
	public static void clickRecaptcha() {
		String imageFilePath = "img/checkbox.png";		
		URL imageURL = RecaptchaResolve.class.getClassLoader().getResource(imageFilePath);
		Pattern imageReference = new Pattern(imageURL.getPath());
		
		imageFilePath = "img/checkboxOK.png";		
		imageURL = RecaptchaResolve.class.getClassLoader().getResource(imageFilePath);
		Pattern checkboxOK = new Pattern(imageURL.getPath());
	
		Screen screen = new Screen();
			
		try {
			screen.wait(imageReference, 10); // espera no máximo 10 segundos pela imagem
			screen.click(imageReference);
			screen.wait(checkboxOK, 10);
		} catch (Exception e) {
			 e.printStackTrace();
		}
    }

}
