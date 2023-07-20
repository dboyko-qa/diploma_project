package ru.intelinvest.tests.ui;

import ru.intelinvest.config.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class SmokeTests extends UiTestBase {
    @Test
    @Tag("Jenkins")
    @Tag("Smoke")
    @DisplayName("Verify in UI basic application workflow that adds and deletes default share")
    public void baseFlowTest(){
        mainPage.login(App.config.userName(), App.config.userPassword());
        leftMenu.openShareInfoPage();
        shareInfoPage.clickAddToPortfolioButton();
        addTradeDialog.addTradeToPortfolio();
        leftMenu.openTradesPage();
        tradesPage.verifyOpened()
                .deleteFirstTrade();
    }

}
