### [221205 ←](/221205-_JSP/221205/) | [→ 221207](/221205-_JSP/221207/)

# 이날 배웠던 것

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