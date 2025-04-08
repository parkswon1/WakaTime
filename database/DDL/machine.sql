-- waka_machine 테이블 생성
CREATE TABLE waka_machine (
                              machine_name_id VARCHAR(255) PRIMARY KEY, -- WakaTime 기준 머신 고유 ID
                              user_id UUID NOT NULL, -- 사용자 ID
                              machine_name VARCHAR(255) NOT NULL, -- 머신 이름 (호스트명 + IP)
                              total_seconds FLOAT NOT NULL, -- 해당 머신에서 작업한 시간 (초)
                              percent FLOAT NOT NULL, -- 전체 중 해당 머신의 시간 비율 (%)
                              digital_time VARCHAR(255) NOT NULL, -- 디지털 시계 형식
                              text_time VARCHAR(255) NOT NULL, -- 사람 읽기 쉬운 시간 표현
                              hours INT NOT NULL, -- 시간 (시)
                              minutes INT NOT NULL, -- 시간 (분)
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성 시간
                              modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 수정 시간
);

--user--id에 index 추가
CREATE INDEX idx_waka_machine_user_id ON waka_machine(user_id);

-- 컬럼에 대한 설명 추가
COMMENT ON COLUMN waka_machine.machine_name_id IS '머신 고유 ID (WakaTime 기준)';
COMMENT ON COLUMN waka_machine.user_id IS '사용자 ID';
COMMENT ON COLUMN waka_machine.machine_name IS '머신 이름 (호스트명 + IP)';
COMMENT ON COLUMN waka_machine.total_seconds IS '해당 머신에서 작업한 시간 (초)';
COMMENT ON COLUMN waka_machine.percent IS '전체 중 해당 머신의 시간 비율 (%)';
COMMENT ON COLUMN waka_machine.digital_time IS '디지털 시계 형식';
COMMENT ON COLUMN waka_machine.text_time IS '사람이 읽기 쉬운 시간 표현';
COMMENT ON COLUMN waka_machine.hours IS '시간 (시)';
COMMENT ON COLUMN waka_machine.minutes IS '시간 (분)';
COMMENT ON COLUMN waka_machine.created_at IS '생성 시간';
COMMENT ON COLUMN waka_machine.modified_at IS '수정 시간';

COMMIT;