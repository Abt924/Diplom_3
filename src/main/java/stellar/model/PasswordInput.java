package stellar.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PasswordInput extends StringInputValidated {

        // селектор поля ввода Password
        static final By selectorPassword = By.xpath(".//input[@type='password']");

        // селектор сообщения об ошибке валидации
        static final By selectorErrorMessage = By.xpath(".//p[contains(@class, 'input__error')]");

        public PasswordInput(WebDriver driver, JavascriptExecutor jse) {
                super(driver, jse, selectorPassword, selectorErrorMessage);
        }
}
