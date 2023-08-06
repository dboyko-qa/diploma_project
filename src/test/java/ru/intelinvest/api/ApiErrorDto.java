package ru.intelinvest.api;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorDto {
    private String errorCode;
    private String message;
}
