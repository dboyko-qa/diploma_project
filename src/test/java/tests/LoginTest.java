package tests;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class LoginTest {

    @Test
    void loginViaApi(){
        Map<String, String> initialCookis = given()
                .cookie("dotcom_user", "dbtest1983@gmail.com")
                .cookie("logged_in", "yes")
        .get("https://github.com/")
                .then()
                .extract().cookies();
//
//        Map<String, String> firstCookies = given()
//                .log().all()
//                .cookies(initialCookis)
//                .get("https://github.com/u2f/login_fragment")
//                .then()
//                .log().all()
//                .extract().cookies();
//        System.out.println("----------------------------------------------");

        Map<String, String> secondCookies = given()
                .cookies(initialCookis)
                .cookie("dotcom_user", "dbtest1983@gmail.com")
                .log().all()
                .contentType("application/x-www-form-urlencoded")
                .accept("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                .header("Authorization", "Bearer " + "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")
//                .formParam("login", "dbtest1983%40gmail.com")
//                .formParam("password", "oqdBkMu6A0")
//                .formParam("commit", "Sign in")
//                .formParam("webauthn-support", "supported")
//                .formParam("webauthn-iuvpaa-support", "supported")
//                .formParam("return_to", "https%3A%2F%2Fgithub.com%2Flogin")
//                .formParam("authenticity_token", "Uwe9kRYMhKSqxgjD%2BBTNsWvaWqo5HW1Dk%2Bii9mUqG97qgYAYC4CSmEg7eTjp3XsLAGINRa%2BcVN6RSvnbDXVFlA%3D%3D")
                .log().all()
                .when()
                .post("https://github.com/session")
                .then()
                .log().all()
                .extract().cookies();


//        open("https://github.githubassets.com/favicons/favicon.svg");
//        for (Map.Entry<String, String> entry: secondCookies.entrySet()){
//            Cookie cookie = new Cookie(entry.getKey(), entry.getValue());
//            getWebDriver().manage().addCookie(cookie);
//        }
//        open("https://github.com/");
//        sleep(5000);
    }
}
