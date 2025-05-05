package ui.POM_Factory;

import configs.TestPropertiesConfig;
import pageObjectFactory.LoginPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import baseTests.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

import static constants.Constants.*;

public class LoginFormTest extends BaseTest {

    private LoginPage loginPage;

    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @BeforeEach
    public void setUpTest() {
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void testLogin() throws InterruptedException {
        loginPage.open(LOGIN_FORM_URL);
        loginPage.enterUsername(config.getUsername());
        loginPage.enterPassword(config.getPassword());
        loginPage.clickLogin();
        Thread.sleep(2000);
        assertTrue(loginPage.isLoginSuccessful(), "Сообщение об успешном входе не появилось");
    }
}
