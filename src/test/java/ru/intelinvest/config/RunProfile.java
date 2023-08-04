package ru.intelinvest.config;

import org.aeonbits.owner.ConfigFactory;

public class RunProfile {
    public static RunProfileConfig config = ConfigFactory.create(RunProfileConfig.class, System.getProperties());

}
