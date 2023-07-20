package ru.intelinvest.tests;

import ru.intelinvest.helpers.ConfigRunner;
import org.junit.jupiter.api.BeforeAll;

import static ru.intelinvest.api.trades.DeleteTradeApi.deleteAllTradesFromPortfolio;

public class TestBase {
    @BeforeAll
    public static void baseSetUp(){
        ConfigRunner.runApi();
        deleteAllTradesFromPortfolio();
    }


}
