package ru.intelinvest.api.specifications;

import io.restassured.specification.RequestSpecification;
import ru.intelinvest.helpers.CustomAllureListener;

import static io.restassured.RestAssured.with;

public class SpecsWithoutAuthorization {

    public static RequestSpecification requestGetWithoutAuthorization = with()
            .log().all()
            .filter(CustomAllureListener.withCustomTemplates());

    public static RequestSpecification requestPostWithoutAuthorization = with()
            .log().all()
            .contentType("application/json;charset=UTF-8")
            .filter(CustomAllureListener.withCustomTemplates());
}
