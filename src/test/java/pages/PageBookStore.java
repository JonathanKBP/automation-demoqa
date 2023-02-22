package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.BaseTest;

public class PageBookStore {
	private WebDriver driver;
	private WebDriverWait espera = BaseTest.getEspera();
	
    @FindBy(id = "searchBox")
    private WebElement searchBoxField;

    @FindBy(id = "basic-addon2")
    private WebElement searchButton;
    
    public PageBookStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchBoxField(String book) {
    	espera.until(ExpectedConditions.visibilityOf(searchBoxField));
    	searchBoxField.sendKeys(book);
    }

    public void searchButton() {
    	espera.until(ExpectedConditions.visibilityOf(searchButton));
    	searchButton.click();
    }
}
