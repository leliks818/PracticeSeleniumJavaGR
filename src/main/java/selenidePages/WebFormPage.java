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


    public void selectOption(String option) {
        selectDropdown.selectOption(option);
    }

    public SelenideElement getSelectedOption() {
        return selectDropdown.getSelectedOption();
    }

    public void uploadFile(String filePath) {
        fileUpload.uploadFile(new java.io.File(filePath));
    }

    public String getUploadedFilePath() {
        return fileUpload.getValue();
    }

    public void pickColor(String color) {
        colorPicker.setValue(color);
    }

    public String getColorValue() {
        return colorPicker.getValue();
    }

    public void enterDate(String date) {
        dateInput.setValue(date);
    }

    public String getDateValue() {
        return dateInput.getValue();
    }

    public void clickCheckbox() {
        checkbox.click();
    }

    public boolean isCheckboxSelected() {
        return checkbox.isSelected();
    }

    public void clickRadioButton() {
        radioButton.click();
    }

    public boolean isRadioButtonSelected() {
        return radioButton.isSelected();
    }

    @Step("Отправка формы")
    public void clickSubmit() {
        submitButton.shouldBe(Condition.visible).click();
    }

    public String getSubmitTitle() {
        return submitTitle.shouldBe(Condition.visible).getText();
    }

    public boolean isReceivedDisplayed() {
        return receivedMessage.shouldBe(Condition.visible).isDisplayed();
    }

    public void waitForSubmission() {
        submitTitle.shouldBe(Condition.visible);
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