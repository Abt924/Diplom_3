package stellar.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class DriveredPage {

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

}

