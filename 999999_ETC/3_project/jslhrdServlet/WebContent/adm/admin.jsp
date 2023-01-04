<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- sub contents -->
	<div class="sub_title">
		<h2>관리자 로그인</h2>
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
						<a href="portfolio.html">포트폴리오</a>
						<a href="online.html">온라인접수</a>
						<a href="notice.html">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">관리자<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.html">공지사항</a>
						<a href="qa.html">질문과답변</a>
						<a href="faq.html">FAQ</a>
						<a href="admin.html">관리자</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="bg_admim">
		<div class="container">
			<div class="grap">
				<form name="admin" method="post" action="admin.do">
					<fieldset>
						<legend class="sr-only">관리자로그인</legend>
						<label for="id" class="sr-only">아이디입력</label><input type="text" name="id" placeholder="아이디를 입력하세요" id="id">
						<label for="pw" class="sr-only">패스워드입력</label><input type="password" name="pw" placeholder="패스워드를 입력하세요" id="pw">
						<a href="javascript:void(0)" onClick="admin_check();" class="btn_admin">로그인</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<!-- end contents -->
	<script type="text/javascript">
		function admin_check() {
			if(admin.id.value=="") {
				alert("아이디입력");
				admin.id.focus();
				return false;
			}
			if (admin.pw.value=="") {
				alert("패스워드입력");
				admin.pw.focus();
				return false;
			}
			admin.submit();
		}
	</script>

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