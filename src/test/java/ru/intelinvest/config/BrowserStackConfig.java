package ru.intelinvest.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${mobileprofile}.properties",
        "classpath:config/local.properties"
})
public interface BrowserStackConfig extends Config {
    @Key("browserStack.remoteDriverUrl")
    String remoteDriverUrl();

    @Key("browserStack.remoteAPIUrl")
    String remoteAPIUrl();

    @Key("browserStack.appUrl")
    String appUrl();

    @Key("browserStack.userName")
    String userName();

    @Key("browserStack.accessKey")
    String accessKey();

}
