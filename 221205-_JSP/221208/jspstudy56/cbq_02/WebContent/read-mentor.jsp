<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<%
	Dao dao = Dao.getDao();
	List<Dto> dtoList = dao.selectAllMentor();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오디션 관리 프로그램</title>
<style>
	* { margin: 0; padding: 0; }
	a { text-decoration: none; }
	ul { list-style: none;}
	
	header {
		background: #00f;
		padding: 20px 0;	
	}
	header h1 {
		color: #fff;
		text-align: center;
	}
	
	footer {
		background: #0ff;
		padding: 20px 0;
	}
	footer p {
		font-weight: bold;
		font-size: 20px;
		color: #333;
		text-align: center;
	}
	
	.menu {
		height: 45px;
		background: #33f;
	}
	.menu * { float: left; }
	.menu a {
		padding: 12px 16px;
		color: #ccc;
	}
	
	.content { margin: 60px 0; }
	.content h2 {
		font-weight: bold;
		text-align: center;
		padding-bottom: 24px;
	}
	.content p { padding-left: 60px; }
	.content table { margin: 0 auto; }
	.content th, .content td {
		text-align: center;
	 	border: 1px solid #ccc;
	}
	.content .small-text { width: 60px; }
</style>
</head>
<body>
<header>
<h1>(과정평가형 정보처리산업기사) 오디션 관리 프로그램 ver 2019-05</h1>
</header>
<section class="menu">
<ul>
  <li><a href="create-artist.jsp">오디션 등록</a></li>
  <li><a href="read-artist.jsp">참가자목록조회</a></li>
  <li><a href="read-mentor.jsp">멘토점수조회</a></li>
  <li><a href="read-rank.jsp">참가자등수조회</a></li>
  <li><a href="index.jsp">홈으로</a></li>
</ul>
</section>
<section class="content">
<h2>멘토 점수 목록 조회</h2>
	<table>
		<tr>
			<th>채점번호</th>
			<th>참가번호</th>
			<th>참가자명</th>
			<th>생년월일</th>
			<th>점수</th>
			<th>평점</th>
			<th>멘토</th>
		</tr>
		<% for (Dto dto : dtoList) { %>
		<tr>
			<td><%=dto.getSerial_no()%></td>
			<td><%=dto.getArtist_id()%></td>
			<td><%=dto.getArtist_name()%></td>
			<%
			String birth = dto.getArtist_birth();
			String birthFormat = birth.substring(0, 4) + "년" +
				birth.substring(4, 6) + "월" +
				birth.substring(6, 8) + "일";
			%>
			<td><%=birthFormat%></td>
			<td><%=dto.getPoint()%></td>
			<%
				String grade = null;
				if (dto.getPoint() >= 90) {
					grade = "A";
				} else if (dto.getPoint() >= 80){
					grade = "B";
				} else if (dto.getPoint() >= 70){
					grade = "C";
				} else if (dto.getPoint() >= 60){
					grade = "D";
				} else {
					grade = "F";
				}
			%>
			<td><%=grade%></td>
			<td><%=dto.getMento_name()%></td>
		</tr>
		<% } %>
	</table>
</section>
<footer>
<p>HRDKOREA Copyright &copy; 2019 All rights reserved. Human Resources Development Service of Korea</p>
</footer>
</body>
</html>