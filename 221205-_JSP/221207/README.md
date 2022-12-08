### [221206 ←](/221205-_JSP/221206/) | [→ 221208](/221205-_JSP/221208/)

# 이날 배웠던 것

- 기존 프로그램의 파일은 그대로, VO 약간 수정
- [/src/model/**Dao.java**: 반별 성적 쿼리 메서드 추가](/221205-_JSP/221207/jspstudy56/HighScore/src/model/Dao.java)
- [/WebContent/**sub4.jsp**: 똑같은 자바 코드 임베드, 근데 이제 반별 통계를 쿼리로 넣는](/221205-_JSP/221207/jspstudy56/HighScore/WebContent/sub4.jsp)

---

## VO 디자인

- VO의 경우 일반적으로 하나의 데이터베이스와 통신하는 경우에 하나의 VO(Value Object)가 할당되는 편이라 생각한다.
- 따라서 거기 들어 있는 테이블의 컬럼이 필드 값으로써 모조리 들어가 있고, 당연히 캡슐화를 위해 `get()`이랑 `set()`으로 입출력을 한다.
- 데이터베이스 전송 객체, 즉 DTO(Database Transfer Object)라고도 불리는 데에는 이러한 이유가 있다.

## DAO 디자인

- Database Access Object의 뜻에서 알 수 있듯이 데이터베이스에 쿼리문을 직접 넣고 받은 결과를 다시 사용하는 프로그래밍 언어에 맞게 가공하는 기능을 하는 객체이다.
- DB 연결 객체가 일반적으로 하나에 하나씩만 있는 것처럼, 이 객체 역시 한 연결 하나에 DAO는 하나만 있게 디자인한다. 즉 싱글톤 패턴을 따르도록 만든다.
- 현재 디자인하고 있는 성적 관리 프로그램의 경우 CRUD 중 Create와 Read만 구현한 상태로, U와 D는 아마도 개인 프로젝트에서 하게 되지 않을까 한다.
    - 모든 쿼리문을 쓸 때는 DBMS 쪽에서 반드시 테스트해 볼 것
    - 쿼리문을 코드에 복사할 때는 반드시 띄어쓰기를 다시 확인할 것
    - `insertStudent(Vo vo)`: `INSERT INTO TBL_STUDENT`
    - `insertScore(Vo vo)`: `INSERT INTO TBL_SCORE`
    - `selectAllStudent()`: `JOIN` 쿼리를 이용해서 원하는 컬럼만 추출
    - `selectAllClass()`: 똑같이 `JOIN`문을 이용,