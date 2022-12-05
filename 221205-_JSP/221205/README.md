### [221202 ←](/221125-221202_JAVA_AND_ORACLE/221202/) | [→ 221206](/221205-_JSP/221206/)

# 이날 배웠던 것

- [**Apache Tomcat 8.5.84** 다운로드 링크](https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.84/bin/apache-tomcat-8.5.84-windows-x64.zip)
- [/src/model/**DBManager.java**: 오라클 DB 연결 객체](/221205-_JSP/221205/jspstudy56/HighScore/src/model/DBManager.java)
- [/WebContent/**dbtest.jsp**](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/dbtest.jsp)

---

## 비보) 케이드 드디어 이클립스에 패배

## JSP와 JDBC를 연동하는 것이 목표

- 웹문서의 인코딩 방식은 **UTF-8**이다
1. Apache Tomcat을 다운로드해서 압축 해제
1. 이클립스에서 서버를 만들어 <http://localhost:8282>에 띄워준다.
    - *8080이 잘 안 되는 이유는 대부분의 컴퓨터가 이 포트를 HTTP 포트로써 다른 프로그램에 쓰고 있기 때문입니다. 대표적으로 오라클 데이터베이스가 있습니다. 8080이나 443(HTTPS), 21(FTP)같이 기본 설정으로 쓰이는 포트를 웰 노운 포트(Well-known port)라고 하며, 보안에서 제일선의 보안 우선순위가 되는 포트입니다.*
1. JSP 파일로 `<% %>` 안에 자바 코드를, 나머지는 HTML 코드를 써서 [/WebContent/dbtest.jsp](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/dbtest.jsp)를 작성해 준다.
    - 주의사항: /WebContent/WEB-INF 폴더에는 넣어선 안 된다.
1. 