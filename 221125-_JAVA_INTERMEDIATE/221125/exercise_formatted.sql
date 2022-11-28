CREATE TABLE STUDENT (
    NUM NUMBER(4) NOT NULL PRIMARY KEY,
    NAME VARCHAR2(12) NOT NULL,
    ADDRESS VARCHAR2(100) NOT NULL,
    TEL VARCHAR2(20) NOT NULL,
    KOR NUMBER(3) NOT NULL,
    ENG NUMBER(3) NOT NULL,
    MAT NUMBER(3) NOT NULL,
    TOT NUMBER(3),
    AVG NUMBER(5, 2)
);

-- dml
/* 명령어 한 줄씩 실행은 Ctrl+Enter, 전부 실행은 F5 */

INSERT INTO STUDENT (
    NUM,
    NAME,
    ADDRESS,
    TEL,
    KOR,
    ENG,
    MAT
) VALUES (
    1111,
    '케이드',
    '대전광역시',
    '010',
    100,
    100,
    100
);

/* 7개의 COLUMN애 들어가는 7개의 데이터 */
INSERT INTO STUDENT (
    NUM,
    NAME,
    ADDRESS,
    TEL,
    KOR,
    ENG,
    MAT
) VALUES (
    2222,
    '페시아',
    '대전광역시',
    '010',
    90,
    90,
    90
);

INSERT INTO STUDENT (
    NUM,
    NAME,
    ADDRESS,
    TEL,
    KOR,
    ENG,
    MAT
) VALUES (
    3333,
    '고양이',
    '대전광역시',
    '010',
    80,
    100,
    70
);

INSERT INTO STUDENT (
    NUM,
    NAME,
    ADDRESS,
    TEL,
    KOR,
    ENG,
    MAT
) VALUES (
    4444,
    '멍멍이',
    '대전광역시',
    '010',
    100,
    70,
    70
);

INSERT INTO STUDENT (
    NUM,
    NAME,
    ADDRESS,
    TEL,
    KOR,
    ENG,
    MAT
) VALUES (
    5555,
    '곰돌이',
    '대전광역시',
    '010',
    90,
    50,
    50
);

SELECT
    *
FROM
    STUDENT;

-- 테이블의 모든 내용 검색
SELECT
    NUM,
    NAME,
    ADDRESS
FROM
    STUDENT;

-- 테이블의 특정 컬럼 검색
SELECT
    *
FROM
    STUDENT
WHERE
    NAME LIKE '페%';

-- %는 '그 글자 뒤 몇 글자든'이라는 의미
SELECT
    *
FROM
    STUDENT
WHERE
    NAME LIKE '케%';

-- name이 '케'로 시작하는 모든 레코드
SELECT
    *
FROM
    STUDENT
WHERE
    NAME LIKE '고%';

SELECT
    *
FROM
    STUDENT
WHERE
    NAME LIKE '멍%';

SELECT
    *
FROM
    STUDENT;

SELECT
    KOR,
    ENG,
    MAT
FROM
    STUDENT;

-- 이하 STUDENT 테이블 검색:
SELECT
    *
FROM
    STUDENT
WHERE
    KOR >= 90;

-- 국어점수 90점 이상
SELECT
    *
FROM
    STUDENT
WHERE
    ENG < 90;

-- 영어점수 90점 미만
SELECT
    *
FROM
    STUDENT
WHERE
    KOR >= 90
    OR ENG >= 90
    OR MAT >= 90;

-- 적어도 과목 하나는 90점 이상
SELECT
    *
FROM
    STUDENT
WHERE
    KOR >= 90
    AND ENG >= 90
    AND MAT >= 90;

-- 전 과목 90점 이상
SELECT
    *
FROM
    STUDENT
WHERE
    ADDRESS LIKE '대전광역시%';

-- 주소 필드 맨 앞에 대전광역시가 있는 레코드
SELECT
    *
FROM
    STUDENT
WHERE
    ADDRESS LIKE '대전광역시%'
    AND NAME LIKE '케%';

-- 주소 맨 앞에 대전광역시가 있고 이름이 케로 시작하는 레코드

SELECT
    *
FROM
    STUDENT;

SELECT
    *
FROM
    STUDENT
WHERE
    NUM = 3333;

/* 3333번 학번인 고양이 학생의 국어 점수를 50점으로 수정하고 싶다. */
UPDATE STUDENT
SET
    KOR = 50
WHERE
    NUM = 3333;

SELECT
    *
FROM
    STUDENT
WHERE
    NUM = 3333;

/* 4444번 멍멍이 학생의 수학 점수를 100점으로 수정 */
UPDATE STUDENT
SET
    MAT = 100
WHERE
    NUM = 4444;

SELECT
    *
FROM
    STUDENT
WHERE
    NUM = 4444;

SELECT
    *
FROM
    STUDENT;

/* 이름이 고양이인 학생의 주소를 대구광역시로 변경 */
UPDATE STUDENT
SET
    ADDRESS = '대구광역시'
WHERE
    NAME = '고양이';

SELECT
    *
FROM
    STUDENT
WHERE
    NAME = '고양이';

/* 계산식으로 총점 구하기 */
SELECT
    *
FROM
    STUDENT;

UPDATE STUDENT
SET
    TOT = KOR + ENG + MAT;

SELECT
    *
FROM
    STUDENT;

/* 계산식으로 평균 구하기 */
UPDATE STUDENT
SET
    AVG = TOT / 3;

