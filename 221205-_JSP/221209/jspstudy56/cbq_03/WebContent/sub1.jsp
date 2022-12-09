<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%
	Dao dao = Dao.getInstance();
	List<Dto> dtoList = dao.selectAllCust();
%>
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
	table tr th, table tr td {text-align: center; border: 1px solid #ccc;}
	
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
	<table>
		<tr>
			<th>고객번호</th>
			<th>고객명</th>
			<th>고객생년월일</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>지역</th>
		</tr>
		<% for (Dto dto : dtoList) { %>
		<tr>
			<td><%=dto.getP_no()%></td>
			<td><%=dto.getP_name()%></td>
			<%
				String birth = dto.getP_birth();
				String birthY = birth.substring(0, 4);
				String birthM = birth.substring(4, 6);
				String birthD = birth.substring(6, 8);
				int age = 2022 - Integer.parseInt(birthY);
				
				String birthFormat = birthY + "년" + birthM + "월" + birthD + "일 (" + age + ")";
			%>
			<td><%=birthFormat%></td>
			<%
				String gender = null;
				if (dto.getP_gender().equals("M")) {
					gender = "남";
				} else if (dto.getP_gender().equals("F")) {
					gender = "여";
				}
			%>
			<td><%=gender%></td>
			<td><%=dto.getP_tel1()%>-<%=dto.getP_tel2()%>-<%=dto.getP_tel3()%></td>
			<%
				String city = null;
				switch (Integer.parseInt(dto.getP_city())) {
				case 10: city = "서울"; break;
				case 20: city = "경기"; break;
				case 30: city = "강원"; break;
				case 40: city = "대구";
				}
			%>
			<td><%=city%></td>
		</tr>
		<% } %>
	</table>
</section>
<footer>
	<p>HRDKOREA Copyright &copy; 2016 All rights reserved. Human Resources Development Service of Korea</p>
</footer>
</body>
</html>