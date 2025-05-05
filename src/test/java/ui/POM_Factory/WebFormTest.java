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

    private WebFormPage webFormPage;

    @BeforeEach
    public void setUpTest() {
        getDriver().get(WEB_FORM_URL);
        webFormPage = new WebFormPage(getDriver());
    }

    @Test
    public void testTextInput() {
        webFormPage.enterText(TEXT_INPUT);
        assertEquals(TEXT_INPUT, webFormPage.getTextFieldValue());
    }

    @Test
    public void testPasswordField() {
        webFormPage.enterPassword(PASSWORD);
        assertEquals(PASSWORD, webFormPage.getPasswordValue());
    }

    @Test
    public void testTextareaField() {
        webFormPage.enterTextarea(TEXTAREA);
        assertEquals(TEXTAREA, webFormPage.getTextareaValue());
    }

    @Test
    public void testDisabledInput() {
        assertFalse(webFormPage.isDisabledInputEnabled(), "Поле не должно быть активно!");
    }

    @Test
    public void testReadonlyInput() {
        assertTrue(webFormPage.isReadonlyPresent(), "Поле должно быть readonly!");
    }

    @Test
    public void testReturnLink() {
        webFormPage.clickReturnLink();
        getDriver().navigate().back();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Web form']")));
        assertTrue(webFormPage.getSubmitTitleReturnLink().contains("Web form"),
                "Заголовок не содержит ожидаемое сообщение!");
    }

    @Test
    public void testSelectOption() {
        webFormPage.selectOption(SELECT_OPTION);
        assertEquals(SELECT_OPTION, webFormPage.getSelectedOption());
    }

    @Test
    public void testFileUpload() {
        webFormPage.uploadFile(FILE_PATH);
        assertTrue(webFormPage.getUploadedFilePath().contains("java.png"));
    }

    @Test
    public void testColorPicker() {
        webFormPage.pickColor(COLOR_PICKER);
        assertEquals(COLOR_PICKER, webFormPage.getColorValue());
    }

    @Test
    public void testDateInput() {
        webFormPage.enterDate(DATE_INPUT);
        assertEquals(DATE_INPUT, webFormPage.getDateValue());
    }

    @Test
    public void testCheckbox() {
        webFormPage.clickCheckbox();
        assertTrue(webFormPage.isCheckboxSelected());
    }

    @Test
    public void testRadioButton() {
        webFormPage.clickRadioButton();
        assertTrue(webFormPage.isRadioButtonSelected());
    }

    @Test
    public void testFormSubmission() throws InterruptedException {
        webFormPage.enterText(TEXT_INPUT);
        webFormPage.enterPassword(PASSWORD);
        webFormPage.clickSubmit();
        Thread.sleep(1000);
        assertTrue(webFormPage.getSubmitTitle().contains("Form submitted"), "Заголовок не содержит ожидаемое сообщение!");
        assertTrue(webFormPage.isReceivedDisplayed(), "Сообщение не отображается");
    }
}
