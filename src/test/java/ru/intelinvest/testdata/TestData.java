package ru.intelinvest.testdata;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ru.intelinvest.models.TradeModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class TestData {
    private ClassLoader classLoader = TestData.class.getClassLoader();
    private final String JSON_FILE_TRADES_DATA = "testdata/tradesdata.json";

    public List<TradeModel> getTradesList(){
        Gson gson = new Gson();

        try (InputStream inputStream = classLoader.getResourceAsStream(JSON_FILE_TRADES_DATA);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream)){
            return gson.fromJson(inputStreamReader, new TypeToken<List<TradeModel>>(){}.getType());

        } catch (IOException e) {
            System.out.printf("Error reading file %s %n", JSON_FILE_TRADES_DATA);
            throw new RuntimeException(e);
        }
    }

}
