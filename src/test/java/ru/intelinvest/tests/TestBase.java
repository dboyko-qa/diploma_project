package ru.intelinvest.tests;

import ru.intelinvest.config.ConfigRunner;
import org.junit.jupiter.api.BeforeAll;
import ru.intelinvest.models.TradeModel;
import ru.intelinvest.testdata.TestData;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static ru.intelinvest.api.trades.DeleteTradeApi.deleteAllTradesFromPortfolio;

public class TestBase {

    protected static List<TradeModel> trades = new TestData().getTradesList();

    @BeforeAll
    public static void baseSetUp() {
        ConfigRunner.runApi();
        deleteAllTradesFromPortfolio();
    }


}
