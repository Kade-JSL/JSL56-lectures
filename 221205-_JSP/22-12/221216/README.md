### [221215 ←](/221205-_JSP/22-12/221215/) | [→ 221219](/221205-_JSP/22-12/221219/)

# 이날 배웠던 것

- [/src/com/jslhrd/](/221205-_JSP/22-12/221216/jslhrdServlet/src/com/jslhrd/)
    - [controller/notice/](/221205-_JSP/22-12/221216/jslhrdServlet/src/com/jslhrd/controller/notice/)
        - [**NoticeView.java**](/221205-_JSP/22-12/221216/jslhrdServlet/src/com/jslhrd/controller/notice/NoticeView.java): 게시물 보기 컨트롤러
    - [dao/](/221205-_JSP/22-12/221216/jslhrdServlet/src/com/jslhrd/dao/)
        - [**NoticeDao.java**](/221205-_JSP/22-12/221216/jslhrdServlet/src/com/jslhrd/dao/NoticeDao.java): 게시물 보기 관련 모델
- [/WebContent/notice/](/221205-_JSP/22-12/221216/jslhrdServlet/WebContent/notice)
    - [**notice.jsp**](/221205-_JSP/22-12/221216/jslhrdServlet/WebContent/notice/notice.jsp): noticeview.do로 이동하는 링크 삽입
    - [**noticeView.jsp**](/221205-_JSP/22-12/221216/jslhrdServlet/WebContent/notice/noticeView.jsp): 게시물 뷰

---

## `GET` 요청은 주소창으로 보낸다

- **/**: 루트 URL
- /**[웹페이지 이름]**: 처리 프로그램
- /[웹페이지 이름]**?[변수]=[값]**: 넘어가는 속성과 그 값
- /[웹페이지 이름]?[변수1]=[값1]**&[변수2]=[값2]**: 여러 개를 넣을 수 있다.
- **?**부터 들어가는 값들은 URI라고 불리며, `GET` 요청과 같이 들어가는 값들을 말한다.