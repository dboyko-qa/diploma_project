package ru.intelinvest.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${webprofile}.properties",
        "classpath:config/local.properties"
})
public interface SelenoidConfig extends Config{
    @Key("selenoid.remoteWebDriver")
    String remoteWebDriver();
    @Key("selenoid.remoteUrl")
    String remoteUrl();

}
