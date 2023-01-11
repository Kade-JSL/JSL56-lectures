<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
		<ul class="list-unstyled">
			<li class="menu col-md-12 col-sm-3 col-xs-4"><a href="pieces.do?where=0">はじめる</a></li>
			<c:choose>
				<c:when test="${not empty user}">
				<li class="menu col-md-12 col-sm-3 col-xs-4">
					<a href="pieces.do?where=${user.lastread}">続きから</a>
				</li>
				</c:when>
				<c:otherwise>
				<li class="inactive menu col-md-12 col-sm-3 col-xs-4">続きから</li>
				</c:otherwise>
			</c:choose>
			<li class="menu col-md-12 col-sm-3 col-xs-4">
				<a href="outer-pieces.do${user.yourpieces}">あなたの</a>
			</li>
			<li class="menu col-md-12 col-sm-3 col-xs-4">
				<a href="notice.do">おしらせ</a>
			</li>
			<li class="menu boldest col-md-12 col-sm-3 col-xs-4">
				<a href="signup.do"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>とうろく</a>
			</li>
		</ul>
	</header><!-- sidebar end -->


<%@ include file="../footer.jsp" %>