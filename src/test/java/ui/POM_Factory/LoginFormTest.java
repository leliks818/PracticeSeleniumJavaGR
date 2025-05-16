package ui.POM_Factory;

import extensions.AllureExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pageObjectFactory.LoginPage;
import baseTests.BaseTest;
import static constants.Constants.*;

import static org.junit.jupiter.api.Assertions.*;

@Tag("smoke")
@ExtendWith(AllureExtension.class)
public class LoginFormTest extends BaseTest {

    @Test
    public void testHeaderComponents() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open(LOGIN_FORM_URL);

        assertTrue(loginPage.getHeader().isLogoVisible());
        assertTrue(loginPage.getHeader().isTitleHeaderVisible());
        assertTrue(loginPage.getHeader().isTitleHeaderTextVisible());
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open(LOGIN_FORM_URL);
        loginPage.enterUsername(configProperties.getUsername());
        loginPage.enterPassword(configProperties.getPassword());
        loginPage.clickLogin();

        assertTrue(loginPage.isLoginSuccessful(), "Сообщение об успешном входе не появилось");

    }
}