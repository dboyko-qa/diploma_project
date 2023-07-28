package ru.intelinvest.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import ru.intelinvest.config.App;
import ru.intelinvest.config.RunProfile;
import ru.intelinvest.helpers.drivers.AppiumDriver;
import ru.intelinvest.helpers.drivers.BrowserstackDriver;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sessionId;
import static io.qameta.allure.Allure.step;

public class ConfigRunner {

    public static void runWeb() {
        Configuration.baseUrl = App.config.webUrl();

        Configuration.browser = RunProfile.config.browser();
        Configuration.browserVersion = RunProfile.config.browserVersion();
        Configuration.browserSize = RunProfile.config.browserSize();

        if (RunProfile.isRemoteWeb()) {
            Configuration.remote = RunProfile.config.remoteWebDriver();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }

    public static void runMobile(){
        if (RunProfile.isRemoteMobile()) {
            Configuration.browser = BrowserstackDriver.class.getName();
        }
        else {
            Configuration.browser = AppiumDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 60000;
        Configuration.screenshots = false;
        }


    public static void finishMobile() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        String sessionId = sessionId().toString();
        if (RunProfile.isRemoteMobile()) {
            Attach.addVideoBS(sessionId);
        }
        closeWebDriver();
    }

    public static void finishWeb() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        if (RunProfile.isRemoteWeb()) {
            Attach.addVideo();
        }
        step("Close webdriver", () -> Selenide.closeWebDriver());
    }

    public static void runApi() {
        RestAssured.baseURI = App.config.apiUrl();
        RestAssured.defaultParser = Parser.JSON;

    }
}

