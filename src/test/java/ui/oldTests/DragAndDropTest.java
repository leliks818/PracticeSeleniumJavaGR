package ui.oldTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static constants.Constants.DRAG_AND_DROP_URL;
import static org.junit.jupiter.api.Assertions.*;

public class DragAndDropTest extends BaseTest {


    @Test
    public void dragAndDropTest() {
        getDriver().get(DRAG_AND_DROP_URL);
        WebElement draggable = getDriver().findElement(By.id("draggable"));
        WebElement target = getDriver().findElement(By.id("target"));

        Point beforeDrag = draggable.getLocation();

        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(draggable, target).perform();

        // Ожидаем, пока элемент окажется на новом месте
        getWait5().until(driver -> {
            Point afterDrag = draggable.getLocation();
            return !afterDrag.equals(beforeDrag);
        });

        Point afterDrag = draggable.getLocation();
        assertNotEquals(beforeDrag, afterDrag, "Элемент не был перемещён");
    }
}
