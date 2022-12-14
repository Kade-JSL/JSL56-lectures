# 이날 배웠던 것

- Oracle DB를 설치하고 `sqlplus`에 들어가서 여러 가지 명령어들을 배웠습니다.
    - 숙제 내용은 [숙제 내역 파일](/221011-221202_JAVA_BASICS/22-10/221013/숙제_내역)에 복사해 두었습니다.
- [Oracle DB 11g Express Edition (Release 2) 다운로드 페이지](https://www.oracle.com/database/technologies/xe-prior-release-downloads.html)
    - 집에서 해 보실 분을 위해서 여기에 적어 둡니다.

---

# 숙제
- 계정명이 `jslhrd05`(아니면 뭐 아무거나) 비밀번호가 `1234`(아니면 뭐 아무거나)인 계정 생성하기
- `CONNECT`, `RESOURCE`, `DBA` 권한을 위 계정에 부여하기
- `test` 테이블을 만들기
    - 각각의 컬럼 내용은 `bno`, `name`, `kor`, `eng`, `mat`, `tot`, `avg`이며 각각의 자료형은 `bno`가 4자리 숫자, `name`이 10자리 글자, `kor`~`tot`까지 3자리 숫자, `avg`는 총 6자리에 소수점 아래가 2자리인 숫자이다.
- `test` 테이블에 데이터를 6개 이상 입력하기
- 모든 레코드를 검색하기
    - 번호, 이름만 검색하기
    - 번호, 이름, 총점, 평균만 검색하기


### 죄송합니다 선생님... 제 자기만족을 위해 수업 내용을 적어두고 있어요...

## Oracle이란?

(출처: [https://blog.naver.com/it-edu/221260172726](https://blog.naver.com/it-edu/221260172726))
- **DBMS**의 하나.
    - **DBMS란?** 데이터를 효과적으로 이용할 수 있도록 정리 및 보관하기 위한 기본 소프트웨어
    - DataBase Management System의 약자
- DBMS는 **계층형**과 **네트워크형**, **관계형**으로 나뉨
- 최근에는 **관계형(Relational)**이 DBMS의 주류를 이루고 있다.
- 관계형 DBMS를 **RDBMS**라고 한다.

## SQL?

- **Structured Query Language**의 준말
    - **데이터 정의어**(DDL; Data Definition Language): 스키마 객체 생성, 변경, 제거 역할
    - **데이터 조작어**(DML; Data Manipulation Language): 데이터에 대한 삽입 및 갱신, 삭제 등의 역할(M은 Management라고 선생님은 말씀하심)
        - 보통 이것을 Query문이라 한다.
    - **데이터 제어어**(DCL; Data Control Language): 데이터 보안, 무결성 유지, 데이터 회복, 병행 수행 제어 등의 역할
    - **트랜잭션 및 세션 관리 언어**
        - 트랜잭션 관리 언어: 트랜잭션 특성을 설정, 트랜잭션을 완료하고 지정하는 역할
        - 세션 관리 언어: 세션의 특성을 설정하는 역할
        - 트랜잭션이란?
            - 데이터베이스 내에서 한꺼번에 모두 수행해야 할 연산들의 집합
            - 하나의 작업 처리를 위한 논리적인 단위

## Oracle 둘러보기

- `cmd.exe`에서 `sqlplus` 명령 실행 → 사용자명 `system`(최고 관리자 계정) → 설치할 때 설정한 비밀번호
- bit < byte < word < record < file < DB
- word 항목들이 모여서 record라는 한 줄을 이루고, record 여러 줄이 모여서 file을 이루고, 항목별로 그렇게 분류한 file이 모여서 DB가 된다.
- DB에 계정을 만들어 달라고 부탁이 들어왔다고 하자.
    - `system` 계정에 로그인해서 `kade` 계정을 만들어 줄 것이다.
    ```SQL
    CREATE USER kade IDENTIFIED BY 1234;
    ```
    - 같은 이름의 계정은 하나밖에 만들 수 없다.
    ```SQL
    SQL> CREATE USER kade IDENTIFIED BY 1234;
    CREATE USER kade IDENTIFIED BY 1234
                *
    ERROR at line 1:
    ORA-01920: user name 'KADE' conflicts with another user or role name
    ```
    - `GRANT` 명령어로 권한을 부여해 보자.
    ```SQL
    GRANT CONNECT, RESOURCE, DBA TO kade;
    ```
    - 권한 종류
        - `CONNECT`: DB 연결 권한
        - `RESOURCE`: 데이터 수정 권한
        - `DBA`: DB 관리자 권한
    - 변경 내용을 저장한 다음 나가자.
    ```sql
    SQL> commit;

    Commit complete.

    SQL> exit;
    Disconnected from Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
    ```
    - 새로 만든 계정으로 로그인을 해 보자.

**중요한 내용: SQL은 대소문자를 구별하지 않으며, 대소문자를 구별하지 않는 언어의 경우 다른 언어와 차별을 두기 위헤 전부 대문자로 표기하곤 합니다. 그리고 줄 끝에 세미콜론(;) 붙이는 거 잊지 맙시다.**

## 테이블(table) 만들어 보기

(출처: [https://gent.tistory.com/322](https://gent.tistory.com/322))

- 데이터를 입력, 수정, 삭제, 검색을 하기 위한 구조를 테이블이라 한다.
- column을 만들 적에는 각 열마다 어떤 자료형이 들어갈지를 생각해서 만들자.
- table은 대량의 데이터들을 저장하기 위한 틀을 설계하는 것
- `VARCHAR2`: 문자 자료형
- `NUMBER(n,m)`: 소수점을 포함한 `n`개의 총 자릿수, 소수점 `m`번째 자리까지
- 테이블 작성 예제

    ![오라클에서 테이블 생성하기](https://blog.kakaocdn.net/dn/dv1TDv/btqFpz9NEdJ/FmaEYhlgbkIjNJ0ZRtNrc1/img.png)

    ```SQL
    SQL> CREATE TABLE MEMBER (
    2  BNO NUMBER(3) NOT NULL,
    3  ID VARCHAR2(12) NOT NULL,
    4  PASSWORD VARCHAR2(12) NOT NULL,
    5  TEL VARCHAR2(12) NOT NULL,
    6  ADDRESS VARCHAR2(50) 
    7  );

    Table created.
    ```
    - `NOT NULL`은 해당 열의 데이터는 비어 있으면 안 된다는 표시이다.
- SQL에선 여타 터미널과 같이 위아래 방향키를 이용해 이전에 실행한 명령어를 찾아볼 수 있다.
- `cmd`에서 그대로 `sqlplus [계정명]/[계정 암호]` 형식으로 입력하여 로그인 절차를 생략할 수도 있다.

## 학생 성적표 테이블 만들어 보기

- **사양: 번호/이름/국어점수/영어점수/수학점수/총점/평균**
- 일단 이렇게 써 보자.
    ```SQL
    CREATE TABLE test (
    2  BNO NUMBER(4) NOT NULL,
    3  NAME VARCHAR2(10) NOT NULL,
    4  KOR NUMBER(3) NOT NULL,
    5  ENG NUMBER(3) NOT NULL,
    6  MAT NUMBER(3) NOT NULL,
    7  TOT NUMBER(3) NOT NULL,
    8  AVG NUMBER(6,2)
    9  );
    ```
- 그리고 만든 테이블의 정보를 확인해 보자.
    ```sql
    SQL> DESC test;
    Name                                      Null?    Type
    ----------------------------------------- -------- ----------------------------
    BNO                                       NOT NULL NUMBER(4)
    NAME                                      NOT NULL VARCHAR2(10)
    KOR                                       NOT NULL NUMBER(3)
    ENG                                       NOT NULL NUMBER(3)
    MAT                                       NOT NULL NUMBER(3)
    TOT                                       NOT NULL NUMBER(3)
    AVG                                                NUMBER(6,2)
    ```
- `tot` 열은 나중에 계산해야 하는 거라서 특성이 `NOT NULL`이 아니게 하고 싶다. 이번엔 아예 삭제하고 다시 만들어 본다. 죽음의 주문인 `DROP TABLE`이 여기에서 등장한다.
    ```SQL
    SQL> DROP TABLE test;
    ```
- 수정한 테이블을 다시 만들어 보면 다음과 같이 나온다.
    ```sql
    SQL> DESC test;
    Name                                      Null?    Type
    ----------------------------------------- -------- ----------------------------
    BNO                                       NOT NULL NUMBER(3)
    NAME                                      NOT NULL VARCHAR2(10)
    KOR                                       NOT NULL NUMBER(3)
    ENG                                       NOT NULL NUMBER(3)
    MAT                                       NOT NULL NUMBER(3)
    TOT                                                NUMBER(3)
    AVG                                                NUMBER(6,2)
    ```
- 그럼 이제 대망의 데이터 입력이다. 아래와 같이 입력한다.
    ```sql
    INSERT INTO [테이블 이름] ([컬럼 이름],...) VALUES ([저장하고자 하는 값],...);
    ```
    ```sql
    INSERT INTO test (bno,name,kor,eng,mat) VALUES (0001,'ariel',100,100,100);
    INSERT INTO test (bno,name,kor,eng,mat) VALUES (0002,'brian',90,90,90);
    INSERT INTO test (bno,name,kor,eng,mat) VALUES (0003,'charlie',80,80,80); 
    ```
- 그리고 테이블 내용을 확인해 보자.
    ```sql
    SQL> SELECT * FROM test; 

           BNO NAME                        KOR        ENG        MAT        TOT        AVG
    ---------- -------------------- ---------- ---------- ---------- ---------- ----------


             1 ariel                       100        100        100


             2 brian                        90         90         90


             3 charlie                      80         80         80
    ```
- 테이블의 내용을 확인하고 싶다면 다음과 같이 하면 된다는 얘기이다. `*`은 인제 모든 항목이라는 뜻이 되고.
    ```sql
    SELECT [컬럼 이름들],... FROM [확인하고자 하는 테이블 이름];
    ```
- 일일이 이렇게 다 입력하려니 좀 지친다. 쉬운 방법이 있지 않을까?
    - 원래 코딩할 때 하나하나 하기 귀찮다 싶은 방법에는 반드시 쉬운 방법이 있기 마련이다.
    - 여기서 강의가 끝나기 때문에, 다음날 내용을 보도록 하자.
