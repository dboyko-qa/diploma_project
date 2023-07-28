package ru.intelinvest.api.marketinfo;
import io.qameta.allure.Step;
import ru.intelinvest.api.specifications.Specs;

import static ru.intelinvest.consts.ApiConsts.MARKET_INFO_ENDPOINT;
import static io.restassured.RestAssured.given;
public class MarketInfoApi {

    @Step("Get info for asset with id = {0}")
    public static MarketInfoDto getMarketInfo(String id){
        return given()
                .spec(Specs.requestGetSpec)
                .when()
                .get(String.format(MARKET_INFO_ENDPOINT, id))
                .then()
                .extract().as(MarketInfoDto.class);
    }
}
