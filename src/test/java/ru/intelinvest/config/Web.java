package ru.intelinvest.config;

import org.aeonbits.owner.ConfigFactory;

public class Web {
    public static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

}
