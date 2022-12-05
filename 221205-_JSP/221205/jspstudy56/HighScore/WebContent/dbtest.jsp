<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %> <!-- 패키지의 모든 클래스를 임포트하라 -->
<%@ page import="java.sql.*" %> 
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!-- 여기까지가 우리가 JSP에서 해 줘야 할 일 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB Test</title>
</head>
<body>
<%
	Connection conn = null;
	conn = DBManager.getInstance().getConnection();
	if (conn != null) {
		out.print("DB 접속 완료!");
	} else {
		out.print("DB 접속 실패...");
	}
%>
</body>
</html>