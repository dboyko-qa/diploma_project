package ru.intelinvest.config;

import org.aeonbits.owner.ConfigFactory;

public class Mobile {
    public static MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

}
