package ru.intelinvest.activities;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ImportPortfolioActivity {
    @Step("Click button Пропустить in Import from brokers screen")
    public ImportPortfolioActivity skip(){
        $(AppiumBy.xpath("//*[@text='Пропустить']")).should(Condition.exist);
        $(AppiumBy.xpath("//*[@text='Пропустить']")).click();

        return this;
    }
}
