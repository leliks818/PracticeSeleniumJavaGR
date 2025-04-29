package ui.POM;

import org.junit.jupiter.api.Test;
import pageObject.WebForm1Page;
import baseTests.BaseTest;

import static constants.Constants.WEB_FORM_URL;
import static constants.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testReturnLink()  {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
        page.clickReturnLink();
        assertNotEquals("Web form", getDriver().getTitle(), "Ссылка не работает!");
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
        page.uploadFile(FILE_PATH);
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
    public void testFormSubmission() {
        getDriver().get(WEB_FORM_URL);
        WebForm1Page page = new WebForm1Page(getDriver());
       page.enterText(TEXT_INPUT);
       page.enterPassword(PASSWORD);
        page.clickSubmit();
        getWait10();
        assertTrue(page.getSubmitTitle().contains("Form submitted"), "Заголовок не содержит ожидаемое сообщение!");
        assertTrue(page.isReceivedDisplayed(), "Сообщение не отображается");
    }
}
