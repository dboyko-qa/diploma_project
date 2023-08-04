package ru.intelinvest.activities;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ImportPortfolioActivity {

    private SelenideElement skipButton = $(AppiumBy.xpath("//*[@text='Пропустить']"));

    @Step("Click button Пропустить in Import from brokers screen")
    public ImportPortfolioActivity clickSkipButton() {
        skipButton.should(Condition.exist);
        skipButton.click();
        return this;
    }
}
