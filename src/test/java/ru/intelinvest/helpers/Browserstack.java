package ru.intelinvest.helpers;

import ru.intelinvest.config.RunProfile;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;


public class Browserstack {

    public static String videoUrl(String sessionId) {
        String url = format(RunProfile.config.remoteMobileAPIUrl() + "/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(RunProfile.config.bsUserName(), RunProfile.config.bsAccessKey())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
