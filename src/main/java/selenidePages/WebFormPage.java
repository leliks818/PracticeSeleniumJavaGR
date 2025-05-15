package selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class WebFormPage extends BasePage {

    public SelenideElement textInput = $("[name='my-text']");
    public SelenideElement passwordField = $("[name='my-password']");
    public SelenideElement textarea = $("[name='my-textarea']");
    public SelenideElement disabledInput = $("[name='my-disabled']");
    public SelenideElement readonlyInput = $("[name='my-readonly']");
    public SelenideElement returnLink = $x("//a[contains(text(), 'Return to index')]");
    public SelenideElement submitTitleReturnLink = $x("//h1[normalize-space()='Web form']");
    public SelenideElement selectDropdown = $("[name='my-select']");
    public SelenideElement fileUpload = $("[name='my-file']");
    public SelenideElement colorPicker = $("[name='my-colors']");
    public SelenideElement dateInput = $("[name='my-date']");
    public SelenideElement checkbox = $("#my-check-2");
    public SelenideElement radioButton = $("#my-radio-1");
    public SelenideElement submitButton = $x("//button[normalize-space()='Submit']");
    public SelenideElement submitTitle = $x("//h1[@class='display-6']");
    public SelenideElement receivedMessage = $x("//p[@class='lead']");

    public void enterText(String value) {
        textInput.setValue(value);
    }

    public WebFormPage enterPassword(String pass) {
        passwordField.setValue(pass);
        return this;
    }

    public void enterTextarea(String text) {
        textarea.setValue(text);
    }

    public boolean isDisabledInputEnabled() {
        return disabledInput.isEnabled();
    }

    public boolean isReadonlyPresent() {
        return readonlyInput.getAttribute("readonly") != null;
    }


    @Step("Клик по ссылке 'Return to index'")
    public void clickReturnLink() {
        returnLink.click();
    }

    @Step("Получить заголовок после возврата")
    public String getSubmitTitleReturnLink() {
        return submitTitleReturnLink.shouldBe(Condition.visible).getText();
    }

    @Step("Отправка формы")
    public void clickSubmit() {
        submitButton.shouldBe(Condition.visible).click();
    }

    public String getTextFieldValue() {
        return textInput.getValue();
    }

    public String getPasswordValue() {
        return passwordField.getValue();
    }

    public String getTextareaValue() {
        return textarea.getValue();
    }
}