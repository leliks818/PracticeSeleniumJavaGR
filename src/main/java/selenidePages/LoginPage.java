package selenidePages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


public class LoginPage extends BasePage {

    private final SelenideElement usernameInput = $("#username");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("button[type='submit']");
    private final SelenideElement successMessage = $("#success");


    private final String loginUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";

    @Step("Открываем страницу логина")
    public void openLoginPage() {
        open(loginUrl);
    }

    @Step("Вводим имя пользователя: {username}")
    public void enterUsername(String username) {
        usernameInput.setValue(username);
    }

    @Step("Вводим пароль: {password}")
    public void enterPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Нажимаем кнопку 'Login'")
    public void clickLogin() {
        loginButton.click();
    }

    @Step("Ожидаем появления сообщения об успешном входе")
    public boolean isLoginSuccessful() {
        return successMessage.shouldBe(visible).isDisplayed();
    }
}