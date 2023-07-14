package tests.ui;

import api.authorization.AuthorizationApi;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.App;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;
import pages.PortfolioPage;
import pages.ShareInfoPage;
import pages.TradesPage;
import pages.components.AddTradeDialog;
import pages.components.LeftMenuComponent;
import pages.components.TopbarComponent;
import consts.UiConsts.*;

import java.util.Map;

import static api.trades.DeleteTradeApi.deleteAllTradesFromPortfolio;
import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBase {

    MainPage mainPage = new MainPage();
    LeftMenuComponent leftMenu = new LeftMenuComponent();
    ShareInfoPage shareInfoPage = new ShareInfoPage();
    AddTradeDialog addTradeDialog = new AddTradeDialog();
    TradesPage tradesPage = new TradesPage();
    PortfolioPage portfolioPage = new PortfolioPage();
    TopbarComponent topbar = new TopbarComponent();
    static Boolean remote = Boolean.valueOf(System.getProperty("remote"));

    @BeforeAll
    static void beforeAll(){
        RestAssured.baseURI = App.config.apiUrl();
        Configuration.baseUrl=App.config.webUrl();
        Configuration.timeout=40000;

        if (remote) {
            System.out.println("remote");
            Configuration.pageLoadStrategy="eager";
            Configuration.browser = "chrome";
            Configuration.browserVersion = "100.0";
            Configuration.browserSize = "1920x1080";
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }

        deleteAllTradesFromPortfolio();

    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        step("Close webdriver", () -> Selenide.closeWebDriver());
    }

}
