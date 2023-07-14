package api.portfolio;

import api.marketinfo.ShareDto;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class RowsPortfolioDto {
    ShareDto share;
}
