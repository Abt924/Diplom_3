package stellar.model;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EmailInput extends StringInput{

    // селектор поля ввода Email
    static final By selectorEmail = By.xpath(".//label[text()='Email']/parent::div/input");

    public EmailInput(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse, selectorEmail);
    }
}