SELECT
    *
FROM
    STUDENT;

/* 학번 내림차순으로 출력 */
SELECT
    *
FROM
    STUDENT
ORDER BY
    NUM DESC;

SELECT
    *
FROM
    STUDENT
WHERE
    NAME LIKE '페%';

/* 평균이 90점 이하인 레코드 검색 */
SELECT
    *
FROM
    STUDENT
WHERE
    AVG < 90;

/* 케이드 학생은 무슨 잘못을 했길래 점수가 10점으로 떡락한 걸까요? */
UPDATE STUDENT
SET
    KOR = 10,
    ENG = 10,
    MAT = 10
WHERE
    NUM = 1111;

SELECT
    *
FROM
    STUDENT;

UPDATE STUDENT
SET
    TOT = KOR + ENG + MAT;

UPDATE STUDENT
SET
    AVG = TOT / 3;

SELECT
    *
FROM
    STUDENT;

/* 이름 오름차순(ASC는 치지 않아도 된다) */
SELECT
    *
FROM
    STUDENT
ORDER BY
    NAME ASC;

/* 평균 오름차순 */
SELECT
    *
FROM
    STUDENT
ORDER BY
    AVG DESC;

/* 5555번 학생 삭제 */
DELETE STUDENT
WHERE
    NUM = 5555;

SELECT
    *
FROM
    STUDENT;

DELETE STUDENT
WHERE
    AVG <= 80;

SELECT
    *
FROM
    STUDENT;

ROLLBACK;

/* RESULT 컬럼 만들기, 거기에 조건문에 따라 텍스트 넣기 */
ALTER TABLE STUDENT ADD (MEMO VARCHAR2(50));

-- 컬럼 추가
ALTER TABLE STUDENT MODIFY (MEMO VARCHAR2(100));

-- 컬럼 자료형 수정
ALTER TABLE STUDENT RENAME COLUMN MEMO TO RESULT;

-- 컬럼 이름 변경
ALTER TABLE STUDENT DROP COLUMN RESULT;

--  컬럼 삭제
ALTER TABLE STUDENT ADD (RESULT VARCHAR2(50));

-- 컬럼 다시 추가
SELECT
    *
FROM
    STUDENT;

UPDATE STUDENT
SET
    RESULT = '합격'
WHERE
    AVG >= 80;

-- 컬럼에 내용 입력
SELECT
    *
FROM
    STUDENT;

UPDATE STUDENT
SET
    RESULT = -- 조건에 따른 내용 입력
    CASE WHEN AVG >= 80 THEN '합격' WHEN AVG < 80 THEN '불합격' END;

SELECT
    *
FROM
    STUDENT;

SELECT
    *
FROM
    STUDENT
WHERE
    RESULT = '불합격';

CREATE TABLE NOTICE (
    BNO NUMBER(3) NOT NULL PRIMARY KEY,
    TITLE VARCHAR2(500) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    NAME VARCHAR2(10) NOT NULL,
    VIEWCOUNT NUMBER(3) DEFAULT 0
);

DESC NOTICE; -- 제 환경(VS Code)에선 안 되더랩니다. 이게 뭐 DB 연결의 주체에 따라 다르다는데, 걍 SQL Developer 프로그램에선 되더군요.


INSERT INTO NOTICE (
    BNO,
    TITLE,
    CONTENT,
    NAME
) VALUES (
    1,
    '개발자 모집',
    '여기 자바 3명이요',
    '관리자'
);

SELECT
    *
FROM
    NOTICE;

-- NOTICE 테이블의 모든 컬럼 검색

SELECT
    TITLE,
    CONTENT
FROM
    NOTICE;

-- 제목, 내용 컬럼만 검색

INSERT INTO NOTICE VALUES (
    2,
    '자바 배우기',
    '객체지향 언어',
    '관리자',
    0
);

-- 데이터를 순서대로 입력할 땐 컬럼 이름 안 입력해도 된다(디폴트까지 입력해 주자)

INSERT INTO NOTICE (
    BNO,
    TITLE,
    CONTENT,
    NAME
) VALUES (
    3,
    '제목임',
    '제곧내',
    '관리자'
);

INSERT INTO NOTICE (
    BNO,
    TITLE,
    CONTENT,
    NAME
) VALUES (
    4,
    '방구석에선 코딩허접이던 내가 마법학원에 갔더니 기대의 신입생?!',
    '방구석에서 코딩하다가 어디서 날아온 예외에 맞아서 죽었다. 하지만 죽었더니 웬 인도네시아 여성처럼 생긴 여신이 나타나서 나를 이세계로 부활시킨다고 하는 것이다. 가는 건 이세계인데 왜 나는 체크무늬 옷차림 그대로일까? 아니나다를까 전생해서 간 곳도 마법학원이라 쓰고 그냥 코딩학원이라 읽는 그런 인력양성소 같은 데였다.',
    '소설가'
);

INSERT INTO NOTICE (
    BNO,
    TITLE,
    CONTENT,
    NAME
) VALUES (
    5,
    '「別に」なんて言わないで、「またね」って言って',
    '私のものにならなくていい、傍にいるだけでいい',
    '千早'
);

SELECT
    *
FROM
    NOTICE;

SELECT
    *
FROM
    NOTICE
WHERE
    NAME = '소설가';

SELECT
    *
FROM
    NOTICE
WHERE
    TITLE LIKE '%な%';