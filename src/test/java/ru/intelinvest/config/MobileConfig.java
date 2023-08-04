package ru.intelinvest.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${mobileprofile}.properties",
        "classpath:config/local.properties"
})

public interface MobileConfig extends Config {
    @DefaultValue("11.0")
    @Key("mobile.version")
    String mobileVersion();
    @DefaultValue("android")
    @Key("mobile.platform")
    String mobilePlatformName();
    @DefaultValue("Pixel 4 API 30")
    @Key("mobile.deviceName")
    String mobileDeviceName();
    @DefaultValue("http://localhost:4723")
    @Key("mobile.url")
    String mobileUrl();

}
