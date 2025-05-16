package ui.oldTests.POM;

import constants.TestData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.WebForm1Page;
import baseTests.BaseTest;

import java.time.Duration;

import static constants.Constants.WEB_FORM_URL;
import static constants.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

@Disabled
public class WebFormTestWithPOM extends BaseTest {

    @Test
    public void testTextInput() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.enterText(TEXT_INPUT);
        assertEquals(TEXT_INPUT, page.getTextFieldValue());
    }

    @Test
    public void testPasswordField() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.enterPassword(PASSWORD);
        assertEquals(PASSWORD, page.getPasswordValue());
    }

    @Test
    public void testTextareaField() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.enterTextarea(TEXTAREA);
        assertEquals(TEXTAREA, page.getTextareaValue());
    }

    @Test
    public void testDisabledInput() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        assertFalse(page.isDisabledInputEnabled(), "Поле не должно быть активно!");
    }

    @Test
    public void testReadonlyInput() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        assertTrue(page.isReadonlyPresent(), "Поле должно быть readonly!");
    }

    @Test
    public void testReturnLink() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.clickReturnLink(); // переход на другую страницу
        getDriver().navigate().back();
        // Ждем заголовка после возврата
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Web form']")));
        // Проверка заголовка
        assertTrue(page.getSubmitTitleReturnLink().contains("Web form"),
                "Заголовок не содержит ожидаемое сообщение!");
    }

    @Test
    public void testSelectOption() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.selectOption(SELECT_OPTION);
        assertEquals(SELECT_OPTION, page.getSelectedOption());
    }

    @Test
    public void testFileUpload() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.uploadFile(TestData.FILE_PATH);
        assertTrue(page.getUploadedFilePath().contains("java.png"));
    }

    @Test
    public void testColorPicker() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.pickColor(COLOR_PICKER);
        assertEquals(COLOR_PICKER, page.getColorValue());
    }

    @Test
    public void testDateInput() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.enterDate(DATE_INPUT);
        assertEquals(DATE_INPUT, page.getDateValue());
    }

    @Test
    public void testCheckbox() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.clickCheckbox();
        assertTrue(page.isCheckboxSelected());
    }

    @Test
    public void testRadioButton() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.clickRadioButton();
        assertTrue(page.isRadioButtonSelected());
    }

    @Test
    public void testFormSubmission() throws InterruptedException {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.enterText(TEXT_INPUT);
        page.enterPassword(PASSWORD);
        page.clickSubmit();
        Thread.sleep(2000);

        assertTrue(page.getSubmitTitle().contains("Form submitted"), "Заголовок не содержит ожидаемое сообщение!");
        assertTrue(page.isReceivedDisplayed(), "Сообщение не отображается");

    }
}
