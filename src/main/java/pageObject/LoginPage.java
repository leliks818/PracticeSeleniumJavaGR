package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
    private final WebDriver driver;

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By successMessage = By.xpath("//div[@id='success']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Открываем страницу по URL: {url}")
    public void open(String url) {
        driver.get(url);
    }

    @Step("Вводим имя пользователя: {username}")
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    @Step("Вводим пароль: {password}")
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажимаем кнопку 'Login'")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Ожидаем появление сообщения об успешном входе")
    public boolean waitForSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.textToBe(successMessage, "Login successful"));
    }
}