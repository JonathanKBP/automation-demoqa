package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.BaseTest;

public class Profile {
	private WebDriver driver;
	private WebDriverWait espera = BaseTest.getEspera();
    @FindBy(id = "gotoStore")
    private WebElement goToStoreButton;

    @FindBy(id = "submit")
    private WebElement DeleteAccountButton;
    
    @FindBy(id = "delete-record-undefined")
    private WebElement deleteBook;
    
    @FindBy(id = "closeSmallModal-ok")
    private WebElement deleteBookOK;


    public Profile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToStoreButton() {
    	espera.until(ExpectedConditions.visibilityOf(goToStoreButton));
    	goToStoreButton.click();
    }

    public void deleteAccountButton() {
    	espera.until(ExpectedConditions.visibilityOf(DeleteAccountButton));
    	DeleteAccountButton.click();
    }
    
    public void deleteBookButton() {
    	espera.until(ExpectedConditions.visibilityOf(deleteBook));
    	deleteBook.click();
    }
    
    public void deleteBookOKButton() {
    	espera.until(ExpectedConditions.visibilityOf(deleteBookOK));
    	deleteBookOK.click();
    }
}