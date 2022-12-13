### [221212 ←](/221205-_JSP/221212/) | [→ 221214](/221205-_JSP/221214/)

- [Jakarta Taglibs Standard 1.1.2](http://archive.apache.org/dist/jakarta/taglibs/standard/binaries/jakarta-taglibs-standard-1.1.2.zip)
- /src/
    - controller/
        - Sub2Servlet.java
    - dao/
        - ArtistDao.java
    - dto/
        - ArtistDto.java
- /WebContent/
    - sub2.jsp

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

## 쓰던 Scriptlet 계속 쓰지 JSTL을 굳이 왜 쓰는가? 

- 장점이 상당히 많기 때문.

1. HTML 태그의 문법을 따름: 자바를 몰라도 프런트엔드 개발자가 낮은 러닝 커브로 간단한 분기문 같은 걸 짜넣을 수 있음
1. 동적 요소를 전부 Servlet에 일임: 프런트엔드에서 무슨 일이 일어나든 Servlet으로 DTO만 잘 넘겨주면 되기 때문에 개발 분업이 쉬워짐
1. 코드 자체가 덜 어색함: 무언가 자바와 HTML의 혼종 같았던 웹 문서가 더 가독성이 높아지고 수정하기도 쉬워짐