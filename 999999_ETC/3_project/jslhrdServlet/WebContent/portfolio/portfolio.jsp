<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	    

	<!-- sub content -->
	<div class="sub_title">
		<h2>포트폴리오</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="/"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="">기업소개</a>
						<a href="tbl.do?t=port">포트폴리오</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="tbl.do?t=port">포트폴리오</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

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
						<a href="view.do?t=${tbltype}&n=${dto.bno}&p=${pagemaker.cri.pageNum}&a=${pagemaker.cri.amount}"><img src="../upload/${dto.imgurl}" alt=""/></a>
					</div>
					<span class="info">
						<span class="blue_text">No. ${dto.bno}</span>
						<i class="bar"></i>
						<i class="fa fa-eye"></i>${dto.viewcount}
					</span>
					<p class="title">
						<a href="view.do?t=${tbltype}&n=${dto.bno}&p=${pagemaker.cri.pageNum}&a=${pagemaker.cri.amount}">${dto.title}</a>
					</p>
					<span class="text">${dto.content}</span>
				</div>
			</li>
			</c:forEach>
		</ul>
		<!-- paging -->
		<%@ include file="../paging.jsp" %>
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

<%@ include file="../footer.jsp"%>