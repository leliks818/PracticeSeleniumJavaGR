package ui.POM;

import org.junit.jupiter.api.Test;

import pageObject.HomePage;
import baseTests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HomePageLinkTestWithPOM extends BaseTest {


    @Test
    public void testWebFormLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickWebFormLink();
        assertNotEquals("Страница не загрузилась: Web form", getDriver().getTitle());
    }

    @Test
    public void testNavigationLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickNavigationLink();
        assertNotEquals("Страница не загрузилась: Navigation", getDriver().getTitle());
    }

    @Test
    public void testDropdownMenuLink() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickDropdownMenuLink();
        assertNotEquals("Страница не загрузилась: Dropdown menu", getDriver().getTitle());
    }

}