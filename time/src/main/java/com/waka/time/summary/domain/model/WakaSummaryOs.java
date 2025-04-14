package com.waka.time.summary.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <h1>WakaTime 운영체제별 요약 도메인</h1>
 * 일자별 운영체제별 코딩 시간 통계를 나타내는 도메인 객체
 *
 * <ul>
 *   <li><b>wakaId</b>: 사용자 ID (WakaTime)</li>
 *   <li><b>summaryDate</b>: 코딩 요약 일자</li>
 *   <li><b>name</b>: 운영체제 이름 (예: Windows)</li>
 *   <li><b>totalSeconds</b>: 해당 OS에서 작업한 시간 (초)</li>
 *   <li><b>percent</b>: 전체 중 해당 OS의 시간 비율 (%)</li>
 *   <li><b>digitalTime</b>: 디지털 시계 형식</li>
 *   <li><b>textTime</b>: 사람이 읽기 쉬운 시간 표현</li>
 *   <li><b>hours</b>: 시</li>
 *   <li><b>minutes</b>: 분</li>
 *   <li><b>seconds</b>: 초</li>
 *   <li><b>createdAt</b>: 레코드 생성 시각</li>
 * </ul>
 *
 * @author 박석원
 * @since 2025-04-07
 */
@Getter
@Builder
public class WakaSummaryOs {
    private String wakaId;
    private LocalDate summaryDate;
    private String name;
    private double totalSeconds;
    private double percent;
    private String digitalTime;
    private String textTime;
    private int hours;
    private int minutes;
    private int seconds;
    private LocalDateTime createdAt;
}
