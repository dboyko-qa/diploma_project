package api.specifications;

import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class SpecsWithoutAuthorization {
    public static RequestSpecification requestGetWithoutAuthorization = with()
            .log().all()
            .filter(withCustomTemplates());
    public static RequestSpecification requestPostWithoutAuthorization = with()
            .log().all()
            .contentType("application/json;charset=UTF-8")
            .filter(withCustomTemplates());
}
