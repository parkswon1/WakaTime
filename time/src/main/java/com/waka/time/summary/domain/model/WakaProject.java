package com.waka.time.summary.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <h1>WakaTime 프로젝트 도메인</h1>
 * 사용자별 프로젝트 정보를 저장하는 도메인 객체입니다.
 *
 * <ul>
 *   <li><b>projectId</b>: WakaTime에서 제공하는 고유 프로젝트 ID</li>
 *   <li><b>wakaId</b>: 사용자 ID</li>
 *   <li><b>name</b>: 프로젝트 이름</li>
 *   <li><b>repository</b>: 연결된 리포지토리</li>
 *   <li><b>badge</b>: 프로젝트 배지</li>
 *   <li><b>color</b>: 커스텀 색상 (Hex 값)</li>
 *   <li><b>clients</b>: 관련 클라이언트 리스트</li>
 *   <li><b>hasPublicUrl</b>: 공유 가능한 URL 여부</li>
 *   <li><b>humanReadableLastHeartbeatAt</b>: 마지막 통계 수신 시간 (사람이 읽기 쉬운 형식)</li>
 *   <li><b>lastHeartbeatAt</b>: 마지막 통계 수신 시간 (ISO 8601)</li>
 *   <li><b>humanReadableFirstHeartbeatAt</b>: 첫 통계 수신 시간 (사람이 읽기 쉬운 형식)</li>
 *   <li><b>firstHeartbeatAt</b>: 첫 통계 수신 시간 (ISO 8601)</li>
 *   <li><b>url</b>: WakaTime 내 프로젝트 URL</li>
 *   <li><b>urlencodedName</b>: URL 인코딩된 프로젝트 이름</li>
 *   <li><b>projectCreatedAt</b>: WakaTime 상의 프로젝트 생성 시각</li>
 *   <li><b>createdAt</b>: 레코드 생성 시각</li>
 *   <li><b>modifiedAt</b>: 레코드 수정 시각</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-04-14
 */
@Getter
@Builder
public class WakaProject {
    private String projectId;
    private String wakaId;
    private String name;
    private String repository;
    private String badge;
    private String color;
    private List<String> clients;
    private boolean hasPublicUrl;
    private String humanReadableLastHeartbeatAt;
    private LocalDateTime lastHeartbeatAt;
    private String humanReadableFirstHeartbeatAt;
    private LocalDateTime firstHeartbeatAt;
    private String url;
    private String urlencodedName;
    private LocalDateTime projectCreatedAt;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
