package ru.intelinvest.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AddTradeDialog {

    @Step("Add asset to portfolio with quantity {0}")
    public AddTradeDialog addTradeToPortfolio(Integer quantity) {
        $(byText("Количество")).sibling(0).setValue(quantity.toString());
        $(byText("Добавить")).click();
        return this;
    }
}
