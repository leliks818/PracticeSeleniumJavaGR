package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

    private final WebDriver driver;

    // Локаторы для ссылок
    private final By webFormLink = By.linkText("Web form");
    private final By navigationLink = By.linkText("Navigation");
    private final By dropdownMenuLink = By.linkText("Dropdown menu");
    private final By slowCalculatorLink = By.linkText("Slow calculator");
    private final By drawInCanvasLink = By.linkText("Draw in canvas");
    private final By dragAndDropLink = By.linkText("Drag and drop");
    private final By loadingImagesLink = By.linkText("Loading images");
    private final By mouseOverLink = By.linkText("Mouse over");

    // Локаторы для кнопок
    private final By navigationButton = By.xpath("//a[@href='navigation1.html']");
    private final By backToIndexLink = By.xpath("//a[@href='index.html']");
    private final By headerTitle = By.xpath("//h1[@class='display-4']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем страницу WebForm URL: {url}")
    public void clickWebFormLink() {
        driver.findElement(webFormLink).click();
    }

    @Step("Открываем страницу Navigation")
    public void clickNavigationLink() {
        driver.findElement(navigationLink).click();
    }

    @Step("Открываем страницу Dropdown menu")
    public void clickDropdownMenuLink() {
        driver.findElement(dropdownMenuLink).click();
    }

    @Step("Открываем страницу Slow Calculator")
    public void clickSlowCalculatorLink() {
        driver.findElement(slowCalculatorLink).click();
    }

    @Step("Открываем страницу Draw in Canvas")
    public void clickDrawInCanvasLink() {
        driver.findElement(drawInCanvasLink).click();
    }

    @Step("Открываем страницу Drag and Drop")
    public void clickDragAndDropLink() {
        driver.findElement(dragAndDropLink).click();
    }

    @Step("Открываем страницу Loading Images")
    public void clickLoadingImagesLink() {
        driver.findElement(loadingImagesLink).click();
    }

    @Step("Открываем страницу Mouse Over")
    public void clickMouseOverLink() {
        driver.findElement(mouseOverLink).click();
    }

    @Step("Нажимаем на кнопку Navigation")
    public void clickNavigationButton() {
        driver.findElement(navigationButton).click();
    }

    @Step("Нажимаем на ссылку Back to Index")
    public void clickBackToIndexLink() {
        driver.findElement(backToIndexLink).click();
    }

    @Step("Получаем заголовок страницы")
    public String getHeaderTitle() {
        return driver.findElement(headerTitle).getText();
    }
}
