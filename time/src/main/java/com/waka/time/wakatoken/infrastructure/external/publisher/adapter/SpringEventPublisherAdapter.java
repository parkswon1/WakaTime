package com.waka.time.wakatoken.infrastructure.external.publisher.adapter;

import com.waka.time.wakatoken.application.port.out.AccessTokenEventPublisher;
import com.waka.time.wakatoken.application.port.out.WakaAccessTokenResponse;
import com.waka.time.wakatoken.infrastructure.external.event.AccessTokenEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("springPublisher")
@RequiredArgsConstructor
public class SpringEventPublisherAdapter implements AccessTokenEventPublisher {
    private final ApplicationEventPublisher springEventPublisher;
    @Override
    public void publish(List<WakaAccessTokenResponse> tokenResponses) {
        springEventPublisher.publishEvent(
                AccessTokenEvent.builder()
                        .accessTokenResponses(tokenResponses)
                        .build()
        );
    }
}
