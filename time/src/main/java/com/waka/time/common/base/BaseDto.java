package com.waka.time.common.base;

/**
 * <h1>Dto 생성시 메서드 생성을 강제하기 위한 추상체</h1>
 * Dto 생성시 domain으로 변환하는 기본 로직을 강제로 가지도록 하는데 의의를 둔다.
 * <ul>
 *  <li> fromDomain : Domain -> Dto 생성 </li>
 *  <li> updateFromDomain : Domain으로 Dto의 필드 갱신 </li>
 *  <li> toDomain : Dto -> Domain 반환 </li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-04-06
 */
public interface BaseDto<D> {
    BaseDto<D> fromDomain(D domain);
    void updateFromDomain(D domain);
    D toDomain();
}