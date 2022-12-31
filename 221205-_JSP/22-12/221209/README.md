### [221208 ←](/221205-_JSP/22-12/221208/) | [→ 221212](/221205-_JSP/22-12/221212/)

# 이날 배웠던 것: 산업기사 모의 시험(오디션 관리) #2

- [**예방접종관리 Ver1.0.pdf**: 시험 요구 사항](/221205-_JSP/22-12/221209/%EC%98%88%EB%B0%A9%EC%A0%91%EC%A2%85%EA%B4%80%EB%A6%AC%20Ver1.0.pdf)
- [/src/model/](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/src/model/)
    - [**Dao.java**: 데이터베이스 접근 객체](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/src/model/Dao.java)
    - [DBConn.java: 데이터베이스 접속 객체](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/src/model/DBConn.java)
    - [**Dto.java**: 데이터베이스 전송 객체](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/src/model/Dto.java)
- [/WebContent/](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/WebContent/)
    - [WEB-INF/lib/ojdbc.jar: 오라클 DB XE thin(자바) 드라이버](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/WebContent/WEB-INF/lib/ojdbc6.jar)
    - [index.jsp: 메인 메뉴, 스타일시트 결정](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/WebContent/index.jsp)
    - [**sub1.jsp**: DAO 메서드로 데이터를 쿼리하여 DTO 배열로 그것을 받아 화면에 출력](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/WebContent/read-artist.jsp)
    - [**sub2.jsp**: 접종 신청자를 `<form>` 태그로 받음](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/WebContent/create-artist.jsp)
        - [**sub2pro.jsp**: `<form>`에 저장된 데이터를 `request` 객체로 자바 DTO에 저장](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/WebContent/cr1-action.jsp)
    - [**sub3.jsp**: 호출하는 DAO 메서드의 쿼리문이 `JOIN`을 포함하는 것을 제외하면 모든 작업이 동일함](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/WebContent/read-mentor.jsp)
    - [**sub4.jsp**: 약간 더 심화된 `JOIN` 쿼리를 사용](/221205-_JSP/22-12/221209/jspstudy56/cbq_02/WebContent/read-rank.jsp)
- [**tbl_cust_201004.sql**: 과제 테이블을 만들고 DAO 메서드의 쿼리문을 테스트했던 PL/SQL 문서](/221205-_JSP/22-12/221209/tbl_cust_201004.sql)

---

## 코딩하면서 자주 틀린 것들

- 쿼리문 `)`와 `;`
    - 괄호가 없으면 SQL 문법 에러로 쿼리가 들어가지 않음
    - 세미콜론이 있으면 `pstmt` 객체가 쿼리를 실행하지 않음
    - 띄어쓰기를 제대로 안 하면 단어끼리 붙어서 문법 에러가 나옴
    - SQL Developer에서는 정상 작동하나 코드에선 작동하지 않으면 십중팔구 이 문제
- DTO 필드의 자료형
    - `<form>`을 통해 넘어오는 데이터는 전부(적어도 시험문제 안에서는) `String`형이라 생각할 것
    - 무언가 자릿수 같은 걸 나누어야 할 땐 숫자라도 `String`으로 저장할 것
    -  

## `TBL_CUST_201004`의 컬럼 `P_CITY`의 값이

- '10'이면 '서울'
- '20'이면 '경기'
- '30'이면 '강원'
- '40'이면 '대구'