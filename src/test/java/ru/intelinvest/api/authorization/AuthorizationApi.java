package ru.intelinvest.api.authorization;

import ru.intelinvest.config.App;
import ru.intelinvest.helpers.CustomAllureListener;

import static ru.intelinvest.api.specifications.Specs.responseSpec;
import static ru.intelinvest.consts.ApiConsts.LOGIN_ENDPOINT;
import static io.restassured.RestAssured.given;

public class AuthorizationApi {

    public static final LoginRequestDto loginRequest = LoginRequestDto.builder()
            .type("USERNAME_OR_EMAIL")
            .username(App.config.userName())
            .password(App.config.userPassword())
            .build();

    public static final LoginDto authInfo = given()
                .contentType("application/json;charset=UTF-8")
                .filter(CustomAllureListener.withCustomTemplates())
                .body(loginRequest)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .log().status()
                .log().body()
                .extract().as(LoginDto.class);

    }

