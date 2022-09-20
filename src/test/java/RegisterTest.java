import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import stellar.model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class RegisterTest extends BaseUiTest {

    public RegisterTest(WebDriver driver, String browser) {
        super(driver, browser);
    }


    @Test
    public void successfulRegistration(){
        User user = UserGenerator.createRandom();
        LoginPage loginPage = new RegisterPage(driver,jse)
                .open()
                .fillName(user.getName())
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .pushRegisterButton()
                .waitLoginPage();

        assertTrue("transition to the LoginPage expected", loginPage.isLoginPage());
        assertEquals("LoginPage url expected", loginPage.getUrl(), driver.getCurrentUrl());
    }

}
