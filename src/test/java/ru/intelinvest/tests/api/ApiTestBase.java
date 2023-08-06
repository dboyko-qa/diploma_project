package ru.intelinvest.tests.api;

import ru.intelinvest.models.AssetModel;
import org.junit.jupiter.api.Tag;
import ru.intelinvest.testdata.TestData;
import ru.intelinvest.tests.TestBase;

@Tag("API")
public class ApiTestBase extends TestBase {
    AssetModel stockModel = new TestData().getStockAsset();
}
