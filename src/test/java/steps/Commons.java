package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import entities.User;
import helpers.BaseTest;
import helpers.Settings;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import pages.Login;

public class Commons {
	private WebDriver driver = BaseTest.getDriver();
	private Login login = new Login(driver);
	
	@Dado("que realizo o acesso ao endereço {string}")
	public void queRealizoOAcessoAoEndereço(String endereco) {
		driver.get(Settings.getProperty("url.base") + Settings.getProperty(endereco));
	}
	
	@Dado("visualizo a mensagem {string}")
	public void visualizoAMensagem(String msg) {
	    validaMsg(driver, msg);
	}
	
	@Quando("realizo o login")
	public void realizoOLogin() {
		login.realizarLogin("JonathanKevin", "Teste@123");
	}
	
    public static void validaMsg(WebDriver driver, String msg) {
    	WebDriverWait espera = BaseTest.getEspera();
    	espera.until(ExpectedConditions.alertIsPresent());
    	
    	Alert alert = driver.switchTo().alert();

    	// Obtenha o texto do alerta
    	String alertText = alert.getText();

    	// Valide o texto do alerta
    	assert alertText.equals(msg);

    	// Aceite o alerta
    	alert.accept();
    }
}
