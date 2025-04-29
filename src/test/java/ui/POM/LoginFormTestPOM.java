package ui.POM;


import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pageObject.LoginPage;
import baseTests.BaseTest;


import static constants.Constants.LOGIN_FORM_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginFormTestPOM extends BaseTest {


    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @Test
    public void loginFormTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.open(LOGIN_FORM_URL);
        loginPage.enterUsername(config.getUsername());
        loginPage.enterPassword(config.getPassword());
        loginPage.clickLogin();
        getWait10();
        assertTrue(loginPage.waitForSuccessMessage(), "Нет текста!");

    }

}