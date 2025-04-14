package com.waka.time.summary.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <h1>WakaTime Heartbeat 도메인</h1>
 * WakaTime에서 수집한 초 단위 개발 활동을 저장하는 도메인 객체입니다.
 *
 * <ul>
 *   <li><b>heartbeatId</b>: 고유 UUID (기본키)</li>
 *   <li><b>wakaId</b>: 사용자 ID</li>
 *   <li><b>timestampUtc</b>: 활동 발생 시각 (UTC 기준)</li>
 *   <li><b>entity</b>: 작업 대상 (파일 경로 등)</li>
 *   <li><b>type</b>: 작업 유형 (file, app, domain)</li>
 *   <li><b>category</b>: 활동 카테고리 (예: coding)</li>
 *   <li><b>project</b>: 프로젝트 이름</li>
 *   <li><b>projectRootCount</b>: 프로젝트 루트 디렉토리 수</li>
 *   <li><b>branch</b>: 브랜치 이름</li>
 *   <li><b>language</b>: 사용 언어</li>
 *   <li><b>dependencies</b>: 감지된 의존성 목록 (comma-separated)</li>
 *   <li><b>machineNameId</b>: 머신 고유 ID</li>
 *   <li><b>lineAdditions</b>: 추가된 라인 수</li>
 *   <li><b>lineDeletions</b>: 삭제된 라인 수</li>
 *   <li><b>lines</b>: 전체 라인 수</li>
 *   <li><b>lineno</b>: 커서 줄 번호</li>
 *   <li><b>cursorpos</b>: 커서 열 위치</li>
 *   <li><b>isWrite</b>: 작성 여부</li>
 *   <li><b>createdAt</b>: 생성 시각</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-04-14
 */
@Getter
@Builder
public class WakaHeartBeat {
    private UUID heartbeatId;
    private String wakaId;
    private LocalDateTime timestampUtc;
    private String entity;
    private String type;
    private String category;
    private String project;
    private Integer projectRootCount;
    private String branch;
    private String language;
    private String dependencies;
    private String machineNameId;
    private Integer lineAdditions;
    private Integer lineDeletions;
    private Integer lines;
    private Integer lineno;
    private Integer cursorpos;
    private Boolean isWrite;
    private LocalDateTime createdAt;
}
