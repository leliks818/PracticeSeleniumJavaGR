package ui.POM;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pageObject.LoginPage;
import baseTests.BaseTest;


import static constants.Constants.LOGIN_FORM_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class LoginFormTestPOM extends BaseTest {

    @Test
    public void loginFormTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open(LOGIN_FORM_URL);
        loginPage.enterUsername(configProperties.getUsername());
        loginPage.enterPassword(configProperties.getPassword());
        loginPage.clickLogin();
        assertTrue(loginPage.waitForSuccessMessage(), "Нет текста!");

    }
    }