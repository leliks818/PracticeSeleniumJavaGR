package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class WebForm1Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы с использованием @FindBy
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

    public WebForm1Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);  // Инициализация элементов с помощью PageFactory
    }

    @Step("Введите текст '{text}' в поле Text Field")
    public void enterText(String text) {
        textField.sendKeys(text);
    }

    @Step("Получить значение из поля Text Field")
    public String getTextFieldValue() {
        return textField.getAttribute("value");
    }

    @Step("Введите пароль '{password}' в поле Password")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Получить значение из поля Password")
    public String getPasswordValue() {
        return passwordField.getAttribute("value");
    }

    @Step("Введите сообщение '{message}' в textarea")
    public void enterTextarea(String message) {
        textareaField.sendKeys(message);
    }

    @Step("Получить значение из textarea")
    public String getTextareaValue() {
        return textareaField.getAttribute("value");
    }

    @Step("Проверить, что disabled input неактивно")
    public boolean isDisabledInputEnabled() {
        return disabledInput.isEnabled();
    }

    @Step("Проверить наличие атрибута readonly в поле")
    public boolean isReadonlyPresent() {
        return readonlyInput.getDomAttribute("readonly") != null;
    }

    @Step("Нажать ссылку Return to index")
    public void clickReturnLink() {
        returnLink.click();
    }

    @Step("Выбрать опцию '{option}' из списка")
    public void selectOption(String option) {
        new Select(selectDropdown).selectByVisibleText(option);
    }

    @Step("Получить выбранную опцию")
    public String getSelectedOption() {
        return new Select(selectDropdown).getFirstSelectedOption().getText();
    }

    @Step("Ввести '{city}' в datalist")
    public void enterDatalist(String city) {
        datalistInput.sendKeys(city);
    }

    @Step("Получить значение datalist")
    public String getDatalistValue() {
        return datalistInput.getAttribute("value");
    }

    @Step("Загрузить файл '{path}'")
    public void uploadFile(String path) {
        fileInput.sendKeys(path);
    }

    @Step("Получить путь загруженного файла")
    public String getUploadedFilePath() {
        return fileInput.getAttribute("value");
    }

    @Step("Нажать чекбокс")
    public void clickCheckbox() {
        checkbox.click();
    }

    @Step("Проверить, что чекбокс выбран")
    public boolean isCheckboxSelected() {
        return checkbox.isSelected();
    }

    @Step("Нажать радиокнопку")
    public void clickRadioButton() {
        radioButton.click();
    }

    @Step("Проверить, что радиокнопка выбрана")
    public boolean isRadioButtonSelected() {
        return radioButton.isSelected();
    }

    @Step("Выбрать цвет '{color}' в color picker")
    public void pickColor(String color) {
        colorInput.sendKeys(color);
    }

    @Step("Получить значение color picker")
    public String getColorValue() {
        return colorInput.getAttribute("value");
    }

    @Step("Ввести дату '{date}'")
    public void enterDate(String date) {
        dateInput.sendKeys(date);
    }

    @Step("Получить значение date input")
    public String getDateValue() {
        return dateInput.getAttribute("value");
    }

    @Step("Получить текущее значение слайдера")
    public String getSliderValue() {
        return slider.getDomAttribute("value");
    }

    @Step("Переместить ползунок на {offset} пикселей")
    public void moveSlider(int offset) {
        WebElement slide = slider;
        new Actions(driver).clickAndHold(slide).moveByOffset(offset, 0).release().perform();
    }

    @Step("Нажать кнопку Submit")
    public void clickSubmit() {
        submitButton.click();
    }

    @Step("Получить заголовок после отправки")
    public String getSubmitTitle() {
        return wait.until(ExpectedConditions.visibilityOf(submitTitle)).getText();
    }

    @Step("Проверить отображение сообщения о получении данных")
    public boolean isReceivedDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(receivedMessage)).isDisplayed();
    }
}
