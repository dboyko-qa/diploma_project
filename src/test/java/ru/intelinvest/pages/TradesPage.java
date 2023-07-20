package ru.intelinvest.pages;

import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TradesPage {

    public static final String PAGE_TITLE = "Сделки";

    @Step("Delete first trade in the list of trades")
    public TradesPage deleteFirstTrade(){
        $("tbody tr .menuDots").click();
        $(".delete-btn").click();
        return this;
    }

    @Step("Verify that Trades page opened")
    public TradesPage verifyOpened(){
        $(".v-expansion-panel-header").shouldHave(text(PAGE_TITLE));
        return this;
    }

}
