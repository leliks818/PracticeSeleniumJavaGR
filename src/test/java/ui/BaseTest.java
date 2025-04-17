package ui;

import configs.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseTest {

    protected WebDriverWait wait5;
    protected WebDriverWait wait10;
    protected TestConfig config;
    protected WebDriver driver;


    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        config = new TestConfig();
        wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl());

    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
        return wait5;
    }

    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait10;
    }

    public static void scrollAndClickWithJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickWithActions(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.click(element).perform();
    }
    public void simpleClick(By locator) {
        getDriver().findElement(locator).click();
    }
    public static void moveAndClickWithJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('mouseenter'));", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('click'));", element);
    }
    public void moveToElementAndClickAction(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    public void openPage(String url) {
        getDriver().get(url);
    }


}
