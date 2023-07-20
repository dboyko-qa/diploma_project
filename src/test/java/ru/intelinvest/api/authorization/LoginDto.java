package ru.intelinvest.api.authorization;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginDto {
    String token;
    String refreshToken;

    UserDto user;


}
