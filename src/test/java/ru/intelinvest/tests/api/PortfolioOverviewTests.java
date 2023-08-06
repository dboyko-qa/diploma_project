package ru.intelinvest.tests.api;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.intelinvest.api.portfolio.PortfolioApi;
import ru.intelinvest.config.App;

import static ru.intelinvest.consts.ApiConsts.FORBIDDEN_CODE;
import static ru.intelinvest.consts.ApiConsts.NOT_FOUND_CODE;


@DisplayName("API tests for portfolio overview endpoint")
@Feature("Portfolio")

public class PortfolioOverviewTests extends ApiTestBase {

    @Test
    @DisplayName("Get portfolio overview from another user")
    public void getForeignPortfolioOverviewTest() {
        PortfolioApi.getPortfolioOverview(Integer.valueOf(App.config.foreignPortfolio()), FORBIDDEN_CODE);
    }

    @Test
    @DisplayName("Get portfolio that does not exist")
    public void getNonExistingPortfolioTest() {
        Integer nonExistingPortfolio = 999999;
        PortfolioApi.getPortfolioOverview(nonExistingPortfolio, NOT_FOUND_CODE);
    }
}
