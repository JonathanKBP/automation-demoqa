package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.BaseTest;

public class Book {
	private WebDriver driver;
	private WebDriverWait espera = BaseTest.getEspera();
	
    @FindBy(css = "#ISBN-wrapper #userName-value")
    private WebElement isbnValue;

    @FindBy(css = "#title-wrapper #userName-value")
    private WebElement titleValue;
    
    @FindBy(css = "#subtitle-wrapper #userName-value")
    private WebElement subTitleValue;
    
    @FindBy(css = "#author-wrapper #userName-value")
    private WebElement authorValue;
    
    @FindBy(css = "#publisher-wrapper #userName-value")
    private WebElement publisherValue;
    
    @FindBy(css = "#pages-wrapper #userName-value")
    private WebElement pagesValue;
    
    @FindBy(css = "#description-wrapper #userName-value")
    private WebElement descriptionValue;

    public Book(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void validateIsbnValue(String string) {
    	espera.until(ExpectedConditions.visibilityOf(isbnValue));
    	WebElement element = isbnValue;
		String text = element.getText();
		Assert.assertEquals("Valor do ISBN incorreto", string, text);
    }
    public void validateTitleValue(String string) {
    	WebElement element = titleValue;
		String text = element.getText();
		assert text.equals(string);
    }
    public void validateSubTitleValue(String string) {
    	WebElement element = subTitleValue;
		String text = element.getText();
		assert text.equals(string);
    }
    public void validateAuthorValue(String string) {
    	espera.until(ExpectedConditions.visibilityOf(authorValue));
    	WebElement element = authorValue;
		String text = element.getText();
		assert text.equals(string);
    }
    public void validatePublisherValue(String string) {
    	WebElement element = publisherValue;
		String text = element.getText();
		assert text.equals(string);
    }
    public void validatePageValue(String string) {
    	WebElement element = pagesValue;
		String text = element.getText();
		assert text.equals(string);
    }
    public void validateDescriptionValue(String string) {
    	WebElement element = descriptionValue;
		String text = element.getText();
		assert text.equals(string);
    }
}
