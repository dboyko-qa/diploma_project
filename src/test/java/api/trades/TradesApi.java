package api.trades;

import api.ApiErrorDto;
import api.enums.Assets;
import api.enums.Operations;
import api.marketinfo.MarketInfoApi;
import api.marketinfo.MarketInfoDto;
import io.qameta.allure.Step;

import static api.specifications.Specs.requestPostSpec;
import static consts.ApiConsts.*;
import static io.restassured.RestAssured.given;

public class TradesApi {

    @Step("Add assets to portfolio")
    public static void postTrade(TradeDto trade){
        postTrade(trade, NO_CONTENT_CODE);
    }

    @Step("Add assets to portfolio and verify result code {1}")
    public static ApiErrorDto postTrade(TradeDto trade, int resultCode){
        return given()
                .spec(requestPostSpec)
                .body(trade)
                .when()
                .post(TRADES_ENDPOINT)
                .then()
                .log().all()
                .statusCode(resultCode)
                .extract().as(ApiErrorDto.class);
    }

    @Step("Create Buy trade for asset id = {0} with quantity {1}")
    public static TradeDto createBuyTrade(String id, Integer quantity) {
        return createTradeDto(Operations.BUY, id, quantity);
    }

    @Step("Create trade for asset id = {0} with quantity {1}")
    public static TradeDto createTradeDto(Operations operation, String id, Integer quantity){
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

        if (marketInfo.getShare().getType().equals(Assets.BOND.toString())){
            tradeFields.setNkd(marketInfo.getShare().getAccruedint().split(" ")[1]);
            tradeFields.setFacevalue(marketInfo.getShare().getFacevalue().split(" ")[1]);
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
