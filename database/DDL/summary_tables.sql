CREATE TABLE waka_daily_summary (
                              user_id          VARCHAR(100),
                              summary_date     DATE,
                              start_time       TIMESTAMP,
                              end_time         TIMESTAMP,
                              timezone         VARCHAR(100),
                              total_seconds    NUMERIC(10,3),
                              digital_time     VARCHAR(20),
                              text_time        VARCHAR(100),
                              created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              PRIMARY KEY (user_id, summary_date)
);

COMMENT ON TABLE waka_daily_summary IS '사용자별 일자별 코딩 요약';

COMMENT ON COLUMN waka_summary.user_id IS '사용자 ID';
COMMENT ON COLUMN waka_summary.summary_date IS '코딩 요약 일자 (KST 기준)';
COMMENT ON COLUMN waka_summary.start_time IS '해당 일자의 시작 시각 (UTC)';
COMMENT ON COLUMN waka_summary.end_time IS '해당 일자의 종료 시각 (UTC)';
COMMENT ON COLUMN waka_summary.timezone IS '사용자 타임존';
COMMENT ON COLUMN waka_summary.total_seconds IS '총 코딩 시간 (초 단위)';
COMMENT ON COLUMN waka_summary.digital_time IS '디지털 시계 형식 (예: 1:30:05)';
COMMENT ON COLUMN waka_summary.text_time IS '사람이 읽기 쉬운 시간 표현 (예: 1 hr 30 mins)';
COMMENT ON COLUMN waka_summary.created_at IS '레코드 생성 시각';

CREATE TABLE waka_daily_summary_project (
                                      user_id          VARCHAR(100),
                                      summary_date     DATE,
                                      name             VARCHAR(255),
                                      total_seconds    NUMERIC(10,3),
                                      percent          NUMERIC(5,2),
                                      digital_time     VARCHAR(20),
                                      text_time        VARCHAR(100),
                                      hours            INTEGER,
                                      minutes          INTEGER,
                                      created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      PRIMARY KEY (user_id, summary_date)
);

COMMENT ON TABLE waka_daily_summary_project IS '일자별 프로젝트별 코딩 시간 통계';

COMMENT ON COLUMN waka_daily_summary_project.user_id IS '사용자 ID';
COMMENT ON COLUMN waka_daily_summary_project.summary_date IS '코딩 요약 일자';
COMMENT ON COLUMN waka_daily_summary_project.name IS '프로젝트 이름';
COMMENT ON COLUMN waka_daily_summary_project.total_seconds IS '해당 프로젝트에서 코딩한 시간 (초)';
COMMENT ON COLUMN waka_daily_summary_project.percent IS '전체 중 해당 프로젝트의 시간 비율 (%)';
COMMENT ON COLUMN waka_daily_summary_project.digital_time IS '디지털 시계 형식';
COMMENT ON COLUMN waka_daily_summary_project.text_time IS '사람이 읽기 쉬운 시간 표현';
COMMENT ON COLUMN waka_daily_summary_project.hours IS '해당 프로젝트에서 작업한 시간 (시)';
COMMENT ON COLUMN waka_daily_summary_project.minutes IS '해당 프로젝트에서 작업한 시간 (분)';

CREATE TABLE waka_summary_language (
                                       user_id          VARCHAR(100),
                                       summary_date     DATE,
                                       name             VARCHAR(100),
                                       total_seconds    NUMERIC(10,3),
                                       percent          NUMERIC(5,2),
                                       digital_time     VARCHAR(20),
                                       text_time        VARCHAR(100),
                                       hours            INTEGER,
                                       minutes          INTEGER,
                                       seconds          INTEGER,
                                       created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       PRIMARY KEY (user_id, summary_date)
);

COMMENT ON TABLE waka_summary_language IS '일자별 사용 언어별 코딩 시간 통계';

