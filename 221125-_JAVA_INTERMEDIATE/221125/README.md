### [221124 ←](/221011-221124_JAVA_BASICS/22-11/221124) | _→ 221128_<!--(/221011-221124_JAVA_BASICS/22-11/221128/)-->

# 이날 배웠던 것

- [**exercise.sql**: 뭔가 아주 기다란 연습 기록... Ctrl+Enter로 한 줄 한 줄 실행해 보자.](/221125-_JAVA_INTERMEDIATE/221125/exercise.sql)
    - `NAME` 컬럼에 있는 이름 다섯 개만 바뀌었지 나머지는 모두 동일합니다.
        - _근데 생각해 보니까 그럼 `SELECT`문 쓰는 부분도 좀 달라지네요. 고건 알아서 감안을... ㅎㅎ;;_

---

## Oracle SQL Developer 소프트웨어 실습

- `INSERT`

    ```sql
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
    ```

    - 컬럼이 7개인 테이블에 데이터를 7종류 입력하는 그런 것.

- `UPDATE`: 테이블 내용 수정
    - `WHERE`
        - `OR`와 `AND`로 조건의 범위를 결정
        - `LIKE`로 `VARCHAR2` 타입 레코드에 있는 데이터 범위 특정
        - `NUMBER` 타입의 경우 `>=`이나 `=` 등의 논리 연산자 사용 가능
            - 다른 언어와 달리 `==`이 아닌 `=`이 논리 연산자
- `DELETE`: 조건에 따라 테이블 삭제
- `ALTER TABLE`
    - `ADD`: 컬럼 추가
    - `MODIFY`: 컬럼 속성 변경
    - `RENAME`: 컬럼 이름 변경
    - `DROP`: 컬럼 삭제