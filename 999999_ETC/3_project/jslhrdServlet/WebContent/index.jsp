<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<section id="main_visual">
	<div class="visual_wrap">
		<h2 class="sr-only">메인 비쥬얼</h2>
		<ul>
			<!-- <li><img src="images/main01.jpg" alt="학생단체관람" class="w100"></li> -->
			<li class="one"></li>
		</ul>
		<div class="visual_inner">
			<p class="title">
				취업의 취업을 위한 취업에 의한<br>
				<strong>여기 자바 두명이요</strong> 중심기관
			</p>
			<p class="txt">
				ここ日本語でなにか書いてありますね？何が分かりますか？<br>
				お分かりでしたらJSLシステムで就活はいかがですか？ニート生活よりはずっと増しですよ？
			</p>
		</div>
	</div>
</section>
<section class="news_group">
	<div class="news_tit">
		<p class="sub_tit">웹노가다의 즐거움이 있는 곳</p>
		<h2>JSL SYSTEM 소식</h2>
		<p class="text">JSL시스템의 다양한 소식을 확인하실 수 있습니다</p>
		<a href="list.do?t=port" class="btn-border">GET REKT</a>
	</div>
	<ul class="news_list">
		<c:forEach var="map" items="${portlist}">
		<li>
			<a href="view.do?t=port&n=${map.bno}">
				<img src="/upload/${map.imgurl}" alt="식품경진대회 우수상 사진" class="w100">
				<strong>${map.title}</strong>
				<p>${map.content}</p>
				<fmt:parseDate var="regdate" value="${map.regdate}" pattern="yyyy-MM-dd" parseLocale="ko-KR"/>
				<span><fmt:formatDate value="${regdate}" pattern="yyyy.MM.dd"/></span>
				<div class="over">
					<strong>${map.title}</strong>
					<p>${map.content}</p>
					<span><fmt:formatDate value="${regdate}" pattern="yyyy.MM.dd"/></span>
				</div>
			</a>
		</li>
		</c:forEach>
	</ul>
</section>
<section class="main_content">
	<h2 class="sr-only">주요서비스</h2>
	<div class="main_left">
		<div class="box">
			<div class="txt_relative">
				<h3>손가락</h3>
				<p>손가락이 무언가<br>가리킴</p>
				<a href="" class="btn-border">EAT FINGER</a>
			</div>
			<div class="img_transition">
			</div>
		</div>
		<div class="box gallery">
			<div class="txt_relative">
				<h3>인간</h3>
				<p>인간도 맛있다<br>냠냠</p>
				<a href="" class="btn-border">KAYU UMA</a>
			</div>
			<div class="img_transition">
			</div>
		</div>
	</div>
	<div class="main_center">
		<div class="box3">
			<h3 class="sr-only">알림마당</h3>
			<nav>
				<ul>
					<li class="active"><a href="#tabview1">공지사항</a></li>
					<li><a href="#tabview2">졸업후기</a></li>
				</ul>
			</nav>
			<div class="noticelist clearfix active taball" id="tabview1">
				<ul>
					<c:forEach var="map" items="${noticelist}" varStatus="status">
						<c:choose>
							<c:when test="${status.first}">
							<div class="recently">
								<p class="title">
									<a class="title" href="/view.do?t=notice&n=${map.bno}">${map.title}</a>
									<fmt:parseDate var="regdate" value="${map.regdate}" pattern="yyyy-MM-dd" parseLocale="ko-KR"/>
									<span class="date"><fmt:formatDate value="${regdate}" pattern="yyyy-MM-dd"/></span>
								</p>
								<p class="text">${map.content}...</p>
							</div>
							</c:when>
							<c:otherwise>
							<li>
								<a href="/view.do?t=notice&n=${map.bno}">${map.title}</a>
								<span class="date"><fmt:formatDate value="${regdate}" pattern="yyyy-MM-dd"/></span>
							</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
				<div class="graduation clearfix taball" id="tabview2">
					<div class="recently">
						<p class="title">
							<a class="title" href="">내가 포기하지 않으면 실패은 없다</a>
							<span class="date">2018-09-27</span>
						</p>
						<p class="text">이런 저런 핑게를 대며 나는 20년간 나를 포기하면 살았다. 시간이 흐른 뒤에 ...
						</p>
					</div>
					<ul>
						<li><a href="">즐거움이 가득한 배움의 즐거움을 알다</a><span class="date">201-09-27</span></li>
						<li><a href="">하자, 해보자, 할 수없다</a><span class="date">201-09-27</span></li>
						<li><a href="">무엇 때문에 오늘도 다시 시작하는가</a><span class="date">201-09-27</span></li>
						<li><a href="">남에게도 있는 시간과 노력을 투자하면</a><span class="date">201-09-27</span></li>
					</ul>
				</div>
				<div class="box4">
				</div>
				<div class="box5">
				</div>
		</div>
	</div>
	<div class="main_right">
	</div>
</section>

<section class="other">
	<h2 class="sr-only">기타서비스</h2>
	<div class="container clearfix">
		<div class="other_left">
			<h3 class="sr-only">소제목을 입력</h3>
			<div class="title_box">
				<em>small title insert</em>
				<p class="title">
					제목을<strong>입력하세요</strong>
				</p>
				<p class="text">1980년 회사내용을 입력하세요</p>
				<a href="" class="btn-border white">READ MORE</a>
			</div>
			<div class="content_box"></div>
		</div>
		<div class="other_right">
			<h3 class="sr-only">소제목을 입력</h3>
			<div class="title_box">
				<em>small title insert</em>
				<p class="title">
					제목을<strong>입력하세요</strong>
				</p>
				<p class="text">1980년 회사내용을 입력하세요</p>
				<ul>
					<li>목록 내용을 입력</li>
					<li>목록 내용을 입력</li>
					<li>목록 내용을 입력</li>
				</ul>
			</div>
			<div class="content_box"></div>
		</div>
	</div>
</section>


<script>
	$(function() {
		$(".taball").hide();
		$("#tabview1").show();
		$(".main_center .box3 nav ul li a").click(function(e) {
	     //$(".main_center .box3 nav ul li").click(function(e) {
	        e.preventDefault();
	        // nav ul li a(공지,졸업)을 클릭했을때
	        $(".main_center .box3 nav ul li").removeClass("active");
	        // nav ul li 태그에 선언된 active라는 클래스이름을 삭제한다
	        //$(this).parent().addClass("active");
	        // 공지, 졸업둘중에 하나클릭을 했다면 현재 클릭한 자기자신위에 부모에게 active 클래스가 추가되어 active css가 실행된다
	        //$(this).addClass("active");
	        $(this).parent().addClass("active");
	        $(".taball").hide();
	        $($(this).attr("href")).show();
	        //var num = $(this).index();
	        //$(".taball").hide().eq(num).show();
		});
	});
</script>

<div class="right_quick">
	<button class="btn btn-open" type="button"></button>
</div>

<%@ include file="footer.jsp"%>