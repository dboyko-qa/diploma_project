package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.options;

public class IntelInvest {
    @Test
    void iiTest(){
        String token = given()
                .contentType("application/json;charset=UTF-8")
                .body("{\"type\":\"USERNAME_OR_EMAIL\",\"username\":\"dbtest1983@gmail.com\",\"password\":\"eYUZcEz5GL\"}")
                .when()
                .post("https://intelinvest.ru/api/user/login")
                .then()
                .log().all()
                .extract().body().path("token");

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .post("https://intelinvest.ru/api/portfolios/588099/default");

    }

    @Test
    @Tag("Jenkins")
    void loginTest(){
        open("https://intelinvest.ru/");
        $(".nav-link [data-modal='.enter']").click();
        $("input[name='username']").setValue("dbtest1983@gmail.com");
        $("input[name='password']").setValue("eYUZcEz5GL");
        $(".default-btn.primary").click();
        $("[title='Рынок']").click();
        $("[href='#/share-info']").click();
        $(".info-share-page__name-stock-block__btns").click();
        $(byText("Количество")).sibling(0).setValue("10");
        $(byText("Добавить")).click();
        $("[title='Сделки']").click();
        $("tbody tr .menuDots").click();
        $(".delete-btn").click();


        sleep(5000);
    }
}
