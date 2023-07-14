package api.authorization;

import config.App;
import consts.ApiConsts;

import static consts.ApiConsts.LOGIN_ENDPOINT;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class AuthorizationApi {

    public static final LoginRequestDto loginRequest = LoginRequestDto.builder()
            .type("USERNAME_OR_EMAIL")
            .username(App.config.userName())
            .password(App.config.userPassword())
            .build();

    public static final LoginDto authInfo = given()
                .contentType("application/json;charset=UTF-8")
                .filter(withCustomTemplates())
                .body(loginRequest)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .log().all()
                .extract().as(LoginDto.class);

    }

