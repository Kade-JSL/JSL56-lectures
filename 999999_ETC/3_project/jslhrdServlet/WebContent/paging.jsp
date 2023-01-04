<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- 	<a href="/write.do?t=${tbltype}" class="btn_write">글쓰기</a> -->
</div>