COMMENT ON COLUMN waka_summary_language.user_id IS '사용자 ID';
COMMENT ON COLUMN waka_summary_language.summary_date IS '코딩 요약 일자';
COMMENT ON COLUMN waka_summary_language.name IS '프로그래밍 언어 이름';
COMMENT ON COLUMN waka_summary_language.total_seconds IS '해당 언어로 코딩한 시간 (초)';
COMMENT ON COLUMN waka_summary_language.percent IS '전체 중 해당 언어의 시간 비율 (%)';
COMMENT ON COLUMN waka_summary_language.digital_time IS '디지털 시계 형식';
COMMENT ON COLUMN waka_summary_language.text_time IS '사람이 읽기 쉬운 시간 표현';
COMMENT ON COLUMN waka_summary_language.hours IS '시간 (시)';
COMMENT ON COLUMN waka_summary_language.minutes IS '시간 (분)';
COMMENT ON COLUMN waka_summary_language.seconds IS '시간 (초)';

CREATE TABLE waka_summary_editor (
                                     user_id          VARCHAR(100),
                                     summary_date     DATE,
                                     name             VARCHAR(100),
                                     total_seconds    NUMERIC(10,3),
                                     percent          NUMERIC(5,2),
                                     digital_time     VARCHAR(20),
                                     text_time        VARCHAR(100),
                                     hours            INTEGER,
                                     minutes          INTEGER,
                                     seconds          INTEGER,
                                     created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     PRIMARY KEY (user_id, summary_date)
);

COMMENT ON TABLE waka_summary_editor IS '일자별 사용 에디터별 코딩 시간 통계';

COMMENT ON COLUMN waka_summary_editor.user_id IS '사용자 ID';
COMMENT ON COLUMN waka_summary_editor.summary_date IS '코딩 요약 일자';
COMMENT ON COLUMN waka_summary_editor.name IS '코드 편집기 이름 (예: IntelliJ IDEA)';
COMMENT ON COLUMN waka_summary_editor.total_seconds IS '해당 에디터에서 작업한 시간 (초)';
COMMENT ON COLUMN waka_summary_editor.percent IS '전체 중 해당 에디터의 시간 비율 (%)';
COMMENT ON COLUMN waka_summary_editor.digital_time IS '디지털 시계 형식';
COMMENT ON COLUMN waka_summary_editor.text_time IS '사람이 읽기 쉬운 시간 표현';
COMMENT ON COLUMN waka_summary_editor.hours IS '시간 (시)';
COMMENT ON COLUMN waka_summary_editor.minutes IS '시간 (분)';
COMMENT ON COLUMN waka_summary_editor.seconds IS '시간 (초)';

CREATE TABLE waka_summary_os (
                                 user_id          VARCHAR(100),
                                 summary_date     DATE,
                                 name             VARCHAR(100),
                                 total_seconds    NUMERIC(10,3),
                                 percent          NUMERIC(5,2),
                                 digital_time     VARCHAR(20),
                                 text_time        VARCHAR(100),
                                 hours            INTEGER,
                                 minutes          INTEGER,
                                 seconds          INTEGER,
                                 created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY (user_id, summary_date)
);

COMMENT ON TABLE waka_summary_os IS '일자별 운영체제별 코딩 시간 통계';

COMMENT ON COLUMN waka_summary_os.user_id IS '사용자 ID';
COMMENT ON COLUMN waka_summary_os.summary_date IS '코딩 요약 일자';
COMMENT ON COLUMN waka_summary_os.name IS '운영체제 이름 (예: Windows)';
COMMENT ON COLUMN waka_summary_os.total_seconds IS '해당 OS에서 작업한 시간 (초)';
COMMENT ON COLUMN waka_summary_os.percent IS '전체 중 해당 OS의 시간 비율 (%)';
COMMENT ON COLUMN waka_summary_os.digital_time IS '디지털 시계 형식';
COMMENT ON COLUMN waka_summary_os.text_time IS '사람이 읽기 쉬운 시간 표현';
COMMENT ON COLUMN waka_summary_os.hours IS '시간 (시)';
COMMENT ON COLUMN waka_summary_os.minutes IS '시간 (분)';
COMMENT ON COLUMN waka_summary_os.seconds IS '시간 (초)';

