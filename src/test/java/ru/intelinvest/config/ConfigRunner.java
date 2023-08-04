package ru.intelinvest.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import ru.intelinvest.config.drivers.AppiumDriver;
import ru.intelinvest.config.drivers.BrowserstackDriver;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.intelinvest.helpers.Attach;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sessionId;
import static io.qameta.allure.Allure.step;

public class ConfigRunner {

    private static Boolean isRemoteWeb(){
        return (Selenoid.config.remoteWebDriver() != null && !Selenoid.config.remoteWebDriver().isEmpty());
    }
    private static Boolean isRemoteMobile(){
        return (BrowserStack.config.remoteDriverUrl() != null && !BrowserStack.config.remoteDriverUrl().isEmpty());
    }

    public static void runWeb() {
        Configuration.baseUrl = App.config.webUrl();

        Configuration.browser = RunProfile.config.browser();
        Configuration.browserVersion = RunProfile.config.browserVersion();
        Configuration.browserSize = RunProfile.config.browserSize();

        if (isRemoteWeb()) {
            Configuration.remote = Selenoid.config.remoteWebDriver();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }

    public static void runMobile(){
        if (isRemoteMobile()) {
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
        Attach.pageSource();

        String sessionId = sessionId().toString();
        if (isRemoteMobile()) {
            Attach.addVideoBS(sessionId);
        }
        else {
            Attach.screenshotAs("Last screenshot");
        }
        closeWebDriver();
    }

    public static void finishWeb() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        if (isRemoteWeb()) {
            Attach.addVideo();
        }
        step("Close webdriver", () -> Selenide.closeWebDriver());
    }

    public static void runApi() {
        RestAssured.baseURI = App.config.apiUrl();
        RestAssured.defaultParser = Parser.JSON;

    }
}

