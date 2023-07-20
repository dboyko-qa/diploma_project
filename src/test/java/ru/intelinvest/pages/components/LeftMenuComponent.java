package ru.intelinvest.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LeftMenuComponent {
    //constants for menu names
    public final String MARKET = "Рынок",
                        TRADES = "Сделки";

    @Step("Open {itemName} screen")
    private void openLeftMenuItem(String itemName){
        $(String.format("[title='%s']", itemName)).click();
    }

    public LeftMenuComponent openTradesPage(){
        openLeftMenuItem(TRADES);
        return this;
    }

    @Step("Open 'Поиск бумаги' screen")
    public LeftMenuComponent openShareInfoPage(){
        openLeftMenuItem(MARKET);
        $("[href='#/share-info']").click();
        return this;
    }

}
