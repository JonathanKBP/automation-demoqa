package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait espera;
    private int timeOut = 5;

    BasePage(WebDriver driver, WebDriverWait espera) {
        this.driver = driver;
        this.espera = new WebDriverWait(driver, Duration.ofMillis(timeOut));
        PageFactory.initElements(driver, this);
    }


    private void changeImplicitWait(int value) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(value));
    }


    private void restoreDefaultImplicitWait() {
        changeImplicitWait(timeOut);
    }

    boolean elementeIsVisible(WebElement element) {
        changeImplicitWait(500);
        boolean isElementOnPage = true;
        try {
            // Get location on WebElement is rising exception when element is not present
            element.getLocation();
        } catch (WebDriverException ex) {
            isElementOnPage = false;
        } finally {
            restoreDefaultImplicitWait();
        }
        return isElementOnPage;
    }

    boolean doesElementeIsVisible(WebElement element) {
        changeImplicitWait(500);
        boolean doesElementHaveErrorMessage = true;
        try {
            element.findElement(By.xpath("../../div[@class='fieldset error']"));
        } catch (WebDriverException ex) {
            doesElementHaveErrorMessage = false;
        } finally {
            restoreDefaultImplicitWait();
        }
        return doesElementHaveErrorMessage;
    }
}
