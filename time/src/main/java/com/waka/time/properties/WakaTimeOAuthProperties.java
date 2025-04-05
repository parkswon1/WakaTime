package com.waka.time.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "wakatime")
public class WakaTimeOAuthProperties {

    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;

    public WakaTimeOAuthProperties(String clientId, String clientSecret, String redirectUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
    }
}
