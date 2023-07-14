package tests.api;

import api.authorization.AuthorizationApi;
import api.marketinfo.MarketInfoApi;
import api.marketinfo.MarketInfoDto;
import api.specifications.SpecsWithoutAuthorization;
import api.trades.DeleteTradeRequestDto;
import consts.ApiConsts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specifications.Specs.*;
import static api.trades.DeleteTradeApi.deleteTrade;
import static consts.ApiConsts.NO_CONTENT_CODE;
import static consts.ApiConsts.UNAUTHORIZED_CODE;
import static io.restassured.RestAssured.given;

@Tag("Jenkins")
public class DeleteTradesTests extends ApiTestBase{

    @Test
    @DisplayName("Test that deleting non existing trade return no content code")
    public void deleteNonExistingTrade(){
        DeleteTradeRequestDto deleteTradeRequest = DeleteTradeRequestDto.builder()
                .portfolioId(AuthorizationApi.authInfo.getUser().getCurrentPortfolioId())
                .shareIssuerId(Integer.valueOf(Integer.valueOf(stockModel.getId())))
                .shareType(MarketInfoApi.getMarketInfo(stockModel.getId()).getShare().getType())
                .build();

        deleteTrade(deleteTradeRequest, NO_CONTENT_CODE);
    }
    //post https://intelinvest.ru/api/trades/delete

}
