CREATE TABLE waka_heartbeat (
                                heartbeat_id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- heartbeat 고유 ID
                                waka_id            VARCHAR(50),      -- 사용자 ID
                                timestamp_utc      TIMESTAMP,        -- heartbeat 발생 시간 (UTC 기준)
                                entity             TEXT,             -- 파일 경로 or 도메인 or 앱 이름
                                type               VARCHAR(50),      -- entity 타입 (file, app, domain 등)
                                category           VARCHAR(50),      -- 활동 카테고리 (coding 등)
                                project            VARCHAR(255),     -- 프로젝트 이름
                                project_root_count INTEGER,          -- 루트 디렉토리 수
                                branch             VARCHAR(255),     -- 브랜치 이름
                                language           VARCHAR(100),     -- 언어
                                dependencies       TEXT,             -- 의존성 목록 (comma-separated)
                                machine_name_id    VARCHAR(100),     -- 머신 고유 ID
                                line_additions     INTEGER,          -- 추가된 라인 수
                                line_deletions     INTEGER,          -- 삭제된 라인 수
                                lines              INTEGER,          -- 전체 라인 수
                                lineno             INTEGER,          -- 현재 커서 라인 번호
                                cursorpos          INTEGER,          -- 현재 커서 위치
                                is_write           BOOLEAN,          -- 작성 작업 여부
                                created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 저장 시각
);
-- user_id에도 idnex 생성
CREATE INDEX idx_waka_heartbeat_user_id ON waka_heartbeat(waka_id);

-- 테이블 설명
COMMENT ON TABLE waka_heartbeat IS 'WakaTime heartbeat 원시 활동 로그 (초 단위 추적 데이터)';

-- 컬럼 설명
COMMENT ON COLUMN waka_heartbeat.heartbeat_id IS 'heartbeat UUID (기본키)';
COMMENT ON COLUMN waka_heartbeat.waka_id IS '사용자 ID';
COMMENT ON COLUMN waka_heartbeat.timestamp_utc IS '활동 발생 시각 (UTC 기준)';
COMMENT ON COLUMN waka_heartbeat.entity IS '작업 대상 (파일 경로, 도메인 등)';
COMMENT ON COLUMN waka_heartbeat.type IS 'entity 유형 (file, app, domain)';
COMMENT ON COLUMN waka_heartbeat.category IS '활동 카테고리 (coding, debugging 등)';
COMMENT ON COLUMN waka_heartbeat.project IS '프로젝트 이름';
COMMENT ON COLUMN waka_heartbeat.project_root_count IS '프로젝트 루트 디렉토리 수';
COMMENT ON COLUMN waka_heartbeat.branch IS '브랜치 이름';
COMMENT ON COLUMN waka_heartbeat.language IS '사용 언어';
COMMENT ON COLUMN waka_heartbeat.dependencies IS '감지된 의존성 (comma-separated)';
COMMENT ON COLUMN waka_heartbeat.machine_name_id IS '머신 고유 ID';
COMMENT ON COLUMN waka_heartbeat.line_additions IS '추가된 라인 수';
COMMENT ON COLUMN waka_heartbeat.line_deletions IS '삭제된 라인 수';
COMMENT ON COLUMN waka_heartbeat.lines IS '파일 전체 라인 수';
COMMENT ON COLUMN waka_heartbeat.lineno IS '커서 현재 줄 위치';
COMMENT ON COLUMN waka_heartbeat.cursorpos IS '커서 열 위치';
COMMENT ON COLUMN waka_heartbeat.is_write IS '작성 여부 (true/false)';
COMMENT ON COLUMN waka_heartbeat.created_at IS '레코드 생성 시각';

COMMIT;