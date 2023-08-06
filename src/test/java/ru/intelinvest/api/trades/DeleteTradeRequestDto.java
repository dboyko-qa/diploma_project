package ru.intelinvest.api.trades;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteTradeRequestDto {
    private String shareType;
    private Integer shareIssuerId;
    private Integer portfolioId;
}
