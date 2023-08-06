package ru.intelinvest.tests.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import ru.intelinvest.config.ConfigRunner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import ru.intelinvest.pages.MainPage;
import ru.intelinvest.pages.PortfolioPage;
import ru.intelinvest.pages.ShareInfoPage;
import ru.intelinvest.pages.TradesPage;
import ru.intelinvest.pages.components.AddTradeDialog;
import ru.intelinvest.pages.components.LeftMenuComponent;
import ru.intelinvest.pages.components.TopbarComponent;
import ru.intelinvest.tests.TestBase;

@Tag("UI")
public class UiTestBase extends TestBase {
    MainPage mainPage = new MainPage();
    LeftMenuComponent leftMenu = new LeftMenuComponent();
    ShareInfoPage shareInfoPage = new ShareInfoPage();
    AddTradeDialog addTradeDialog = new AddTradeDialog();
    TradesPage tradesPage = new TradesPage();
    PortfolioPage portfolioPage = new PortfolioPage();
    TopbarComponent topbar = new TopbarComponent();

    @BeforeAll
    public static void beforeAll(){
        ConfigRunner.runWeb();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        ConfigRunner.finishWeb();
    }
}
