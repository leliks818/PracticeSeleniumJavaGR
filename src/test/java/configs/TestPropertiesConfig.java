package configs;

import constants.Constants;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties"
})
public interface TestPropertiesConfig extends Config {
    @Key("baseUrlUi")
    @DefaultValue(Constants.BASE_URL)
    String getBaseUrl();

    @Key("baseUrlApi")
    @DefaultValue(Constants.BASE_URL_API)
    String getBaseUrlApi();


    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();

    @Key("invalidUsername")
    String getInvalidUsername();

    @Key("invalidPassword")
    String getInvalidPassword();
}
