package com.waka.time.wakatoken.infrastructure.service;

import com.waka.time.wakatoken.application.service.WakaAuthService;
import com.waka.time.wakatoken.domain.model.WakaToken;
import com.waka.time.wakatoken.domain.repository.WakaTokenRepository;
import com.waka.time.wakatoken.infrastructure.external.WakaOAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WakaAuthServiceImpl implements WakaAuthService {
    private final WakaOAuthClient wakaOAuthClient;
    private final WakaTokenRepository wakaTokenRepository;

    @Override
    public void authenticate(String code, String userId) {
        WakaToken token = wakaOAuthClient.requestToken(code, userId);
        wakaTokenRepository.save(token);
    }
}