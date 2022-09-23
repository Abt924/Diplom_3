package stellar.model.inputs;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NameInput extends StringInput{

    // селектор поля ввода Name
    static final By selectorName = By.xpath(".//label[text()='Имя']/parent::div/input");

    public NameInput(WebDriver driver, JavascriptExecutor jse) {
        super(driver, jse, selectorName);
    }
}
