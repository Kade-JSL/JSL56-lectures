### [221214 ←](/221205-_JSP/221214/) | [→ 221216](/221205-_JSP/221216/)

# 이날 배웠던 것

- [/src/com/jslhrd/](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/)
    - [controller/notice/](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/controller/notice/)
        - [**NoticeWritePro.java**](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/controller/notice/NoticeWritePro.java): 공지사항 내용 처리 컨트롤러
    - [dao/](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/dao/)
        - [**NoticeDao.java**](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/dao/NoticeDao.java): 공지사항 DB 삽입 메서드 추가
    - [dbmanager/](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/dbmanager/)
        - [DBManager.java](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/dbmanager/DBManager.java)
    - [dto/](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/dto/)
        - [NoticeDto.java](/221205-_JSP/221215/jslhrdServlet/src/com/jslhrd/dto/NoticeDto.java)
- [/WebContent/](/221205-_JSP/221215/jslhrdServlet/WebContent)
    - [/notice](/221205-_JSP/221215/jslhrdServlet/WebContent/notice)
        - [**NoticeWrite.jsp**](/221205-_JSP/221215/jslhrdServlet/WebContent/notice/noticeWrite.jsp)
    - [/WEB-INF/](/221205-_JSP/221215/jslhrdServlet/WebContent/WEB-INF/)
        - [**web.xml**](/221205-_JSP/221215/jslhrdServlet/WebContent/WEB-INF/web.xml): JW 군이 보내준 선물

---

## 프로젝트 웹페이지 기본 틀

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ include file="../footer.jsp"%>
```