package ru.intelinvest.tests.mobile;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginTests extends MobileTestBase{

    @Test
    public void loginTest(){

        $(AppiumBy.xpath("//*[@text='Войти']")).click();
        sleep(5000);
    }
}
