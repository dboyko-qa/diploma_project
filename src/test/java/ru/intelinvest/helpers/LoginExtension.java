package ru.intelinvest.helpers;

import ru.intelinvest.api.authorization.AuthorizationApi;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;

public class LoginExtension implements BeforeEachCallback {
    private final String REFRESH_TOKEN = "INTELINVEST-REFRESH-TOKEN",
                        TOKEN = "INTELINVEST_TOKEN";
    @Override
    @Step("Login to site")
    public void beforeEach(ExtensionContext context){
        open("/app/favicons/favicon.ico");
        localStorage().setItem(REFRESH_TOKEN, String.format("\"%s\"",  AuthorizationApi.authInfo.getRefreshToken()));
        localStorage().setItem(TOKEN, String.format("\"%s\"",  AuthorizationApi.authInfo.getToken()));
    }
}
