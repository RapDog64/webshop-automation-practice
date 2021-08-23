package com.demowebshop.configuration.env;

import org.aeonbits.owner.ConfigFactory;

public class ApplicationConfigImpl {

    public static final ApplicationConfig config = ConfigFactory.create(ApplicationConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoTurnedOn() {
        return !config.videoStorage().equals("");
    }
}
