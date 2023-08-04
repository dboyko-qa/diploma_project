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
    String shareId;
    String ticker;
    @Builder.Default
    String date = ZonedDateTime.now(ZoneId.of("Africa/Harare"))
            .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    @Builder.Default
    String quantity = "10";
    @Builder.Default
    String price = "175";
    @SerializedName("facevalue")
    String faceValue;
    String nkd;
    @Builder.Default
    Boolean perOne = true;
    String fee;
    String feeCurrency;
    String note;
    @Builder.Default
    Boolean keepMoney = false;
    @Builder.Default
    String moneyAmount = "1750";
    @Builder.Default
    String currency = "RUB";
}
