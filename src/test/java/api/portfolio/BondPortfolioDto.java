package api.portfolio;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class BondPortfolioDto {
    List<RowsPortfolioDto> rows;

}
