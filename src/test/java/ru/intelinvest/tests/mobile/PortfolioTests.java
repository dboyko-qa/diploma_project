package ru.intelinvest.tests.mobile;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.intelinvest.api.enums.Assets;
import ru.intelinvest.api.trades.TradesApi;
import ru.intelinvest.config.App;
import ru.intelinvest.models.TradeModel;

import java.util.List;
import java.util.stream.Collectors;

@DisplayName("Android tests for portfolio")
@Feature("Portfolio")
public class PortfolioTests extends MobileTestBase{

    @BeforeAll
    public static void configurePortfolio(){
        TradesApi.addMultipleTrades(trades);
    }

    @BeforeEach
    public void appLogin(){
        loginActivity.login(App.config.userName(), App.config.userPassword());
    }

    @Test
    @DisplayName("Verify that assets are added to portfolio")
    public void assetsShownInPortfolioTest(){

        mainActivity.openAssetsScreen();

        //TODO rewrite to get all types of assets and iterate through all of them
        mainActivity.verifyStocksTabExist()
                .openStocksTab();
        verifyAssetsByAssetType(Assets.STOCK);

        mainActivity.verifyBondsTabExist()
                .openBondsTab();
        verifyAssetsByAssetType(Assets.BOND);

    }

    private void verifyAssetsByAssetType(Assets assetType) {
        List<TradeModel> stockTrades = trades.stream()
                .filter(t -> t.getAsset().getAssetType() == assetType)
                .collect(Collectors.toList());
        for (TradeModel stockTrade : stockTrades) {
            mainActivity.verifyAssetExistInPortfolio(stockTrade.getAsset().getShortName());
        }
    }

    @Test
    @DisplayName("Verify that summary lines for portfolio are shown")
    public void portfolioSummaryDataShownTest(){
        mainActivity.verifyPortfolioScreenOpened()
                .verifySummaryLinesShown();
    }
}
