package ru.intelinvest.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${webprofile}.properties",
        "classpath:config/local.properties"
})

public interface WebConfig extends Config{
    @Config.DefaultValue("chrome")
    @Key("browser.name")
    String browser();
    @Config.DefaultValue("115.0")
    @Key("browser.version")
    String browserVersion();
    @Config.DefaultValue("1920x1080")
    @Key("browser.size")
    String browserSize();

}
