### [221220 ←](/221205-_JSP/22-12/221220/) | [→ 221222](/221205-_JSP/22-12/221222/)

# 이날 배웠던 것

- /src/com/jslhrd/
    - controller/notice/
        - [Notice.java](/221205-_JSP/22-12/221221/jslhrdServlet/src/com/jslhrd/controller/notice/Notice.java)
- /WebContent/notice/
    - [notice.jsp](/221205-_JSP/22-12/221221/jslhrdServlet/WebContent/notice/notice.jsp)


---

## INDEX

- 정렬을 빠르게 할 수 있다.
- 힌트가 있다.
    - `SELECT`문 뒤에`/*+ */`를 써서 표기한다.
    - `SELECT /*+ INDEX_DESC (NOTICE NOTICE_PK) */ * FROM NOTICE;`: 기본키 제약인 NOTICE_PK에 따라 만들어진 인덱스에 따라 NOTICE 테이블의 값을 표시 

## ROWNUM과 인라인 뷰

- 페이지 처리를 하기 위해서 사용한다.
- MySQL이나 MariaDB에서는 LIMIT을 사용한다.
- ROWNUM의 경우 SELECT를 할 때마다 나오는 결과의 줄 번호에 다시 붙여진다.
- `ROWNUM > 10 AND ROWNUM <= 20`: ROWNUM은 검색 결과에 숫자를 붙이는 거라서...
    - 그래서 인라인 뷰 기능을 사용한다는 거다.

## `utility.Criteria` 클래스

- 하나의 객체로 묶어서 전달하는 방식이 나중을 생각하면 확장성이 좋다