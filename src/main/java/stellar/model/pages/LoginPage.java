package stellar.model.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellar.model.inputs.EmailInput;
import stellar.model.inputs.PasswordInput;
import stellar.model.pojo.User;

public class LoginPage extends DriveredPage {
    public final String PATH = "/login";
    public final By selectorLoginPage = By.xpath(".//h2[text()='Вход']");
    public final By selectorLoginButton = By.xpath(".//button[text()='Войти']");
    public final By selectorRegisterLink = By.xpath(".//a[@href='/register']");
    public final By selectorRestorePasswordLink = By.xpath(".//a[@href='/forgot-password']");
    private EmailInput emailInput;
    private PasswordInput passwordInput;

    public LoginPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    @Step("open Login Page")
    public LoginPage open() {
        driver.get(URL + PATH);
        waitLoginPage();
        return this;
    }

    public LoginPage waitLoginPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(selectorLoginPage));
        return this;
    }

    public boolean isLoginPage() {
        WebElement element = driver.findElement(selectorLoginButton);
        return element != null;
    }

    public String getUrl() {
        return URL + PATH;
    }

    public RegisterPage followToRegister() {
        driver.findElement(selectorRegisterLink).click();
        return new RegisterPage(driver, jse);
    }

    public StellarHomePage pushLoginButton() {
        driver.findElement(selectorLoginButton).click();
        return new StellarHomePage(driver, jse);
    }

    private void initInputs() {
        passwordInput = new PasswordInput(driver, jse);
        emailInput = new EmailInput(driver, jse);
    }

    public LoginPage fillCreds(User user) {
        initInputs();
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        return this;
    }

    @Step("ui login as {user}")
    public StellarHomePage loginAs(User user) {
        initInputs();
        return this.fillCreds(user).pushLoginButton();
    }
}
