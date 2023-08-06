package ru.intelinvest.pages.components;

import io.qameta.allure.Step;
import ru.intelinvest.consts.UiConsts;

import static com.codeborne.selenide.Selenide.$;

public class LeftMenuComponent {

    @Step("Open {itemName} screen")
    private void openLeftMenuItem(String itemName) {
        $(String.format("[title='%s']", itemName)).click();
    }

    public LeftMenuComponent openTradesPage() {
        openLeftMenuItem(UiConsts.TRADES);
        return this;
    }

    @Step("Open 'Поиск бумаги' screen")
    public LeftMenuComponent openShareInfoPage() {
        openLeftMenuItem(UiConsts.MARKET);
        $("[href='#/share-info']").click();
        return this;
    }
}
