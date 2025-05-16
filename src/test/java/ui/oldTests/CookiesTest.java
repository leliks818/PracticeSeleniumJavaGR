package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import java.util.Set;


import static constants.Constants.COOKIES_URL;
import static org.junit.jupiter.api.Assertions.*;

public class CookiesTest extends BaseTest {




    @Test
    public void testGetCookie() {
        getDriver().get(COOKIES_URL);
        Set<Cookie> cookies = getDriver().manage().getCookies();
        System.out.println("Исходная кука: " + cookies);
        assertNotNull(cookies, "Куки не найдены");
    }

    @Test
    public void testUpdateCookie() {
        getDriver().get(COOKIES_URL);
        Cookie newCookie = new Cookie("Yuliya", "01/04/2026");
        getDriver().manage().addCookie(newCookie);

        Cookie modifiedCookie = driver.manage().getCookieNamed("Yuliya");
        System.out.println("Обновленная кука: " + modifiedCookie);
        assertNotNull(modifiedCookie, "Кука 'Yuliya' не добавлена");
    }

    @Test
    public void testDeleteAllCookies() {
        getDriver().get(COOKIES_URL);
        getDriver().manage().deleteAllCookies();
        getDriver().findElement(By.id("refresh-cookies")).click();
        getWait5();

        Set<Cookie> cookies = getDriver().manage().getCookies();
        System.out.println("Куки после удаления всех: " + cookies);
        assertTrue(cookies.isEmpty(), "Куки не были удалены");
    }
}
