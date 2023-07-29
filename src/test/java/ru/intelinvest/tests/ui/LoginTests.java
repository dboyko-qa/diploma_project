package ru.intelinvest.tests.ui;

import ru.intelinvest.config.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

@DisplayName("Web tests for login functionality")
public class LoginTests extends UiTestBase {
    @Test
    @DisplayName("Verify successful login")
    public void testLogin(){
        mainPage.login(App.config.userName(), App.config.userPassword());
        portfolioPage.verifyOpened();

        sleep(5000);
    }

    @Test
    @DisplayName("Verify error message when password is incorrect")
    public void invalidLoginTest(){
        //ввести неверный пароль. проверить, что получаем ошибку
        mainPage.login(App.config.userName(), App.config.userPassword() + "1")
                .verifyErrorMessageIncorrectUserPassword();

    }
}
