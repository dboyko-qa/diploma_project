package ru.intelinvest.api.trades;

import ru.intelinvest.api.authorization.AuthorizationApi;
import ru.intelinvest.api.marketinfo.MarketInfoApi;
import ru.intelinvest.api.marketinfo.MarketInfoDto;
import ru.intelinvest.api.portfolio.PortfolioApi;
import ru.intelinvest.api.portfolio.PortfolioOverviewDto;
import ru.intelinvest.api.portfolio.RowsPortfolioDto;
import ru.intelinvest.consts.ApiConsts;
import io.qameta.allure.Step;
import ru.intelinvest.api.specifications.Specs;
import ru.intelinvest.models.TradeModel;

import java.util.List;

import static ru.intelinvest.api.specifications.Specs.responseSpec;
import static ru.intelinvest.consts.ApiConsts.NO_CONTENT_CODE;
import static io.restassured.RestAssured.given;

public class DeleteTradeApi {

    @Step("Delete trade for asset id = {0} from portfolio")
    public static void deleteTrade(String id) {
        MarketInfoDto marketInfo = MarketInfoApi.getMarketInfo(id);

        DeleteTradeRequestDto deleteTradeRequest = DeleteTradeRequestDto.builder()
                .portfolioId(AuthorizationApi.authInfo.getUser().getCurrentPortfolioId())
                .shareIssuerId(Integer.valueOf(id))
                .shareType(marketInfo.getShare().getType())
                .build();

        deleteTrade(deleteTradeRequest, NO_CONTENT_CODE);
    }

    public static void deleteTrade(DeleteTradeRequestDto deleteTradeRequest, int resultCode) {
        given()
                .spec(Specs.requestPostSpec)
                .body(deleteTradeRequest)
                .when()
                .post(ApiConsts.DELETE_ALL_ENDPOINT)
                .then()
                .spec(responseSpec)
                .statusCode(resultCode);
    }

    @Step("Delete all stocks and bonds from current portfolio")
    public static void deleteAllTradesFromPortfolio() {
        //delete all stocks from portfolio
        PortfolioOverviewDto portfolioOverview = PortfolioApi.getCurrentPortfolioOverview();
        for (RowsPortfolioDto row : portfolioOverview.getStockPortfolio().getRows()) {
            deleteTrade(row.getShare().getId().toString());
        }
        for (RowsPortfolioDto row : portfolioOverview.getBondPortfolio().getRows()) {
            deleteTrade(row.getShare().getId().toString());
        }

    }

    @Step("Delete assets from portfolio that were added for tests")
    public static void deleteMultipleTrades(List<TradeModel> trades) {
        for (TradeModel trade : trades) {
            DeleteTradeApi.deleteTrade(trade.getAsset().getId());
        }

    }

}
