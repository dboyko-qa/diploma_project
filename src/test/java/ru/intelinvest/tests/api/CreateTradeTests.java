package ru.intelinvest.tests.api;

import ru.intelinvest.api.ApiErrorDto;
import ru.intelinvest.api.enums.Assets;
import ru.intelinvest.api.enums.Operations;
import ru.intelinvest.api.portfolio.PortfolioApi;
import ru.intelinvest.api.portfolio.PortfolioOverviewDto;
import ru.intelinvest.api.trades.TradeDto;
import ru.intelinvest.api.trades.TradeFieldsDto;
import ru.intelinvest.api.trades.TradesApi;
import ru.intelinvest.config.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.intelinvest.helpers.Common;

import static ru.intelinvest.api.trades.DeleteTradeApi.deleteTrade;
import static ru.intelinvest.consts.ApiConsts.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@Tag("Jenkins")

public class CreateTradeTests extends ApiTestBase{

    @Test
    @DisplayName("Verify that error is returned when empty body is sent")
    public void tradeWithEmptyBody(){
        //500 error code is expected result according to the response that is received
        //actually 500 error code is not a good result here
        TradeDto trade = TradeDto.builder().build();
        TradesApi.postTrade(trade, BAD_REQUEST_CODE);
    }

    @Test
    @DisplayName("Verify that Buy trade can be successfully created")
    public void createBuyTrade(){
        TradeDto trade = TradesApi.createBuyTrade(stockModel.getId(), 10);
        TradesApi.postTrade(trade, NO_CONTENT_CODE);

        step("Verify that trade was added to portfolio", () -> {
            PortfolioOverviewDto portfolioOverview = PortfolioApi.getPortfolioOverview();
            Assertions.assertTrue(stockModel.getId().equals(
                portfolioOverview.getStockPortfolio().getRows().get(0).getShare().getId().toString()));
        });

        deleteTrade(stockModel.getId());
    }


    @Test
    @DisplayName("Verify that trade with not existing id cannot be added")
    public void createTradeWithNotExistingId() {
        String id = "999999";
        String ticker = "NOTEXIST";

        TradeFieldsDto tradeFields = TradeFieldsDto.builder()
                .shareId(id)
                .ticker(ticker)
                .build();

        TradeDto trade = TradeDto.builder()
                .operation(Operations.BUY.toString())
                .asset(Assets.STOCK.toString())
                .fields(tradeFields)
                .build();

        ApiErrorDto error = TradesApi.postTrade(trade, BAD_REQUEST_CODE);
        Common.verifyResultMessage(error, "Ценная бумага с идентификатором: NOTEXIST не найдена");
    }

        //создать сделку
        @ParameterizedTest(name = "Verify that trade with asset type {0} is not created")
        @ValueSource(strings = {
                "",
                "INCORRECT"
        })
        public void createTradeWithIncorrectAssetType(String assetType) {
            TradeFieldsDto tradeFields = TradeFieldsDto.builder()
                    .shareId(stockModel.getId())
                    .ticker(stockModel.getTicker())
                    .build();

            TradeDto trade = TradeDto.builder()
                    .operation(Operations.BUY.toString())
                    .asset(assetType)
                    .fields(tradeFields)
                    .build();

            //expected result is set according to current API behavior
            //actually 500 error code should not be returned
            ApiErrorDto error = TradesApi.postTrade(trade, SERVER_INTERNAL_ERROR_CODE);
            Common.verifyResultMessage(error, "Внутренняя ошибка сервера");
        }

    @Test
    @DisplayName("Verify that trade without asset type cannot be added")
    public void createTradeWithAbsentAssetType() {
        TradeFieldsDto tradeFields = TradeFieldsDto.builder()
                .shareId(stockModel.getId())
                .ticker(stockModel.getTicker())
                .build();

        TradeDto trade = TradeDto.builder()
                .operation(Operations.BUY.toString())
                .fields(tradeFields)
                .build();

        //expected result is set according to current API behavior
        //actually 500 error code should not be returned
        ApiErrorDto error = TradesApi.postTrade(trade, BAD_REQUEST_CODE);
        Common.verifyResultMessage(error, "Актив должен быть указан");
    }

    @Test
    @DisplayName("Verify that trade cannot be added to foreign portfolio")
    public void createTradeForForeignPortfolio() {
        TradeFieldsDto tradeFields = TradeFieldsDto.builder()
                .shareId(stockModel.getId())
                .ticker(stockModel.getTicker())
                .build();

        TradeDto trade = TradeDto.builder()
                .portfolioId(Integer.valueOf(App.config.foreignPortfolio()))
                .operation(Operations.BUY.toString())
                .asset(Assets.STOCK.toString())
                .fields(tradeFields)
                .build();

        ApiErrorDto error = TradesApi.postTrade(trade, FORBIDDEN_CODE);

        Common.verifyResultMessage(error, String.format("Доступ к портфелю с идентификатором %s запрещен",
                                                App.config.foreignPortfolio()));
    }


}
