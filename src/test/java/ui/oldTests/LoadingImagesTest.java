package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static constants.Constants.BASE_URL;
import static constants.Constants.LOADING_IMAGES_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadingImagesTest extends BaseTest {

    String currentUrl = BASE_URL + "loading-images";

    @Test
    public void testImageLoading() {
        getDriver().get(LOADING_IMAGES_URL);

        //getWait10();
        WebElement image = getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img")));

        assertTrue(image.isDisplayed(), "Изображения не загрузилось");

    }
}