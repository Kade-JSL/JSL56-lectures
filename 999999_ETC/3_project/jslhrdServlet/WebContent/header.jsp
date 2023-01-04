<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	    
<!doctype html>
<html lang="ko">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="JSL">
  <meta name="Keywords" content="반응형홈페이지,  JAVA, JSP, PHP, 대전직업전문학교, 대전국비지원, 국비무료">
  <meta name="Description" content="응용SW개발자를 위한 반응형 홈페이지">
  <title>JSL인재개발원</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <link href="/css/font-awesome.min.css" type="text/css" rel="stylesheet">
  <link href="/css/common.css" rel="stylesheet">
  <link href="/css/layout.css" rel="stylesheet">
  
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  <!--
  	jquery언어 사용법
	1. jquey.js을 기반으로 프로그램을 작성하기 때문에 jquery.js 파일을 다운 또는 CDN 방식으로 링크를 건다
	2. $(function() {
		실행문;
	});
  -->
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
  

 </head>
 <body>
 <!-- 
 웹문서 만들기 기본 공식
 1. 요소를 어떻게 묶을 것인가? 그룹만들기
 2. 그룹안에 적절한 태그 사용
 3. class 이름 붙이고 css 적용
 -->
	<div class="sr-only">
		<p><a href="#content">본문 바로가기</a></p>
	</div>

	<div class="top_navigation">
	
		<header class="header">
			<nav class="top_left">
			  <ul>
			  	<li class="first"><a href="/">HOME</a></li>
				<li><a href="">아이돌마</a></li>
				<li><a href="">스터밀리</a></li>
				<li><a href="">언라이브</a></li>
			  </ul>
			</nav>
			<nav class="top_right">
				<ul>
					<c:choose>
						<c:when test="${not empty id}">
							<li class="first"><a href="logout.do">로그아웃</a></li>
							<li><a href="mypage.do">마이페이지</a></li>
						</c:when>
						<c:otherwise>
							<li class="first"><a href="login.do">로그인</a></li>
							<li><a href="memberterms.do">회원가입</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			
			<div class="gnb_group">
				<h1 class="logo">JSL시스템</h1>
				<nav class="gnb">
					<ul class="nav_1depth">
						<li><a href="">기업소개</a>
							<ul class="nav_2depth">
								<li><a href="">인사말</a></li>
								<li><a href="">연혁</a></li>
								<li><a href="">직원소개</a></li>
								<li><a href="">국내 자바 갤러리</a></li>
								<li><a href="">기어오시는길</a></li>
							</ul>
						</li>
						<li><a href="list.do?t=port">포트폴리오</a>
							<ul class="nav_2depth">
								<li><a href="list.do?t=port">포트폴리오</a></li>
							</ul>
						</li>
						<li><a href="list.do?t=notice">커뮤니티</a>
							<ul class="nav_2depth">
								<li><a href="list.do?t=notice">공지사항</a></li>
								<li><a href="list.do?t=qa">질문과답변</a></li>
								<li><a href="list.do?t=faq">FAQ</a></li>
								<li><a href="">자료실</a></li>
								<li><a href="admin.do">관리자</a></li>
							</ul>
						</li>
					</ul>
				</nav>
			</div>
		</header>

		<div class="line">
		</div>

	</div>

	<script>
		//$(document).ready(function() {
		$(function() {
			$(".gnb>.nav_1depth>li").hover(function() {
				$(".gnb>.nav_1depth>li").removeClass();
				$(this).addClass("active");

				//$(this).children(".nav_2depth").show();
				//}, function() {
				//  $(".gnb>.nav_1depth>li").removeClass();
				//  $(this).children(".nav_2depth").hide();
				//	});

				$(this).children(".nav_2depth").stop().slideDown("fast");
				}, function() {
				  $(".gnb>.nav_1depth>li").removeClass();
				  $(this).children(".nav_2depth").stop().slideUp("fast");
					});

				/* $(this).children(".nav_2depth").fadeIn();
				}, function() {
				  $(".gnb>.nav_1depth>li").removeClass();
				  $(this).children(".nav_2depth").fadeOut();
					}); */

			});
	</script>