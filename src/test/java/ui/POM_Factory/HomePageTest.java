package ui.POM_Factory;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import baseTests.BaseTest;
import pageObjectFactory.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends BaseTest {

  private HomePage homePage;

    @BeforeEach
    public void setUpTest() {
      homePage = new HomePage(getDriver()); /// Инициализация перед каждым тестом надо ли
   }

    @Test
    public void testWebFormLink() {

        homePage.clickWebFormLink();
        assertNotEquals("Страница не загрузилась: Web form", getDriver().getTitle());
    }

    @Test
    public void testNavigationLink() {

        homePage.clickNavigationLink();
        assertNotEquals("Страница не загрузилась: Navigation", getDriver().getTitle());
    }

    @Test
    public void testDropdownMenuLink() {

        homePage.clickDropdownMenuLink();
        assertNotEquals("Страница не загрузилась: Dropdown menu", getDriver().getTitle());
    }

    @Test
    public void testMouseOverLink() {
        homePage.clickMouseOverLink();
        assertNotEquals("Страница не загрузилась: Mouse over", getDriver().getTitle());
    }

    @Test
    public void testDragAndDropLink() {

        homePage.clickDragAndDropLink();
        assertNotEquals("Страница не загрузилась: Drag and drop", getDriver().getTitle());
    }

    @Test
    public void testDrawInCanvasLink() {

        homePage.clickDrawInCanvasLink();
        assertNotEquals("Страница не загрузилась: Draw in canvas", getDriver().getTitle());
    }

    @Test
    public void testLoadingImagesLink() {

        homePage.clickLoadingImagesLink();
        assertNotEquals("Страница не загрузилась: Loading images", getDriver().getTitle());
    }

    @Test
    public void testSlowCalculatorLink() {

        homePage.clickSlowCalculatorLink();
        assertNotEquals("Страница не загрузилась: Slow calculator", getDriver().getTitle());
    }

    @Test
    public void testHeader() {

        String headerTitle = homePage.getHeaderTitle();
        assertEquals("Hands-On Selenium WebDriver with Java", headerTitle);
    }

    @Test
    public void testNavigationPageLink() {
        assertNotNull(homePage, "HomePage не был инициализирован");
        homePage.clickNavigationButton();
        homePage.clickBackToIndexLink();
        String actualURL = getDriver().getCurrentUrl();
        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/index.html", actualURL);
    }
}
