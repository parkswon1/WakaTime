CREATE TABLE user_waka_token (
                                 token_id       SERIAL PRIMARY KEY,
                                 waka_id        VARCHAR(50) NOT NULL UNIQUE,
                                 access_token   TEXT NOT NULL,
                                 refresh_token  TEXT NOT NULL,
                                 expires_at     TIMESTAMP,
                                 scope          VARCHAR(255),
                                 token_type     VARCHAR(50),
                                 created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE UNIQUE INDEX idx_user_waka_token_user_id
    ON user_waka_token(waka_id);

COMMENT ON INDEX idx_user_waka_token_user_id IS 'user_id에 대한 유니크 인덱스, 사용자 중복 방지용';
COMMENT ON TABLE user_waka_token IS 'WakaTime 사용자 인증 토큰 저장 테이블';
COMMENT ON COLUMN user_waka_token.token_id IS '고유 ID (PK App 내에서 사용)';
COMMENT ON COLUMN user_waka_token.waka_id IS '사용자 식별자 (WakaTime에서 받아옴)';
COMMENT ON COLUMN user_waka_token.access_token IS 'WakaTime OAuth access token';
COMMENT ON COLUMN user_waka_token.refresh_token IS 'WakaTime OAuth refresh token';
COMMENT ON COLUMN user_waka_token.expires_at IS 'access_token 만료 일시 (UTC 기준)';
COMMENT ON COLUMN user_waka_token.scope IS '토큰 권한 범위';
COMMENT ON COLUMN user_waka_token.token_type IS '토큰 타입 (예: Bearer)';
COMMENT ON COLUMN user_waka_token.created_at IS '레코드 생성 일시';
COMMENT ON COLUMN user_waka_token.updated_at IS '레코드 수정 일시';

commit;