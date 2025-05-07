package ui.selenide;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import selenidePages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;
import configs.TestPropertiesConfig;

public class LoginTest {

    private final LoginPage loginPage = new LoginPage();
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @Test
    public void successfulLoginTest() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.enterUsername(config.getUsername());
        loginPage.enterPassword(config.getPassword());
        loginPage.clickLogin();

        Thread.sleep(1000);
        assertTrue(loginPage.isLoginSuccessful(), "Вход не удался, хотя ожидался успешный вход");
    }
}