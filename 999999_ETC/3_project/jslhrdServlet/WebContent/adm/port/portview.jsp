<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admheader.jsp"%>
    
<!-- sub content -->
	<div class="container">
		<div class="board_view">
			<h2>${view.title}</h2>
			<p class="info">
				<span class="user">${view.writer}</span>
				<fmt:parseDate parseLocale="ko-KR" var="regdate" value="${view.regdate}" pattern="yyyy-MM-dd"/>
				| <fmt:formatDate value="${regdate}" pattern="yyyy-MM-dd"/> | <i class="fa fa-eye"></i> ${view.viewcount}
			</p>
			<div class="board_body">
				${view.content}
			</div>
			<div class="prev_next">
				<a href="" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span>이전글제목표시</span>
				</span>
				</a>
				<div class="btn_3wrap">
					<a href="adm-port.do?p=${pagemaker.cri.pageNum}&a=${pagemaker.cri.amount}">목록</a>
					<a href="adm-port-mod.do?n=${view.bno}&p=${pagemaker.cri.pageNum}&a=${pagemaker.cri.amount}">수정</a>
					<a href="adm-port-del.do?n=${view.bno}" onClick="return confirm('삭제하시겠어요?')">삭제</a>
				</div>
				<a href="" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span>다음글제목표시</span>
				</span>
				<i class="fa fa-angle-right"></i></a>
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

<%@ include file="../admfooter.jsp"%>