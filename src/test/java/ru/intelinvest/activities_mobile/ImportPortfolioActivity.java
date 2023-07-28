package ru.intelinvest.activities_mobile;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ImportPortfolioActivity {
    @Step("Click button Пропустить in Import from brockers screen")
    public ImportPortfolioActivity skip(){
        $(AppiumBy.xpath("//*[@text='Пропустить']")).click();

        return this;
    }
}
