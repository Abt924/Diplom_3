package stellar.model.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends DriveredPage {
    private final String PATH = "/account/profile";

    private final By selectorProfilePage = By.xpath(".//a[text()='Профиль']");
    private final By selectorLogoutButton = By.xpath(".//button[text()='Выход']");
    private final By selectorConstructor = By.xpath(".//p[text()='Конструктор']");
    private final By selectorLogo = By.xpath(".//div[contains(@class, 'logo')]/a");

    public ProfilePage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    public ProfilePage waitProfilePage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(selectorLogoutButton));
        return this;
    }

    public boolean isProfilePage() {
        WebElement element = driver.findElement(selectorProfilePage);
        return element != null;
    }

    @Step("logout")
    public LoginPage pushLogout() {
        driver.findElement(selectorLogoutButton).click();
        ;
        return new LoginPage(driver, jse);
    }

    @Step("follow to burger Constructor")
    public StellarHomePage clickConstructor() {
        driver.findElement(selectorConstructor).click();
        return new StellarHomePage(driver, jse);
    }

    @Step("follow by Logo click")
    public StellarHomePage clickLogo() {
        driver.findElement(selectorLogo).click();
        return new StellarHomePage(driver, jse);
    }

    public String getUrl() {
        return URL + PATH;
    }
}
