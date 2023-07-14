package tests.api;

import api.authorization.AuthorizationApi;
import api.marketinfo.MarketInfoApi;
import api.marketinfo.MarketInfoDto;
import api.specifications.SpecsWithoutAuthorization;
import api.trades.DeleteTradeRequestDto;
import api.trades.TradeDto;
import api.trades.TradesApi;
import consts.ApiConsts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specifications.SpecsWithoutAuthorization.requestPostWithoutAuthorization;
import static consts.ApiConsts.*;
import static io.restassured.RestAssured.given;

@Tag("Jenkins")

public class NoAuthorizationTest extends ApiTestBase{
    @Test
    @DisplayName("Get portfolio by non authorized user")
    public void getPortfolioByNonAuthorizedUser(){
        given()
                .spec(SpecsWithoutAuthorization.requestGetWithoutAuthorization)
                .when()
                .get(String.format(PORTFOLIO_OVERVIEW_ENDPOINT, AuthorizationApi.authInfo.getUser().getCurrentPortfolioId()))
                .then()
                .log().all()
                .statusCode(UNAUTHORIZED_CODE);
    }

    @Test
    @DisplayName("Test that delete by unauthorized user is forbidden")
    public void deleteTradeByUnauthorizedUser(){
        MarketInfoDto marketInfo = MarketInfoApi.getMarketInfo(stockModel.getId());

        DeleteTradeRequestDto deleteTradeRequest = DeleteTradeRequestDto.builder()
                .portfolioId(AuthorizationApi.authInfo.getUser().getCurrentPortfolioId())
                .shareIssuerId(Integer.valueOf(stockModel.getId()))
                .shareType(marketInfo.getShare().getType())
                .build();

        given()
                .spec(SpecsWithoutAuthorization.requestPostWithoutAuthorization)
                .body(deleteTradeRequest)
                .when()
                .post(ApiConsts.DELETE_ALL_ENDPOINT)
                .then()
                .log().all()
                .statusCode(UNAUTHORIZED_CODE);

    }

    @Test
    @DisplayName("Verify that trade cannot be created without authorization")
    public void tradeByNonAuthorizedUser(){
        TradeDto trade = TradesApi.createBuyTrade(stockModel.getId(), 10);

        given()
                .spec(requestPostWithoutAuthorization)
                .body(trade)
                .when()
                .post(TRADES_ENDPOINT)
                .then()
                .log().all()
                .statusCode(UNAUTHORIZED_CODE);
    }

}
