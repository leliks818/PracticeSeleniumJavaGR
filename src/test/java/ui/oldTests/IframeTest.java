package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.jupiter.api.Assertions;

import static constants.Constants.BASE_URL;
import static constants.Constants.IFRAMES_URL;

public class IframeTest extends BaseTest {
    String currentUrl = BASE_URL + "iframes";


    @Test
    public void testIframe() {

        getDriver().get(IFRAMES_URL);

        getWait5().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

        WebElement paragraph = getWait5().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(normalize-space(), 'Magnis feugiat natoque')]")
        ));

        //((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", paragraph);
        scrollAndClickWithJS(getDriver(), paragraph);
        Assertions.assertTrue(paragraph.isDisplayed(), "Элемент не найден в iframe");

        getDriver().switchTo().defaultContent();
    }


        }

