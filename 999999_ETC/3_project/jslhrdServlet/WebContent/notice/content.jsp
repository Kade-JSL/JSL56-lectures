<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<div class="search_wrap">
		<div class="record_group">
			<p>
				총게시글<span>${count}</span>건
			</p>
		</div>
		<div class="search_group">
			<form name="myform" method="get" action="notice.do">
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