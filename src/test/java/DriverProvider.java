import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProvider {

    public static WebDriver yandexDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\ChromeDriver\\104.0.5112.79\\chromedriver.exe");
        ChromeOptions optionsForYandex = new ChromeOptions();
        optionsForYandex.setBinary("C:\\Users\\Andrey\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        return new ChromeDriver(optionsForYandex);
    }

    public static WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\ChromeDriver\\105.0.5195.52\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        return new ChromeDriver(options);
    }


}
