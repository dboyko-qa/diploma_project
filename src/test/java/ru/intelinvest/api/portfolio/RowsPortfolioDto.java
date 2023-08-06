package ru.intelinvest.api.portfolio;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import ru.intelinvest.api.marketinfo.ShareDto;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RowsPortfolioDto {
    private ShareDto share;
}
