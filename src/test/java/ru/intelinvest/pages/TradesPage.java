package ru.intelinvest.pages;

import static com.codeborne.selenide.Condition.*;

import io.qameta.allure.Step;
import ru.intelinvest.consts.UiConsts;

import static com.codeborne.selenide.Selenide.$;

public class TradesPage {

    @Step("Delete first trade in the list of trades")
    public TradesPage deleteFirstTrade() {
        $("tbody tr .menuDots").click();
        $(".delete-btn").click();
        return this;
    }

    @Step("Verify that Trades page opened")
    public TradesPage verifyOpened() {
        $(".v-expansion-panel-header").shouldHave(text(UiConsts.TRADES_PAGE_TITLE));
        return this;
    }

}
