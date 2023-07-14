package api.portfolio;

import api.authorization.AuthorizationApi;
import io.qameta.allure.Step;

import static api.specifications.Specs.requestGetSpec;
import static consts.ApiConsts.*;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class PortfolioApi {
    @Step("Get overview information for current portfolio")
    public static PortfolioOverviewDto getPortfolioOverview(){
        return getPortfolioOverview(AuthorizationApi.authInfo.getUser().getCurrentPortfolioId(), OK_CODE);
    }

    @Step("Get overview information for portfolio with id {0}")
    public static PortfolioOverviewDto getPortfolioOverview(Integer portfolioId, int errorCode){

        return given()
                .spec(requestGetSpec)
                .get(String.format(PORTFOLIO_OVERVIEW_ENDPOINT, portfolioId))
                .then()
                .log().all()
                .statusCode(errorCode)
                .extract().as(PortfolioOverviewDto.class);
    }

    @Step("Get overview information for portfolio with id {0}")
    public static PortfolioInfoDto getPortfolioInfo(Integer portfolioId, int errorCode){

        return given()
                .spec(requestGetSpec)
                .get(String.format(PORTFOLIO_INFO_ENDPOINT, portfolioId))
                .then()
                .log().all()
                .statusCode(errorCode)
                .extract().as(PortfolioInfoDto.class);
    }

}
