package ru.intelinvest.tests.api;

import io.qameta.allure.Feature;
import ru.intelinvest.models.AssetModel;
import org.junit.jupiter.api.Tag;
import ru.intelinvest.tests.TestBase;

@Tag("API")
public class ApiTestBase extends TestBase {
    AssetModel stockModel = AssetModel.builder().id("1344").ticker("SBER").shortName("Сбербанк").build();
    AssetModel bondModel = AssetModel.builder().id("17803").ticker("SU26230RMFS1").shortName("ОФЗ 26230").build();

}
