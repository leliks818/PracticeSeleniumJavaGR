package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static constants.Constants.LOGIN_FORM_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginFormTest extends BaseTest {

    @Test
    public void loginFormTest() {
       getDriver().get(LOGIN_FORM_URL);
       getDriver().findElement(By.id("username")).sendKeys("Yuliya123");
        getDriver().findElement(By.id("password")).sendKeys("pas123456");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        assertTrue(getDriver().findElement(By.xpath("//div[@id='invalid']")).isDisplayed());

    }




}
