package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import helpers.BaseTest;

public class Register {
	private WebDriver driver;
	private WebDriverWait espera = BaseTest.getEspera();

    @FindBy(id = "firstname")
    private WebElement userFirstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;
    
    @FindBy(id = "userName")
    private WebElement userNameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(id = "register")
    private WebElement registerButton;
    
    @FindBy(id = "gotologin")
    private WebElement goToLoginButton;
    
    @FindBy(id = "output")
    private WebElement output;

    public Register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserFirstName(String firstName) {
        userFirstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void setUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickGoToLoginButton() {
        goToLoginButton.click();
    }
    
    public void assertOutput(String msg) {
    	SoftAssert softAssert = new SoftAssert();
    	WebElement element = espera.until(ExpectedConditions.visibilityOf(output));
    	
    	String msgOutput = element.getText();
    	
    	softAssert.assertEquals(msg, msgOutput, "Validação da mensagem recebida");
    	softAssert.assertAll();
    }
}
