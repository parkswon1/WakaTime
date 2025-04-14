package com.waka.time.summary.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <h1>WakaTime 일일 코딩 요약 도메인</h1>
 * 사용자별 일자별 코딩 활동 요약 정보를 표현하는 도메인 객체입니다.
 *
 * <ul>
 *   <li><b>wakaId</b>: WakaTime 사용자 ID</li>
 *   <li><b>summaryDate</b>: 코딩 요약 일자 (KST 기준)</li>
 *   <li><b>startTime</b>: 해당 일자의 시작 시각 (UTC)</li>
 *   <li><b>endTime</b>: 해당 일자의 종료 시각 (UTC)</li>
 *   <li><b>timezone</b>: 사용자 타임존</li>
 *   <li><b>totalSeconds</b>: 총 코딩 시간 (초)</li>
 *   <li><b>digitalTime</b>: 디지털 시계 형식 (예: 1:30:05)</li>
 *   <li><b>textTime</b>: 사람이 읽기 쉬운 시간 표현 (예: 1 hr 30 mins)</li>
 *   <li><b>createdAt</b>: 레코드 생성 시각</li>
 *
 * @author 박석원
 * @updated 2025-04-14
 */
@Getter
@Builder
public class WakaDailySummary {
    private String wakaId;
    private LocalDate summaryDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String timezone;
    private BigDecimal totalSeconds;
    private String digitalTime;
    private String textTime;
    private LocalDateTime createdAt;
}
