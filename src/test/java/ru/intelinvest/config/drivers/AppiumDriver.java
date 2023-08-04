package ru.intelinvest.config.drivers;

import com.codeborne.selenide.WebDriverProvider;
import ru.intelinvest.config.App;
import ru.intelinvest.config.Mobile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;

public class AppiumDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Mobile.config.mobileUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(Mobile.config.mobilePlatformName())
                .setDeviceName(Mobile.config.mobileDeviceName())
                .setPlatformVersion(Mobile.config.mobileVersion())
                .setApp(new File(App.config.mobileAppPath()).getAbsolutePath())
                .setAppPackage(App.config.mobileAppPackage())
                .setAppActivity(App.config.mobileAppActivity());
        System.out.println(options);
        return new AndroidDriver(getAppiumServerUrl(), options);
    }
}
