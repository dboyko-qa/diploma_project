package tests.api;

import config.App;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import models.AssetModel;
import org.junit.jupiter.api.BeforeAll;

import static api.trades.DeleteTradeApi.deleteAllTradesFromPortfolio;

public class ApiTestBase {
    AssetModel stockModel = AssetModel.builder().id("1344").ticker("SBER").shortName("Сбербанк").build();
    AssetModel bondModel = AssetModel.builder().id("17803").ticker("SU26230RMFS1").shortName("ОФЗ 26230").build();

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = App.config.apiUrl();
        RestAssured.defaultParser = Parser.JSON;

        deleteAllTradesFromPortfolio();

    }
}
