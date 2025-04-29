package configs;
import static constants.Constants.BASE_URL;
import static constants.Constants.BASE_URL_API;

public class TestConfig {
    public String getBaseUrl(){
        return System.getProperty("baseUrl", BASE_URL);
    }
    public String getBaseUrlApi(){
        return System.getProperty("baseUrlApi", BASE_URL_API);
    }

}
