package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

import static constants.Constants.BASE_URL;
import static constants.Constants.NAVIGATION1_URL;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaginationTest extends BaseTest {
     String currentUrl = BASE_URL + "navigation1";

    @Test
    public void testPagination()  {
        getDriver().get(NAVIGATION1_URL);
        List<String> expectedResult = List.of(
                "Lorem ipsum dolor sit amet",
                "Ut enim ad minim veniam",
                "Excepteur sint occaecat cupidatat non proident"
        );

        for (int i = 1; i <= 3; i++) {
            getDriver().findElement(By.xpath("//a[text()='" + i + "']")).click();
            String pageText = getDriver().findElement(By.tagName("p")).getText();
            assertTrue(pageText.contains(expectedResult.get(i - 1)),
                    "Текст на странице " + i + " не совпадает!");
        }
    }

    @Test
    public void clickPreviousButton() throws InterruptedException {
        //Actions actions = new Actions(driver);
        getDriver().get(currentUrl);
        getDriver().findElement(By.xpath("//a[text()='2']")).click();
        Thread.sleep(1000);
        String currentUrl = getDriver().getCurrentUrl();
        WebElement buttonPrevious = getDriver().findElement(By.xpath("//li[not(contains(@class, 'disabled'))]//a[text()='Previous']"));
        //actions.moveToElement(buttonPrevious).click().perform();
        moveToElementAndClickAction(getDriver(),buttonPrevious);
        Thread.sleep(2000);
        //getWait5();
        String newUrl = getDriver().getCurrentUrl();
        assertNotEquals(currentUrl, newUrl, "URL не изменился после клика по 'Next'!");

    }

    @Test
    public void clickNextButton() throws InterruptedException {
        Actions actions = new Actions(driver);

        String currentUrl = getDriver().getCurrentUrl();
        Thread.sleep(2000);
        WebElement nextButton = getDriver().findElement(By.xpath("//li[not(contains(@class, 'disabled'))]//a[text()='Next']"));
        Thread.sleep(2000);
        actions.moveToElement(nextButton).click().perform();
        //moveToElementAndClickAction(getDriver(),nextButton);
        Thread.sleep(2000);
        String newUrl = getDriver().getCurrentUrl();
        assertNotEquals(currentUrl, newUrl, "URL не изменился после клика по 'Next'!");
    }
}