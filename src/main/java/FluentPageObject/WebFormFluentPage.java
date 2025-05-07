package FluentPageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjectFactory.BasePage;

import java.io.File;

public class WebFormFluentPage extends BasePage {

    public WebFormFluentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "my-text") private WebElement textField;
    @FindBy(name = "my-password") private WebElement passwordField;
    @FindBy(xpath = "//textarea[@name='my-textarea']") private WebElement textareaField;
    @FindBy(xpath = "//a[contains(text(), 'Return to index')]") private WebElement returnLink;
    @FindBy(name = "my-select") private WebElement selectDropdown;
    @FindBy(name = "my-file") private WebElement fileInput;
    @FindBy(name = "my-colors") private WebElement colorInput;
    @FindBy(css = "input[name='my-date']") private WebElement dateInput;
    @FindBy(xpath = "//button[@type='submit']") private WebElement submitButton;
    @FindBy(xpath = "//h1[@class='display-6']") private WebElement submitTitle;
    @FindBy(xpath = "//p[@class='lead']") private WebElement receivedMessage;


    @Step("Вводим текст в поле: {text}")
    public WebFormFluentPage enterText(String text) {
        textField.sendKeys(text);
        return this;
    }

    @Step("Вводим пароль: {password}")
    public WebFormFluentPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Вводим текст в textarea: {text}")
    public WebFormFluentPage enterTextarea(String text) {
        textareaField.sendKeys(text);  // Исправлено: textarea -> textareaField
        return this;
    }

    @Step("Выбираем значение из select: {option}")
    public WebFormFluentPage selectOption(String option) {
        selectDropdown.click();  // Исправлено: select -> selectDropdown
        return this;
    }

    @Step("Загружаем файл: {filePath}")
    public WebFormFluentPage uploadFile(String filePath) {
        String absolutePath = new File(filePath).getAbsolutePath();
        fileInput.sendKeys(absolutePath);
        return this;
    }

    @Step("Выбираем цвет: {color}")
    public WebFormFluentPage pickColor(String color) {
        colorInput.sendKeys(color);
        return this;
    }

    @Step("Выбираем дату: {date}")
    public WebFormFluentPage enterDate(String date) {
        dateInput.sendKeys(date);
        return this;
    }

    @Step("Нажимаем Submit")
    public WebFormFluentPage clickSubmit() {
        submitButton.click();
        return this;
    }

    @Step("Нажимаем Return to index")
    public WebFormFluentPage clickReturnLink() {
        returnLink.click();
        return this;
    }

    @Step("Получаем заголовок после отправки")
    public String getSubmitTitle() {
        return submitTitle.getText();
    }

    @Step("Проверяем отображение блока Received")
    public boolean isReceivedDisplayed() {
        return receivedMessage.isDisplayed();
    }
}