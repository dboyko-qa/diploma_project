package ru.intelinvest.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PortfolioPage {

    public static final String PAGE_TITLE = "Портфель";

    //отсюда читать title
    ElementsCollection assetsShortNames = $$(".share-table tr.selectable div.table-ellipsis.w100pc");
    ElementsCollection assetsTickers = $$(".share-table tr.selectable div.ellipsis");

    @Step("Verify that Portfolio page opened")
    public PortfolioPage verifyOpened(){
        $(".page-title").should(Condition.have(Condition.text(PAGE_TITLE)));
        return this;
    }

    @Step("Open Portfolio page")
    public PortfolioPage openPage(){
        open("/app/#/portfolio");
        return this;
    }

    @Step("Verify currency sign")
    public PortfolioPage verifyCurrencySign(String currency){
        $(".dashboard-currency").shouldHave(Condition.cssClass(currency.toLowerCase()));
        return this;
    }

    @Step("Verify {0} tab exists")
    public PortfolioPage verifyTabExists(String tabName){
        $(".v-slide-group__wrapper").$(byText(tabName)).should(Condition.exist);
        return this;
    }

    @Step("Open tab {0}")
    public PortfolioPage openTab(String tabName){
        $(".v-slide-group__wrapper").$(byText(tabName)).click();
        return this;
    }

    private void verifyValuesInTable(ElementsCollection elements, ArrayList<String> expectedValues){
        //wait when elements are shown on page
        elements.shouldHave(size(expectedValues.size()));

        //get title attributes
        List<String> elementsTitles = elements.attributes("title");

        //sort both lists as they are compared each to each elements
        Collections.sort(elementsTitles);
        Collections.sort(expectedValues);

        //compare lists using equals method.ShouldHave method from Selenide is not useful as it doesn't compare sorted lists
        Assertions.assertTrue(elementsTitles.equals(expectedValues));

    }

    @Step("Verify that short names in list coincide with expected values")
    public PortfolioPage verifyShortNamesList(ArrayList<String> expectedTexts){
        verifyValuesInTable(assetsShortNames, expectedTexts);
        return this;
    }

    @Step("Verify that tickers in list coincide with expected values")
    public PortfolioPage verifyTickers(ArrayList<String> expectedTickers) {
        verifyValuesInTable(assetsTickers, expectedTickers);
        return this;

    }
}
