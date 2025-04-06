package com.waka.time.common.base;

/**
 * <h1>Entity 생성시 메서드 생성을 강제하기 위한 추상체</h1>
 * Entity 생성시 domain으로 변환하는 기본 로직을 강제로 가지도록 하는데 의의를 둔다.
 * <ul>
 *  <li> updateFromDomain : Domain으로 Entity의 필드 갱신 </li>
 *  <li> toDomain : Entity -> Domain 반환 </li>
 *  <li> fromDomain : static으로 직접 상속 객체에서 구현해야 한다.</li>
 * </ul>
 *
 * @author 박석원
 * @updated 2025-04-06
 */
public interface BaseEntity<D> {
    void updateFromDomain(D domain);
    D toDomain();
}