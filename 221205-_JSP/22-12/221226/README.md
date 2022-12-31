### [221223 ←](/221205-_JSP/22-12/221223/) | [→ 221227](/221205-_JSP/22-12/221227/)

# 이날 배웠던 것

- /src/com/jslhrd
    - /controller
        - /faq/
            - [**Faq.java**](/221205-_JSP/22-12/221226/jslhrdServlet/src/com/jslhrd/controller/faq/Faq.java)
        - /portfolio/
            - [**Portfolio.java**](/221205-_JSP/22-12/221226/jslhrdServlet/src/com/jslhrd/controller/portfolio/Portfolio.java)
            - [**PortfolioView.java**](/221205-_JSP/22-12/221226/jslhrdServlet/src/com/jslhrd/controller/portfolio/PorfolioView.java)
    - /dao
        - [**NoticeDao.java**](/221205-_JSP/22-12/221226/jslhrdServlet/src/com/jslhrd/dao/NoticeDao.java)
        - [**FaqDao.java**: 더보기 버튼을 눌러 글자 갯수 늘리기 구현, 스크롤 아래로는 안 내려감](/221205-_JSP/22-12/221226/jslhrdServlet/src/com/jslhrd/dao/FaqDao.java)
        - [**PortfolioDao.java**](/221205-_JSP/22-12/221226/jslhrdServlet/src/com/jslhrd/dao/PortfolioDao.java)
- /WebContent
    - /faq/
        - [**faq.jsp**](/221205-_JSP/22-12/221226/jslhrdServlet/WebContent/faq/faq.jsp)
    - /portfolio/
        - [**portfolio.jsp**: 이미지가 삽입된 감동적인 모습](/221205-_JSP/22-12/221226/jslhrdServlet/WebContent/portfolio/portfolio.jsp)
        - [**portfolioview.jsp**: 아직은 그냥 만들어만 놓은 상태](/221205-_JSP/22-12/221226/jslhrdServlet/WebContent/portfolio/portfolioview.jsp)

---

## 페이지 공통 요소

- 일단 게시판 형식이라 `c:forEach`문으로 받은 DTO 배열을 줄줄이 늘어놓는다.