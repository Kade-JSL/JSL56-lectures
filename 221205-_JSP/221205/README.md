### [221202 ←](/221011-221202_JAVA_BASICS/22-11/221202/) | [→ 221206](/221205-_JSP/221206/)

# 이날 배웠던 것

- [**Apache Tomcat 8.5.84** 다운로드 링크](https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.84/bin/apache-tomcat-8.5.84-windows-x64.zip)
- [/src/model/**DBManager.java**: 오라클 DB 연결 객체](/221205-_JSP/221205/jspstudy56/HighScore/src/model/DBManager.java)
- [/WebContent/](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/)
    - [**dbtest.jsp**: DB 연결됐니?](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/dbtest.jsp)
    - [**index.jsp**: 뭔가 자격시험 과제 메인페이지인 모양이다](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/index.jsp)
    - [**sub1.jsp**: 뭔가 학생등록 페이지인 모양이다](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/sub1.jsp)
- [**sqlinput.sql**: 테이블 등록에 쓰인 쿼리문](/221205-_JSP/221205/sqlinput.sql)
- ~~**비보) 케이드, 톰캣 서버를 VSCode에 올리지 못해 이클립스에 패배... "레드햇이 밉다" 심경 밝혀**~~

---


## JSP와 JDBC를 연동하는 것이 목표

- 웹문서의 인코딩 방식은 **UTF-8**이다
    - 이클립스에서도 설정에서 인코딩을 바꿔 준다
1. Apache Tomcat을 다운로드해서 압축 해제
1. 이클립스에서 서버를 만들어 <http://localhost:8282>에 띄워준다. 이 때 포트번호는 아무래도 상관 없다.
    - *8080이 잘 안 되는 이유는 대부분의 컴퓨터가 이 포트를 HTTP 포트로써 다른 프로그램에 쓰고 있기 때문입니다. 대표적으로 오라클 데이터베이스가 있습니다. 8080이나 443(HTTPS), 21(FTP)같이 기본 설정으로 쓰이는 포트를 웰 노운 포트(Well-known port)라고 하며, 보안에서 제일선의 보안 우선순위가 되는 포트입니다.*
1. [/src/model/DBManager.java](/221205-_JSP/221205/jspstudy56/HighScore/src/model/DBManager.java)를 작성. 쓰는 방법은 기억하고 있던 그거 대로.
    - `close()` 메서드를 작성할 때는 객체를 열어 놓은 순서의 역순으로 닫도록 한다.
1. JSP 파일로 `<% %>` 안에 자바 코드를, 나머지는 HTML 코드를 써서 [/WebContent/dbtest.jsp](/221205-_JSP/221205/jspstudy56/HighScore/WebContent/dbtest.jsp)를 작성해 준다.
    - 주의사항: /WebContent/WEB-INF 폴더에는 넣어선 안 된다.
1. 프로젝트를 빌드해서 서버 위에 배포(deploy)한다. 빌드하는 과정에서 데이터베이스에 연결하고 그 결과를 정적 웹페이지에 띄우게 된다.
1. 빌드되어 배포된 코드가 서버 위에 올라가고, 이 서버의 정해진 위치에 들어가면 웹페이지가 보이게 된다.

## 제약조건과 테이블 간의 연관

- `TBL_SCORE` 테이블의 세 개의 컬럼이 제약조건으로 `TBL_STUDENT`와 연관되어 있다.
    - `FOREIGN KEY`: 반드시 이 테이블에 있는 컬럼은 `REFERENCES`가 가리키는 컬럼에 있는 내용이어야 한다.
    - 학생 테이블의 레코드 하나는 반드시 점수 테이블의 레코드 하나에만 대응되므로 이 연관관계는 **1:1 연관관계**이다.

## 페이지를 만들자

1. JSP 파일을 쓸 땐 무조건 `import`부터 하자
1. 예전에 배웠던 [HTML/CSS](/220926-221007_HTMLCSS/)를 떠올리며 모양을 잡아 보자