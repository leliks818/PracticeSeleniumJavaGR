package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static constants.Constants.BASE_URL;
import static constants.Constants.INFINITE_SCROLL_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InfiniteScrollTest extends BaseTest {
    String currentUrl = BASE_URL + "infinite-scroll";

    @Test
    public void testScrollToParagraph() throws InterruptedException {
        getDriver().get(INFINITE_SCROLL_URL);

        getWait5().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[contains(text(), 'Lorem ipsum')]")));
        WebElement paragraph = getDriver().findElement(By.xpath("(//b[contains(text(), 'Lorem ipsum')])[last()]"));
        scrollAndClickWithJS(getDriver(), paragraph);
        getWait5().until(ExpectedConditions.visibilityOf(paragraph));

        assertTrue(paragraph.isDisplayed(), "Элемент не найден.");
    }
}
