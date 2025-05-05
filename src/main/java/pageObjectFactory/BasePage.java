package pageObjectFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
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

