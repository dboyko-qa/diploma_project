package ru.intelinvest.models;

import lombok.*;
import ru.intelinvest.api.enums.Assets;

@Data
public class AssetModel {
    private String id;
    private String shortName;
    private String ticker;
    private Assets assetType;

    public AssetModel(String id, String shortName, String ticker, Assets assetType) {
        this.id = id;
        this.shortName = shortName;
        this.ticker = ticker;
        this.assetType = assetType;
    }

    public AssetModel(){}
}
