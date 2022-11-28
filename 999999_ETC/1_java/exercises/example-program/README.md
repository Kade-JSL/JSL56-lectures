# 소스코드 구조(ver. 0.1.1)

- [/controller](/999999_ETC/1_java/exercises/example-program/controller/)
    - [/Menu.java](/999999_ETC/1_java/exercises/example-program/controller/Menu.java): 메뉴가 실행되는 클래스
- [/dao](/999999_ETC/1_java/exercises/example-program/dao/)
    - [/GeneralActions.java](/999999_ETC/1_java/exercises/example-program/dao/GeneralActions.java): 인터페이스와 그것의 구현. 프리릴리즈 버전에선 계좌 생성 기능밖에 없음.
    - [/DBConnection.java](/999999_ETC/1_java/exercises/example-program/dao/DBConnection.java): 사용자 컴퓨터에 있는 `BANKDBA`/`BANK1234` 계정에 있는 `LITEACCOUNT` 테이블이 있어야 제대로 작동.
- [/dto](/999999_ETC/1_java/exercises/example-program/dto/)
    - [/BankAccount.java](/999999_ETC/1_java/exercises/example-program/dto/BankAccount.java): 일반적인 은행 계좌 특성을 담은 가상 클래스. 다형성을 이용해 여러 타입의 하위 클래스 객체에 접근.
    - [/LiteAccount.java](/999999_ETC/1_java/exercises/example-program/dto/LiteAccount.java): 일반 계정의 실제 멤버를 담은 클래스. `BankAccount`의 하위 클래스이다.

# TODO

- 우선 순위 높음
    - DB 연동에 수반되는 CRUD 메서드 다시 구현하기
    - GeneralActions에서 발생하는 수많은 예외에 대처하기
    - 더 많이 배워서 리포지토리에 DB를 내장할 수 있도록 해 보기

- 우선 순위 낮음
    - LiteAccount 말고도 다른 BankAccount 타입 클래스 만들어 보기
    - 이후 사용되는 개념들을 위해 리팩터링
    - 관리자 계정 기능 제대로 구현하기
        - remove() 메서드 구현하고 테스트