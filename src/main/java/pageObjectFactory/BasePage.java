package pageObjectFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected final Actions actions;
    protected final WebDriverWait wait;

    // Конструктор, принимающий уже инициализированный драйвер
        public BasePage(WebDriver driver) {
        this.driver = driver;  // Инициализация драйвера
        this.actions = new Actions(driver);  // Инициализация actions для взаимодействия
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Step("Get current url")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Get title")
    public String getTitle() {
        return driver.getTitle();
    }
        }
