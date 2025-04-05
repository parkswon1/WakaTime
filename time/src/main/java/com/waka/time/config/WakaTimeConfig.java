package com.waka.time.config;

import com.waka.time.properties.WakaTimeOAuthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WakaTimeOAuthProperties.class)
public class WakaTimeConfig {
}