package ru.intelinvest.tests.ui;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.intelinvest.config.App;

@Feature("Login")
@DisplayName("Web tests for login functionality")
public class LoginTests extends UiTestBase {

    @Test
    @DisplayName("Verify successful login")
    public void successfulLoginTest() {
        mainPage.login(App.config.userName(), App.config.userPassword());
        portfolioPage.verifyOpened();
    }

    @Test
    @DisplayName("Verify error message when password is incorrect")
    public void invalidLoginTest() {
        //ввести неверный пароль. проверить, что получаем ошибку
        mainPage.login(App.config.userName(), App.config.userPassword() + "1")
                .verifyErrorMessageIncorrectUserPassword();
    }
}
