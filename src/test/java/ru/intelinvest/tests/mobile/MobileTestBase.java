package ru.intelinvest.tests.mobile;

import com.codeborne.selenide.logevents.SelenideLogger;
import ru.intelinvest.helpers.ConfigRunner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import ru.intelinvest.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;

@Tag("ANDROID")
public class MobileTestBase extends TestBase {
    @BeforeAll
    public static void beforeAll(){
        ConfigRunner.runMobile();

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
//        Duration duration = Duration.of(60, ChronoUnit.SECONDS);
//        getWebDriver().manage().timeouts().pageLoadTimeout(duration);

    }

    @AfterEach
    void afterEach() {
        ConfigRunner.finishMobile();

    }

}
