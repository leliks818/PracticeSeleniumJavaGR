package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static constants.Constants.BASE_URL;
import static constants.Constants.SHADOW_DOM_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShadowDomTest extends BaseTest {

    String currentUrl = BASE_URL + "shadow-dom";

    @Test
    public void testShadowDom() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        getDriver().get(SHADOW_DOM_URL);

        WebElement content = driver.findElement(By.id("content"));
        SearchContext shadowRoot = content.getShadowRoot();
        WebElement shadowText = shadowRoot.findElement(By.cssSelector("p"));
        assertEquals("Hello Shadow DOM", shadowText.getText(), "Текст не совпадает");

        driver.quit();
    }
}