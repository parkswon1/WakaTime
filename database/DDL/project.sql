-- waka_project 테이블 생성
CREATE TABLE waka_project (
                              project_id VARCHAR(255) PRIMARY KEY, -- WakaTime에서 제공하는 고유 프로젝트 ID (문자열 형식)
                              waka_id VARCHAR(100),
                              name VARCHAR(255) NOT NULL, -- 프로젝트 이름
                              repository VARCHAR(255), -- 연결된 리포지토리
                              badge VARCHAR(255), -- 프로젝트 배지
                              color VARCHAR(7), -- 커스텀 프로젝트 색상 (Hex 값)
                              clients TEXT[], -- 관련된 클라이언트 리스트 (JSON 배열로 저장)
                              has_public_url BOOLEAN DEFAULT FALSE, -- 공유 가능한 URL이 있는지 여부
                              human_readable_last_heartbeat_at VARCHAR(255), -- 마지막 코드 통계 수신 시간 (사람이 읽기 쉬운 형식)
                              last_heartbeat_at TIMESTAMP, -- 마지막 코드 통계 수신 시간 (ISO 8601 형식)
                              human_readable_first_heartbeat_at VARCHAR(255), -- 첫 번째 코드 통계 수신 시간 (사람이 읽기 쉬운 형식)
                              first_heartbeat_at TIMESTAMP, -- 첫 번째 코드 통계 수신 시간 (ISO 8601 형식)
                              url VARCHAR(255), -- 프로젝트 URL (wakatime.com 상대 URL)
                              urlencoded_name VARCHAR(255), -- URL 인코딩된 프로젝트 이름
                              project_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 프로젝트 생성 시간
                              CONSTRAINT unique_project_name UNIQUE(name), -- 프로젝트 이름에 대한 유니크 제약 조건
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성 시간
                              modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 수정 시간
);
--user--id에 index 추가
CREATE INDEX idx_waka_proejct_waka_id ON waka_project(waka_id);

-- 컬럼에 대한 설명 추가
COMMENT ON COLUMN waka_project.project_id IS 'WakaTime에서 제공하는 고유 프로젝트 ID';
COMMENT ON COLUMN waka_project.name IS '프로젝트 이름';
COMMENT ON COLUMN waka_project.repository IS '연결된 리포지토리';
COMMENT ON COLUMN waka_project.badge IS '프로젝트 배지';
COMMENT ON COLUMN waka_project.color IS '커스텀 프로젝트 색상 (Hex 값)';
COMMENT ON COLUMN waka_project.clients IS '관련된 클라이언트 리스트 (JSON 배열로 저장)';
COMMENT ON COLUMN waka_project.has_public_url IS '공유 가능한 URL이 있는지 여부';
COMMENT ON COLUMN waka_project.human_readable_last_heartbeat_at IS '마지막 코드 통계 수신 시간 (사람이 읽기 쉬운 형식)';
COMMENT ON COLUMN waka_project.last_heartbeat_at IS '마지막 코드 통계 수신 시간 (ISO 8601 형식)';
COMMENT ON COLUMN waka_project.human_readable_first_heartbeat_at IS '첫 번째 코드 통계 수신 시간 (사람이 읽기 쉬운 형식)';
COMMENT ON COLUMN waka_project.first_heartbeat_at IS '첫 번째 코드 통계 수신 시간 (ISO 8601 형식)';
COMMENT ON COLUMN waka_project.url IS '프로젝트 URL (wakatime.com 상대 URL)';
COMMENT ON COLUMN waka_project.urlencoded_name IS 'URL 인코딩된 프로젝트 이름';
COMMENT ON COLUMN waka_project.project_created_at IS '프로젝트 생성 시간';
COMMENT ON COLUMN waka_project.created_at IS '프로젝트 생성 시간';
COMMENT ON COLUMN waka_project.modified_at IS '프로젝트 생성 시간';

COMMIT;