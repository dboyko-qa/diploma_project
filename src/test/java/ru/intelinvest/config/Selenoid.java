package ru.intelinvest.config;

import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.sessionId;

public class Selenoid {
    public static SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class, System.getProperties());

    public static URL getVideoUrl() {
        String videoUrl = Selenoid.config.remoteUrl() + "/video/" + sessionId() + ".mp4";
        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
