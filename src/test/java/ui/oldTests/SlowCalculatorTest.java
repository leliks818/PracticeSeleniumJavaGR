package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SlowCalculatorTest extends BaseTest {


    @Test
    public void testSlowCalculator() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = driver.findElement(By.id("calculator"));
        input.findElement(By.xpath("//span[text() = '7']")).click();
        input.findElement(By.xpath("//span[text() = '+']")).click();
        input.findElement(By.xpath("//span[text() = '7']")).click();
        input.findElement(By.xpath("//span[text() = '=']")).click();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("screen")));
        wait.until(ExpectedConditions.textToBePresentInElement(result, "14"));
        assertEquals("14", result.getText(), "Результат неверный");

        driver.quit();
    }
}
