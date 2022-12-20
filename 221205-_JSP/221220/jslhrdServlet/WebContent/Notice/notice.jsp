<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- sub contents -->
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
						<a href="greetings.do">공지사항</a> <a href="allclass.do">학과및모집안내</a>
						<a href="portfolio.do">포트폴리오</a> <a href="online.do">온라인접수</a> <a
							href="notice.do">커뮤니티</a>
					</div></li>
				<li class="dropdown"><a href="">공지사항<i
						class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.do">공지사항</a> <a href="qa.do">질문과답변</a> <a
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
				총게시글<span> <?=$count?>
				</span>건
			</p>
		</div>
		<div class="search_group">
			<form name="myform" method="get" action="notice.do">
				<select name="sel" class="select">
					<option value="1">제목</option>
					<option value="2">내용</option>
				</select> <input type="text" name="search" class="search_word">
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
				<c:forEach var="dto" items="${noticelist}">
					<tr>
						<td>${dto.bno}</td>
						<td class="title"><a href="noticeview.do?bno=${dto.bno}">${dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.regdate}</td>
						<td>${dto.viewcount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paging">
			<a href=""><i class="fa fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa fa-angle-double-right"></i></a>
			<a href="/noticewrite.do" class="btn_write">글쓰기</a>
		</div>
	</div>
</div>
<!-- end contents -->

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