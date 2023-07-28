package ru.intelinvest.activities_mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import ru.intelinvest.config.App;

import static com.codeborne.selenide.Selenide.$;

public class SettingsActivity {
    @Step("Open screen Настройки")
    public SettingsActivity openActivity(){
        $(AppiumBy.xpath("//*[@text='Настройки']")).click();
        return this;
    }

    @Step("Open screen Основные")
    public SettingsActivity openBasic(){
        $(AppiumBy.xpath("//*[@text='Основные']")).click();
        return this;
    }

    @Step("Verify that user {0} is logged in")
    public SettingsActivity verifyLoginUser(String userName) {
        $(AppiumBy.xpath(String.format("//*[@text='%s']", userName))).should(Condition.exist);
        return this;
    }
}
