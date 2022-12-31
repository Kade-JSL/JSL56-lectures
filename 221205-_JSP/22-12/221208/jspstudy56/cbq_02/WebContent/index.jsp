<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	}
	.content p { padding-left: 60px; }
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
<h2>과정평가형 자격 CBQ</h2>
<br><p>국가직무능력표준(NCS:National Competancy Standards)으로 설계된 교육! 훈련과정을 체계적으로 이수하고 내외부 평가를 거쳐 취즉하는 국가 기술 자격입니다.</p>
<br><p>산업현장 중심의 교육평가로 더 커지는 능력!</p>
<br><p>알고 있는 것에 할 수 있는 것을 더하는</p>
<br><p>과정평가형 자격은</p>
<br><p>현장 중심형 인재육성을 지원합니다.</p>
</section>
<footer>
<p>HRDKOREA Copyright &copy; 2019 All rights reserved. Human Resources Development Service of Korea</p>
</footer>
</body>
</html>