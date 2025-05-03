package com.waka.time.wakatoken.infrastructure.external.controller;

import com.waka.time.wakatoken.infrastructure.external.publisher.AccessTokenPublisher;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>WakaTime Access토큰을 받을때 사용하는 컨트롤러</h1>
 * 다른 도메인에서 이 컨트롤를 통해서 accessToken을 받아온다.
 * @author 박석원
 * @updated 2025-04-27
 */
@Tag(name = "WakaTime Access Token", description = "WakaTime에서 필요한 Token을 가져오는 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("wakatoken/api/v1/token")
public class WakaAccessTokenController {

    private final AccessTokenPublisher accessTokenPublisher;

    @Operation(summary = "AccessToken 이벤트 시작 Trigger", description = "AccessToken을 전부 보내주는 이벤트 Trigger입니다.")
    @GetMapping("/event/all")
    public ResponseEntity<Void> getAllAccessToken(){
        accessTokenPublisher.publishAllAccessTokens();
        return ResponseEntity.status(200).build();
    }
}
