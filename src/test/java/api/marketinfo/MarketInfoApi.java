package api.marketinfo;
import api.authorization.AuthorizationApi;
import io.qameta.allure.Step;

import static api.specifications.Specs.requestGetSpec;
import static consts.ApiConsts.MARKET_INFO_ENDPOINT;
import static io.restassured.RestAssured.given;
public class MarketInfoApi {

    @Step("Get info for asset with id = {0}")
    public static MarketInfoDto getMarketInfo(String id){
        return given()
                .spec(requestGetSpec)
                .when()
                .get(String.format(MARKET_INFO_ENDPOINT, id))
                .then()
                //.log().all()
                .extract().as(MarketInfoDto.class);
    }
}
