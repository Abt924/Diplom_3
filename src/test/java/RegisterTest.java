import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellar.model.UserGenerator;
import stellar.model.pages.LoginPage;
import stellar.model.pages.RegisterPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegisterTest extends BaseUiTest {

    @Test
    @DisplayName("successful Registration")
    @Description("successful Registration should follow to LoginPage")
    public void successfulRegistration() {
        user = UserGenerator.createRandom();
        LoginPage loginPage = new RegisterPage(driver, jse)
                .open()
                .registerAs(user)
                .waitLoginPage();

        assertTrue("transition to the LoginPage expected", loginPage.isLoginPage());
        assertEquals("LoginPage url expected", loginPage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Registration without Password Forbidden")
    @Description("Should stay on register page, error mess should be displayed")
    public void withoutPasswordRegistrationForbidden() {
        user = UserGenerator.createWithoutPassword();

        RegisterPage registerPage = new RegisterPage(driver, jse)
                .open()
                .registerAsExpectingFailure(user)
                .waitRegisterPage();


        assertTrue("transition to the RegisterPage expected", registerPage.isRegisterPage());
        assertEquals("RegisterPage url expected", registerPage.getUrl(), driver.getCurrentUrl());
        assertTrue("error message expected, course pwd is required", registerPage.passwordInput.isError());
        assertTrue("Error mess should be displayed", registerPage.passwordInput.isErrorMessageDisplayed());
        assertEquals("RegisterPage url expected",
                "Пароль быть обязан",
                registerPage.passwordInput.getErrorMessageText());
    }

    @Test
    @DisplayName("Registration with short Password Forbidden")
    @Description("If password is less 6 symbols Should stay on register page, error mess should be displayed")
    public void shortPasswordRegistrationForbidden() {
        user = UserGenerator.createShortPassword();

        RegisterPage registerPage = new RegisterPage(driver, jse)
                .open()
                .registerAsExpectingFailure(user);


        assertTrue("transition to the RegisterPage expected", registerPage.isRegisterPage());
        assertEquals("RegisterPage url expected", registerPage.getUrl(), driver.getCurrentUrl());

        assertTrue("Short Password error expected", registerPage.passwordInput.isError());
        assertTrue("Short Password error mess should displayed", registerPage.passwordInput.isErrorMessageDisplayed());
        assertEquals("Error message is not as expected",
                "Некорректный пароль",
                registerPage.passwordInput.getErrorMessageText());
    }


}
