package patterns;


import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.EDGE;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class WebDriverFactory {
    static TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());


public static WebDriver createWebDriver(String browser) {
    WebDriver driver = switch (browser.toLowerCase()) {
        case CHROME -> getChromeDriver();
        case FIREFOX -> new FirefoxDriver();
        case EDGE -> new EdgeDriver();

        // Добавить другие браузеры по необходимости
        default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
    };
    driver.manage().window().maximize();
    return driver;
}
    private static WebDriver getChromeDriver() {
        WebDriver driver;
        String remoteUrl = configProperties.remoteUrl();

        if (remoteUrl != null && !remoteUrl.isBlank()) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));

            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Malformed URL for Selenium Remote WebDriver", e);
            }
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }
}