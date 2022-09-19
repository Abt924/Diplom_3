import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stellar.model.WebDriverGenerator;

public class BaseUiTest {

    protected WebDriver driver;
    protected JavascriptExecutor jse;

    @Before
    public void setUp() {
//        driver = WebDriverGenerator.yandexDriver();
        driver = WebDriverGenerator.chromeDriver();

        jse = (JavascriptExecutor) driver;

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}