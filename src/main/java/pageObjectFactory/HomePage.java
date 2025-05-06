package pageObjectFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(linkText = "Web form")
    private WebElement webFormLink;

    @FindBy(linkText = "Navigation")
    private WebElement navigationLink;

    @FindBy(linkText = "Dropdown menu")
    private WebElement dropdownMenuLink;

    @FindBy(linkText = "Mouse over")
    private WebElement mouseOverLink;

    @FindBy(linkText = "Drag and drop")
    private WebElement dragAndDropLink;

    @FindBy(linkText = "Draw in canvas")
    private WebElement drawInCanvasLink;

    @FindBy(linkText = "Loading images")
    private WebElement loadingImagesLink;

    @FindBy(linkText = "Slow calculator")
    private WebElement slowCalculatorLink;

    @FindBy(xpath = "//h1[@class='display-4']")
    private WebElement headerTitle;

    @FindBy(xpath = "//a[@href='navigation1.html']")
    private WebElement navigationButton;

    @FindBy(xpath = "//a[@href='index.html']")
    private WebElement backToIndexLink;

    // Конструктор инициализации локаторов
    public HomePage(WebDriver driver) {
        super(driver);

    }

    @Step("Получить заголовок страницы")
    public String getPageTitle() {
        return getTitle();
    }

    @Step("Проверить, что страница загружена (заголовок не равен: {unexpectedTitle})")
    public boolean isPageLoaded(String unexpectedTitle) {
        return !getPageTitle().equals(unexpectedTitle);
    }

    @Step("Получить текущий URL страницы")
    public String getCurrentPageUrl() {
        return getCurrentUrl();
    }

    @Step("Проверить, что отображается правильный заголовок страницы")
    public boolean isCorrectHeaderDisplayed() {
        return getHeaderTitle().equals("Hands-On Selenium WebDriver with Java");
    }

    @Step("Переход на главную страницу через Back to Index")
    public boolean navigatesBackToIndexPage() {
        clickNavigationButton();
        clickBackToIndexLink();
        return getCurrentUrl().equals("https://bonigarcia.dev/selenium-webdriver-java/index.html");
    }

    @Step("Клик по ссылке Web Form")
    public void clickWebFormLink() {
        webFormLink.click();
    }

    @Step("Клик по ссылке Navigation")
    public void clickNavigationLink() {
        navigationLink.click();
    }

    @Step("Клик по ссылке Dropdown Menu")
    public void clickDropdownMenuLink() {
        dropdownMenuLink.click();
    }

    @Step("Клик по ссылке Mouse Over")
    public void clickMouseOverLink() {
        mouseOverLink.click();
    }

    @Step("Клик по ссылке Drag and Drop")
    public void clickDragAndDropLink() {
        dragAndDropLink.click();
    }

    @Step("Клик по ссылке Draw in Canvas")
    public void clickDrawInCanvasLink() {
        drawInCanvasLink.click();
    }

    @Step("Клик по ссылке Loading Images")
    public void clickLoadingImagesLink() {
        loadingImagesLink.click();
    }

    @Step("Клик по ссылке Slow Calculator")
    public void clickSlowCalculatorLink() {
        slowCalculatorLink.click();
    }

    @Step("Получить текст заголовка на странице")
    public String getHeaderTitle() {
        return headerTitle.getText();
    }

    @Step("Клик по кнопке Navigation")
    public void clickNavigationButton() {
        navigationButton.click();
    }

    @Step("Клик по ссылке Back to Index")
    public void clickBackToIndexLink() {
        backToIndexLink.click();
    }
}
