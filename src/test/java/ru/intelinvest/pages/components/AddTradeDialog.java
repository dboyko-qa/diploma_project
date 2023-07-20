package ru.intelinvest.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AddTradeDialog {
    @Step("Add asset to portfolio with default quantity 10")
    public AddTradeDialog addTradeToPortfolio(){
        $(byText("Количество")).sibling(0).setValue("10");
        $(byText("Добавить")).click();
        return this;
    }
}
