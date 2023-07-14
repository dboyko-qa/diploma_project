package api.specifications;

import api.authorization.AuthorizationApi;
import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification requestPostSpec = with()
            .header("Authorization", "Bearer " + AuthorizationApi.authInfo.getToken())
            .contentType("application/json;charset=UTF-8")
            .log().all()
            .filter(withCustomTemplates());
    public static RequestSpecification requestGetSpec = with()
            .header("Authorization", "Bearer " + AuthorizationApi.authInfo.getToken())
            .log().all()
            .filter(withCustomTemplates());

}
