package ru.intelinvest.api.marketinfo;

import com.google.gson.annotations.SerializedName;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShareDto {
    private Integer id;
    private String ticker;
    private String name;
    private String type;
    @SerializedName("lotsize")
    private String lotSize;
    private String bigDecimalPrice;
    private String currency;
    private String isin;
    @SerializedName("shortname")
    private String shortName;
    private String accruedint;
    @SerializedName("facevalue")
    private String faceValue;
}
