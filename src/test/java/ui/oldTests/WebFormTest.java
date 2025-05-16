package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

import static constants.Constants.WEB_FORM_URL;
import static org.junit.jupiter.api.Assertions.*;

public class WebFormTest extends BaseTest {


    @Test
    public void testTextInput() {
        getDriver().get(WEB_FORM_URL);
        WebElement textField = driver.findElement(By.name("my-text"));
        textField.sendKeys("Test Input");
        assertEquals("Test Input", textField.getAttribute("value"), "Поле 'my-text' содержит неверное значение!");
    }

    @Test
    public void testPasswordField() {
        getDriver().get(WEB_FORM_URL);
        WebElement passField = driver.findElement(By.name("my-password"));
        passField.sendKeys("pass123");
        assertEquals("pass123", passField.getAttribute("value"), "Неверное значение");
    }

    @Test
    public void testTextareaField() {
        getDriver().get(WEB_FORM_URL);
        WebElement textareaField = driver.findElement(By.xpath("//textarea[@name='my-textarea']"));
        textareaField.sendKeys("Привет всем");
        assertEquals("Привет всем", textareaField.getAttribute("value"), "Неверное значение");
    }

    @Test
    public void testDisabledInput() {
        getDriver().get(WEB_FORM_URL);
        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        assertFalse(disabledInput.isEnabled(), "Поле не заблокировано, должно быть!");
    }

    @Test
    public void testReadonlyInput() {
        getDriver().get(WEB_FORM_URL);
        WebElement readonlyInput = driver.findElement(By.name("my-readonly"));
        assertNotNull(readonlyInput.getDomAttribute("readonly"), "Поле должно быть readonly!");
    }

    @Test
    public void testReturnLink() throws InterruptedException {
        getDriver().get(WEB_FORM_URL);
        WebElement returnLink = driver.findElement(By.xpath("//a[contains(text(), 'Return to index')]"));
        returnLink.click();
        Thread.sleep(2000);
        driver.navigate().back();
        assertNotEquals("Страница не загрузилась", driver.getTitle());
    }

    @Test
    public void testSelectOption() {
        getDriver().get(WEB_FORM_URL);
        Select select = new Select(driver.findElement(By.name("my-select")));
        select.selectByVisibleText("Two");
        String selectedText = select.getFirstSelectedOption().getText();
        assertEquals("Two", selectedText);
    }

    @Test
    public void testDataList() {
        getDriver().get(WEB_FORM_URL);
        WebElement dataList = driver.findElement(By.cssSelector("input[list='my-options']"));
        dataList.sendKeys("San Francisco");
        assertEquals("San Francisco", dataList.getAttribute("value"), "Значение в поле ввода неверное!");
    }

    @Test
    public void testFileUpload() {
        getDriver().get(WEB_FORM_URL);
        String filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "uploads", "java.png").toString();
        File file = new File(filePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-file")));
        uploadElement.sendKeys(filePath);
        String uploadedFilePath = uploadElement.getAttribute("value");
        assertNotNull(uploadedFilePath);
        assertTrue(uploadedFilePath.contains("java.png"), "Файл не был загружен!");
    }

    @Test
    public void testCheckbox() {
        getDriver().get(WEB_FORM_URL);
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='my-check-1']"));
        checkbox.click();
        assertFalse(checkbox.isSelected(), "Чекбокс не должен быть выбран");
    }

    @Test
    public void testRadioButton() {
        getDriver().get(WEB_FORM_URL);
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='my-radio-1']"));
        radioButton.click();
        assertTrue(radioButton.isSelected(), "Радиокнопка не выбрана");
    }

    @Test
    public void testColorPicker() {
        getDriver().get(WEB_FORM_URL);

        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        String newColor = "#ff0000";
        colorPicker.sendKeys(newColor);
        String pickedColor = colorPicker.getAttribute("value");
        assertNotNull(pickedColor);
        assertEquals(newColor, pickedColor.toLowerCase(), "Цвет не изменился!");
    }

    @Test
    public void testDateInput() {
        getDriver().get(WEB_FORM_URL);
        WebElement dateInput = driver.findElement(By.cssSelector("input[name='my-date']"));
        dateInput.sendKeys("17/03/2025");
        assertEquals("17/03/2025", dateInput.getAttribute("value"));
    }

    @Test
    public void testSlider() {
        getDriver().get(WEB_FORM_URL);
        WebElement slider = driver.findElement(By.name("my-range"));
        String initialValue = slider.getDomAttribute("value");
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();
        String newValue = slider.getDomAttribute("value");

        System.out.println("Начальное значение: " + initialValue);
        System.out.println("Новое значение: " + newValue);
        assertNotEquals("Слайдер не перемещен как нужно", initialValue, newValue);
    }

    @Test
    public void testSubmitButton() {
        getDriver().get(WEB_FORM_URL);
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.display-6")));

        assertTrue(element.getText().contains("Form submitt"), "Expected text 'Form submitt' not found!");

        WebElement receivedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-12.py-2")));
        assertTrue(receivedMessage.isDisplayed(), "Текст 'Received!' не найден!");
    }

}
