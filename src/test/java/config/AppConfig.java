package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/app.properties"
})
public interface AppConfig extends Config{
    String webUrl();
    String apiUrl();
    String userName();
    String userPassword();
    String foreignPortfolio();

}
