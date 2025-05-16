package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static constants.Constants.DIALOG_BOXES_URL;
import static org.junit.jupiter.api.Assertions.*;

public class DialogBoxesTest extends BaseTest {

    @Test
    public void testAlert() {
        getDriver().get(DIALOG_BOXES_URL);
        driver.findElement(By.id("my-alert")).click();
        Alert alert = getWait5().until(ExpectedConditions.alertIsPresent());
        assertEquals("Hello world!", alert.getText());
        alert.accept();
    }

    @Test
    public void testConfirm() {
        getDriver().get(DIALOG_BOXES_URL);
        driver.findElement(By.id("my-confirm")).click();
        Alert confirm = getWait5().until(ExpectedConditions.alertIsPresent());
        confirm.dismiss();

        WebElement confirmText = getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm-text")));
        assertEquals("You chose: false", confirmText.getText().trim(), "Текст не совпадает или не появился!");
    }

    @Test
    public void testPrompt() {
        getDriver().get(DIALOG_BOXES_URL);
        driver.findElement(By.id("my-prompt")).click();
        Alert prompt = getWait5().until(ExpectedConditions.alertIsPresent());
        prompt.sendKeys("YULIYA");
        prompt.accept();

        WebElement confirmText = getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("prompt-text")));
        assertEquals("You typed: YULIYA", confirmText.getText().trim(), "Текст не появился!");
    }

    @Test
    public void testModalWindow() {
        getDriver().get(DIALOG_BOXES_URL);
        driver.findElement(By.id("my-modal")).click();
        WebElement modal = getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        WebElement confirmText = getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("modal-text")));
        assertEquals("You chose: Save changes", confirmText.getText().trim(), "Текст не появился!");
    }
}
