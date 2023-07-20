package ru.intelinvest.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssetModel {
    String id;
    String shortName;
    String ticker;
}
