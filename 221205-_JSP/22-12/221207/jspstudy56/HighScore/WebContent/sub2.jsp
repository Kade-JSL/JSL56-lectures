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
	table {margin: 0 auto;}
	.sname {width: 220px;}
	.birth {width: 220px;}
	.tel {width: 60px;}
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
	<h2>성적입력</h2>
	<form name="my" method="post" action="sub2pro.jsp" onsubmit="return check();">
		<table>
			<tr>
				<th>학년</th>
				<td>
					<select name="syear">
						<option>선택</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>반</th>
				<td>
					<select name="sclass">
						<option>선택</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<td><input type="text" name="sno">(예)01</td>
			</tr>
			<tr>
				<th>국어</th>
				<td><input type="text" name="kor">점수범위(0-100)</td>
			</tr>
			<tr>
				<th>영어</th>
				<td><input type="text" name="eng">점수범위(0-100)</td>
			</tr>
			<tr>
				<th>수학</th>
				<td><input type="text" name="mat">점수범위(0-100)</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;">
					<input type="submit" value="성적저장">
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</section>
<footer>
	<p>HRDKOREA Copyright &copy; 2016 All rights reserved. Human Resources Development Service of Korea</p>
</footer>

<script>
function check() {
	if(my.syear.value == "") {
		alert("학년 정보가 입력되지 않았습니다.");
		my.syear.focus();
		return false;
	}
	if(my.sclass.value == "") {
		alert("반 정보가 입력되지 않았습니다.");
		my.sclass.focus();
		return false;
	}
	if(my.sno.value == "") {
		alert("번호 정보가 입력되지 않았습니다.");
		my.sno.focus();
		return false;
	}
	if(my.kor.value == "") {
		alert("국어 점수가 입력되지 않았습니다.");
		my.kor.focus();
		return false;
	}
	if(my.eng.value == "") {
		alert("영어 점수가 입력되지 않았습니다.");
		my.eng.focus();
		return false;
	}
	if(my.mat.value == "") {
		alert("수학 점수가 입력되지 않았습니다.");
		my.mat.focus();
		return false;
	}
	
	alert("성적이 정상적으로 등록되었습니다!");
	return true;
}
</script>
</body>
</html>