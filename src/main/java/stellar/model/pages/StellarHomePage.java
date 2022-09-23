package stellar.model.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StellarHomePage extends DriveredPage {

    private final String PATH = "/";

    private final By selectorAccountLoginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By selectorAccountProfile = By.xpath(".//p[text()='Личный Кабинет']");
    private final By selectorPlaceAnOrder = By.xpath(".//button[text()='Оформить заказ']");



    public StellarHomePage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }
    public String getUrl() {return URL + PATH;}

    public boolean isAuthorizedPage(){
        WebElement element = driver.findElement(selectorPlaceAnOrder);
        return element.isEnabled();
    }

    public StellarHomePage waitForAuthorizedHomePage(){
        waitForClickableElement(selectorPlaceAnOrder);
        return this;
    }

    @Step("open Home page")
    public StellarHomePage open() {
        driver.get(URL + PATH);
        waitForClickableElement(selectorAccountLoginButton);
        return this;
    }

    @Step("push Login to account")
    public LoginPage pushAccountLogin(){
        driver.findElement(selectorAccountLoginButton).click();;
        return new LoginPage(driver,jse);
    }

    @Step("push Account Profile")
    public ProfilePage pushAccountProfile(){
        driver.findElement(selectorAccountProfile).click();
        return new ProfilePage(driver,jse);
    }
    @Step("push Account Profile")
    public LoginPage pushUnauthorizedAccountProfile(){
        driver.findElement(selectorAccountProfile).click();
        return new LoginPage(driver,jse);
    }


}
