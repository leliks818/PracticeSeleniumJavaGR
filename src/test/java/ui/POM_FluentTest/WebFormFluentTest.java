package ui.POM_FluentTest;

import FluentPageObject.WebFormFluentPage;
import baseTests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static constants.Constants.WEB_FORM_URL;
import static constants.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

public class WebFormFluentTest extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        getDriver().get(WEB_FORM_URL);
    }

    @Test
    public void testWebFormFluentPage() throws URISyntaxException {
        WebFormFluentPage webFormPage = new WebFormFluentPage(getDriver());

        webFormPage
                .enterText(TEXT_INPUT)
                .enterPassword(PASSWORD)
                .enterTextarea(TEXTAREA)
                .selectOption(SELECT_OPTION)
                //.enterDatalist(DATALIST_OPTION)
                .uploadFile(FILE_PATH)
                .pickColor(COLOR_PICKER)
                .enterDate(DATE_INPUT)
                .clickSubmit();

        assertTrue(webFormPage.getSubmitTitle().contains("Form submitted"));
        assertTrue(webFormPage.isReceivedDisplayed());
    }
}
