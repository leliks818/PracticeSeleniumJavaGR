package ui.selenide;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import selenidePages.BasePage;
import selenidePages.WebFormPage;

import static com.codeborne.selenide.Selenide.*;
import static constants.Constants.WEB_FORM_URL;
import static constants.TestData.*;

import static org.junit.jupiter.api.Assertions.*;

public class WebFormTest extends BasePage {

    @BeforeEach
    public void setUp() {
        open(WEB_FORM_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    private WebFormPage getPage() {
        WebFormPage page = new WebFormPage();
        page.openUrl(WEB_FORM_URL);
        return page;
    }

    @Test
    public void testTextInput() {
        WebFormPage page = getPage();
        page.enterText(TEXT_INPUT);
        assertEquals(TEXT_INPUT, page.getTextFieldValue());
    }

    @Test
    public void testPasswordField() {
        WebFormPage page = getPage();
        page.enterPassword(PASSWORD);
        assertEquals(PASSWORD, page.getPasswordValue());
    }

    @Test
    public void testTextareaField() {
        WebFormPage page = getPage();
        page.enterTextarea(TEXTAREA);
        assertEquals(TEXTAREA, page.getTextareaValue());
    }

    @Test
    public void testDisabledInput() {
        WebFormPage page = getPage();
        assertFalse(page.isDisabledInputEnabled(), "Поле не должно быть активно!");
    }

    @Test
    public void testReadonlyInput() {
        WebFormPage page = getPage();
        assertTrue(page.isReadonlyPresent(), "Поле должно быть readonly!");
    }

    @Test
    public void testReturnLink() {
        WebFormPage page = getPage();
        page.clickReturnLink();
        back();
        String title = page.getSubmitTitleReturnLink();
        assertTrue(title.contains("Web form"), "Заголовок не содержит ожидаемое!");
    }
}