package baseTests;
import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class DebugPropertyTest {

    @Test
    void printSystemProperties() {
        System.out.println("=== DEBUG PROPERTIES ===");

        // Смотрим, читается ли проперти из system properties
        String baseUrl = System.getProperty("baseUrl");
        System.out.println("baseUrl from System.getProperty: " + baseUrl);

        // Смотрим, что возвращает config (если используется owner)
        TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
        System.out.println("config.baseUrl(): " + config.baseUrl());
        System.out.println("config.browser(): " + config.browser());

        // Читаем переменную окружения
        String seleniumUrl = System.getenv("SELENIUM_REMOTE_URL");
        System.out.println("SELENIUM_REMOTE_URL from env: " + seleniumUrl);

        String password = System.getProperty("password");
        System.out.println("password from system property: " + password);
    }
}
