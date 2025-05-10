package pageObjectFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='success']")
    private WebElement successMessage;

    public LoginPage(WebDriver driver) {
        super(driver);

    }
    @Step("Открываем страницу по URL: {url}")
    public void open(String url) {
        driver.get(url);
    }

    @Step("Вводим имя пользователя: {username}")
    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    @Step("Вводим пароль: {password}")
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Нажимаем кнопку 'Login'")
    public void clickLogin() {
        loginButton.click();
    }

    @Step("Ожидаем появления сообщения об успешном входе")
    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.isDisplayed();
    }
}
