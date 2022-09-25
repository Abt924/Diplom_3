import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellar.model.UserGenerator;
import stellar.model.pages.LoginPage;
import stellar.model.pages.ProfilePage;
import stellar.model.pages.StellarHomePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountProfileTest extends BaseUiTest {
    private StellarHomePage homePage;
    private ProfilePage profilePage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        super.setUp();
        user = UserGenerator.createRandom();
        userCreated = userClient.createUser(user);

        homePage = new LoginPage(driver, jse)
                .open()
                .waitLoginPage()
                .fillCreds(user)
                .pushLoginButton()
                .waitForAuthorizedHomePage();
    }

    @Test
    @DisplayName("following to AccountProfile")
    public void followingToAccountProfile() {
        profilePage = homePage
                .pushAccountProfile()
                .waitProfilePage();

        assertTrue("transition to the AccountProfile page expected", profilePage.isProfilePage());
        assertEquals("AccountProfile page url expected", profilePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("successful Logout")
    @Description("transition to the LoginPage expected")
    public void successfulLogout() {
        loginPage = homePage
                .pushAccountProfile()
                .waitProfilePage()
                .pushLogout()
                .waitLoginPage();

        assertTrue("transition to the LoginPage expected", loginPage.isLoginPage());
        assertEquals("LoginPage url expected", loginPage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("follow by Logo")
    @Description("transition to HomePage expected")
    public void followByLogo() {
        homePage = homePage
                .pushAccountProfile()
                .waitProfilePage()
                .clickLogo()
                .waitForAuthorizedHomePage();

        assertTrue("transition to the LoginPage expected", homePage.isAuthorizedPage());
        assertEquals("LoginPage url expected", homePage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("follow by click Constructor")
    @Description("transition to HomePage expected")
    public void followToConstructor() {
        homePage = homePage
                .pushAccountProfile()
                .waitProfilePage()
                .clickConstructor()
                .waitForAuthorizedHomePage();

        assertTrue("transition to the LoginPage expected", homePage.isAuthorizedPage());
        assertEquals("LoginPage url expected", homePage.getUrl(), driver.getCurrentUrl());
    }
}
