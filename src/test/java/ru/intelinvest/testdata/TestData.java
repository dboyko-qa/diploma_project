package ru.intelinvest.testdata;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ru.intelinvest.models.AssetModel;
import ru.intelinvest.models.TradeModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class TestData {
    private ClassLoader classLoader = TestData.class.getClassLoader();
    private Gson gson = new Gson();
    private final String JSON_FILE_TRADES_DATA = "testdata/tradesdata.json";
    private final String JSON_FILE_STOCK_ASSET = "testdata/stockasset.json";

    public List<TradeModel> getTradesList() {

        try (InputStream inputStream = classLoader.getResourceAsStream(JSON_FILE_TRADES_DATA);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {

            return gson.fromJson(inputStreamReader, new TypeToken<List<TradeModel>>() {}.getType());

        } catch (IOException e) {
            System.out.printf("Error reading file %s %n", JSON_FILE_TRADES_DATA);
            throw new RuntimeException(e);
        }
    }

    public AssetModel getStockAsset() {
        Gson gson = new Gson();

        try (InputStream inputStream = classLoader.getResourceAsStream(JSON_FILE_STOCK_ASSET);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {

            return gson.fromJson(inputStreamReader, AssetModel.class);

        } catch (IOException e) {
            System.out.printf("Error reading file %s %n", JSON_FILE_STOCK_ASSET);
            throw new RuntimeException(e);
        }
    }
}
