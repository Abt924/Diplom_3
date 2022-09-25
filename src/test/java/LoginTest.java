import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellar.model.UserGenerator;
import stellar.model.pages.ForgotPasswordPage;
import stellar.model.pages.RegisterPage;
import stellar.model.pages.ResetPasswordPage;
import stellar.model.pages.StellarHomePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseUiTest {

    @Before
    public void setUp() {
        super.setUp();
        user = UserGenerator.createRandom();
    }

    @Test
    @DisplayName("login From Register Page after registration")
    @Description("transfer to Authorized Home page expected")
    public void loginFromRegisterPage() {
        StellarHomePage stellarHomePage = new RegisterPage(driver, jse)
                .open()
                .registerAs(user)
                .waitLoginPage()
                .loginAs(user)
                .waitForAuthorizedHomePage();

        assertEquals("HomePage url expected", stellarHomePage.getUrl(), driver.getCurrentUrl());
        assertTrue("Place an Order Button should enable on Authorized Home page", stellarHomePage.isAuthorizedPage());
    }

    @Test
    @DisplayName("login From Register Page Via Link")
    @Description("transfer to Authorized Home page expected")
    public void loginFromRegisterPageViaLink() {
        userCreated = userClient.createUser(user);

        StellarHomePage stellarHomePage = new RegisterPage(driver, jse)
                .open()
                .followToLoginPage()
                .waitLoginPage()
                .loginAs(user)
                .waitForAuthorizedHomePage();

        assertEquals("HomePage url expected", stellarHomePage.getUrl(), driver.getCurrentUrl());
        assertTrue("Place an Order Button should enable on Authorized Home page", stellarHomePage.isAuthorizedPage());
    }

    @Test
    @DisplayName("login via LoginToAccount button on HomePage")
    @Description("transfer to Authorized Home page expected")
    public void loginViaAccountLoginButton() {
        userCreated = userClient.createUser(user);

        StellarHomePage stellarHomePage = new StellarHomePage(driver, jse)
                .open()
                .pushAccountLogin()
                .waitLoginPage()
                .loginAs(user)
                .waitForAuthorizedHomePage();

        assertTrue("Place an Order Button should enable on Authorized Home page", stellarHomePage.isAuthorizedPage());
        assertEquals("HomePage url expected", stellarHomePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("login via AccountProfile button")
    @Description("transfer to Authorized Home page expected")
    public void loginViaAccountProfileButton() {
        userCreated = userClient.createUser(user);

        StellarHomePage stellarHomePage = new StellarHomePage(driver, jse)
                .open()
                .pushUnauthorizedAccountProfile()
                .waitLoginPage()
                .loginAs(user)
                .waitForAuthorizedHomePage();

        assertTrue("Place an Order Button should enable on Authorized Home page", stellarHomePage.isAuthorizedPage());
        assertEquals("HomePage url expected", stellarHomePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("login from ResetPassword page via link Login")
    @Description("transfer to Authorized Home page expected")
    public void loginFromResetPasswordPageViaLink() {
        userCreated = userClient.createUser(user);

        StellarHomePage stellarHomePage = new ResetPasswordPage(driver, jse)
                .open()
                .followToLoginPage()
                .waitLoginPage()
                .loginAs(user)
                .waitForAuthorizedHomePage();

        assertTrue("Place an Order Button should enable on Authorized Home page", stellarHomePage.isAuthorizedPage());
        assertEquals("HomePage url expected", stellarHomePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("login from ForgotPassword page via link Login")
    @Description("transfer to Authorized Home page expected")
    public void loginFromForgotPasswordPageViaLink() {
        userCreated = userClient.createUser(user);

        StellarHomePage stellarHomePage = new ForgotPasswordPage(driver, jse)
                .open()
                .followToLoginPage()
                .waitLoginPage()
                .loginAs(user)
                .waitForAuthorizedHomePage();

        assertTrue("Place an Order Button should enable on Authorized Home page", stellarHomePage.isAuthorizedPage());
        assertEquals("HomePage url expected", stellarHomePage.getUrl(), driver.getCurrentUrl());
    }
}
