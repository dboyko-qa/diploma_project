package ru.intelinvest.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.intelinvest.config.App;

public class LoginTests extends MobileTestBase{

    @Test
    @DisplayName("Verify successful login")
    public void loginTest(){
        loginActivity.login(App.config.userName(), App.config.userPassword());
        importPortfolioActivity.skip();
        mainActivity.isPortfolioScreenOpened()
                    .openMoreScreen();
        settingsActicity.openActivity()
                        .openBasic()
                        .verifyLoginUser(App.config.userName());

    }

    @Test
    @DisplayName("Verify error message when password is incorrect")
    public void incorrectPasswordTest(){
        loginActivity.login(App.config.userName(), App.config.userPassword() + "1")
                .verifyWrongUserOrPasswordMessageShown();

    }

    @Test
    @DisplayName("Verify that application is opened with Registration screen")
    public void registrationScreenTest(){
        loginActivity.verifyRegistrationScreenOpened();
    }
}
