package pageObjectFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WebFormPage extends BasePage {

    private final WebDriver driver;

    public WebFormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // Инициализация всех элементов с @FindBy
    }

    @FindBy(name = "my-text")
    private WebElement textField;

    @FindBy(name = "my-password")
    private WebElement passwordField;

    @FindBy(xpath = "//textarea[@name='my-textarea']")
    private WebElement textareaField;

    @FindBy(name = "my-disabled")
    private WebElement disabledInput;

    @FindBy(name = "my-readonly")
    private WebElement readonlyInput;

    @FindBy(xpath = "//a[contains(text(), 'Return to index')]")
    private WebElement returnLink;

    @FindBy(xpath = "//h1[normalize-space()='Web form']")
    private WebElement submitTitleReturnLink;


    @FindBy(name = "my-select")
    private WebElement selectDropdown;

    @FindBy(css = "input[list='my-options']")
    private WebElement datalistInput;

    @FindBy(name = "my-file")
    private WebElement fileInput;

    @FindBy(id = "my-check-2")
    private WebElement checkbox;

    @FindBy(id = "my-radio-1")
    private WebElement radioButton;

    @FindBy(name = "my-colors")
    private WebElement colorInput;

    @FindBy(css = "input[name='my-date']")
    private WebElement dateInput;

    @FindBy(name = "my-range")
    private WebElement slider;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[@class='display-6']")
    private WebElement submitTitle;

    @FindBy(xpath = "//p[@class='lead']")
    private WebElement receivedMessage;

    // ========== Методы (Steps) ==========

    @Step("Ввод текста в текстовое поле: {text}")
    public void enterText(String text) {
        textField.sendKeys(text);
    }

    public String getTextFieldValue() {
        return textField.getAttribute("value");
    }

    @Step("Ввод пароля: {password}")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String getPasswordValue() {
        return passwordField.getAttribute("value");
    }

    @Step("Ввод текста в textarea: {message}")
    public void enterTextarea(String message) {
        textareaField.sendKeys(message);
    }

    public String getTextareaValue() {
        return textareaField.getAttribute("value");
    }

    public boolean isDisabledInputEnabled() {
        return disabledInput.isEnabled();
    }

    public boolean isReadonlyPresent() {
        return readonlyInput.getDomAttribute("readonly") != null;
    }

    @Step("Клик по ссылке 'Return to index'")
    public void clickReturnLink() {
        returnLink.click();
    }
    @Step("Получить заголовок после возврата")
    public String getSubmitTitleReturnLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(submitTitleReturnLink));
        return submitTitleReturnLink.getText();
    }

    @Step("Выбор опции из выпадающего списка: {text}")
    public void selectOption(String text) {
        new Select(selectDropdown).selectByVisibleText(text);
    }

    public String getSelectedOption() {
        return new Select(selectDropdown).getFirstSelectedOption().getText();
    }

    @Step("Ввод значения в datalist: {city}")
    public void enterDatalist(String city) {
        datalistInput.sendKeys(city);
    }

    public String getDatalistValue() {
        return datalistInput.getAttribute("value");
    }

    @Step("Загрузка файла: {path}")
    public void uploadFile(String path) {
        fileInput.sendKeys(path);
    }

    public String getUploadedFilePath() {
        return fileInput.getAttribute("value");
    }

    @Step("Установка чекбокса")
    public void clickCheckbox() {
        checkbox.click();
    }

    public boolean isCheckboxSelected() {
        return checkbox.isSelected();
    }

    @Step("Выбор радио-кнопки")
    public void clickRadioButton() {
        radioButton.click();
    }

    public boolean isRadioButtonSelected() {
        return radioButton.isSelected();
    }

    @Step("Выбор цвета: {color}")
    public void pickColor(String color) {
        colorInput.sendKeys(color);
    }

    public String getColorValue() {
        return colorInput.getAttribute("value");
    }

    @Step("Ввод даты: {date}")
    public void enterDate(String date) {
        dateInput.sendKeys(date);
    }

    public String getDateValue() {
        return dateInput.getAttribute("value");
    }

    public String getSliderValue() {
        return slider.getDomAttribute("value");
    }

    @Step("Перемещение слайдера на смещение: {offset}")
    public void moveSlider(int offset) {
        new Actions(driver).clickAndHold(slider).moveByOffset(offset, 0).release().perform();
    }

    @Step("Отправка формы")
    public void clickSubmit() {
        submitButton.click();
    }

    public String getSubmitTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(submitTitle)).getText();
    }

    public boolean isReceivedDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(receivedMessage)).isDisplayed();
    }
}
