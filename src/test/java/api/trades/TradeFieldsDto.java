package api.trades;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class TradeFieldsDto{
    String shareId;
    String ticker;
    @Builder.Default
    String date = ZonedDateTime.now(ZoneId.of( "Africa/Harare" ))
            .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            //ofPattern( "yyyy-MM-dd hh:mm" )
    @Builder.Default String quantity = "10";
    @Builder.Default String price = "175";
    String facevalue;
    String nkd;
    @Builder.Default Boolean perOne = true;
    String fee;
    String feeCurrency;
    String note;
    @Builder.Default Boolean keepMoney = false;
    @Builder.Default String moneyAmount = "1750";
    @Builder.Default String currency = "RUB";


//        String payload = "{\"portfolioId\":588095,\"asset\":\"STOCK\",\"operation\":\"BUY\",\"createLinkedTrade\":false," +
//                "\"eventDate\":null,\"eventPeriod\":null,\"processShareEvent\":false," +
//                "\"fields\":{\"shareId\":\"1075\",\"ticker\":\"GAZP\",\"date\":\"2023-07-06 22:35\"," +
//                "\"quantity\":\"10\",\"price\":\"166.69\",\"facevalue\":null,\"nkd\":null," +
//                "\"perOne\":true,\"fee\":null,\"note\":null,\"keepMoney\":false," +
//                "\"moneyAmount\":\"1666.9\",\"currency\":\"RUB\",\"feeCurrency\":\"RUB\"},\"linkedTradeRequest\":null}";

}
