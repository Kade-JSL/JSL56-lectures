<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	 
<c:if test="${empty admin}">
	<script>
		alert("접근 권한이 없습니다.");
		location.href="admin.do";
	</script>
</c:if>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>관리자 페이지</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<link href="/css/font-awesome.min.css" type="text/css" rel="stylesheet">
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/layout.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src="/js/admin.js"></script>
</head>
<body>
<div class="adm-box"> <!-- adminmain.jsp에 </div>가 있음 -->
	<header class="adm-left">
		<nav>
			<a href="admin.do">
				<h3>JSL시스템 사이트 관리</h3>
			</a>
			<ul>
<!-- 				<li><a href="#notice">공지사항</a></li> -->
<!-- 				<li><a href="#port">포트폴리오</a></li> -->
<!-- 				<li><a href="#qa">회원답변</a></li> -->
<!-- 				<li><a href="#member">회원관리</a></li> -->
<!-- 				<li><a href="logout.do">로그아웃</a></li> -->
				<li><a href="adm-notice.do">공지사항</a></li>
				<li><a href="adm-port.do">포트폴리오</a></li>
				<li><a href="adm-qa.do">회원답변</a></li>
				<li><a href="adm-member.do">회원관리</a></li>
				<li><a href="logout.do">로그아웃</a></li>
			</ul>
		</nav>
	</header>