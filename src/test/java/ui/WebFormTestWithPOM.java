package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.WebFormPage;

import static constants.Constants.WEB_FORM_URL;
import static constants.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

public class WebFormTestWithPOM extends BaseTest {

    @Test
    public void testTextInput() {
        getDriver().get(WEB_FORM_URL);
        WebFormPage webFormPage = new WebFormPage(getDriver());
        webFormPage.enterText(TEXT_INPUT);
        assertEquals(TEXT_INPUT, getDriver().findElement(By.name("my-text")).getAttribute("value"), "Поле 'my-text' содержит неверное значение!");
    }

    @Test
    public void testPasswordField() {
        getDriver().get(WEB_FORM_URL);
        WebFormPage webFormPage = new WebFormPage(getDriver());
        webFormPage.enterPassword(PASSWORD);
        assertEquals(PASSWORD, getDriver().findElement(By.name("my-password")).getAttribute("value"), "Неверное значение");
    }

    @Test
    public void testTextareaField() {
        getDriver().get(WEB_FORM_URL);
        WebFormPage webFormPage = new WebFormPage(getDriver());
        webFormPage.enterTextarea(TEXTAREA);
        assertEquals(TEXTAREA, getDriver().findElement(By.xpath("//textarea[@name='my-textarea']")).getAttribute("value"), "Неверное значение");
    }

    @Test
    public void testDisabledInput() {
        getDriver().get(WEB_FORM_URL);
        WebFormPage webFormPage = new WebFormPage(getDriver());
        assertTrue(webFormPage.isDisabledInput(), "Поле не заблокировано, должно быть!");
    }

    @Test
    public void testReadonlyInput() {
        getDriver().get(WEB_FORM_URL);
        WebFormPage webFormPage = new WebFormPage(getDriver());
        assertTrue(webFormPage.isReadonlyInput(), "Поле должно быть readonly!");
    }

    @Test
    public void testReturnLink() throws InterruptedException {
        getDriver().get(WEB_FORM_URL);
        WebFormPage webFormPage = new WebFormPage(getDriver());
        webFormPage.clickReturnLink();
        Thread.sleep(2000); // Вместо этого лучше использовать ожидания с WebDriverWait
        getDriver().navigate().back();
        assertNotEquals("Страница не загрузилась", getDriver().getTitle());
    }

    // Оставшиеся тесты можно обновить аналогично, используя данные из TestData
}
