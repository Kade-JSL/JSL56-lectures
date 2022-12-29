### [221227 ←](/221205-_JSP/221227/) | [→ 221229](/221205-_JSP/221229/)

# 이날 배웠던 것

- /src/com/jslhrd
    - /controller
        - /member/
            - [**MemberTerms.java**: 답이 없다. 그냥 서블릿인 듯하다.](/221205-_JSP/221228/jslhrdServlet/src-com-jslhrd/controller/member/MemberTerms.java)
        - /portfolio/
            - [**PortfolioWrite.java**: 뭔가 qna 쪽으로 넘겨주는 분기를 만들고 싶었어](/221205-_JSP/221228/jslhrdServlet/src-com-jslhrd/controller/portfolio/PortfolioWrite.java)
        - /qna/
            - [Qa.java: 작업중](/221205-_JSP/221228/jslhrdServlet/src-com-jslhrd/controller/qna/Qa.java)
    - /dao
        - [QaDao.java: 작업중](/221205-_JSP/221228/jslhrdServlet/src-com-jslhrd/dao/)
- /WebContent
    - /member/
        - [**memberterms.jsp**: 메인. 제이쿼리 입문, 간단한 CSS 작업](/221205-_JSP/221228/jslhrdServlet/WebContent/member/memberterms.jsp)
    - /notice/
        - [**noticeWrite.jsp**: 제대로 썸머보드 적용. 오타와의 싸움은 계속된다.](/221205-_JSP/221228/jslhrdServlet/WebContent/notice/noticeWrite.jsp)
        - [**noticeModify.jsp**: 여기도 간단하게만 썸머보드 적용.](/221205-_JSP/221228/jslhrdServlet/WebContent/notice/noticeModify.jsp)
    - /qna/
        - [qa.jsp: 작업중](/221205-_JSP/221228/jslhrdServlet/WebContent/qna/qa.jsp)
    - [**header.jsp**: 링크 부분 다시 개수. 사이트 내 링크도 개수.](/221205-_JSP/221228/jslhrdServlet/WebContent/header.jsp)
- [sqlinput.sql: 디제이 드랍 더 테이블](/221205-_JSP/221228/sqlinput.sql)

---

## 비동기 처리

- 화면 전환 없이 데이터를 주고받는 것

```js
function sendFile(file, el) {
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({ // 비동기식 데이터 처리(<form> 태그와 본질적으로 같음); jQuery 함수에 해당
        data : form_data, // 서버에 보낼 데이터
        type : "post", // 전송 방식
        url : 'summernote.do', // 요청이 전송될 URL 주소
        cache : false, // 캐시 여부
        contentType : false, // 전송 데이터 형식
        encType : 'multipart/form-data', // 데이터 인코딩 방식
        processData : false, // 데이터를 contentType 타입에 맞기 변환할지 결정
        success : function(img_name) { // 위의 요청이 성공했을 때 == summernote.do가 성공했을 때
            //alert(img_name);
            $(el).summernote('editor.insertImage', img_name); // POST에서 넘어온 이미지 이름을 썸머노트 안에 집어넣기
        }
    })
}
```

- 해당 서블릿의 POST 메서드는 다음과 같다:

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    String realPath = getServletContext().getRealPath("/upload");
    int maxImgSize = 1024 * 1024 * 2;
    String encType = "UTF-8";
    
    MultipartRequest mr = new MultipartRequest( // 받은 요청은 cos.jar에서 처리
            request,
            realPath,
            maxImgSize,
            encType,
            new DefaultFileRenamePolicy()
            );
    
    response.setContentType("text/html, charset=UTF-8");
    PrintWriter out = response.getWriter(); // 출력 스트림 객체
    String file = mr.getFilesystemName("file");
    out.print("/upload" + "/" + file); // "/upload/a.jpg"로 결합해서 출력
    out.close(); // 출력 스트림 닫기
}
```

## jQuery 입문

```js
$(document).ready(function() { // 제이쿼리 시작했다
    var chkList = $("input[name=agree]");
    // jQuery 선택자: name 속성이 agree라고 되어 있는 input 요소를 선택해서 저장하라
    $("#chkCtrl").on("click", function() { // 콜백 함수
    // id가 chkCtrl인 요소를 선택해서 . ( "click" 이벤트가 발생하면, {} 안을 실행하세요 )
    // 그래서 id 속성은 JS와의 연계에서 주로 사용하고, class 속성은 CSS와의 연계에서 주로 사용한다.
    // id는 유일하게만 쓰이기 때문에 JS에서 쓰기 편하기 때문이다.
        if($(this).is(":checked")) {
            chkList.prop("checked", true); // JS의 PROPerty를 가져와서 변경하는 것
        } else {
            chkList.prop("checked", false);
        }
    })
    
    $("#agree1, #agree2, #agree3").on("click", function() {
        if($("#agree1").is(":checked") == true && $("#agree2").is(":checked") == true && $("#agree3").is(":checked") == true) {
            $("#chkCtrl").prop("checked", true);
        } else {
            $("#chkCtrl").prop("checked", false);
        }
    })

}) // 제이쿼리 끝났다
```