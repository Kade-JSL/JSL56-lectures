### [221202 ←](/221125-221202_JAVA_AND_ORACLE/221202/) | [→ 221206](/221205-_JSP/221206/)

# 이날 배웠던 것

- [**Apache Tomcat 8.5.84** 다운로드 링크](https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.84/bin/apache-tomcat-8.5.84-windows-x64.zip)
- [/src/model/**DBManager.java**: 오라클 DB 연결 객체](/221205-_JSP/221205/jspstudy56/HighScore/src/model/DBManager.java)
- [/WebContent/**dbtest.jsp**](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/dbtest.jsp)

---

## JSP와 JDBC를 연동하는 것이 목표

- 웹문서의 인코딩 방식은 **UTF-8**이다
1. Apache Tomcat을 다운로드해서 압축 해제
1. 이클립스에서 서버를 만들어서 등록
1. JSP 파일로 `<% %>` 안에 자바 코드를, 나머지는 HTML 코드를 써서 [dbtest.jsp](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/dbtest.jsp)를 작성해 준다
    - 주의사항: [/WebContent/WEB-INF] 폴더에는 넣어선 안 된다.
    