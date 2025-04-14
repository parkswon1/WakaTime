package com.waka.time.summary.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <h1>일자별 프로젝트별 코딩 요약 도메인</h1>
 * 특정 사용자에 대해 일자별로 프로젝트 단위의 코딩 시간을 표현하는 도메인 객체입니다.
 *
 * <ul>
 *   <li><b>wakaId</b>: WakaTime 사용자 ID</li>
 *   <li><b>summaryDate</b>: 코딩 요약 일자</li>
 *   <li><b>name</b>: 프로젝트 이름</li>
 *   <li><b>totalSeconds</b>: 해당 프로젝트에서 코딩한 시간 (초)</li>
 *   <li><b>percent</b>: 전체 중 해당 프로젝트의 시간 비율 (%)</li>
 *   <li><b>digitalTime</b>: 디지털 시계 형식 (예: 1:23:45)</li>
 *   <li><b>textTime</b>: 사람이 읽기 쉬운 시간 표현 (예: 1 hr 23 mins)</li>
 *   <li><b>hours</b>: 시간 (시)</li>
 *   <li><b>minutes</b>: 시간 (분)</li>
 *   <li><b>createdAt</b>: 레코드 생성 시각</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-04-14
 */
@Getter
@Builder
public class WakaDailySummaryProject {
    private String wakaId;
    private LocalDate summaryDate;
    private String name;
    private BigDecimal totalSeconds;
    private BigDecimal percent;
    private String digitalTime;
    private String textTime;
    private Integer hours;
    private Integer minutes;
    private LocalDateTime createdAt;
}