CREATE TABLE waka_summary_dependency (
                                         user_id          VARCHAR(100),
                                         summary_date     DATE,
                                         name             VARCHAR(255),
                                         total_seconds    NUMERIC(10,3),
                                         percent          NUMERIC(5,2),
                                         digital_time     VARCHAR(20),
                                         text_time        VARCHAR(100),
                                         hours            INTEGER,
                                         minutes          INTEGER,
                                         seconds          INTEGER,
                                         created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                         PRIMARY KEY (user_id, summary_date)
);

COMMENT ON TABLE waka_summary_dependency IS '일자별 의존성(라이브러리)별 코딩 시간 통계';

COMMENT ON COLUMN waka_summary_dependency.user_id IS '사용자 ID';
COMMENT ON COLUMN waka_summary_dependency.summary_date IS '코딩 요약 일자';
COMMENT ON COLUMN waka_summary_dependency.name IS '사용된 의존성 또는 라이브러리 이름';
COMMENT ON COLUMN waka_summary_dependency.total_seconds IS '해당 의존성에서 작업한 시간 (초)';
COMMENT ON COLUMN waka_summary_dependency.percent IS '전체 중 해당 의존성의 시간 비율 (%)';
COMMENT ON COLUMN waka_summary_dependency.digital_time IS '디지털 시계 형식';
COMMENT ON COLUMN waka_summary_dependency.text_time IS '사람이 읽기 쉬운 시간 표현';
COMMENT ON COLUMN waka_summary_dependency.hours IS '시간 (시)';
COMMENT ON COLUMN waka_summary_dependency.minutes IS '시간 (분)';
COMMENT ON COLUMN waka_summary_dependency.seconds IS '시간 (초)';

CREATE TABLE waka_summary_machine (
                                      user_id           VARCHAR(100),
                                      summary_date      DATE,
                                      name              VARCHAR(255),
                                      machine_name_id   VARCHAR(100),
                                      total_seconds     NUMERIC(10,3),
                                      percent           NUMERIC(5,2),
                                      digital_time      VARCHAR(20),
                                      text_time         VARCHAR(100),
                                      hours             INTEGER,
                                      minutes           INTEGER,
                                      seconds           INTEGER,
                                      created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      PRIMARY KEY (user_id, summary_date)
);

COMMENT ON TABLE waka_summary_machine IS '일자별 머신(장비)별 코딩 시간 통계';

COMMENT ON COLUMN waka_summary_machine.user_id IS '사용자 ID';
COMMENT ON COLUMN waka_summary_machine.summary_date IS '코딩 요약 일자';
COMMENT ON COLUMN waka_summary_machine.name IS '머신 이름 (호스트명 + IP)';
COMMENT ON COLUMN waka_summary_machine.machine_name_id IS '머신 고유 ID (WakaTime 기준)';
COMMENT ON COLUMN waka_summary_machine.total_seconds IS '해당 머신에서 작업한 시간 (초)';
COMMENT ON COLUMN waka_summary_machine.percent IS '전체 중 해당 머신의 시간 비율 (%)';
COMMENT ON COLUMN waka_summary_machine.digital_time IS '디지털 시계 형식';
COMMENT ON COLUMN waka_summary_machine.text_time IS '사람이 읽기 쉬운 시간 표현';
COMMENT ON COLUMN waka_summary_machine.hours IS '시간 (시)';
COMMENT ON COLUMN waka_summary_machine.minutes IS '시간 (분)';
COMMENT ON COLUMN waka_summary_machine.seconds IS '시간 (초)';

COMMIT;