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
    // Создаём конфигурацию с настройками из файла
    static TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    // Основной метод для создания драйвера
    public static WebDriver createWebDriver(String browser) {
        WebDriver driver = switch (browser.toLowerCase()) {
            case CHROME -> getChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();

            // Добавление новых браузеров по мере необходимости
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
        driver.manage().window().maximize();
        return driver;
    }

    // Метод для создания драйвера Chrome
    private static WebDriver getChromeDriver() {
        WebDriver driver;
        // Получаем remoteUrl из конфигурации
        String remoteUrl = configProperties.remoteUrl();  // Изменено

        // Создаём настройки для Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // всегда headless
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));

        // Если указан remoteUrl, используем RemoteWebDriver, иначе обычный ChromeDriver
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), options); //  Оставлено без изменений, но добавлена строка выше
            } catch (MalformedURLException e) {
                throw new RuntimeException("Malformed URL for Selenium Remote WebDriver", e);
            }
        } else {
            driver = new ChromeDriver(options); //  Изменено: передаём options для headless
        }

        return driver;
    }
}
