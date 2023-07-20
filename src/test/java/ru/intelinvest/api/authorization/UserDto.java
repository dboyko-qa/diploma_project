package ru.intelinvest.api.authorization;

import ru.intelinvest.api.portfolio.PortfolioInfoDto;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    Integer id;
    Integer currentPortfolioId;
    List<PortfolioInfoDto> portfolios;

}
