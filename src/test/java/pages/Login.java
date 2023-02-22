package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.BaseTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	private WebDriver driver;
	private WebDriverWait espera = BaseTest.getEspera();
	
    @FindBy(id = "userName")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(id = "login")
    private WebElement loginButton;
    
    @FindBy(id = "newUser")
    private WebElement newUserButton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
    	espera.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.sendKeys(username);
    }

    public void setPassword(String password) {
    	espera.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
    	espera.until(ExpectedConditions.visibilityOf(loginButton));
    	loginButton.click();
    }
    
    public void clickNewUserButton() {
    	espera.until(ExpectedConditions.visibilityOf(newUserButton));
    	newUserButton.click();
    }
    
    public void realizarLogin(String userName, String password) {
		setUsername(userName);
		setPassword(password);	
		clickLoginButton();
    }
}

