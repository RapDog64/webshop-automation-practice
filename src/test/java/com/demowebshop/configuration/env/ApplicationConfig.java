package com.demowebshop.configuration.env;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/file-run-example.properties"
})
public interface ApplicationConfig extends Config {

    String userEmail();
    String userPassword();
    String webUrl();
    String apiUrl();
    String browser();
    String browserVersion();

    @DefaultValue("")
    String remoteDriverUrl();
    @DefaultValue("")
    String videoStorage();
}
