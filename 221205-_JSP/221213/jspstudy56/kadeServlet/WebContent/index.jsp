<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	section {height: 460px;}
	section h2 {text-align: center; padding: 20px 0;}
	section p {line-height: 180%; padding-left: 20px;}
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
		<h2>과정평가형 CBQ</h2>
		<p>국가직무 어쩌구저쩌구</p>
	</section>
	<footer>
		<p>&copy; HRDKOREA</p>
	</footer>
</body>
</html>