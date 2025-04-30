package selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.*;

public abstract class BasePage {

    public void openUrl(String url) {
        open(url);
    }

    public String getTitle() {
        return title();
    }

    public void scrollTo(SelenideElement element) {
        element.scrollIntoView(true);
    }

    // Ожидание, пока элемент не станет видимым
    public void waitUntilVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    // Ожидание, пока элемент не станет доступным для взаимодействия
    public void waitUntilEnabled(SelenideElement element) {
        element.shouldBe(Condition.enabled);
    }

}


