package ru.intelinvest.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/{webprofile}.properties",
        "classpath:config/{mobileprofile}.properties",
        "classpath:config/local.properties",
})

public interface RunProfileConfig extends Config {
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("115.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String remoteWebDriver();
    String remoteUrl();


    //mobile tests settings
    @DefaultValue("11.0")
    String mobileVersion();
    @DefaultValue("android")
    String mobilePlatformName();
    @DefaultValue("Pixel 4 API 30")
    String mobileDeviceName();
    @DefaultValue("http://localhost:4723")
    String mobileUrl();

    //browserstack settings
    String remoteMobileUrl();
    String remoteMobileAPIUrl();
    String appUrl();
    String bsUserName();
    String bsAccessKey();
}
