package tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class AuthorizationTest extends TestBase{

    void login(){
        open("https://github.com/login");
        sleep(5000);
        $("#login_field").setValue("dbtest1983@gmail.com");
        $("#password").setValue("oqdBkMu6A0");
        sleep(5000);
        $("[name='commit']").click();
        sleep(5000);

    }
    @Test
    void authorizationTest(){
        login();
        $("[name='user-login']").shouldHave(Condition.attribute("content", "DBtest1983"));    }

    @Test
    @Tag("Jenkins")
    void createRepoTest(){
        // create repo via API
        Faker faker = new Faker();
        String repoName = faker.name().username();
        System.out.println(repoName);
        String body =String.format("{\"name\":\"%s\",\"description\":\"This is your first repo! \",\"homepage\":\"https://github.com/\",\"private\":false,\"is_template\":true}", repoName);
        given()
                .header("Authorization", "Bearer " + "gith" +
                        "ub_pat_11BA" +
                        "7FJXQ0VqFn7EmdQCnr_9mwRM" +
                        "dLkPAC2DHFGoVcNsyvBzyq18T" +
                        "YqGaYyyXKKzbzBETRDP" +
                        "WVPLVcj7HM")
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .body(body)
                .when()
                .post("https://api.github.com/user/repos")
                .then()
                .log().all();

        login();
        $(String.format("[href='/DBtest1983/%s']", repoName)).should(Condition.exist);
        $(String.format("[href='/DBtest1983/%s']", repoName)).click();

        //delete repository via api
        given()
                .header("Authorization", "Bearer " + "gith" +
                        "ub_pat_11BA" +
                        "7FJXQ0VqFn7EmdQCnr_9mwRM" +
                        "dLkPAC2DHFGoVcNsyvBzyq18T" +
                        "YqGaYyyXKKzbzBETRDP" +
                        "WVPLVcj7HM")
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .when()
                .delete("https://api.github.com/repos/DBtest1983/" + repoName)
                .then()
                .statusCode(204)
                .log().all();


    }
}
