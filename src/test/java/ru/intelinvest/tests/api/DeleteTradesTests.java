package ru.intelinvest.tests.api;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.intelinvest.api.authorization.AuthorizationApi;
import ru.intelinvest.api.marketinfo.MarketInfoApi;
import ru.intelinvest.api.trades.DeleteTradeApi;
import ru.intelinvest.api.trades.DeleteTradeRequestDto;

import static ru.intelinvest.consts.ApiConsts.NO_CONTENT_CODE;


@DisplayName("API tests for deleteAll trades post request")
@Feature("Trades")

public class DeleteTradesTests extends ApiTestBase {

    @Test
    @DisplayName("Test that deleting non existing trade return no content code")
    public void deleteNonExistingTradeTest() {
        DeleteTradeRequestDto deleteTradeRequest = DeleteTradeRequestDto.builder()
                .portfolioId(AuthorizationApi.authInfo.getUser().getCurrentPortfolioId())
                .shareIssuerId(Integer.valueOf(Integer.valueOf(stockModel.getId())))
                .shareType(MarketInfoApi.getMarketInfo(stockModel.getId()).getShare().getType())
                .build();

        DeleteTradeApi.deleteTrade(deleteTradeRequest, NO_CONTENT_CODE);
    }
}
