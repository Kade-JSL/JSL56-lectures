### [221125 ←](/221011-221202_JAVA_BASICS/22-11/221125/) | [→ 221129](/221011-221202_JAVA_BASICS/22-11/221129/)

# 이날 배웠던 것

- [/controller/](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/controller/)
    - [**StudentMain.java**: 성적 관리 프로그램 메인 메뉴](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/controller/StudentMain.java)
    - [**NoticeMain.java**: 게시물 관리 프로그램 메인 메뉴](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/controller/NoticeMain.java)
- [/dao/](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/dao/)
    - [**StudentJdbcDao.java**: 그 프로그램의 각종 기능을 담은 메서드 객체(싱글톤), DB 연동 포함](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/dao/StudentJdbcDao.java)
    - [**NoticeDao.java**: DB와 연동한 게시물 관리 기능을 담은 싱글톤 메서드 객체](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/dao/NoticeDao.java)
- [/DBManager/](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/DBManager/)
    - [**DBConnection.java**: JDBC 드라이버와 Connection 클래스를 이용한 DB 연동 객체](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/DBManager/DBConnection.java)
- [/dto/](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/dto/)
    - [**Student.java**: DB에 저장하는 레코드의 원형이 되는 객체](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/dto/Student.java)
    - [**NoticeDto.java**: 게시물 객체](/221011-221202_JAVA_BASICS/22-11/221128/javastudy/dto/NoticeDto.java)

---

## 자바와 데이터베이스 연계

- 이 날을 위해 우리는 온갖 것들을 배워 온 것이다.
1. 테이블을 만들자.
1. 테이블과 똑같이 객체 형태로 데이터를 주고받기 위한 설계도를 만들자.
1. `INSERT`, `SELECT`, `UPDATE`, `DELETE`를 하기 위한 화면이 필요할 것이다.

## DTO란?

- 자바의 디자인 패턴 중 하나. 응용 소프트웨어의 서브시스템 간 데이터 전송에 사용함. *J2EE 1판에선 Value Object(VO)라고 불렸다고 합니다.*
- Data Transfer Object: 데이터 전송 객체; (딱히 일본어로 따로 불리는 이름은 없음)

## `JDBC`로 Java와 Oracle Database XE 연결하기

- JDBC: Java DataBase Connectivity의 약자.
- 관계형 데이터베이스(Relational database; 関係データベース)에 접속, SQL문을 수행하여 처리하고자 할 때 사용되는 표준 SQL 인터페이스.
- JDBC 개발 절차
    1. *`import`로 JDBC 라이브러리를 불러오는 것도 잊지 맙시다.*
    1. JDBC 드라이버 로드: `Class.forName()`
    1. 데이터베이스 연결: `java.sql.Connection`
    1. Statement 객체 생성: `java.sql.PreparedStatement`
    1. SQL문 전송: `executeQuery()`, `executeUpdate()`
    1. 결과 받기: `java.sql.ResultSet`
    1. 연결 해제: `close()`
- 보통은 DAO에 쓰거나, 아니면 DB를 위한 폴더를 따로 만들기도 한다.

    ```java
    String url = "jdbc:oracle:thin:@localhost:1521:xe"
    ```

## 쿼리문을 자바로 실행해 보기

- `conn`: DB와의 연결
- `pstmt`: `PreparedStatement` 객체로써 쿼리문을 작성하고 실행
    - `executeUpdate()`: `INSERT`, `UPDATE`, `DELETE` 실행
- `rs`: `ResultSet` 객체로써 역시 쿼리문을 실행하나...
    - `executeQuery()`: `SELECT`문을 실행한다.
