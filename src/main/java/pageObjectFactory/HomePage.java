package pageObjectFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

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
        PageFactory.initElements(driver, this);
    }


    public void clickWebFormLink() {
        webFormLink.click();
    }

    public void clickNavigationLink() {
        navigationLink.click();
    }

    public void clickDropdownMenuLink() {
        dropdownMenuLink.click();
    }

    public void clickMouseOverLink() {
        mouseOverLink.click();
    }

    public void clickDragAndDropLink() {
        dragAndDropLink.click();
    }

    public void clickDrawInCanvasLink() {
        drawInCanvasLink.click();
    }

    public void clickLoadingImagesLink() {
        loadingImagesLink.click();
    }

    public void clickSlowCalculatorLink() {
        slowCalculatorLink.click();
    }

    public String getHeaderTitle() {
        return headerTitle.getText();
    }

    public void clickNavigationButton() {
        navigationButton.click();
    }

    public void clickBackToIndexLink() {
        backToIndexLink.click();
    }
}
