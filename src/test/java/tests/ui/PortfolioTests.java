package tests.ui;

import api.trades.DeleteTradeApi;
import api.trades.TradesApi;
import helpers.WithLogin;
import models.AssetModel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import static consts.UiConsts.*;

@Tag("Jenkins")
public class PortfolioTests extends TestBase{
    private static Map<AssetModel, Integer> tradesList = Map.of(
            AssetModel.builder().id("1344").ticker("SBER").shortName("Сбербанк").build(), 10,
            AssetModel.builder().id("1075").ticker("GAZP").shortName("ГАЗПРОМ ао").build(), 10,
            AssetModel.builder().id("17803").ticker("SU26230RMFS1").shortName("ОФЗ 26230").build(), 10);

    @BeforeAll
    static void addTradesToPortfolio(){
        for (Map.Entry<AssetModel, Integer> trade: tradesList.entrySet()){
            TradesApi.postTrade(TradesApi.createBuyTrade(trade.getKey().getId(), trade.getValue()));
        }

    }

    @AfterAll
    static void deleteAllTradesFromPortfolio(){
        for (Map.Entry<AssetModel, Integer> trade: tradesList.entrySet()){
            DeleteTradeApi.deleteTrade(trade.getKey().getId());
        }
    }

    @ValueSource(strings = {
            "USD",
            "EUR",
            "RUB"
    })
    @ParameterizedTest(name = "Correct sign is shown for currency {0}")
    @WithLogin
    public void changeCurrencyTest(String currency){
        portfolioPage.openPage();
        topbar.selectCurrency(currency);
        portfolioPage.verifyCurrencySign(currency);
    }

    @Test
    @WithLogin
    @DisplayName("Verify that all tabs are shown in Portfolio screen")
    public void infoTabsTest(){
        portfolioPage.openPage()
                .verifyTabExists(PORTFOLIO_CONTENT_TAB)
                .verifyTabExists(ALL_ASSETS)
                .verifyTabExists(CONSOLIDATED_REPORT)
                .verifyTabExists(STOCKS_TAB)
                .verifyTabExists(BONDS_TAB);
    }

    @Test
    @WithLogin
    @DisplayName("Verify that added stocks and bonds are shown in the table")
    public void portfolioInfoWindowTest(){
        ArrayList<String> shortNamesExpected = new ArrayList(tradesList.keySet().stream().map(AssetModel::getShortName)
                .collect(Collectors.toList()));
        ArrayList<String> tickersExpected = new ArrayList(tradesList.keySet().stream().map(AssetModel::getTicker)
                .collect(Collectors.toList()));

        portfolioPage.openPage()
                    .openTab(ALL_ASSETS)
                    .verifyShortNamesList(shortNamesExpected)
                    .verifyTickers(tickersExpected);
    }
}
