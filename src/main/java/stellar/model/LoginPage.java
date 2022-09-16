package stellar.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends DriveredPage{
    public final String PATH = "/login";

    public final By selectorLoginPage = By.xpath(".//h2[text()='Вход']");
    public final By selectorLogin = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    public LoginPage waitLoginPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(selectorLoginPage));
        return this;
    }
    public boolean isLoginPage(){
        WebElement loginButton = driver.findElement(selectorLogin);
        return loginButton != null;
    }

    public String getUrl(){
        return StellarHomePage.URL+PATH;
    }

}
