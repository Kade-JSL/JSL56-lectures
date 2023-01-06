### [230102 ←](/221205-_JSP/230102/) | [→ 230106](/221205-_JSP/230106/)

# 이날 배웠던 것

- [login.jsp](/221205-_JSP/230104/jslhrdServlet/login.jsp): 회원 로그인 기능 구현
    - 관련 서블릿 구현([LoginServlet.java : /login.do](/221205-_JSP/230104/jslhrdServlet/LoginServlet.java))
        - `HttpSession` 객체로 로그인 상태를 브라우저(=세션)가 닫힐 때까지 유지시키고 header.jsp에서도 JSTL core 태그로 로그아웃과 마이페이지 메뉴가 뜨도록 구현 _(작은 수정이라 링크하지 않음)_
    - 로그아웃 기능 구현([LogoutServlet.java : /logout.do](/221205-_JSP/230104/jslhrdServlet/LogoutServlet.java))
        - `HttpSession.removeAttribute()`
        - `HttpSession.invalidate()`
- [index.jsp](/221205-_JSP/230104/jslhrdServlet/index.jsp) 관련 백엔드 수정
    - 포트폴리오 표시 부분, 공지사항 표시 부분에 대한 DAO 생성([MainDao.java](/221205-_JSP/230104/jslhrdServlet/MainDao.java))
    - 이에 따라 서블릿 역시 수정함([Index.java](/221205-_JSP/230104/jslhrdServlet/Index.java))
- index.jsp 프런트엔드 수정
    - 탭뷰가 정상적으로 작동하도록 [layout.css](/221205-_JSP/230104/jslhrdServlet/layout.css)와 index.jsp 안의 jQuery 수정
- 관리자 메뉴 구현
    - [admin.jsp](/221205-_JSP/230104/jslhrdServlet/admin.jsp) → [AdminServlet.java](/221205-_JSP/230104/jslhrdServlet/AdminServlet.java) → [adminmain.jsp](/221205-_JSP/230104/jslhrdServlet/adminmain.jsp)
    - 화면구현 관련 js를 따로 [admin.js](/221205-_JSP/230104/jslhrdServlet/admin.js)에 저장
