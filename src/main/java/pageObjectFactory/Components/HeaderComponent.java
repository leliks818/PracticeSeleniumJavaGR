package pageObjectFactory.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent {

    public HeaderComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@class='img-fluid']")
    private WebElement logo;

    @FindBy(css = ".display-4")
    private WebElement titleHeader;

    @FindBy(xpath = "//h5[normalize-space()='Practice site']")
    private WebElement titleHeaderText;

    public boolean isLogoVisible() {
        return logo.isDisplayed();
    }

    public boolean isTitleHeaderVisible() {
        return titleHeader.isDisplayed();
    }

    public boolean isTitleHeaderTextVisible() {
        return titleHeaderText.isDisplayed();
    }
}
