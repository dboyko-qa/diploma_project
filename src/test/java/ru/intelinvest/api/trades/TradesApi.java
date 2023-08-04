package ru.intelinvest.api.trades;

import ru.intelinvest.api.ApiErrorDto;
import ru.intelinvest.api.enums.Assets;
import ru.intelinvest.api.enums.Operations;
import ru.intelinvest.api.marketinfo.MarketInfoApi;
import ru.intelinvest.api.marketinfo.MarketInfoDto;
import io.qameta.allure.Step;
import ru.intelinvest.api.specifications.Specs;
import ru.intelinvest.models.TradeModel;

import java.util.List;

import static ru.intelinvest.api.specifications.Specs.responseSpec;
import static ru.intelinvest.consts.ApiConsts.*;
import static io.restassured.RestAssured.given;

public class TradesApi {

    @Step("Add assets to portfolio")
    public static void postSuccessfulTrade(TradeDto trade) {
        postTrade(trade, NO_CONTENT_CODE);
    }

    @Step("Add assets to portfolio and verify result code {1}")
    public static ApiErrorDto postTrade(TradeDto trade, int resultCode) {
        return given()
                .spec(Specs.requestPostSpec)
                .body(trade)
                .when()
                .post(TRADES_ENDPOINT)
                .then()
                .spec(responseSpec)
                .statusCode(resultCode)
                .extract().as(ApiErrorDto.class);
    }

    @Step("Add several assets of different types to portfolio")
    public static void addMultipleTrades(List<TradeModel> trades) {
        for (TradeModel trade : trades) {
            TradesApi.postSuccessfulTrade(TradesApi.createBuyTradeDto(trade.getAsset().getId(), trade.getQuantity()));
        }
    }


    @Step("Create Buy trade for asset id = {0} with quantity {1}")
    public static TradeDto createBuyTradeDto(String id, Integer quantity) {
        return createTradeDto(Operations.BUY, id, quantity);
    }

    @Step("Create trade for asset id = {0} with quantity {1}")
    public static TradeDto createTradeDto(Operations operation, String id, Integer quantity) {
        MarketInfoDto marketInfo = MarketInfoApi.getMarketInfo(id);

        Float moneyAmount = Float.parseFloat(marketInfo.getShare().getBigDecimalPrice()) * quantity;
        TradeFieldsDto tradeFields = TradeFieldsDto.builder()
                .shareId(marketInfo.getShare().getId().toString())
                .ticker(marketInfo.getShare().getTicker())
                .currency(marketInfo.getShare().getCurrency())
                .quantity(quantity.toString())
                .price(marketInfo.getShare().getBigDecimalPrice())
                .moneyAmount(moneyAmount.toString())
                .build();

        if (marketInfo.getShare().getType().equals(Assets.BOND.toString())) {
            tradeFields.setNkd(marketInfo.getShare().getAccruedint().split(" ")[1]);
            tradeFields.setFaceValue(marketInfo.getShare().getFaceValue().split(" ")[1]);
        }

        TradeDto trade = TradeDto.builder()
                .operation(operation.toString())
                .asset(marketInfo.getShare().getType())
                .fields(tradeFields)
                .build();

        System.out.println(trade);
        return trade;
    }
}
