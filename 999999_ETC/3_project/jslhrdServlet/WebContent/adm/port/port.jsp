<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admheader.jsp"%>

<aside id="port" class="adm-right">
<div class="container">
  <div class="search_wrap">
	<div class="record_group">
		<p>총게시글<span>${pagemaker.total}</span>건</p>
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
		<ul class="basic_board">
			<c:forEach var="dto" items="${list}">
			<li>
				<span class="date">
					<em>
						<fmt:parseDate var="regdate" value="${dto.regdate}" pattern="yyyy-MM-dd"/>
						<fmt:formatDate value="${regdate}" pattern="dd"/>
					</em>
						<fmt:formatDate value="${regdate}" pattern="yyyy.MM"/>
					</span>
				<div class="text_wrap">
					<div class="img_wrap">
						<a href="adm-port-view.do?n=${dto.bno}&p=${pagemaker.cri.pageNum}&a=${pagemaker.cri.amount}"><img src="../upload/${dto.imgurl}" alt=""/></a>
					</div>
					<span class="info">
						<span class="blue_text">No. ${dto.bno}</span>
						<i class="bar"></i>
						<i class="fa fa-eye"></i>${dto.viewcount}
					</span>
					<p class="title">
						<a href="adm-port-view.do?n=${dto.bno}&p=${pagemaker.cri.pageNum}&a=${pagemaker.cri.amount}">${dto.title}</a>
					</p>
					<span class="text">${dto.content}</span>
				</div>
			</li>
			</c:forEach>
		</ul>
		<!-- paging -->
		<div class="paging">
			<c:if test="${pagemaker.prev}">
				<a href="adm-port.do?p=${pagemaker.startPage - 1}&a=${pagemaker.cri.amount}">
				<i class="fa fa-angle-double-left"></i></a>
			</c:if>
			<c:forEach var="pages" begin="${pagemaker.startPage}" end="${pagemaker.endPage}">
				<a href="adm-port.do?p=${pages}&a=${pagemaker.cri.amount}" class="${pagemaker.cri.pageNum == pages ? 'active':''}">${pages}</a>
			</c:forEach>
			<c:if test="${pagemaker.next}">
				<a href="adm-port.do&p=${pagemaker.endPage + 1}&a=${pagemaker.cri.amount}"><i class="fa fa-angle-double-right"></i></a>
			</c:if>
			<a href="adm-port-write.do" class="btn_write">글쓰기</a>
		</div>
	  </div>
	</div>
	<!-- end content -->
	</aside>

<%@ include file="../admfooter.jsp"%>