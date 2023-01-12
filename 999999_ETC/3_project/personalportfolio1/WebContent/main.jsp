<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/header.jsp" %>
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
				<a href="outer-pieces.do${user.outerpiece}">あなたの</a>
			</li>
			<li class="menu col-md-12 col-sm-3 col-xs-4">
				<a href="notice.do">おしらせ</a>
			</li>
			<li class="menu col-md-12 col-sm-3 col-xs-4">
				<a href="signup.do">とうろく</a>
			</li>
		</ul>
	</header><!-- sidebar end -->

	<section class="col-md-9 pd30">
		<div class="col-md-8">
			<table class="table">
				<tbody>
					<tr>
						<th colspan="2"><a href="pieces.do" class="bolder px24">私の最新作品</a></th>
					</tr>
					<tr>
						<td class="col-md-9 col-xs-9"><a href="">白いクジラ(72)</a></td>
						<td class="col-md-3 col-xs-3"><a href="">2072-07-02</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-8">
			<table class="table">
				<tbody>
					<tr>
						<th colspan="2"><a href="outer-pieces.do" class="bolder px24">ユーザー作品</a></th>
					</tr>
					<tr>
						<td class="col-md-9 col-xs-9"><a href="">白いクジラ(72)</a></td>
						<td class="col-md-3 col-xs-9"><a href="">2072-07-02</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-8">
			<table class="table">
				<tbody>
					<tr>
						<th colspan="2"><a href="notice.do" class="bolder px24">雑談・お知らせ</a></th>
					</tr>
					<tr>
						<td class="col-md-9 col-xs-9"><a href="">白いクジラ(72)</a></td>
						<td class="col-md-3 col-xs-9"><a href="">2072-07-02</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		${msg}
	</section>
</div> <!-- row end -->
<%@ include file="../footer.jsp"%>