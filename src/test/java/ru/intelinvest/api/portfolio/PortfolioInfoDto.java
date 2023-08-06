package ru.intelinvest.api.portfolio;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioInfoDto {
    private Integer id;
    private String name;
    private String viewCurrency;
    private String status;
}
