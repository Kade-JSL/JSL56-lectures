<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String result = (String) request.getAttribute("result");
	out.println(result);
%>
<%=result %>

<!-- ${result} -->
</body>
</html>