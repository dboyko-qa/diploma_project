package ru.intelinvest.helpers;

import ru.intelinvest.api.ApiErrorDto;
import org.junit.jupiter.api.Assertions;

import static io.qameta.allure.Allure.step;

public class Common {

    public static void verifyResultMessage(ApiErrorDto error, String resultMessage){
        step("Verify result message is " + resultMessage, () ->
                Assertions.assertTrue(error.getMessage().equals(resultMessage)));

    }
}
