package ru.intelinvest.tests.ui;

import io.qameta.allure.Feature;
import ru.intelinvest.config.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature("Smoke tests")
@DisplayName("Web tests: smoke")
public class SmokeTests extends UiTestBase {

    @Test
    @Tag("Smoke")
    @DisplayName("Verify in UI basic application workflow that adds and deletes default share")
    public void baseFlowTest() {
        mainPage.login(App.config.userName(), App.config.userPassword());
        leftMenu.openShareInfoPage();
        shareInfoPage.clickAddToPortfolioButton();
        addTradeDialog.addTradeToPortfolio(10);
        leftMenu.openTradesPage();
        tradesPage.verifyOpened()
                .deleteFirstTrade();
    }
}
