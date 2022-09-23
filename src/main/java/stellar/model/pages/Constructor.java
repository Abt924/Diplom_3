package stellar.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Constructor extends DriveredPage {

    private final By selectorBunsButton = By.xpath(".//span[text()='Булки']/parent::div");
    private final By selectorSaucesButton = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By selectorFillingsButton = By.xpath(".//span[text()='Начинки']/parent::div");

    private final By selectorBunsDivision = By.xpath(".//h2[text()='Булки']");
    private final By selectorSaucesDivision = By.xpath(".//h2[text()='Соусы']");
    private final By selectorFillingsDivision = By.xpath(".//h2[text()='Начинки']");

    private final By selectorTabs = By.xpath(".//div[contains(@class, 'tab_tab__')]");

    private final String tabSelectedClass = "tab_tab_type_current__";

    List<WebElement> tabs = new ArrayList<>();
    public Constructor(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse);
        tabs = driver.findElements(selectorTabs);
    }

    public Constructor clickTab(By selector) {
        waitForElementAttributeNotContains(selector, "class", tabSelectedClass);
        driver.findElement(selector).click();
        return this;
    }

    public Constructor clickBuns() {
        clickTab(selectorBunsButton);
        return this;
    }
    public Constructor clickSauces() {
        clickTab(selectorSaucesButton);
        return this;
    }

    public Constructor clickFillings() {
        clickTab(selectorFillingsButton);
        return this;
    }

    public boolean isTabSelected(By selector){
        return driver.findElement(selector).getAttribute("class").contains(tabSelectedClass);
    }

    public boolean isBunsTabSelected(){
        return isTabSelected(selectorBunsButton);
    }
    public boolean isSaucesTabSelected(){
        return isTabSelected(selectorSaucesButton);
    }
    public boolean isFillingsTabSelected(){
        return isTabSelected(selectorFillingsButton);
    }


    public boolean isTabClickable(By selector){
        return driver.findElement(selector).isEnabled();
    }

    public boolean isBunsVisible(){
        return driver.findElement(selectorBunsDivision).isDisplayed();
    }
    public boolean isSaucesVisible(){
        return driver.findElement(selectorSaucesDivision).isDisplayed();
    }
    public boolean isFillingsVisible(){
        return driver.findElement(selectorFillingsDivision).isDisplayed();
    }

    public boolean isBunsClickable(){
        return isTabClickable(selectorBunsButton);
    }
    public boolean isSaucesClickable(){
        return isTabClickable(selectorSaucesButton);
    }
    public boolean isFillingsClickable(){
        return isTabClickable(selectorFillingsButton);
    }

}
