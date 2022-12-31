### [221209 ←](/221205-_JSP/22-12/221209/) | [→ 221213](/221205-_JSP/22-12/221213/)

# 이날 배웠던 것

- [/src/](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/)
    - [controller/](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/controller/)
        - [DbTestServlet.java](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/controller/DbTestServlet.java)
        - [**IndexServlet.java**](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/controller/IndexServlet.java): `main.do` 리퀘스트에 `index.jsp` 리스폰스를 보내는 서블릿
        - [**Sub1Servlet.java**](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/controller/Sub1Servlet.java): `sub1.do` 
            - [**Sub1ProServlet.java**](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/controller/Sub1ProServlet.java): `sub1pro.do`, `<form>`으로 받은 데이터를 DTO에 저장하고 DAO에 넘김
    - [dao/](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/dao/)
        - [**ArtistDao.java**](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/dao/ArtistDao.java): `INSERT` 메서드 구현
    - [DBManager/](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/DBManager/)
        - [DBManager.java](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/DBManager/DBManager.java)
    - [dto/](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/dto/)
        - [**ArtistDto.java**](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/src/dto/ArtistDto.java): 말 그대로 DB에 넘겨주는 객체
- [/WebContent/](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/WebContent/)
    - [dbtest.jsp](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/WebContent/dbtest.jsp)
    - [**index.jsp**](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/WebContent/index.jsp): main.do로 리다이렉트되는 페이지
    - [**sub1.jsp**](/221205-_JSP/22-12/221212/jspstudy56/kadeServlet/WebContent/sub1.jsp): 이제 따로 폼을 넘겨주는 JSP가 없음

---

## Servlet 패턴

- 자바를 사용하여 웹...저시기(문서, 서버, 앱, 할튼 거시기)를 만들기 위하여 필요한 기술
- 클라이언트가 어떠한 요청을 하면 그에 대한 결과를 다시 전송해 주어야 하는데, 이러한 역할을 하는 자바 프로그래밍 기법을 말함
- `doGet()` 메서드는 클라이언트가 HTTP 요청으로 `GET`이 들어오면 자동으로 실행, `doPost()` 메서드는 `POST` 요청에 반응하여 자동으로 실행
    - 이런 걸 해 주는 **Java** 코드를 서블릿이라 하는 것.
- JSP도 실행하면 파일이 **먼저 서블릿 파일로 변환**된 다음 바이트코드가 된다.
- `request.getContextPath()`: URL 경로를 반환하는 메서드
- 요청 주소와 클래스를 다르게 하니까 아무래도 보안이 더 좋아짐

## `~~.do`

- 확장자 자체는 아무 의미 없음
- 그냥 뭘 **한다**는 뜻. 뒤에 뭔가는 아무런 의미가 없음

## `GET` 요청에 대응하기

- `setAttribute()` 메서드: 특정 속성 변수에 값을 저장하게 하기
- `RequestDispatcher` 클래스: `request` 객체에 저장된 값과 `response` 객체에 저장된 값을 `getRequestDispatcher()` 메서드에서 지정된 곳으로 `forward()` 메서드를 통해 보낼 것
- `${result}`: `result` 속성에 저장된 값을 출력할 것
    - **표현 언어**라고도 한다.
- 결국 그래서 JSP는 결과를 보여주는 정적 기능에 지나지 않고, 결국에 뒤에서 일어나는 일은 서블릿이 담당하게 됨

## `%` 패턴과는 이제 안녕이다

- 좀 약간 HTML이 가독성이 안 좋아 보이지 않냐?
    - *저는 아무 문제 없어 보입니다만...*
- 아무튼 `%` 태그를 사용하면 가독성도 떨어지고 불편하댄다.
- 그래서 JSTL이라는 라이브러리가 개발되었댄다.
- `${}` 표현 언어: JSP 출력 부분을 쉽게 하기 위해 개발된 태그