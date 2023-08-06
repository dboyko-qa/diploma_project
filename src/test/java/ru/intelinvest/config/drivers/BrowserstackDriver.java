package ru.intelinvest.config.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.intelinvest.config.BrowserStack;
import ru.intelinvest.config.Mobile;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", BrowserStack.config.userName());
        mutableCapabilities.setCapability("browserstack.key", BrowserStack.config.accessKey());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", BrowserStack.config.appUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", Mobile.config.mobileDeviceName());
        mutableCapabilities.setCapability("os_version", Mobile.config.mobileVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        System.out.println(mutableCapabilities);
        try {
            return new RemoteWebDriver(
                    new URL(BrowserStack.config.remoteDriverUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
