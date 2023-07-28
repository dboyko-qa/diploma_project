package ru.intelinvest.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TradeModel {
    AssetModel asset;
    Integer quantity;

}
