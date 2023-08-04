package ru.intelinvest.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String LOGIN_ERROR_MESSAGE="Неверное имя пользователя или пароль";

    SelenideElement errorMessageLabel = $(".modal-text-error");

    @Step("Login in browser using username and password")
    public MainPage login(String userName, String password){
        open("");
        $(".nav-link [data-modal='.enter']").should(Condition.exist);
        $(".nav-link [data-modal='.enter']").click();
        $("input[name='username']").setValue(userName);
        $("input[name='password']").setValue(password);
        $(".default-btn.primary").click();
        return this;
    }

    @Step("Verify that error message \"Неверное имя пользователя или пароль\" is shown")
    public MainPage verifyErrorMessageIncorrectUserPassword(){
        errorMessageLabel.shouldHave(Condition.text(LOGIN_ERROR_MESSAGE));
        return this;
    }
}
