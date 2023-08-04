package ru.intelinvest.api.marketinfo;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfoDto {
    private ShareDto share;
}
