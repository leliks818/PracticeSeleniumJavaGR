package baseTests;

import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static constants.Constants.BASE_URL;


public class BaseTest {

    protected WebDriverWait wait5;
    protected WebDriverWait wait10;
    protected WebDriver driver;
    protected TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    public static  String TITLE_HEADER = "Hands-On Selenium WebDriver with Java";
    @BeforeEach
    void setup() {
        driver = createWebDriver(configProperties.browser());
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait5() {
        return wait5;
    }

    protected WebDriverWait getWait10() {
        return wait10;
    }

    // Метод для создания WebDriver в зависимости от браузера
    protected WebDriver createWebDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--headless");  // Пример: запуск в headless режиме
                chromeOptions.addArguments("--start-maximized");
                return new ChromeDriver(chromeOptions);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");  // Пример: запуск в headless режиме
                return new FirefoxDriver(firefoxOptions);

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
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
