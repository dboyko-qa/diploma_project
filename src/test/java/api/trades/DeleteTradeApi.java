package api.trades;

import api.authorization.AuthorizationApi;
import api.marketinfo.MarketInfoApi;
import api.marketinfo.MarketInfoDto;
import api.portfolio.PortfolioApi;
import api.portfolio.PortfolioOverviewDto;
import api.portfolio.RowsPortfolioDto;
import consts.ApiConsts;
import io.qameta.allure.Step;

import static api.specifications.Specs.requestPostSpec;
import static consts.ApiConsts.NO_CONTENT_CODE;
import static io.restassured.RestAssured.given;

public class DeleteTradeApi {

    @Step("Delete trade for asset id = {0} from portfolio")
    public static void deleteTrade(String id){
        MarketInfoDto marketInfo = MarketInfoApi.getMarketInfo(id);

        DeleteTradeRequestDto deleteTradeRequest = DeleteTradeRequestDto.builder()
                .portfolioId(AuthorizationApi.authInfo.getUser().getCurrentPortfolioId())
                .shareIssuerId(Integer.valueOf(id))
                .shareType(marketInfo.getShare().getType())
                .build();

        deleteTrade(deleteTradeRequest, NO_CONTENT_CODE);
    }

    public static void deleteTrade(DeleteTradeRequestDto deleteTradeRequest, int resultCode){
        given()
                .spec(requestPostSpec)
                .body(deleteTradeRequest)
                .when()
                .post(ApiConsts.DELETE_ALL_ENDPOINT)
                .then()
                .statusCode(resultCode);
    }

    @Step("Delete all stocks and bonds from current portfolio")
    public static void deleteAllTradesFromPortfolio(){
        //delete all stocks from portfolio
        PortfolioOverviewDto portfolioOverview = PortfolioApi.getPortfolioOverview();
        for (RowsPortfolioDto row: portfolioOverview.getStockPortfolio().getRows()){
            deleteTrade(row.getShare().getId().toString());
        }
        for (RowsPortfolioDto row: portfolioOverview.getBondPortfolio().getRows()){
            deleteTrade(row.getShare().getId().toString());
        }

    }
}
