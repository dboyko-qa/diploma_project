package ru.intelinvest.models;

import lombok.Builder;
import lombok.Data;
import ru.intelinvest.api.enums.Assets;

@Data
@Builder
public class AssetModel {
    String id;
    String shortName;
    String ticker;
    Assets assetType;
}
