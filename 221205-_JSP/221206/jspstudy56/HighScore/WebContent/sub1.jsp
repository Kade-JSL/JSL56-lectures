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
	<h2>학생등록</h2>
	<form name="my" method="post" action="sub1pro.jsp" onsubmit="return check();">
		<table>
			<tr>
				<th>학년</th>
				<td><input type="text" name="syear">(예)1</td>
			</tr>
			<tr>
				<th>반</th>
				<td><input type="text" name="sclass">(예)01</td>
			</tr>
			<tr>
				<th>번호</th>
				<td><input type="text" name="sno">(예)01</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="sname" class="sname">(예)홍길동</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="birth" class="birth">(예)20190301</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="M">남성
					<input type="radio" name="gender" value="F">여성
					<input type="radio" name="gender" value="N">그 외
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="tel1" class="tel"> - 
					<input type="text" name="tel2" class="tel"> - 
					<input type="text" name="tel3" class="tel">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;">
					<input type="submit" value="학생등록">
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
	if(my.sname.value == "") {
		alert("이름 정보가 입력되지 않았습니다.");
		my.sname.focus();
		return false;
	}
	if(my.birth.value == "") {
		alert("생년월일 정보가 입력되지 않았습니다.");
		my.birth.focus();
		return false;
	}
	if(!my.gender[0].checked && !my.gender[1].checked && !my.gender[2].checked) {
		alert("성별 정보가 입력되지 않았습니다.");
		my.gender[2].focus();
		return false;
	}
	if(my.tel1.value == "") {
		alert("전화번호 정보가 입력되지 않았습니다.");
		my.tel1.focus();
		return false;
	}
	if(my.tel2.value == "") {
		alert("전화번호 정보가 완성되지 않았습니다.");
		my.tel2.focus();
		return false;
	}
	if(my.tel3.value == "") {
		alert("전화번호 정보가 완성되지 않았습니다.");
		my.tel3.focus();
		return false;
	}
	alert("학생이 정상적으로 등록되었습니다!");
	return true;
}
</script>
</body>
</html>