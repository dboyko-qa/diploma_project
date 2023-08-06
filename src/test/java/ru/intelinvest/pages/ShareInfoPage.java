package ru.intelinvest.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShareInfoPage {

    @Step("Open Share info page")
    public ShareInfoPage openPage(){
        open("/app/#/share-info");
        return this;
    }

    @Step("Click 'Добавить в портфель' button")
    public ShareInfoPage clickAddToPortfolioButton(){
        $(".info-share-page__name-stock-block__btns").click();
        return this;
    }
}
