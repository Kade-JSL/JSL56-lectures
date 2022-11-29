### [221128 ←](/221125-_JAVA_INTERMEDIATE/221128/) | [→ 221130](/221125-_JAVA_INTERMEDIATE/221130/)

# 이날 배웠던 것

- [/controller/](/221125-_JAVA_INTERMEDIATE/221129/javastudy/controller/)
    - [**StudentMain.java**: 성적 관리 프로그램 메인 메뉴](/221125-_JAVA_INTERMEDIATE/221129/javastudy/controller/StudentMain.java)
    - [**NoticeMain.java**: 게시물 관리 프로그램 메인 메뉴](/221125-_JAVA_INTERMEDIATE/221129/javastudy/controller/NoticeMain.java)
- [/dao/](/221125-_JAVA_INTERMEDIATE/221129/javastudy/dao/)
    - [**StudentJdbcDao.java**: 그 프로그램의 각종 기능을 담은 메서드 객체(싱글톤), DB 연동 포함](/221125-_JAVA_INTERMEDIATE/221129/javastudy/dao/StudentJdbcDao.java)
    - [**NoticeDao.java**: ]
- [/DBManager/](/221125-_JAVA_INTERMEDIATE/221129/javastudy/DBManager/)
    - [**DBConnection.java**: JDBC 드라이버와 Connection 클래스를 이용한 DB 연동 객체](/221125-_JAVA_INTERMEDIATE/221129/javastudy/DBManager/DBConnection.java)
- [/dto/](/221125-_JAVA_INTERMEDIATE/221129/javastudy/dto/)
    - [**Student.java**: DB에 저장하는 레코드의 원형이 되는 객체](/221125-_JAVA_INTERMEDIATE/221129/javastudy/dto/Student.java)

---

## 다시 과정을 돌아보자.

- `DBConnection`
    1. 싱글톤 객체 속성을 정의한다.
    1. `Connection` 객체를 만든다.
    1. 네트워크 상의 DB의 URL, 계정, 비밀번호를 적는다.
        - 이 때 URL은 `"jdbc:oracle:thin:@...`으로 시작한다.
        - 순서는 `"[드라이버]:[연결하는 DB]:[드라이버 객체가 사용하는 언어]:@[네트워크 주소]:[DB 리스너 포트 번호]:[DB 버전]"` 순이다.
    1. 