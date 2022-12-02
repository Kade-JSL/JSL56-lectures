### [221201 ←](/221125-_JAVA_INTERMEDIATE/221201/) | [→ 221205](/221125-_JAVA_INTERMEDIATE/221205/)

# 이날 배웠던 것

- [/**sqlinput.sql**: 이제는 세 개의 테이블을 `JOIN`해 보자](/221125-_JAVA_INTERMEDIATE/221201/javastudy/sqlinput.sql)
- [/controller/**HomeShoppingMain.java**: 회원 매출 목록 추가 (홈쇼핑 회원 관리 프로그램 프런트엔드)](/221125-_JAVA_INTERMEDIATE/221201/javastudy/controller/HomeShoppingMain.java)
- [/dao/**HomeShoppingDao.java**: 매출 목록 쿼리 메서드 추가 (관리 프로그램 DB 연동 객체)](/221125-_JAVA_INTERMEDIATE/221201/javastudy/dao/HomeShoppingDao.java)
- [/DBManager/DBConnection.java](/221125-_JAVA_INTERMEDIATE/221201/javastudy/DBManager/DBConnection.java)
- [/dto/**HomeShoppingDto.java**: `JOIN`되는 테이블의 컬럼 멤버 변수 추가 (DB에 전송되는 객체)](/221125-_JAVA_INTERMEDIATE/221201/javastudy/dto/HomeShoppingDto.java)

---

## ANSI 조인에서의 테이블 여러 개 붙이기

```sql
SELECT
    [조인해서 띄울 컬럼들]
FROM
    [메인 테이블]
    INNER JOIN [조인 테이블 1]
    ON [조건 1]
    INNER JOIN [조인 테이블 2]
    ON [조건 2]
```

## 사용한 