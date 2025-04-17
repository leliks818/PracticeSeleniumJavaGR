package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WebFormPage {

    private WebDriver driver;

    // Локаторы для элементов
    private By textField = By.name("my-text");
    private By passField = By.name("my-password");
    private By textareaField = By.xpath("//textarea[@name='my-textarea']");
    private By disabledInput = By.name("my-disabled");
    private By readonlyInput = By.name("my-readonly");
    private By returnLink = By.xpath("//a[contains(text(), 'Return to index')]");
    private By selectField = By.name("my-select");
    private By dataList = By.cssSelector("input[list='my-options']");
    private By fileUploadField = By.name("my-file");
    private By checkboxField = By.xpath("//input[@id='my-check-1']");
    private By radioButton = By.xpath("//input[@id='my-radio-1']");
    private By colorPicker = By.name("my-colors");
    private By dateInput = By.cssSelector("input[name='my-date']");
    private By slider = By.name("my-range");
    private By submitButton = By.xpath("//button[normalize-space()='Submit']");
    private By successMessage = By.cssSelector("div.col-12.py-2");

    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для взаимодействия с элементами
    public void enterText(String text) {
        driver.findElement(textField).sendKeys(text);
    }

    public void enterPassword(String password) {
        driver.findElement(passField).sendKeys(password);
    }

    public void enterTextarea(String text) {
        driver.findElement(textareaField).sendKeys(text);
    }

    public boolean isDisabledInput() {
        return !driver.findElement(disabledInput).isEnabled();
    }

    public boolean isReadonlyInput() {
        return driver.findElement(readonlyInput).getAttribute("readonly") != null;
    }

    public void clickReturnLink() {
        driver.findElement(returnLink).click();
    }

    public void selectOptionByText(String text) {
        Select select = new Select(driver.findElement(selectField));
        select.selectByVisibleText(text);
    }

    public void enterDataListValue(String value) {
        driver.findElement(dataList).sendKeys(value);
    }

    public void uploadFile(String filePath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadElement = wait.until(visibilityOfElementLocated(fileUploadField));
        uploadElement.sendKeys(filePath);
    }

    public void toggleCheckbox() {
        WebElement checkbox = driver.findElement(checkboxField);
        checkbox.click();
    }

    public void clickRadioButton() {
        WebElement radioButtonElement = driver.findElement(radioButton);
        radioButtonElement.click();
    }

    public void pickColor(String color) {
        driver.findElement(colorPicker).sendKeys(color);
    }

    public void enterDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
    }

    public void moveSlider() {
        WebElement sliderElement = driver.findElement(slider);
        sliderElement.click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
