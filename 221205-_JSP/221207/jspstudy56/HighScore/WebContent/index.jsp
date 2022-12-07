<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고교 성적 관리 프로그램</title>
<style>
	* {margin: 0; padding: 0;}
	a {text-decoration: none;}
	ul, ol {list-style: none;}
	table, th, td {border: 1px solid #ccc;}
	
	header {background: #00f; padding: 20px 0;}
	h1 {text-align: center; color: #fff;}
	nav {overflow: hidden; background: #06f;}
	nav ul li {float:left;}
	nav ul li a {padding: 12px 16px; display: block; color: #fff;}
	section {height: 500px;}
	h2 {padding: 30px 0; text-align: center;}
	p {padding: 0 0 0 16px;}
	footer {background: #00f; padding: 20px 0;}
	footer p {color: #fff; text-align: center;}
</style>
</head>
<body>
<header>
	<h1>(과정평가형 정보처리산업기사)고교성적관리프로그램 ver2019-05</h1>
</header>
<nav>
	<ul>
		<li><a href="sub1.jsp">학생등록</a></li>
		<li><a href="sub2.jsp">성적입력</a></li>
		<li><a href="sub3.jsp">성적조회</a></li>
		<li><a href="sub4.jsp">반별통계</a></li>
		<li><a href="index.jsp">홈으로</a></li>
	</ul>
</nav>
<section>
	<h2>과정평가형 자격 CBQ</h2>
	<p>국가직무능력표준(NCS : National Competancy Standards)으로 설계된 교육훈련과정을 이수하고<br>
	내/외부 평가를 거쳐 취득하는 국가기술자격입니다.</p>
	<p>산업현장 중심의 교육평가로 더 커지는 능력!</p>
	<p>알고 있는 것에 할 수 있다는 것을 더하는</p>
	<p>과정평가형 자격은</p>
	<p>현장 중심형 인재육성을 지원합니다</p>
</section>
<footer>
	<p>HRDKOREA Copyright &copy; 2016 All rights reserved. Human Resources Development Service of Korea</p>
</footer>
</body>
</html>