package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TopbarComponent {
    @Step("Select currency {0}")
    public void selectCurrency(String currency){
        $(".currency-select").click();
        $("[role='listbox']").$(byText(currency)).click();
        //currency-select
    }

}
