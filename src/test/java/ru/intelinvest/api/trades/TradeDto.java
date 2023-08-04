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
    Integer portfolioId = AuthorizationApi.authInfo.getUser().getCurrentPortfolioId();
    String asset;
    String operation;
    @Builder.Default
    Boolean createLinkedTrade = false;
    String eventDate;
    String eventPeriod;
    @Builder.Default
    Boolean processShareEvent = false;
    TradeFieldsDto fields;
    String linkedTradeRequest;

}
