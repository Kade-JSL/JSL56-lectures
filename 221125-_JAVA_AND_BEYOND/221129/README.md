### [221128 ←](/221125-_JAVA_AND_BEYOND/221128/) | [→ 221130](/221125-_JAVA_AND_BEYOND/221130/)

# 이날 배웠던 것

- [/controller/](/221125-_JAVA_AND_BEYOND/221129/javastudy/controller/)
    - [**StudentMain.java**: 성적 관리 프로그램 메인 메뉴](/221125-_JAVA_AND_BEYOND/221129/javastudy/controller/StudentMain.java)
- [/dao/](/221125-_JAVA_AND_BEYOND/221129/javastudy/dao/)
    - [**StudentJdbcDao.java**: (그 프로그램의 각종 기능을 담은 메서드 객체(싱글톤), DB 연동 포함) 전체 출력 기능 추가](/221125-_JAVA_AND_BEYOND/221129/javastudy/dao/StudentJdbcDao.java)
- [/DBManager/](/221125-_JAVA_AND_BEYOND/221129/javastudy/DBManager/)
    - [**DBConnection.java**: JDBC 드라이버와 Connection 클래스를 이용한 DB 연동 객체](/221125-_JAVA_AND_BEYOND/221129/javastudy/DBManager/DBConnection.java)
- [/dto/](/221125-_JAVA_AND_BEYOND/221129/javastudy/dto/)
    - [**Student.java**: DB에 저장하는 레코드의 원형이 되는 객체](/221125-_JAVA_AND_BEYOND/221129/javastudy/dto/Student.java)

---

## 다시 과정을 돌아보자.

- `DBConnection`
    1. 싱글톤 객체 속성을 정의한다.
    1. `Connection` 객체를 만든다.
    1. 네트워크 상의 DB의 URL, 계정, 비밀번호를 `String`형으로 적는다.
        - 이 때 URL은 `"jdbc:oracle:thin:@...`으로 시작한다.
        - 순서는 `"[드라이버]:[연결하는 DB]:[드라이버 객체가 사용하는 언어]:@[네트워크 주소]:[DB 리스너 포트 번호]:[DB 버전]"` 순이다.
    1. `conn.getConnection(url, id, pw)` 메서드로 연결을 시작한다.

## `SELECT * FROM STUDENT`

1. 처음에 `rs.next()`는 첫 번째 줄을 가리키게 된다.
1. 이것을 `Student`형 객체에 담는다.
    1. `Student` 객체를 생성하고
    1. `rs.get[자료형]([컬럼명])`을 이용하여 각 레코드의 열을 받고
    1. `Student`의 `set...()` 메서드를 이용하여 받은 데이터를 차례차례 넣는다.
1. `while (rs.next())`를 이용하여 레코드 하나하나를 가변 배열에 담는다.
1. 이렇게 받은 가변 배열을 그대로 리턴해 준다.
1. `...Main` 클래스로 돌아가서 요구받은 방식대로 리턴받은 배열을 출력한다.

## 왜 자꾸 출력을 `Main`에서 하려는 걸까?

- 나중에 배울 JSP에서 실제 웹페이지로 나가는 부분이 Main이 될 것이기 때문이다.