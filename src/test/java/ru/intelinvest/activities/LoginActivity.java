package ru.intelinvest.activities;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginActivity {
    @Step("Login to application with username {0} and password {1}")
    public LoginActivity login(String username, String password){
        $(AppiumBy.xpath("//*[@text='Войти']")).click();
        $(AppiumBy.xpath("//*[@text='Введите Email']")).sendKeys(username);
        $(AppiumBy.xpath("//*[@text='Пароль']")).sendKeys(password);
        $$(AppiumBy.xpath("//*[@text='Войти']")).get(1).click();
        return this;
    }

    @Step("Verify that error message about incorrect user or password exists")
    public LoginActivity verifyWrongUserOrPasswordMessageShown(){
        $(AppiumBy.xpath("//*[@text='Неверное имя пользователя или пароль']")).should(Condition.exist);
        return this;
    }

    @Step("Verify that screen Регистрация opened")
    public LoginActivity verifyRegistrationScreenOpened(){
        $(AppiumBy.xpath("//*[@text='Регистрация']")).should(Condition.exist);
        return this;
    }
}
