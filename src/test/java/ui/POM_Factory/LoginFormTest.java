package ui.POM_Factory;

import org.junit.jupiter.api.Test;
import pageObjectFactory.LoginPage;
import baseTests.BaseTest;
import static constants.Constants.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginFormTest extends BaseTest {

//    @Test
//    public void testHeaderComponents() {
//        LoginPage loginPage = new LoginPage(getDriver());
//        HeaderComponent header = loginPage.getHeader();
//        assertTrue(header.isLogoVisible());
//        assertTrue(header.isTitleHeaderVisible());
//        assertTrue(header.isTitleHeaderTextVisible());
//    }
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