<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오디션 관리 프로그램</title>
<style>
	* {margin: 0; padding: 0}
	a {text-decoration: none;}
	ul, ol {list-style: none;}
	table th, table td {border: 1px solid #ccc;}
	
	header {background: #ccc; padding: 20px 0;}
	header h1 {text-align: center;}
	nav {background: #888; overflow: hidden;}
	nav ul li {float: left; padding: 12px 16px;}
	nav ul li a {color: #ccc;}
	section {height: 460px; text-align: center;}
	section h2 {padding: 20px 0;}
	section p {line-height: 180%; padding-left: 20px;}
	section table {margin: 0 auto;}
	footer {background: #333; padding: 20px 0;}
	footer p {text-align: center; color: #ccc;}
</style>
</head>
<body>
	<header>
		<h1>(과정평가형 정보처리산업기사) 오디션 관리 프로그램</h1>
	</header>
	<nav>
		<ul>
			<li><a href="sub1.do">오디션등록</a></li>
			<li><a href="sub2.do">참가자 목록 조회</a></li>
			<li><a href="sub3.do">멘토점수조회</a></li>
			<li><a href="sub4.do">참가자등수조회</a></li>
			<li><a href="main.do">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>참가자 목록 조회</h2>
			<table style="width: 620px;">
				<tr>
					<th>참가번호</th>
					<th>참가자명</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>특기</th>
					<th>소속사</th>
				</tr>
				<c:forEach var="list" items="${dtoList}">
					<tr>
						<td>${list.artist_id}</td>
						<td>${list.artist_name}</td>
						<td>${list.artist_birth}</td>
						<td>
						<%-- <c:if test="${list.getArtist_gender() == 'M'}">
							남
						</c:if>
						<c:if test="${list.getArtist_gender() == 'F'}">
							여
						</c:if> --%>
						<c:choose>
							<c:when test="${list.artist_gender == 'M'}">남</c:when>
							<c:when test="${list.artist_gender == 'F'}">여</c:when>
							<c:otherwise>논</c:otherwise>
						</c:choose>
						</td>
						<td>
						<c:choose>
							<c:when test="${list.talent == 1}">댄스</c:when>
							<c:when test="${list.talent == 2}">랩</c:when>
							<c:when test="${list.talent == 3}">노래</c:when>
						</c:choose>
						</td>
						<td>${list.agency}</td>
					</tr>
				</c:forEach>
			</table>
	</section>
	<footer>
		<p>&copy; HRDKOREA</p>
	</footer>
</body>
</html>