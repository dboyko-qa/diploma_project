package ru.intelinvest.activities_mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainActivity {
    @Step("Verify that element {0} exists")
    private void isElementExist(String elementName){
        $(AppiumBy.xpath(String.format("//*[@text='%s']", elementName))).should(Condition.exist);
    }

    @Step("Tap on element {0}")
    private void clickElementByText(String elementName){
        $(AppiumBy.xpath(String.format("//*[@text='%s']", elementName))).click();
    }

    @Step("Verify that screen Портфель is opened")
    public MainActivity isPortfolioScreenOpen(){
        $(AppiumBy.xpath("//*[@text='Портфель']")).should(Condition.exist);
        return this;
    }

    @Step("Open screen 'Еще'")
    public MainActivity openMoreScreen(){
        $(AppiumBy.xpath("//*[@content-desc='Еще, tab, 4 out of 4']")).click();
        return this;
    }

    @Step("Open screen 'Бумаги'")
    public MainActivity openAssetsScreen(){
        $(AppiumBy.xpath("//*[@content-desc='Бумаги, tab, 2 out of 4']")).click();
        return this;
    }

    @Step("Verify that tab Акции exists")
    public MainActivity verifyStocksTabExist(){
        isElementExist("Акции");
        return this;

    }

    @Step("Open tab Акции")
    public MainActivity openStocksTab(){
        clickElementByText("Акции");
        return this;

    }

    @Step("Verify that asset {0} exists in portfolio")
    public MainActivity isAssetExistInPortfolio(String shortName){
        isElementExist(shortName);
        return this;

    }


    @Step("Verify that summary statistics lines are shown for portfolio")
    public MainActivity isSummaryLinesShown() {
        isElementExist("Стоимость");
        isElementExist("Сум. прибыль");
        isElementExist("Изменение за день");
        isElementExist("Доходность");
        return this;
    }

    public MainActivity verifyBondsTabExist() {
        isElementExist("Обл-ии");
        return this;
    }

    public MainActivity openBondsTab(){
        clickElementByText("Обл-ии");
        return this;
    }
}
