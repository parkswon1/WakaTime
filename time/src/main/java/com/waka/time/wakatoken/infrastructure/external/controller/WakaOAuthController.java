package com.waka.time.wakatoken.infrastructure.external.controller;

import com.waka.time.properties.WakaTimeOAuthProperties;
import com.waka.time.wakatoken.application.service.WakaAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * <h1>WakaTime OAuth 콜백 컨트롤러</h1>
 * 인증 완료 후 WakaTime으로부터 받은 code를 처리하는 엔드포인트입니다.
 *
 * author 박석원
 * updated 2025-04-05
 */
@Tag(name = "WakaTime OAuth", description = "WakaTime OAuth 인증 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("wakatoken/api/v1/oauth")
public class WakaOAuthController {

    private final WakaAuthService wakaAuthService;
    private final WakaTimeOAuthProperties props;

    @Operation(summary = "WakaTime OAuth 콜백", description = "WakaTime 인증 완료 후 code를 받아 accessToken 발급을 진행합니다.")
    @GetMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam("code") String code) {
        String userId = "1";
        wakaAuthService.authenticate(code, userId);
        return ResponseEntity.ok("WakaTime 인증 완료");
    }

    /**
     * <h1>WakaTime OAuth 인증 시작 (브라우저 리다이렉트)</h1>
     * 브라우저에서 이 엔드포인트를 호출하면 WakaTime 로그인 페이지로 이동합니다.
     *
     * @return 302 Redirect to WakaTime OAuth URL
     */
    @Operation(summary = "WakaTime OAuth 인증 시작", description = "WakaTime 로그인 페이지로 리다이렉트합니다.")
    @GetMapping("/test-login")
    public ResponseEntity<Void> redirectToWakaTime() {
        String clientId = props.getClientId();
        String redirectUri = props.getRedirectUri();

        String scope = "read_logged_time read_summaries read_goals";
        String url = "https://wakatime.com/oauth/authorize"
                + "?client_id=" + clientId
                + "&response_type=code"
                + "&redirect_uri=" + redirectUri
                + "&scope=" + URLEncoder.encode(scope, StandardCharsets.UTF_8);

        return ResponseEntity.status(302).location(URI.create(url)).build();
    }
}