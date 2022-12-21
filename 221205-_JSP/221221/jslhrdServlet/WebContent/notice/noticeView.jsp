<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- sub contents -->
	<div class="sub_title">
		<h2>공지사항</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="/"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="greetings.do">공지사항</a>
						<a href="allclass.do">학과및모집안내</a>
						<a href="portfolio.do">포트폴리오</a>
						<a href="online.do">온라인접수</a>
						<a href="notice.do">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">질문답변<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.do">공지사항</a>
						<a href="greetings.do">질문답변</a>
						<a href="greetings.do">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
		<div class="board_view">
			<h2>${view.title}</h2>
			<p class="info"><span class="user">${view.writer}</span> | ${view.regdate} | <i class="fa fa-eye"></i> ${view.viewcount}</p>
			<div class="board_body">
				${view.content}
			</div>
			<div class="prev_next">
				<c:if test="${prev.bno != view.bno}">
					<a href="/noticeview.do?bno=${prev.bno}&p=${cri.pageNum}&a=${cri.amount}" class="btn_prev">
						<i class="fa fa-angle-left"></i>
						<span class="prev_wrap">
							<strong>이전글</strong><span>${prev.title}</span>
						</span>
					</a>
				</c:if>
				<div class="btn_3wrap">
					<a href="notice.do?p=${cri.pageNum}&a=${cri.amount}">목록</a>
					<a href="noticemodify.do?bno=${view.bno}&p=${cri.pageNum}&a=${cri.amount}">수정</a>
					<a href="noticedelete.do?bno=${view.bno}&p=${cri.pageNum}&a=${cri.amount}" onClick="return confirm('삭제하시겠어요?')">삭제</a>
				</div>
				<c:if test="${next.bno != view.bno}">
					<a href="/noticeview.do?bno=${next.bno}&p=${cri.pageNum}&a=${cri.amount}" class="btn_next">
						<span class="next_wrap">
							<strong>다음글</strong><span>${next.title}</span>
						</span>
						<i class="fa fa-angle-right"></i>
					</a>
				</c:if>
			</div>
		</div>
	</div>

	<!-- end contents -->
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>

<%@ include file="../footer.jsp" %>