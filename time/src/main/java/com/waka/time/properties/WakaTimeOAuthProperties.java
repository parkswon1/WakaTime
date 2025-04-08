package com.waka.time.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <h1>WakaTime OAuth 설정 클래스</h1>
 * <ul>
 *   <li>WakaTime OAuth 연동에 필요한 설정 값을 주입받는다.</li>
 *   <li>application.yml 또는 application.properties의 wakatime.* 값을 자동 바인딩한다.</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-04-08
 */
@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "wakatime")
public class WakaTimeOAuthProperties {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String oauthUrl;
    private String apiUrl;
}