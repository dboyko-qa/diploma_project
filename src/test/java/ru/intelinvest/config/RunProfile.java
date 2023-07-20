package ru.intelinvest.config;

import org.aeonbits.owner.ConfigFactory;

public class RunProfile {
    public static RunProfileConfig config = ConfigFactory.create(RunProfileConfig.class, System.getProperties());

    public static Boolean isRemoteWeb(){
        return (RunProfile.config.remoteWebDriver() != null && !RunProfile.config.remoteWebDriver().isEmpty());
    }
    public static Boolean isRemoteMobile(){
        return (RunProfile.config.remoteMobileUrl() != null && !RunProfile.config.remoteMobileUrl().isEmpty());
    }
}
