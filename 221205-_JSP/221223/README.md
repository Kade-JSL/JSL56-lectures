### [221222 ←](/221205-_JSP/221222/) | [→ 221227](/221205-_JSP/221227/)

# 이날 배웠던 것

- 포트폴리오 만듦

---

## `cos.jar`를 이용하여 첨부파일을 처리하기

- 일단은 `write.jsp`의 `<form>` 태그 안에 `enctype` 속성을 바꿔 줘야 한다.

    ```html
        <form name="portfolio" method="post" action="write.do" 
        enctype="multipart/form-data" onsubmit="return check();">
    ```

    - 이래야 이미지 파일까지 서버로 `POST` 요청을 통해 날아가게 된다.
- `com.oreilly.servlet.MultipartRequest`
    - 생성자 인수
        - 파일이 들어 있는 요청 객체: `HttpServletRequest`,
        - 파일 경로: `String`,
        - 최대 업로드 크기: `int`,
        - 인코딩 방법: `String`,
        - 동일한 파일명이 존재할 때: `com.oreilly.servlet.multipart.DefaultFileRenamePolicy`
- `multipart/form-data` 형태로 요청을 하면 다른 DTO 필드들 역시 `request.getParameter()` 메서드로는 가져오면 안 된다.