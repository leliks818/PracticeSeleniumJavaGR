package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class WebForm1Page {

    private final WebDriver driver;
    private final WebDriverWait wait;


    private final By textField = By.name("my-text");
    private final By passwordField = By.name("my-password");
    private final By textareaField = By.xpath("//textarea[@name='my-textarea']");
    private final By disabledInput = By.name("my-disabled");
    private final By readonlyInput = By.name("my-readonly");
    private final By returnLink = By.xpath("//a[contains(text(), 'Return to index')]");
    private final By selectDropdown = By.name("my-select");
    private final By datalistInput = By.cssSelector("input[list='my-options']");
    private final By fileInput = By.name("my-file");
    private final By checkbox = By.id("my-check-2");
    private final By radioButton = By.id("my-radio-1");
    private final By colorInput = By.name("my-colors");
    private final By dateInput = By.cssSelector("input[name='my-date']");
    private final By slider = By.name("my-range");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By submitTitle = By.xpath("//h1[@class='display-6']");
    private final By submitTitleReturnLink = By.xpath("//h1[normalize-space()='Web form']");
    private final By receivedMessage = By.xpath("//p[@class='lead']");

    public WebForm1Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);  // Инициализация элементов с помощью PageFactory
    }

        @Step("Введите текст '{text}' в поле Text Field")
        public void enterText(String text) {
            driver.findElement(textField).sendKeys(text);
        }

        @Step("Получить значение из поля Text Field")
        public String getTextFieldValue() {
            return driver.findElement(textField).getAttribute("value");
        }

        @Step("Введите пароль '{password}' в поле Password")
        public void enterPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
        }

        @Step("Получить значение из поля Password")
        public String getPasswordValue() {
            return driver.findElement(passwordField).getAttribute("value");
        }

        @Step("Введите сообщение '{message}' в textarea")
        public void enterTextarea(String message) {
            driver.findElement(textareaField).sendKeys(message);
        }

        @Step("Получить значение из textarea")
        public String getTextareaValue() {
            return driver.findElement(textareaField).getAttribute("value");
        }

        @Step("Проверить, что disabled input неактивно")
        public boolean isDisabledInputEnabled() {
            return driver.findElement(disabledInput).isEnabled();
        }

        @Step("Проверить наличие атрибута readonly в поле")
        public boolean isReadonlyPresent() {
            return driver.findElement(readonlyInput).getDomAttribute("readonly") != null;
        }
    @Step("Нажать ссылку Return to index")
    public void clickReturnLink() {
        driver.findElement(returnLink).click();
    }

    @Step("Получить заголовок после возврата")
    public String getSubmitTitleReturnLink() {
        return driver.findElement(submitTitleReturnLink).getText();
    }


        @Step("Выбрать опцию '{option}' из списка")
        public void selectOption(String option) {
            new Select(driver.findElement(selectDropdown)).selectByVisibleText(option);
        }

        @Step("Получить выбранную опцию")
        public String getSelectedOption() {
            return new Select(driver.findElement(selectDropdown)).getFirstSelectedOption().getText();
        }

        @Step("Ввести '{city}' в datalist")
        public void enterDatalist(String city) {
            driver.findElement(datalistInput).sendKeys(city);
        }

        @Step("Получить значение datalist")
        public String getDatalistValue() {
            return driver.findElement(datalistInput).getAttribute("value");
        }

        @Step("Загрузить файл '{path}'")
        public void uploadFile(String path) {
            driver.findElement(fileInput).sendKeys(path);
        }

        @Step("Получить путь загруженного файла")
        public String getUploadedFilePath() {
            return driver.findElement(fileInput).getAttribute("value");
        }

        @Step("Нажать чекбокс")
        public void clickCheckbox() {
            driver.findElement(checkbox).click();
        }

        @Step("Проверить, что чекбокс выбран")
        public boolean isCheckboxSelected() {
            return driver.findElement(checkbox).isSelected();
        }

        @Step("Нажать радиокнопку")
        public void clickRadioButton() {
            driver.findElement(radioButton).click();
        }

        @Step("Проверить, что радиокнопка выбрана")
        public boolean isRadioButtonSelected() {
            return driver.findElement(radioButton).isSelected();
        }

        @Step("Выбрать цвет '{color}' в color picker")
        public void pickColor(String color) {
            driver.findElement(colorInput).sendKeys(color);
        }

        @Step("Получить значение color picker")
        public String getColorValue() {
            return driver.findElement(colorInput).getAttribute("value");
        }

        @Step("Ввести дату '{date}'")
        public void enterDate(String date) {
            driver.findElement(dateInput).sendKeys(date);
        }

        @Step("Получить значение date input")
        public String getDateValue() {
            return driver.findElement(dateInput).getAttribute("value");
        }

        @Step("Получить текущее значение слайдера")
        public String getSliderValue() {
            return driver.findElement(slider).getDomAttribute("value");
        }

        @Step("Переместить ползунок на {offset} пикселей")
        public void moveSlider(int offset) {
            WebElement slide = driver.findElement(slider);
            new Actions(driver).clickAndHold(slide).moveByOffset(offset, 0).release().perform();
        }

        @Step("Нажать кнопку Submit")
        public void clickSubmit() {
            driver.findElement(submitButton).click();
        }

        @Step("Получить заголовок после отправки")
        public String getSubmitTitle() {
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitTitle))).getText();
        }

        @Step("Проверить отображение сообщения о получении данных")
        public boolean isReceivedDisplayed() {
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(receivedMessage))).isDisplayed();
        }
    }
