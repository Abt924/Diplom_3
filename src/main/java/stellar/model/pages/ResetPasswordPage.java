package stellar.model.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends DriveredPage {
    private final String PATH = "/reset-password";
    private final By selectorSaveButton = By.xpath(".//button[text()='Сохранить']");
    private final By selectorLoginLink = By.xpath(".//a[@href='/login']");

    public ResetPasswordPage(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
    }

    @Step("open Page reset password")
    public ResetPasswordPage open() {
        driver.get(URL + PATH);
        waitForClickableElement(selectorLoginLink);
        return this;
    }

    @Step("follow to Login page")
    public LoginPage followToLoginPage() {
        driver.findElement(selectorLoginLink).click();
        return new LoginPage(driver, jse);
    }

    public ResetPasswordPage pushSave() {
        driver.findElement(selectorSaveButton).click();
        return new ResetPasswordPage(driver, jse);
    }
}
