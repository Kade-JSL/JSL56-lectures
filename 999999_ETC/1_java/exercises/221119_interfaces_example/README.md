# 소스코드 구조

- [/controller](/999999_ETC/1_java/exercises/221119_interfaces_example/controller/)
    - [/Menu.java](/999999_ETC/1_java/exercises/221119_interfaces_example/controller/Menu.java): 메뉴가 실행되는 클래스
- [/dao](/999999_ETC/1_java/exercises/221119_interfaces_example/dao/)
    - [/GeneralActions.java](/999999_ETC/1_java/exercises/221119_interfaces_example/dao/GeneralActions.java): 인터페이스와 그것의 구현. 해당 클래스 타입의 인스턴스는 데이터 처리만을 담당하므로 싱글톤 객체로 만들었다.
- [/dto](/999999_ETC/1_java/exercises/221119_interfaces_example/dto/)
    - [/BankAccount.java](/999999_ETC/1_java/exercises/221119_interfaces_example/dto/BankAccount.java): 일반적인 은행 계좌 특성을 담은 가상 클래스. 다형성을 이용해 여러 타입의 하위 클래스 객체에 접근.
    - [/GeneralAccount.java](/999999_ETC/1_java/exercises/221119_interfaces_example/dto/GeneralAccount.java): 일반 계정의 실제 멤버를 담은 클래스. `BankAccount`의 하위 클래스이다.
    - [/AccountList.java](/999999_ETC/1_java/exercises/221119_interfaces_example/dto/AccountList.java): `BankAccount` 타입 객체를 담는 리스트 객체. 은행은 하나뿐이므로 싱글톤 객체로 만들었다.

# TODO

- 우선 순위 높음
    - GeneralActions에서 발생하는 수많은 예외에 대처하기
    - 관리자 계정 기능 제대로 구현하기
        - removeList() 메서드 구현하고 테스트
- 우선 순위 낮음
    - GeneralAccount 말고도 다른 BankAccount 타입 클래스 만들어 보기
    - 이후 사용되는 개념들을 위해 리팩터링