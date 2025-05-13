package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties",  // Загружаем только один файл
        "system:properties"  // Подгружаем свойства из системы, если они есть
//        "classpath:${env}.properties",
//        "classpath:default.properties"
})
public interface TestPropertiesConfig extends Config {

    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();

    @Key("invalidLogin")
    String getInvalidUsername();

    @Key("invalidPassword")
    String getInvalidPassword();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("baseUrl")
    String baseUrl();
}
