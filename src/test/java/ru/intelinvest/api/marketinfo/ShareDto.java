package ru.intelinvest.api.marketinfo;

import lombok.Data;

@Data
public class ShareDto {
    Integer id;
    String ticker;
    String name;
    String type;
    String lotsize;
    String bigDecimalPrice;
    String currency;
    String isin;
    String shortname;
    String accruedint;
    String facevalue;
}
