### [221205 ←](/221205-_JSP/22-12/221205/) | [→ 221207](/221205-_JSP/22-12/221207/)

# 이날 배웠던 것

- [/src/model/](/221205-_JSP/22-12/221206/jspstudy56/HighScore/src/model/)
    - [**Vo.java**: DB에서 넘어온 값들이 정리되는 객체](/221205-_JSP/22-12/221206/jspstudy56/HighScore/src/model/Vo.java)
    - [**Dao.java**: DB에 접근하여 VO 객체를 활용하는 객체](/221205-_JSP/22-12/221206/jspstudy56/HighScore/src/model/Dao.java)
- [/WebContent/](/221205-_JSP/22-12/221206/jspstudy56/HighScore/WebContent/)
    - [**sub1.jsp**: `<form>` 태그로 학생 등록](/221205-_JSP/22-12/221206/jspstudy56/HighScore/WebContent/sub1.jsp)
        - [**sub1pro.jsp**: `request` 객체로 넘어온 값을 DAO를 통해 `TBL_STUDENT`에 쿼리](/221205-_JSP/22-12/221206/jspstudy56/HighScore/WebContent/sub1pro.jsp)
    - [**sub2.jsp**: 같은 태그로 성적 입력](/221205-_JSP/22-12/221206/jspstudy56/HighScore/WebContent/sub2.jsp)
        - [**sub2pro.jsp**: 같은 방법으로 `TBL_SCORE`에 쿼리](/221205-_JSP/22-12/221206/jspstudy56/HighScore/WebContent/sub2pro.jsp)
    - [**sub3.jsp**: Servlet을 이용해 JSP 파일에 자바 코드를 임베드](/221205-_JSP/22-12/221206/jspstudy56/HighScore/WebContent/sub3.jsp)

---

## Request, response

- sub1.jsp에서 넘어온 값은 sub1pro.jsp로 가고, 여기에서 request(요청) 객체를 이용하여 VO(Value Object)에 그 값을 담게 된다.
    - 다시 정리해 보자:
    1. request 객체로 요청,
    1. VO에 저장,
    1. DAO(Data Access Object; 데이터 접근 객체) 객체의 저장 메서드를 호출하여서,
    1. DB 연결 객체로 VO를 DB에 저장시킨다.
    1. response 객체를 통해 원래 페이지로 돌릴 수도 있다. 

## 웹에서 DB까지

1. HTML의 `<form>` 태그
    - 변수는 `name=""` 속성으로 저장
1. JSP의 `request.getParameter()` 메서드
    - VO 객체를 생성해서 `set()` 메서드로 값 저장
1. Java의 DAO 객체의 `PreparedStatement` 객체
    - `pstmt.set()` 메서드를 호출하여
    - 쿼리문에서의 데이터 위치를 첫 번째 인수로,
    - 넘어온 VO 객체의 멤버를 `get()` 메서드로 뽑아내어 쿼리문에 세팅할 `VALUES`로 지정
1. `pstmt.executeUpdate()`로 JDBC 데이터베이스 쿼리
1. 오라클 DB에서 제대로 값이 넘어왔는가 확인