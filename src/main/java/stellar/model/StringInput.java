package stellar.model;

import org.openqa.selenium.*;

import java.util.List;

public class StringInput extends DriveredPage {
    // Селекторы элементов ввода
    private final By selectorInput;
    // Селектор для элемента status относительно input
    private final By selectorStatus = By.xpath("parent::div");
    // Селектор для элемента filling относительно input
//    private final By selectorFilling = By.xpath("/parent::div/label");
    private final By selectorFilling = By.xpath("label");

    // элементы поля ввода
    protected WebElement input;
    protected WebElement status;
    protected WebElement filling;

    // признаки в атрибуте @class для определения статуса поля ввода
    private final String filledClass = "input__placeholder-filled";
    private final String focusedClass = "input__placeholder-focused";
    private final String activeClass = "input_status_active";

    // счетчики элементов
    private int countInput;

    public StringInput(WebDriver driver, JavascriptExecutor jse, By selectorInput) {
        super(driver, jse);
        this.selectorInput = selectorInput;
        init();
    }


    // поиск элементов на странице, подсчет, инициализация первым найденным.
    private void init() {

        List<WebElement> inputs = driver.findElements(selectorInput);
        countInput = inputs.size();
//        System.out.println(selectorInput.toString() + " found "  + countInput);
        if (countInput == 1) input = inputs.get(0);
        else input = null;
//        System.out.println(input.toString() + " pass found "  );
//        input.sendKeys("9876543221");
        if (input != null) {
            status = input.findElement(selectorStatus);
            filling = status.findElement(selectorFilling);
        }
    }

    // наличие на странице и единственность
    public boolean isInputExist() {
        return countInput > 0;
    }

    public boolean isInputSingleton() {
        return countInput == 1;
    }


    // действия
    public void clear() {
        input.clear();
    }

    public void click() {
        input.click();
    }

    public void scrollTo() {
        jse.executeScript("arguments[0].scrollIntoView()", input);
    }

    public void sendKeys(String s) {
        input.sendKeys(s);
    }

    public void submit() {
        input.submit();
    }

    public void pushTab() {
        input.sendKeys(Keys.TAB);
    }

    // получение атрибутов
    public String getPlaceholder() {
        return input.getAttribute("placeholder");
    }

    public String getValue() {
        return input.getAttribute("value");
    }

    public String getClasses() {
        return input.getAttribute("class");
    }


    //статусы поля ввода
    public boolean isFilled() {
        return input.getAttribute("class").contains(filledClass);
    }

    public boolean isActive() {
        return input.getAttribute("class").contains(activeClass);
    }

    public boolean isFocused() {
        return input.getAttribute("class").contains(focusedClass);
    }

    public boolean isInputDisplayed() {
        return input.isDisplayed();
    }

}
