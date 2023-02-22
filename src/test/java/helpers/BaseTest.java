package helpers;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
	public static WebDriver driver;
	public static WebDriverWait espera;
	
	@Before
	public static void setup() {
        // Define a variável de ambiente para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver/chromedriver.exe");

        // Cria uma instância do ChromeDriver
        driver = new ChromeDriver();

        // Configura o tempo de espera implícito para 10 segundos
        espera = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
	
    private static void ensureDriverInitialized() {
        if (driver == null) {
            setup();
        }
    }

    public static WebDriver getDriver() {
        ensureDriverInitialized();
        return driver;
    }
    
    public static WebDriverWait getEspera() {
        ensureDriverInitialized();
        return espera;
    }
}