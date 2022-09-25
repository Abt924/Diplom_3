package stellar.model.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellar.model.inputs.EmailInput;
import stellar.model.inputs.NameInput;
import stellar.model.inputs.PasswordInput;
import stellar.model.pojo.User;

public class RegisterPage extends DriveredPage {
    private final String PATH = "/register";
    private final By selectorRegisterPage = By.xpath(".//h2[text()='Регистрация']");
    private final By selectorRegisterButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By selectorLoginLink = By.xpath(".//a[@href='/login']");
    private NameInput nameInput;
    private EmailInput emailInput;
    public PasswordInput passwordInput;

    public RegisterPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    @Step("open Register page")
    public RegisterPage open() {
        driver.get(URL + PATH);
        waitRegisterPage();
        passwordInput = new PasswordInput(driver, jse);
        nameInput = new NameInput(driver, jse);
        emailInput = new EmailInput(driver, jse);
        return this;
    }

    public RegisterPage waitRegisterPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(selectorRegisterButton));
        return this;
    }

    //    @Step("fill name {name}")
    public RegisterPage fillName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    //    @Step("fill email {email}")
    public RegisterPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    //    @Step("fill pwd {password}")
    public RegisterPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    //    @Step("puss Register button")
    public LoginPage pushRegisterButton() {
        driver.findElement(selectorRegisterButton).click();
        return new LoginPage(driver, jse);
    }

    @Step("ui register user {user}")
    public LoginPage registerAs(User user) {
        open();
        fillName(user.getName());
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        return pushRegisterButton();
    }

    @Step("ui register user {user}")
    public RegisterPage registerAsExpectingFailure(User user) {
        open();
        fillName(user.getName());
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        return pushRegisterExpectingFailure();
    }

    //    @Step("push Register button")
    public RegisterPage pushRegisterExpectingFailure() {
        driver.findElement(selectorRegisterButton).click();
        return this;
    }

    public boolean isRegisterPage() {
        WebElement element = driver.findElement(selectorRegisterPage);
        return element != null;
    }

    public String getUrl() {
        return URL + PATH;
    }

    @Step("follow to Login page")
    public LoginPage followToLoginPage() {
        driver.findElement(selectorLoginLink).click();
        return new LoginPage(driver, jse);
    }
}
