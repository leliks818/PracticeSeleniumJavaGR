package ui.POM_Factory;

import org.junit.jupiter.api.Test;
import pageObject.WebForm1Page;
import baseTests.BaseTest;

import static constants.Constants.WEB_FORM_URL;
import static constants.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

public class WebFormTest extends BaseTest {

    private WebForm1Page getPage() {
        getDriver().get(WEB_FORM_URL);
        return new WebForm1Page(getDriver());
    }

    @Test
    public void testTextInput() {
        WebForm1Page page = getPage();
        page.enterText(TEXT_INPUT);
        assertEquals(TEXT_INPUT, page.getTextFieldValue());
    }

    @Test
    public void testPasswordField() {
        WebForm1Page page = getPage();
        page.enterPassword(PASSWORD);
        assertEquals(PASSWORD, page.getPasswordValue());
    }

    @Test
    public void testTextareaField() {
        WebForm1Page page = getPage();
        page.enterTextarea(TEXTAREA);
        assertEquals(TEXTAREA, page.getTextareaValue());
    }

    @Test
    public void testDisabledInput() {
        WebForm1Page page = getPage();
        assertFalse(page.isDisabledInputEnabled(), "Поле не должно быть активно!");
    }

    @Test
    public void testReadonlyInput() {
        WebForm1Page page = getPage();
        assertTrue(page.isReadonlyPresent(), "Поле должно быть readonly!");
    }

    @Test
    public void testReturnLink() {
        WebForm1Page page = getPage();
        page.clickReturnLink();
        assertNotEquals("Web form", getDriver().getTitle(), "Ссылка не работает!");
    }

    @Test
    public void testSelectOption() {
        WebForm1Page page = getPage();
        page.selectOption(SELECT_OPTION);
        assertEquals(SELECT_OPTION, page.getSelectedOption());
    }

    @Test
    public void testFileUpload() {
        WebForm1Page page = getPage();
        page.uploadFile(FILE_PATH);
        assertTrue(page.getUploadedFilePath().contains("java.png"));
    }

    @Test
    public void testColorPicker() {
        WebForm1Page page = getPage();
        page.pickColor(COLOR_PICKER);
        assertEquals(COLOR_PICKER, page.getColorValue());
    }

    @Test
    public void testDateInput() {
        WebForm1Page page = getPage();
        page.enterDate(DATE_INPUT);
        assertEquals(DATE_INPUT, page.getDateValue());
    }

    @Test
    public void testCheckbox() {
        WebForm1Page page = getPage();
        page.clickCheckbox();
        assertTrue(page.isCheckboxSelected());
    }

    @Test
    public void testRadioButton() {
        WebForm1Page page = getPage();
        page.clickRadioButton();
        assertTrue(page.isRadioButtonSelected());
    }

    @Test
    public void testFormSubmission() {
        WebForm1Page page = getPage();
        page.enterText(TEXT_INPUT);
        page.enterPassword(PASSWORD);
        page.clickSubmit();
        getWait10();
        assertTrue(page.getSubmitTitle().contains("Form submitted"), "Заголовок не содержит ожидаемое сообщение!");
        assertTrue(page.isReceivedDisplayed(), "Сообщение не отображается");
    }
}
