import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class BaseUiTest {

    protected WebDriver driver;
//    protected WebDriver driver_;
    protected JavascriptExecutor jse;

    public BaseUiTest(WebDriver driver, String browser) {
        this.driver = driver;
    }
    @Parameterized.Parameters(name ="browser {1}")
    public static  Object [][] getDriver(){
        return new Object[][]{
                {WebDriverGenerator.chromeDriver(), "Chrome"},
                {WebDriverGenerator.yandexDriver(), "Yandex"}
        };
    }


    @Before
    public void setUp() {
//        driver = WebDriverGenerator.yandexDriver();
//        driver = driver_;
        jse = (JavascriptExecutor) driver;

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}