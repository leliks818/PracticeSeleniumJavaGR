package patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.EDGE;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class WebDriverFactory {


    /// ЗАКОМИТЕЛА Т.К внутри класса WebDriverFactory ты больше не использую
    /// configProperties, а, перешла на System.getenv("SELENIUM_REMOTE_URL").
    // static TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    // Основной метод для создания драйвера с настройками
    public static WebDriver createWebDriver(String browser) {
        WebDriver driver = switch (browser.toLowerCase()) {
            //case CHROME -> getChromeDriver();
            case CHROME -> initDriver();
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };

        //  добавили
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }

    // Метод для Chrome, поддерживает локальный и remote режим

    public static WebDriver initDriver() {
        WebDriver driver;
        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        //  логирование браузера
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);

        if (remoteUrl != null && !remoteUrl.isBlank()) {
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), options);
                System.out.println("🔧 Remote WebDriver запущен по адресу: " + remoteUrl);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Malformed URL for Selenium Remote WebDriver", e);
            }
        } else {
            driver = new ChromeDriver(options);
            System.out.println("🖥️ Локальный ChromeDriver запущен");
        }

        driver.manage().window().maximize();
        return driver;
    }
}