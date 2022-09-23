package stellar.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellar.model.api.RestClient;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class DriveredPage {

    public final String URL = RestClient.URL;
    public final String PATH = "";

    protected WebDriver driver;
    protected JavascriptExecutor jse;

    // Конструктор с параметром WebDriver
    public DriveredPage(WebDriver driver) {
        this.driver = driver;
    }

    // Конструктор с параметром WebDriver, JavascriptExecutor
    public DriveredPage(WebDriver driver, JavascriptExecutor jse) {
        this.driver = driver;
        this.jse = jse;
    }

    protected void scrollAndClick(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView()", element);
        element.click();
    }
    public void waitForClickableElement(By selector) {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.elementToBeClickable(selector));
    }

    public void waitForElementVisibility(By selector) {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void waitForElementAttributeNotContains(By selector, String attr, String substring) {
        new WebDriverWait(driver, 30).
                until(not(ExpectedConditions.attributeContains(selector, attr, substring)));
    }


}

