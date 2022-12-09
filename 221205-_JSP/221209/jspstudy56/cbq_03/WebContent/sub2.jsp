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
<title>물류창고 입출고 관리 프로그램</title>
<style>
	* {margin: 0; padding: 0;}
	
	header {padding: 20px 0; background: #ccc;}
	h1 {text-align: center;}
	
	.menu {background: #aaa; padding: 12px 0;}
	ul li {display: inline;}
	ul li a {padding: 0 16px;}
	
	h2 {padding: 30px 0; text-align: center;}
	.content p {padding-left: 60px;}
	
	table {margin: 0 auto;}
	table tr th {text-align: center; border: 1px solid #ccc;}
	
	footer {padding: 20px 0; margin-top: 60px; background: #333;}
	footer p {text-align: center; color: #fff;}
</style>
</head>
<body>
<header>
	<h1>(과정평가형 정보처리산업기사)예방접종 프로그램 ver 2020-04</h1>
</header>
<section class="menu">
	<ul>
		<li><a href="sub1.jsp">고객조회</a></li>
		<li><a href="sub2.jsp">예방접종등록</a></li>
		<li><a href="sub3.jsp">접종이력조회</a></li>
		<li><a href="sub4.jsp">백신별접종건수</a></li>
		<li><a href="index.jsp">홈으로</a></li>
	</ul>
</section>
<section class="content">
	<h2>고객조회</h2>
	<form name="my" method="post" action="sub2pro.jsp" onsubmit="return check();" onreset="resetmsg();">
		<table>
			<tr>
				<th>예방접종이력번호</th>
				<td><input type="text" name="p_seno"/>예)20200001</td>
			</tr>
			<tr>
				<th>고객번호</th>
				<td><input type="text" name="p_no"/></td>
			</tr>
			<tr>
				<th>백신코드</th>
				<td><input type="text" name="i_code"/></td>
			</tr>
			<tr>
				<th>접종일자</th>
				<td><input type="text" name="p_date"/></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="submit" value="예방접종등록" />
					<input type="reset" value="다시쓰기"/>
				</td>
			</tr>
		</table>
	</form>
</section>
<footer>
	<p>HRDKOREA Copyright &copy; 2016 All rights reserved. Human Resources Development Service of Korea</p>
</footer>
</body>
<script>
	function check() {
		if (my.p_seno.value == "") {
			alert("예방접종이력번호가 입력되지 않았습니다!");
			my.p_seno.focus();
			return false;
		}
		if (my.p_no.value == "") {
			alert("고객번호가 입력되지 않았습니다!");
			my.p_no.focus();
			return false;
		}
		if (my.i_code.value == "") {
			alert("백신코드가 입력되지 않았습니다!");
			my.i_code.focus();
			return false;
		}
		if (my.p_date.value == "") {
			alert("접종일자가 입력되지 않았습니다!");
			my.p_date.focus();
			return false;
		}
		alert("예방접종 등록 정보가 정상적으로 등록되었습니다!");
		return true;
	}
	function resetmsg() {
		alert("정보를 지우고 처음부터 다시 입력합니다.");
		my.p_seno.focus();
	}
</script>
</html>