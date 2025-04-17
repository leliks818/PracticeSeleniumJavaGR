
    package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class HomePage {

        private final WebDriver driver;

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        // Локаторы для ссылок
        private By webFormLink = By.linkText("Web form");
        private By navigationLink = By.linkText("Navigation");
        private By dropdownMenuLink = By.linkText("Dropdown menu");

        // Методы для взаимодействия с элементами
        public void clickWebFormLink() {
            driver.findElement(webFormLink).click();
        }

        public void clickNavigationLink() {
            driver.findElement(navigationLink).click();
        }

        public void clickDropdownMenuLink() {
            driver.findElement(dropdownMenuLink).click();
        }
    }


