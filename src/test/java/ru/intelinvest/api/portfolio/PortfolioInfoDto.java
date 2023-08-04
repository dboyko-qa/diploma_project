package ru.intelinvest.api.portfolio;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioInfoDto {
    Integer id;
    String name;
    String viewCurrency;
    String status;
}
