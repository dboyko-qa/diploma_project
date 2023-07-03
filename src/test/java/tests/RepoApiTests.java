package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RepoApiTests {
    @Test
    void createRepoTest(){
        Faker faker = new Faker();
        String repoName = faker.name().title();
        String body =String.format("{\"name\":\"%s\",\"description\":\"This is your first repo! \",\"homepage\":\"https://github.com/\",\"private\":false,\"is_template\":true}", repoName);
        given()
                .header("Authorization", "Bearer " + "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")
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .body(body)
                .when()
                .post("https://api.github.com/user/repos")
                .then()
                .log().all();

    }
}
