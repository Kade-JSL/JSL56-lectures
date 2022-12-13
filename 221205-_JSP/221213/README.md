### [221212 ←](/221205-_JSP/221212/) | [→ 221214](/221205-_JSP/221214/)

- [Jakarta Taglibs Standard 1.1.2](http://archive.apache.org/dist/jakarta/taglibs/standard/binaries/jakarta-taglibs-standard-1.1.2.zip)

- [/src/](/221205-_JSP/221213/jspstudy56/kadeServlet/src/)
    - [controller/](/221205-_JSP/221213/jspstudy56/kadeServlet/src/controller/)
        - [**Sub2Servlet.java**](/221205-_JSP/221213/jspstudy56/kadeServlet/src/controller/Sub2Servlet.java): `SELECT *`
        - [**Sub3Servlet.java**](/221205-_JSP/221213/jspstudy56/kadeServlet/src/controller/Sub3Servlet.java): `INNER JOIN`
        - [**Sub4Servlet.java**](/221205-_JSP/221213/jspstudy56/kadeServlet/src/controller/Sub4Servlet.java): `INNER JOIN` **"2배"**
    - [dao/](/221205-_JSP/221213/jspstudy56/kadeServlet/src/dao/)
        - [**ArtistDao.java**](/221205-_JSP/221213/jspstudy56/kadeServlet/src/dao/ArtistDao.java): 세 개의 `SELECT` 쿼리 메서드 추가
    - [dto/](/221205-_JSP/221213/jspstudy56/kadeServlet/src/dto/)
        - [**ArtistDto.java**](/221205-_JSP/221213/jspstudy56/kadeServlet/src/dto/ArtistDto.java)
- [/WebContent/](/221205-_JSP/221213/jspstudy56/kadeServlet/WebContent/)
    - [**sub2.jsp**](/221205-_JSP/221213/jspstudy56/kadeServlet/WebContent/sub2.jsp): JSTL core 본격 구사하기
    - [**sub3.jsp**](/221205-_JSP/221213/jspstudy56/kadeServlet/WebContent/sub3.jsp)
    - [**sub4.jsp**](/221205-_JSP/221213/jspstudy56/kadeServlet/WebContent/sub4.jsp): fmt까지 써 보도록 하자
        - _[똑같은 기능을 구현한 다른 소스 코드](/221205-_JSP/221208/jspstudy56/cbq_02/WebContent/read-rank.jsp)와 비교해 보죠._

---

## JSTL을 이용하여 리스트 출력을 해 보자

- `core` 태그를 이용해서 외부에 출력해 본다
- 아래와 같은 코드는...

    ```html
    <c:foreach var="list" items=${dtoList}>
    ```

- ...아래와 같다.

    ```jsp
    <% for (Dto list : dtoList) { %>
    ```

- `<c:choose><c:when test="${list.getArtist_gender} == 'M'"`: 자바의 `if` ~ `else`문과 동일
- `varStatus`: 반복 상태를 나타내 주는 속성

## 쓰던 Scriptlet 계속 쓰지 JSTL을 굳이 왜 쓰는가? 

- 장점이 상당히 많기 때문.

1. HTML 태그의 문법을 따름: 자바를 몰라도 프런트엔드 개발자가 낮은 러닝 커브로 간단한 분기문 같은 걸 짜넣을 수 있음
1. 동적 요소를 전부 Servlet에 일임: 프런트엔드에서 무슨 일이 일어나든 Servlet으로 DTO만 잘 넘겨주면 되기 때문에 개발 분업이 쉬워짐
1. 코드 자체가 덜 어색함: 무언가 자바와 HTML의 혼종 같았던 웹 문서가 더 가독성이 높아지고 수정하기도 쉬워짐