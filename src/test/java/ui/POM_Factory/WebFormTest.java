package ui.POM_Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import baseTests.BaseTest;
import pageObjectFactory.WebFormPage;

import java.time.Duration;

import static constants.Constants.WEB_FORM_URL;
import static constants.TestData.*;

import static org.junit.jupiter.api.Assertions.*;

public class WebFormTest extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        getDriver().get(WEB_FORM_URL);

    }
    @Test
    public void testTextInput() {

        WebFormPage webFormPage = new WebFormPage(getDriver()); // драйвер не передаём
        webFormPage.enterText(TEXT_INPUT);
        assertEquals(TEXT_INPUT, webFormPage.getTextFieldValue());
    }

    @Test
    public void testPasswordField() {


        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.enterPassword(PASSWORD);
        assertEquals(PASSWORD, webFormPage.getPasswordValue());
    }

    @Test
    public void testTextareaField() {
        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.enterTextarea(TEXTAREA);
        assertEquals(TEXTAREA, webFormPage.getTextareaValue());
    }

    @Test
    public void testDisabledInput() {
        WebFormPage webFormPage = new WebFormPage(driver);
        assertFalse(webFormPage.isDisabledInputEnabled(), "Поле не должно быть активно!");
    }

    @Test
    public void testReadonlyInput() {
        WebFormPage webFormPage = new WebFormPage(driver);
        assertTrue(webFormPage.isReadonlyPresent(), "Поле должно быть readonly!");
    }

    @Test
    public void testReturnLink() {

        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.clickReturnLink();
        getDriver().navigate().back();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Web form']")));
        assertTrue(webFormPage.getSubmitTitleReturnLink().contains("Web form"),
                "Заголовок не содержит ожидаемое сообщение!");
    }

    @Test
    public void testSelectOption() {
        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.selectOption(SELECT_OPTION);
        assertEquals(SELECT_OPTION, webFormPage.getSelectedOption());
    }

    @Test
    public void testFileUpload() {
        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.uploadFile(FILE_PATH);
        assertTrue(webFormPage.getUploadedFilePath().contains("java.png"));
    }

    @Test
    public void testColorPicker() {
        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.pickColor(COLOR_PICKER);
        assertEquals(COLOR_PICKER, webFormPage.getColorValue());
    }

    @Test
    public void testDateInput() {
        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.enterDate(DATE_INPUT);
        assertEquals(DATE_INPUT, webFormPage.getDateValue());
    }

    @Test
    public void testCheckbox() {
        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.clickCheckbox();
        assertTrue(webFormPage.isCheckboxSelected());
    }

    @Test
    public void testRadioButton() {
        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.clickRadioButton();
        assertTrue(webFormPage.isRadioButtonSelected());
    }

    @Test
    public void testFormSubmission() throws InterruptedException {
        WebFormPage webFormPage = new WebFormPage(driver);
        webFormPage.enterText(TEXT_INPUT);
        webFormPage.enterPassword(PASSWORD);
        webFormPage.clickSubmit();
        Thread.sleep(1000);
        assertTrue(webFormPage.getSubmitTitle().contains("Form submitted"), "Заголовок не содержит ожидаемое сообщение!");
        assertTrue(webFormPage.isReceivedDisplayed(), "Сообщение не отображается");
    }
}
