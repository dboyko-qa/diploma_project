package ru.intelinvest.api.trades;

import com.google.gson.annotations.SerializedName;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeFieldsDto {
    private String shareId;
    private String ticker;
    @Builder.Default
    private String date = ZonedDateTime.now(ZoneId.of("Africa/Harare"))
            .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    @Builder.Default
    private String quantity = "10";
    @Builder.Default
    private String price = "175";
    @SerializedName("facevalue")
    private String faceValue;
    private String nkd;
    @Builder.Default
    private Boolean perOne = true;
    private String fee;
    private String feeCurrency;
    private String note;
    @Builder.Default
    private Boolean keepMoney = false;
    @Builder.Default
    private String moneyAmount = "1750";
    @Builder.Default
    private String currency = "RUB";
}
