package ru.intelinvest.api.trades;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteTradeRequestDto {
    String shareType;
    Integer shareIssuerId;
    Integer portfolioId;
}
