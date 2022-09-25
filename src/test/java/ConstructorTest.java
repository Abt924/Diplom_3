import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellar.model.pages.Constructor;
import stellar.model.pages.StellarHomePage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseUiTest {
    private Constructor constructor;

    @Before
    public void setUp() {
        super.setUp();
        new StellarHomePage(driver, jse)
                .open();
        constructor = new Constructor(driver, jse);
    }

    @Test
    @DisplayName("check Buns selected by default")
    public void checkBunsSelectedByDefault() {
        assertTrue("Buns should be selected by default", constructor.isBunsTabSelected());
        assertFalse("Sauces should Not be selected by default", constructor.isSaucesTabSelected());
        assertFalse("Fillings should Not be selected by default", constructor.isFillingsTabSelected());
    }

    @Test
    @DisplayName("check Fillings Select")
    public void checkFillingSelect() {
        constructor.clickFillings();
        assertFalse("Buns should be selected by default", constructor.isBunsTabSelected());
        assertFalse("Sauces should Not be selected by default", constructor.isSaucesTabSelected());
        assertTrue("Fillings should Not be selected by default", constructor.isFillingsTabSelected());
    }

    @Test
    @DisplayName("check Sauces Select")
    public void checkSaucesSelect() {
        constructor.clickSauces();
        assertFalse("Buns should be selected by default", constructor.isBunsTabSelected());
        assertTrue("Sauces should Not be selected by default", constructor.isSaucesTabSelected());
        assertFalse("Fillings should Not be selected by default", constructor.isFillingsTabSelected());
    }

    @Test
    @DisplayName("check Bun Select")
    public void checkBunSelect() {
        constructor.clickFillings();
        constructor.clickBuns();
        assertTrue("Buns should be selected by default", constructor.isBunsTabSelected());
        assertFalse("Sauces should Not be selected by default", constructor.isSaucesTabSelected());
        assertFalse("Fillings should Not be selected by default", constructor.isFillingsTabSelected());
    }
}
