CREATE TABLE user_waka_token (
                                 id             SERIAL PRIMARY KEY, -- 고유 ID (PK)
                                 user_id        VARCHAR(100) NOT NULL, -- 사용자 식별자 (앱 내 사용자 기준)
                                 access_token   TEXT NOT NULL, -- WakaTime OAuth access token
                                 refresh_token  TEXT NOT NULL, -- WakaTime OAuth refresh token
                                 expires_at     TIMESTAMP, -- access_token 만료 일시 (UTC 기준)
                                 scope          VARCHAR(255), -- 토큰 권한 범위
                                 token_type     VARCHAR(50), -- 토큰 타입 (예: Bearer)
                                 created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 레코드 생성 일시
                                 updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 레코드 수정 일시
);

COMMENT ON TABLE user_waka_token IS 'WakaTime 사용자 인증 토큰 저장 테이블';
COMMENT ON COLUMN user_waka_token.id IS '고유 ID (PK)';
COMMENT ON COLUMN user_waka_token.user_id IS '사용자 식별자 (앱 내 사용자 기준)';
COMMENT ON COLUMN user_waka_token.access_token IS 'WakaTime OAuth access token';
COMMENT ON COLUMN user_waka_token.refresh_token IS 'WakaTime OAuth refresh token';
COMMENT ON COLUMN user_waka_token.expires_at IS 'access_token 만료 일시 (UTC 기준)';
COMMENT ON COLUMN user_waka_token.scope IS '토큰 권한 범위';
COMMENT ON COLUMN user_waka_token.token_type IS '토큰 타입 (예: Bearer)';
COMMENT ON COLUMN user_waka_token.created_at IS '레코드 생성 일시';
COMMENT ON COLUMN user_waka_token.updated_at IS '레코드 수정 일시';

commit;