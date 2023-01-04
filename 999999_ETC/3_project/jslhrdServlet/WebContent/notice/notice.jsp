<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- sub content -->
<div class="sub_title">
	<h2>공지사항</h2>
	<div class="container">
		<div class="location">
			<ul>
				<li class="btn_home"><a href="/"><i
						class="fa fa-home btn_plus"></i></a></li>
				<li class="dropdown"><a href="">커뮤니티<i
						class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="">공지사항</a> <a href="">학과및모집안내</a>
						<a href="list.do?t=port">포트폴리오</a> <a href="">온라인접수</a> <a
							href="list.do?t=notice">커뮤니티</a>
					</div></li>
				<li class="dropdown"><a href="">공지사항<i
						class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="list.do?t=notice">공지사항</a> <a href="qa.do">질문과답변</a> <a
							href="faq.do">FAQ</a>
					</div></li>
			</ul>
		</div>
	</div>
	<!-- container end -->
</div>

<div class="container">
	<div class="search_wrap">
		<div class="record_group">
			<p>
				총게시글<span>${count}</span>건
			</p>
		</div>
		<div class="search_group">
			<form name="myform" method="get" action="list.do?t=notice">
				<select name="type" class="select">
					<option value="">검색조건</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select> <input type="text" name="keyword" class="search_word"
					placeholder="검색 단어 입력...">
				<button class="btn_search" type="submit">
					<i class="fa fa-search"></i><span class="sr-only">검색버튼</span>
				</button>
			</form>
		</div>
	</div>
	<!-- search end -->
	<div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="num"
					value="${count - (pagemaker.cri.pageNum - 1) * pagemaker.cri.amount}" />
				<c:forEach var="notice" items="${noticelist}">
					<tr>
						<td>${num}</td>
						<td class="title"><a
							href="view.do?t=${tbltype}&n=${notice.bno}&p=${pagemaker.cri.pageNum}&a=${pagemaker.cri.amount}">${notice.title}</a></td>
						<td>${notice.writer}</td>
						<td>${notice.regdate}</td>
						<td>${notice.viewcount}</td>
					</tr>
					<c:set var="num" value="${num - 1}" />
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="../paging.jsp" %>
	</div>
</div>
<!-- end content -->

<script>
	$(function() {
		$(".location  .dropdown > a").on("click", function(e) {
			e.preventDefault();
			if ($(this).next().is(":visible")) {
				$(".location  .dropdown > a").next().hide();
			} else {
				$(".location  .dropdown > a").next().hide();
				$(this).next().show();
			}
		});
	});
</script>

<%@ include file="../footer.jsp"%>