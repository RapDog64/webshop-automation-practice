package com.demowebshop.configuration.env;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/file-run-example.properties"
})
public interface ApplicationConfig extends Config {

    @Config.Key("webUrl")
    String webUrl();

    @Config.Key("apiUrl")
    String apiUrl();

    @Config.Key("browser")
    String browser();

    @Config.Key("browserVersion")
    String browserVersion();

    @Config.Key("remoteDriverUrl")
    @DefaultValue("")
    String remoteDriverUrl();

    @DefaultValue("")
    @Config.Key("videoStorage")
    String videoStorage();
}
