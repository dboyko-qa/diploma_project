package ru.intelinvest.helpers.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.intelinvest.config.RunProfile;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", RunProfile.config.bsUserName());
        mutableCapabilities.setCapability("browserstack.key", RunProfile.config.bsAccessKey());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", RunProfile.config.bsAppUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", RunProfile.config.mobileDeviceName());
        mutableCapabilities.setCapability("os_version", RunProfile.config.mobileVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(RunProfile.config.remoteMobileUrl()), mutableCapabilities);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
