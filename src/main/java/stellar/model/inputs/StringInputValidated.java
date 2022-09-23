package stellar.model.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stellar.model.inputs.StringInput;

import java.util.List;

public class StringInputValidated extends StringInput {

    private final By selectorErrorMessage;
    protected WebElement errorMessage;
    private int countErrorMessage;


    protected final String errorClass = "input_status_error";



    public StringInputValidated(WebDriver driver, JavascriptExecutor jse, By selectorInput, By selectorErrorMessage) {
        super(driver, jse, selectorInput);
        this.selectorErrorMessage = selectorErrorMessage;
        init();
    }

    private void init() {
        List<WebElement> errorMessages = driver.findElements(selectorErrorMessage);
        countErrorMessage = errorMessages.size();
        if (countErrorMessage == 1) errorMessage = errorMessages.get(0);
        else errorMessage = null;
    }

    public boolean isErrorMessageExist() {
        return countErrorMessage > 0;
    }
    public boolean isErrorMessageSingleton() {
        return countErrorMessage == 1;
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public boolean isError() {
        return status.getAttribute("class").contains(errorClass);
    }

    public boolean isErrorMessageDisplayed() {
        errorMessage = driver.findElement(selectorErrorMessage);
        return errorMessage.isDisplayed();
    }

    // результат валидации
    public boolean isValidate() {
        return !isError();
    }

}
