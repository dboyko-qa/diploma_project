package ru.intelinvest.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorDto {
    private String errorCode;
    private String message;
}
