package ru.intelinvest.api.authorization;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import ru.intelinvest.api.portfolio.PortfolioInfoDto;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Integer id;
    private Integer currentPortfolioId;
    private List<PortfolioInfoDto> portfolios;
}
