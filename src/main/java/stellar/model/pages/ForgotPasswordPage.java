package stellar.model.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends DriveredPage {
    private final String PATH = "/forgot-password";
    private final By selectorResetButton = By.xpath(".//button[text()='Восстановить']");
    private final By selectorLoginLink = By.xpath(".//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    @Step("open page Forgot Password")
    public ForgotPasswordPage open() {
        driver.get(URL + PATH);
        waitForClickableElement(selectorLoginLink);
        return this;
    }

    @Step("follow to Login Page")
    public LoginPage followToLoginPage() {
        driver.findElement(selectorLoginLink).click();
        return new LoginPage(driver, jse);
    }

    public ResetPasswordPage pushReset() {
        driver.findElement(selectorResetButton).click();
        return new ResetPasswordPage(driver, jse);
    }
}
