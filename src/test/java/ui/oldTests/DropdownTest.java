package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.List;

import static constants.Constants.BASE_URL;
import static constants.Constants.DROP_DOWN_URL;
import static org.junit.jupiter.api.Assertions.*;

public class DropdownTest extends BaseTest {
    String currentUrl = BASE_URL + "dropdown-menu";

    private final List<String> dropDownItems = List.of(
            "Action",
            "Another action",
            "Something else here",
            "Separated link"
    );


    @Test
    public void testLeftClickDropdown() {
        getDriver().get(currentUrl);
        //Actions actions = new Actions(driver);
        WebElement dropdownLeft = getDriver().findElement(By.id("my-dropdown-1"));
        clickWithActions(dropdownLeft);

        List<WebElement> dropdownElements = getWait5().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("(//ul[@class='dropdown-menu show']//a)")));

        for (WebElement element : dropdownElements) {
            String actualItemText = element.getText().trim();
            assertTrue(dropDownItems.contains(actualItemText),
                    "Элемент '" + actualItemText + "' не найден в ожидаемом списке");
        }
    }

    @Test
    public void testRightClickDropdown() {
        getDriver().get(currentUrl);
        Actions actions = new Actions(driver);
        WebElement dropdownRight = getDriver().findElement(By.id("my-dropdown-2"));
        actions.contextClick(dropdownRight).perform();
        List<WebElement> dropdownElements = getWait5().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//ul[@id='context-menu-2']//a")));

        for (WebElement element : dropdownElements) {
            String actualItemText = element.getText().trim();
            assertTrue(dropDownItems.contains(actualItemText),
                    "Элемент '" + actualItemText + "' не найден в ожидаемом списке");
        }
    }

    @Test
    public void testDoubleClickDropdown() {
        getDriver().get(DROP_DOWN_URL);
        Actions actions = new Actions(driver);
        WebElement dropdownDouble = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropdownDouble).perform();

        List<WebElement> dropdownElements = getWait5().until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//ul[@id='context-menu-3']//a")));

        for (WebElement element : dropdownElements) {
            String actualItemText = element.getText().trim();
            assertTrue(dropDownItems.contains(actualItemText),
                    "Элемент '" + actualItemText + "' не найден в ожидаемом списке");
        }
    }
}
