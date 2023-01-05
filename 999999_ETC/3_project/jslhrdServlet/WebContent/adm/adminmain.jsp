<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admheader.jsp" %>

<!-- contents -->
<aside id="welcome" class="adm-right active">
	<h2>환영합니다!</h2>
	<p>사실은 환영하지 않습니다</p>
	<p>그저 당신은 노예일 뿐...</p>
</aside>
<aside id="notice" class="adm-right">
	<table>
	<c:set var="num" value="${count - (pagemaker.cri.pageNum - 1) * pagemaker.cri.amount}" />
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
	</table>
	<%@ include file="../paging.jsp" %>
</aside>

	
</div> <!-- 헤더에 시작 태그 있음 -->

<%@ include file="admfooter.jsp" %>
