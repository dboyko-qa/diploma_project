package ru.intelinvest.tests;

import ru.intelinvest.api.enums.Assets;
import ru.intelinvest.helpers.ConfigRunner;
import org.junit.jupiter.api.BeforeAll;
import ru.intelinvest.models.AssetModel;
import ru.intelinvest.models.TradeModel;

import java.util.List;

import static ru.intelinvest.api.trades.DeleteTradeApi.deleteAllTradesFromPortfolio;

public class TestBase {
    //TODO change way of creating test data to load from json file

    protected static List<TradeModel> trades = List.of(
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
    public static void baseSetUp(){
        ConfigRunner.runApi();
        deleteAllTradesFromPortfolio();
    }


}
