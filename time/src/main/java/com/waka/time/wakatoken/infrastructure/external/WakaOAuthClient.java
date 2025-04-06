package com.waka.time.wakatoken.infrastructure.external;

import com.waka.time.properties.WakaTimeOAuthProperties;
import com.waka.time.wakatoken.domain.model.WakaToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>WakaTime OAuth 클라이언트</h1>
 * WakaTime에 인증 코드를 보내고 토큰을 받아오는 외부 API 연동 로직입니다.
 *
 * @author 박석원
 * @updated 2025-04-06
 */
@Component
@RequiredArgsConstructor
public class WakaOAuthClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final WakaTimeOAuthProperties properties;

    public WakaToken requestToken(String code, Long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", properties.getClientId());
        params.add("client_secret", properties.getClientSecret());
        params.add("redirect_uri", properties.getRedirectUri());
        params.add("grant_type", "authorization_code");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://wakatime.com/oauth/token", request, String.class);

        String raw = response.getBody();
        if (!raw.contains("access_token")) {
            throw new IllegalStateException("WakaTime token 요청 실패");
        }

        Map<String, String> tokenMap = Arrays.stream(raw.split("&"))
                .map(param -> param.split("=", 2))
                .filter(arr -> arr.length == 2)
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> URLDecoder.decode(arr[1], StandardCharsets.UTF_8)
                ));

        return WakaToken.builder()
                .userId(userId)
                .wakaId(tokenMap.get("uid"))
                .accessToken(tokenMap.get("access_token"))
                .refreshToken(tokenMap.get("refresh_token"))
                .tokenType(tokenMap.get("token_type"))
                .scope(tokenMap.get("scope"))
                .expiresAt(LocalDateTime.now().plusSeconds(Long.parseLong(tokenMap.get("expires_in"))))
                .build();
    }
}