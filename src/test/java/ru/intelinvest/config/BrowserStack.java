package ru.intelinvest.config;

import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserStack {

    public static BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    public static String getVideoUrl(String sessionId) {
        String url = format(config.remoteAPIUrl() + "/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.userName(), config.accessKey())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
