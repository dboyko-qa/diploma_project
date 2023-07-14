package tests.ui;

import config.App;
import helpers.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SmokeTests extends TestBase{
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
