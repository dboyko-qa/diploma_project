package ru.intelinvest.models;

import lombok.*;

@Data
public class TradeModel {
    AssetModel asset;
    Integer quantity;

    public TradeModel(AssetModel asset, Integer quantity) {
        this.asset = asset;
        this.quantity = quantity;
    }

    public TradeModel() {
    }
}
