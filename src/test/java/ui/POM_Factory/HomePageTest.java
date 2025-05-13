package ui.POM_Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import baseTests.BaseTest;
import pageObjectFactory.HomePage;

import static constants.Constants.BASE_URL;
import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends BaseTest {

    @BeforeEach
    public void setUpTest() {
        getDriver().get(BASE_URL);

    }
    @Test
    public void testHeaderComponents() {
        HomePage homePage = new HomePage(getDriver());
        assertTrue(homePage.getHeader().isLogoVisible());
        assertTrue(homePage.getHeader().isTitleHeaderVisible());
        assertTrue(homePage.getHeader().isTitleHeaderTextVisible());
    }
    @Test
    public void testWebFormLink() {
       HomePage homePage = new HomePage(getDriver());
        homePage.clickWebFormLink();
        assertTrue(homePage.isPageLoaded("Страница не загрузилась: Web form"));
    }

    @Test
    public void testNavigationLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickNavigationLink();
        assertTrue(homePage.isPageLoaded("Страница не загрузилась: Navigation"));
    }

    @Test
    public void testDropdownMenuLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickDropdownMenuLink();
        assertTrue(homePage.isPageLoaded("Страница не загрузилась: Dropdown menu"));
    }

    @Test
    public void testMouseOverLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickMouseOverLink();
        assertTrue(homePage.isPageLoaded("Страница не загрузилась: Mouse over"));
    }

    @Test
    public void testDragAndDropLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickDragAndDropLink();
        assertTrue(homePage.isPageLoaded("Страница не загрузилась: Drag and drop"));
    }

    @Test
    public void testDrawInCanvasLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickDrawInCanvasLink();
        assertTrue(homePage.isPageLoaded("Страница не загрузилась: Draw in canvas"));
    }

    @Test
    public void testLoadingImagesLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickLoadingImagesLink();
        assertTrue(homePage.isPageLoaded("Страница не загрузилась: Loading images"));
    }

    @Test
    public void testSlowCalculatorLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSlowCalculatorLink();
        assertTrue(homePage.isPageLoaded("Страница не загрузилась: Slow calculator"));
    }

    @Test
    public void testHeader() {
        HomePage homePage = new HomePage(getDriver());
        String headerTitle = homePage.getHeaderTitle();
        assertEquals("Hands-On Selenium WebDriver with Java", headerTitle);
    }

    @Test
    public void testNavigationPageLink() {
        HomePage homePage = new HomePage(getDriver());
        assertNotNull(homePage, "HomePage не был инициализирован");
        homePage.clickNavigationButton();
        homePage.clickBackToIndexLink();
        String actualURL = getDriver().getCurrentUrl();
        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/index.html", actualURL);
    }
}