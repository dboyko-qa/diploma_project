package ru.intelinvest.api.portfolio;

import ru.intelinvest.api.authorization.AuthorizationApi;
import io.qameta.allure.Step;
import ru.intelinvest.api.specifications.Specs;

import static io.restassured.RestAssured.*;
import static ru.intelinvest.consts.ApiConsts.*;

public class PortfolioApi {
    @Step("Get overview information for current portfolio")
    public static PortfolioOverviewDto getPortfolioOverview(){
        return getPortfolioOverview(AuthorizationApi.authInfo.getUser().getCurrentPortfolioId(), OK_CODE);
    }

    @Step("Get overview information for portfolio with id {0}")
    public static PortfolioOverviewDto getPortfolioOverview(Integer portfolioId, int errorCode){

        return given()
                .spec(Specs.requestGetSpec)
                .get(String.format(PORTFOLIO_OVERVIEW_ENDPOINT, portfolioId))
                .then()
                .spec(responseSpecification)
                .statusCode(errorCode)
                .extract().as(PortfolioOverviewDto.class);
    }

    @Step("Get overview information for portfolio with id {0}")
    public static PortfolioInfoDto getPortfolioInfo(Integer portfolioId, int errorCode){

        return given()
                .spec(Specs.requestGetSpec)
                .get(String.format(PORTFOLIO_INFO_ENDPOINT, portfolioId))
                .then()
                .spec(responseSpecification)
                .statusCode(errorCode)
                .extract().as(PortfolioInfoDto.class);
    }

}
