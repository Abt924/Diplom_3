import org.junit.Test;
import stellar.model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseUiTest {

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
