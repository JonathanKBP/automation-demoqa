package steps;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import entities.User;
import helpers.BaseTest;
import helpers.RecaptchaResolve;
import helpers.Settings;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.Login;
import pages.Register;

public class CadastroUsuario {
	private WebDriver driver = BaseTest.getDriver();
	private Register register = new Register(driver);
	private Login login = new Login(driver);
	private User userOk = new User("Jonathan", "Kevin", UUID.randomUUID().toString(), "Test-123@");
	
	@Quando("clico no botão new user")
	public void clicoNoBotãoNewUser() {	
		login.clickNewUserButton();
	}
	@Quando("preencho os campos com a senha {string}")
	public void preenchoOsCamposComUmaSenha(String senha) {
		User user = new User("Jonathan", "Kevin", "jonathan@teste", senha);
		
		register.setUserFirstName(user.getFirstName());
		register.setLastName(user.getLastName());
		register.setUserName(user.getUserName());
		register.setPassword(user.getPassword());
	}
	
	@Quando("preencho os campos com dados corretos")
	public void preenchoOsCamposComUmaSenha() {
		register.setUserFirstName(userOk.getFirstName());
		register.setLastName(userOk.getLastName());
		register.setUserName(userOk.getUserName());
		register.setPassword(userOk.getPassword());
	}
	
	@Quando("realizo o login com esse usuario")
	public void realizoOLogin() {
		login.realizarLogin(userOk.getUserName(), userOk.getPassword());
	}
	
	@Quando("clico no botão register")
	public void clicoNoBotãoRegister() {	
		RecaptchaResolve.clickRecaptcha();
		
		register.clickRegisterButton();
	}
	@Então("visualizo a mensagem informando os critérios da senha")
	public void visualizoAMensagemInformandoOsCritériosDaSenha() {
	    register.assertOutput("Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), "
	    		+ "one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.");
	}
	
	@Quando("clico no botão back to login")
	public void clicoNoBotãoBackToLogin() {	
		register.clickGoToLoginButton();
	}
	
	@Então("no cabeçalho visualizo {string}")
	public void noCabeçalhoVisualizo(String string) {
		WebElement element = driver.findElement(By.className("main-header"));
		String text = element.getText();
		assert text.equals(string);
	}
}
