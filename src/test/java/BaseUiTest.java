import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import stellar.model.api.UserClient;
import stellar.model.pojo.Authorized;
import stellar.model.pojo.User;
import stellar.model.pojo.UserCreated;

public class BaseUiTest {
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected UserClient userClient;
    protected User user;
    protected UserCreated userCreated;
    protected Authorized authorized;

    @Before
    public void setUp() {
        driver = DriverProvider.yandexDriver();
        jse = (JavascriptExecutor) driver;
        userClient = new UserClient();
    }

    @After
    public void tearDown() {
        driver.quit();

        if (user != null) {
            authorized = userClient.loginUser(user);
            if (authorized.isSuccess()) {
                userClient.deleteAuthorizedUser(authorized);
            }
        }
    }
}