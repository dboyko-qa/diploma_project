package api.trades;

import api.authorization.AuthorizationApi;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TradeDto {
    @Builder.Default Integer portfolioId = AuthorizationApi.authInfo.getUser().getCurrentPortfolioId();
    String asset;
    String operation;
    @Builder.Default Boolean createLinkedTrade = false;
    String eventDate;
    String eventPeriod;
    @Builder.Default Boolean processShareEvent = false;
    TradeFieldsDto fields;
    String linkedTradeRequest;

}
