package com.waka.time.summary.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * <h1>WakaTime 머신 도메인</h1>
 * 사용자별 머신 정보를 저장하는 도메인 객체입니다.
 *
 * <ul>
 *   <li><b>machineNameId</b>: 머신 고유 ID (WakaTime 기준)</li>
 *   <li><b>wakaId</b>: 사용자 ID</li>
 *   <li><b>machineName</b>: 머신 이름 (호스트명 + IP)</li>
 *   <li><b>totalSeconds</b>: 해당 머신에서 작업한 시간 (초)</li>
 *   <li><b>percent</b>: 전체 중 해당 머신의 시간 비율 (%)</li>
 *   <li><b>digitalTime</b>: 디지털 시계 형식</li>
 *   <li><b>textTime</b>: 사람이 읽기 쉬운 시간 표현</li>
 *   <li><b>hours</b>: 시간 (시)</li>
 *   <li><b>minutes</b>: 시간 (분)</li>
 *   <li><b>createdAt</b>: 생성 시간</li>
 *   <li><b>modifiedAt</b>: 수정 시간</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-04-14
 */
@Getter
@Builder
public class WakaMachine {
    private String machineNameId;
    private String wakaId;
    private String machineName;
    private double totalSeconds;
    private double percent;
    private String digitalTime;
    private String textTime;
    private int hours;
    private int minutes;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
