package stellar.model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StellarHomePage extends DriveredPage {
    public final static String URL = "https://stellarburgers.nomoreparties.site";

    public StellarHomePage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }
}
