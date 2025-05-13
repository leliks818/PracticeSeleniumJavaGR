package baseTests;

import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import static patterns.WebDriverFactory.initDriver;

public abstract class BaseTest {

    protected WebDriverWait wait5;
    protected WebDriverWait wait10;
    protected WebDriver driver;
    protected TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @BeforeEach
    void setup() {
        // Вызываем фабрику, которая теперь уже сама настраивает window и таймауты
        driver = initDriver();
        //driver = WebDriverFactory.createWebDriver(configProperties.browser());
        driver.get(configProperties.baseUrl());

        wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



//
//public abstract class BaseTest {
//
//    protected WebDriverWait wait5;
//    protected WebDriverWait wait10;
//    protected WebDriver driver;
//    protected TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
//
//    @BeforeEach
//    void setup() {
//        driver = WebDriverFactory.createWebDriver(configProperties.browser());
//        driver.manage().window().maximize();
//        driver.get(configProperties.baseUrl());  // Открытие базового URL
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));  // Установка времени ожидания
//
//        wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    @AfterEach
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait5() {
        return wait5;
    }

    protected WebDriverWait getWait10() {
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

    public static void moveAndClickWithJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('mouseenter'));", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('click'));", element);
    }

    public void moveToElementAndClickAction(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void waitForElementToBeVisible(By locator, WebDriver driver, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator, WebDriver driver, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
