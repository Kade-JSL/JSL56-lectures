### [221114 ←](/221011-221202_JAVA_BASICS/22-11/221114) | [→ 221116](/221011-221202_JAVA_BASICS/22-11/221116/)

# 이날 배웠던 것

- [**/dao/DBConn.java**: 데이터베이스와 자바 코드를 연계하는 Connector 클래스와 그에 필요한 라이브러리들](/221011-221202_JAVA_BASICS/22-11/221115/javastudy/dao/DBConn.java)
- [**/controller/SingletonMain.java**: 싱글톤 패턴의 개념과 Java에서의 그 구현](/221011-221202_JAVA_BASICS/22-11/221115/javastudy/controller/SingletonMain.java)

---

## Singleton 패턴

- 하나의 어플리케이션에서 오로지 단 하나만 생성되는 객체(인스턴스)
    - 사용자 환경설정
    - 커넥션 풀
    - 사용자 정보 로딩 등에 사용됨
- 이 패턴을 만드는 순서
    1. 해당 클래스에 자신의 타입으로 정적 멤버를 선언함과 동시에 생성됨
    1. 외부에서 new 예약어로 인스턴스 생성을 할 수 없도록 생성자는 private 처리
    1. 정적 멤버의 주소를 넘겨주기 위해서 외부에서 호출할 수 있는 `getInstance()` 메서드를 제공

## Java와 데이터베이스(Oracle DB)의 연결 방법

1. Oracle DB 드라이버 로드
2. Oracle Java DB Connector 연결(`ojdbc6.jar`: `oraclexe/app/oracle/product/11.2.0/server/jdbc/lib/`)
    - 보통 이 과정이 부하가 가장 크기 대문에, 한 번 연결된 객체를 계속 사용하는 것이 좋다
    - 그러니까 Singleton을 쓴다 그 이야기다!
3. `oracle.jdbc.connector`와 `oracle.jdbc.driver` 패키지 안의 클래스들을 자주 쓴다.

- Singleton 패턴을 이용해서 이 DB를 연결하는 객체를 생성할 것이다.
- 그리고 DB의 CRUD(Create, Read, Update, Delete) 작업을 이걸로 할 것이다.

## 경로 해석

- 드라이버 `oracle.jdbc.driver.OracleDriver`
    - `ojdbc6.jar`의 `oracle.jdbc.driver` 패키지
        - 거기 있는 `OracleDriver` 클래스
- URL `jdbc:oracle:thin:@localhost:1521:xe`(또는 `orcl`)
    - `jdbc` 데이터베이스 연결 라이브러리
    - `oracle` DBMS 소프트웨어
    - `thin` 사용하는 소스 코드의 언어(java)
    - `@localhost` 말 그대로 자기 자신의 IP
        - 데이터베이스가 리스너로 사용하는 포트 `:1521`
        - 개인용 `xe` 버전(기업용 `orcl`)