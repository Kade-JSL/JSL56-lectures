## _아직 미완성 코드(WIP)라 그대로 복붙하는 것에 대해서 발생하는 재산상의 피해는 보상하지 않습니다._



# 소스코드 구조

- [/controller](/999999_ETC/1_java/exercises/221119_interfaces_example/controller/)
    - [/Menu.java](/999999_ETC/1_java/exercises/221119_interfaces_example/controller/Menu.java): 메뉴가 실행되는 클래스
- [/dao](/999999_ETC/1_java/exercises/221119_interfaces_example/dao/)
    - [/AccountActions.java](/999999_ETC/1_java/exercises/221119_interfaces_example/dao/AccountActions.java): 인터페이스와 그것의 구현. 해당 클래스 타입의 인스턴스는 데이터 처리만을 담당하므로 싱글톤 객체로 만들었다.
- [/dto](/999999_ETC/1_java/exercises/221119_interfaces_example/dto/)
    - [/BankAccount.java](/999999_ETC/1_java/exercises/221119_interfaces_example/dto/BankAccount.java): 일반적인 은행 계좌 특성을 담은 가상 클래스. 다형성을 이용해 여러 타입의 하위 클래스 객체에 접근.
    - [/GeneralAccount.java](/999999_ETC/1_java/exercises/221119_interfaces_example/dto/GeneralAccount.java): 일반 계정의 실제 멤버를 담은 클래스. `BankAccount`의 하위 클래스이다.
    - [/AccountList.java](/999999_ETC/1_java/exercises/221119_interfaces_example/dto/AccountList.java): `BankAccount` 타입 객체를 담는 리스트 객체. 은행은 하나뿐이므로 싱글톤 객체로 만들었다.