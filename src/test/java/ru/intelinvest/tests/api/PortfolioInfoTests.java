package ru.intelinvest.tests.api;

import ru.intelinvest.api.authorization.AuthorizationApi;
import ru.intelinvest.api.portfolio.PortfolioApi;
import ru.intelinvest.api.portfolio.PortfolioInfoDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static ru.intelinvest.consts.ApiConsts.OK_CODE;
import static io.qameta.allure.Allure.step;

@Tag("Jenkins")

public class PortfolioInfoTests {

    @Test
    @DisplayName("Verify that portfolio with corresponding id is returned")
    public void correctPortfolioIdReturnedTest(){
        Integer portfolioId = AuthorizationApi.authInfo.getUser().getCurrentPortfolioId();
        PortfolioInfoDto portfolio = PortfolioApi.getPortfolioInfo(portfolioId, OK_CODE);

        step("Verify that correct portfolio id is returned",
                () -> Assertions.assertTrue(portfolioId.equals(portfolio.getId())));
    }
}
