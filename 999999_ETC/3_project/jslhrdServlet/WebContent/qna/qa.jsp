<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
   
<!-- sub content -->
<div class="sub_title">
	<h2>질문과답변</h2>
	<div class="container">
	  <div class="location">
		<ul>
			<li class="btn_home">
				<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
			</li>
			<li class="dropdown">
				<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
				<div class="dropdown_menu">
					<a href="gratings.html">공지사항</a>
					<a href="allclass.html">학과및모집안내</a>
					<a href="list.do?t=port">포트폴리오</a>
					<a href="online.html">온라인접수</a>
					<a href="">커뮤니티</a>
				</div>
			</li>
			<li class="dropdown">
				<a href="">질문과답변<i class="fa fa-plus btn_plus"></i></a>
				<div class="dropdown_menu">
					<a href="list.do?t=notice">공지사항</a>
					<a href="list.do?t=qa">질문과답변</a>
					<a href="list.do?t=faq">취업실적</a>
				</div>
			</li>
		</ul>
	  </div>
	</div><!-- container end -->
</div>

<div class="container">
  <div class="search_wrap">
	<div class="record_group">
		<p>총게시글<span>120</span>건</p>
	</div>
	<div class="search_group">
		<form name="myform" action="">
			<select name="sel" class="select">
				<option value="1">제목</option>
				<option value="2">내용</option>
			</select>
			<input type="text" name="search" class="search_word">
			<button class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
		</form>
	</div>
  </div> <!-- search end -->
  <div class="bord_list">
	<table class="bord_table" summary="이표는 번호,제목,답변상태, 작성자, 작성일, 조회수로 구성되어 있습니다">
		<caption class="sr-only">질문과 답변 리스트</caption>
		<colgroup>
			<col width="10%">
			<col width="*">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>답변상태</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>8</td>
				<td class="title"><a href="qa_view.html">입학절차에 대하여 알고 싶어요</a></td>
				<td><span class="waiting">답변대기</span></td>
				<td>관리자</td>
				<td>18-10-16</td>
				<td>187</td>
			</tr>
		</tbody>
	</table>
	<div class="paging">
	<c:if test="${pagemaker.prev}">
		<a href="list.do?t=${tbltype}&p=${pagemaker.startPage - 1}&a=${pagemaker.cri.amount}">
		<i class="fa fa-angle-double-left"></i></a>
	</c:if>
	<c:forEach var="pages" begin="${pagemaker.startPage}" end="${pagemaker.endPage}">
		<a href="list.do?t=${tbltype}&p=${pages}&a=${pagemaker.cri.amount}" class="${pagemaker.cri.pageNum == pages ? 'active':''}">${pages}</a>
	</c:forEach>
	<c:if test="${pagemaker.next}">
		<a href="/list.do?t=${tbltype}&p=${pagemaker.endPage + 1}&a=${pagemaker.cri.amount}"><i class="fa fa-angle-double-right"></i></a>
	</c:if>
	<a href="/write.do?t=${tbltype}" class="btn_write">글쓰기</a>
</div>
  </div>
</div>
<!-- end content -->

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
