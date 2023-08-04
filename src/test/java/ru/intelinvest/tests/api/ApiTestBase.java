package ru.intelinvest.tests.api;

import io.qameta.allure.Feature;
import ru.intelinvest.models.AssetModel;
import org.junit.jupiter.api.Tag;
import ru.intelinvest.tests.TestBase;

@Tag("API")
public class ApiTestBase extends TestBase {
    AssetModel stockModel = trades.get(0).getAsset();

}
