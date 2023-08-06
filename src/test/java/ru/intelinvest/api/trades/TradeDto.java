package ru.intelinvest.api.trades;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import ru.intelinvest.api.authorization.AuthorizationApi;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeDto {
    @Builder.Default
    private Integer portfolioId = AuthorizationApi.authInfo.getUser().getCurrentPortfolioId();
    private String asset;
    private String operation;
    @Builder.Default
    private Boolean createLinkedTrade = false;
    private String eventDate;
    private String eventPeriod;
    @Builder.Default
    private Boolean processShareEvent = false;
    private TradeFieldsDto fields;
    private String linkedTradeRequest;
}
