package stellar.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends DriveredPage {
    public final String PATH = "/register";

    public final By selectorRegisterButton = By.xpath(".//button[text()='Зарегистрироваться']");

    NameInput nameInput;
    EmailInput emailInput;
    PasswordInput passwordInput;

    public RegisterPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    public RegisterPage open() {
        driver.get(StellarHomePage.URL + PATH);
        waitRegisterButton();
        passwordInput = new PasswordInput(driver, jse);
        nameInput = new NameInput(driver, jse);
        emailInput = new EmailInput(driver, jse);

        return this;
    }

    public RegisterPage waitRegisterButton() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(selectorRegisterButton));
        return this;
    }

    public RegisterPage fillName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public RegisterPage fillEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public RegisterPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage pushRegisterButton() {
        driver.findElement(selectorRegisterButton).click();
        return new LoginPage(driver, jse);
    }

    public RegisterPage pushRegisterExpectingFailure() {
        driver.findElement(selectorRegisterButton).click();
        return new RegisterPage(driver, jse);
    }


}
