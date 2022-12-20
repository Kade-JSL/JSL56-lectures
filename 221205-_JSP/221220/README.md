### [221219 ←](/221205-_JSP/221219/) | [→ 221221](/221205-_JSP/221221/)

# 이날 배웠던 것

- [/src/com/jslhrd/](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/)
    - [controller/](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/)
        - [notice/](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/notice/)
            - [**NoticeWrite.java**](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/notice/NoticeWrite.java): Create-Controller
            - [**NoticeView.java**](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/notice/NoticeView.java): Read-Controller
            - [**NoticeModify.java**](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/notice/NoticeModify.java): Update-Controller
            - [**NoticeDelete.java**](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/notice/NoticeDelete.java): Delete-Controller
        - [faq/](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/faq/)
            - [**FaqInsert.java**](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/faq/FaqInsert.java): Create-Controller
            - [**Faq.java**](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/controller/faq/): Read-Controller
    - [dao/](/221205-_JSP/221216/jslhrdServlet/src/com/jslhrd/dao/)
        - [**NoticeDao.java**](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/dao/NoticeDao.java): CRUD-Model 전부 완성
        - [**FaqDao.java**](/221205-_JSP/221220/jslhrdServlet/src/com/jslhrd/dao/FaqDao.java): 아직은 Create-와 Read-Model만 구현
- [/WebContent/](/221205-_JSP/221220/jslhrdServlet/WebContent/)
    - [notice/](/221205-_JSP/221220/jslhrdServlet/WebContent/notice)
        - [**noticeWrite.jsp**](/221205-_JSP/221220/jslhrdServlet/WebContent/notice/noticeWrite.jsp): Create-View
        - [**notice.jsp**](/221205-_JSP/221220/jslhrdServlet/WebContent/notice/notice.jsp): 일종의 Read-View
        - [**noticeView.jsp**](/221205-_JSP/221220/jslhrdServlet/WebContent/notice/noticeView.jsp): Read-View
        - [**noticeWrite.jsp**](/221205-_JSP/221220/jslhrdServlet/WebContent/notice/noticeWrite.jsp): Update-View
        - Delete-View는 굳이 말하자면 삭제 확인 창 정도가 되겠습니다만, 당연히 그냥 서블릿으로만 구현되어 있습니다.
    - [faq/](/221205-_JSP/221220/jslhrdServlet/WebContent/faq/)
        - [**faqWrite.jsp**](/221205-_JSP/221220/jslhrdServlet/WebContent/faq/faqWrite.jsp): Create-View
        - [**faq.jsp**](/221205-_JSP/221220/jslhrdServlet/WebContent/faq/faq.jsp): Read-View
- [**sqlinput.sql**](/221205-_JSP/221220/sqlinput.sql): FAQ1 테이블과 FAQ2 테이블 생성, 레코드 삽입, 검색 및 기타 작업 관련 쿼리

---

## 벌써 우리는 MVC 모델을 하고 있어요!

- 제가 그렇게 링크를 분류해 놨다구요!