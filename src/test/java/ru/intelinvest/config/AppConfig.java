package ru.intelinvest.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/app.properties",
        "classpath:config/users.properties"
})
public interface AppConfig extends Config {
    String webUrl();

    String apiUrl();

    String userName();

    String userPassword();

    String foreignPortfolio();

    String mobileAppPath();

    String mobileAppPackage();

    String mobileAppActivity();
}
