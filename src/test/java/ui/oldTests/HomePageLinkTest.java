package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Disabled
public class HomePageLinkTest extends BaseTest {


    @Test
    public void testWebFormLink() {
        WebElement link = getDriver().findElement(By.linkText("Web form"));
        link.click();
        //simpleClick("Web form");
        assertNotEquals("Страница не загрузилась: Web form", getDriver().getTitle());
    }

    @Test
    public void testNavigationLink() {
        WebElement link = getDriver().findElement(By.linkText("Navigation"));
        link.click();
        assertNotEquals("Страница не загрузилась: Navigation", getDriver().getTitle());
    }

    @Test
    public void testDropdownMenuLink() {
        WebElement link = getDriver().findElement(By.linkText("Dropdown menu"));
        link.click();
        assertNotEquals("Страница не загрузилась: Dropdown menu", getDriver().getTitle());
    }

    @Test
    public void testMouseOverLink() {
        WebElement link = getDriver().findElement(By.linkText("Mouse over"));
        link.click();
        assertNotEquals("Страница не загрузилась: Mouse over", getDriver().getTitle());
    }

    @Test
    public void testDragAndDropLink() {
        WebElement link = getDriver().findElement(By.linkText("Drag and drop"));
        link.click();
        assertNotEquals("Страница не загрузилась: Drag and drop", getDriver().getTitle());
    }

    @Test
    public void testDrawInCanvasLink() {
        WebElement link = getDriver().findElement(By.linkText("Draw in canvas"));
        link.click();
        assertNotEquals("Страница не загрузилась: Draw in canvas", getDriver().getTitle());
    }

    @Test
    public void testLoadingImagesLink() {
        WebElement link = getDriver().findElement(By.linkText("Loading images"));
        link.click();
        assertNotEquals("Страница не загрузилась: Loading images", getDriver().getTitle());
    }

    @Test
    public void testSlowCalculatorLink() {
        WebElement link = getDriver().findElement(By.linkText("Slow calculator"));
        link.click();
        assertNotEquals("Страница не загрузилась: Slow calculator", getDriver().getTitle());
    }

    @Test
    public void testHeader() {
        WebElement title = getDriver().findElement(By.xpath("//h1[@class='display-4']"));

        assertEquals("Hands-On Selenium WebDriver with Java", title.getText());
    }

    @Test
    public void testNavigationPageLink() {
        WebElement navigationButton = getDriver().findElement(By.xpath("//a[@href='navigation1.html']"));
        navigationButton.click();

        WebElement backToIndexLink = getDriver().findElement(By.xpath("//a[@href='index.html']"));
        backToIndexLink.click();
        String actualURL = getDriver().getCurrentUrl();

        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/index.html", actualURL);
    }
}
