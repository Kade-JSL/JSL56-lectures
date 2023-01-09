<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admheader.jsp"%>

<aside id="port" class="adm-right">
<div class="board_view">
	<h2>${view.title}</h2>
	<p class="info"><span class="user">${view.writer}</span> | ${view.regdate} | <i class="fa fa-eye"></i> ${view.viewcount}</p>
	<div class="board_body">
		${view.content}
	</div>
	<div class="prev_next">
		<c:if test="${prev.bno != view.bno}">
			<a href="/adm-notice-view.do?n=${prev.bno}&p=${cri.pageNum}&a=${cri.amount}" class="btn_prev">
				<i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span>${prev.title}</span>
				</span>
			</a>
		</c:if>
		<div class="btn_3wrap">
			<a href="adm-notice.do?p=${cri.pageNum}&a=${cri.amount}">목록</a>
			<a href="adm-notice-modify.do?bno=${view.bno}&p=${cri.pageNum}&a=${cri.amount}">수정</a>
			<a href="adm-notice-delete.do?bno=${view.bno}&p=${cri.pageNum}&a=${cri.amount}" onClick="return confirm('삭제하시겠어요?')">삭제</a>
		</div>
		<c:if test="${next.bno != view.bno}">
			<a href="/adm-notice-view.do?&n=${next.bno}&p=${cri.pageNum}&a=${cri.amount}" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span>${next.title}</span>
				</span>
				<i class="fa fa-angle-right"></i>
			</a>
		</c:if>
	</div>
</div>
</aside>

<%@ include file="../admfooter.jsp" %>