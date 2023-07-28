package ru.intelinvest.tests.mobile;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.intelinvest.api.enums.Assets;
import ru.intelinvest.api.trades.TradesApi;
import ru.intelinvest.config.App;
import ru.intelinvest.models.AssetModel;
import ru.intelinvest.models.TradeModel;

import java.util.List;
import java.util.stream.Collectors;

public class PortfolioTests extends MobileTestBase{
    //TODO change way of creating test data to load from json file
    private static List<TradeModel> trades = List.of(
        TradeModel.builder().asset(
                AssetModel.builder().id("1344").ticker("SBER").shortName("Сбербанк").assetType(Assets.STOCK).build())
                .quantity(10)
                .build(),
        TradeModel.builder().asset(
                AssetModel.builder().id("1075").ticker("GAZP").shortName("ГАЗПРОМ ао").assetType(Assets.STOCK).build())
                .quantity(10)
                .build(),
        TradeModel.builder().asset(
                AssetModel.builder().id("17803").ticker("SU26230RMFS1").shortName("ОФЗ 26230").assetType(Assets.BOND).build())
                .quantity(10)
                .build()
    );

    @BeforeAll
    public static void beforeAll(){
        for (TradeModel trade: trades){
            TradesApi.postTrade(TradesApi.createBuyTradeDto(trade.getAsset().getId(), trade.getQuantity()));
        }
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
        mainActivity.isPortfolioScreenOpened()
                .verifySummaryLinesShown();

    }
}
