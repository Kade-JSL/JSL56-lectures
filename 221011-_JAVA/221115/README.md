### [221114 ←](/221011-_JAVA/221114) | _→ 221116_<!--(/221011-_JAVA/221116/)-->

# 이날 배웠던 것

-

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
2. Connection DB 연결(`ojdbc6.jar`: `oraclexe/app/oracle/product/11.2.0/server/jdbc/lib/`; Oracle Java DB Connector)
    - 보통 이 과정이 부하가 가장 크기 대문에, 한 번 연결된 객체를 계속 사용하는 것이 좋다
    - 그러니까 Singleton을 쓴다 그 이야기다!
3. `oracle.jdbc.connector`와 `oracle.jdbc.driver` 패키지 안의 클래스들을 자주 쓴다.

- Singleton 패턴을 이용해서 이 DB를 연결하는 객체를 생성할 것이다.
- 그리고 DB의 CRUD(Create, Read, Update, Delete) 작업을 이걸로 할 것이다.
