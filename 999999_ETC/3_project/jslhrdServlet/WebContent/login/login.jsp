<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- sub contents -->
<div class="sub_title">
	<h2>접속자 로그인</h2>
	<div class="container">
	  <div class="location">
		<ul>
			<li class="btn_home">
				<a href="main.do"><i class="fa fa-home btn_plus"></i></a>
			</li>
			<li class="dropdown">
				<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
				<div class="dropdown_menu">
					<a href="tbl.do?t=notice">공지사항</a>
					<a href="">학과및모집안내</a>
					<a href="tbl.do?t=port">포트폴리오</a>
					<a href="">온라인접수</a>
					<a href="">커뮤니티</a>
				</div>
			</li>
			<li class="dropdown">
				<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
				<div class="dropdown_menu">
					<a href="tbl.do?t=notice">공지사항</a>
					<a href="tbl.do?t=qa">질문과답변</a>
					<a href="tbl.do?t=faq">FAQ</a>
				</div>
			</li>
		</ul>
	  </div>
	</div><!-- container end -->
</div>

<div class="container">
	<form>
		<div class="member_boxL">
        	<h2>개인회원</h2>
        	<div class="login_form">
	           	<form name="login" id="frmLogin" method="post" action="login.do">
	        		<div class="fl_clear">
	            		<label for="mbrId">아이디</label>
	            		<input name="mbrId" id="mbrId" type="text">
	            	</div>
	            	<div class="fl_clear">
	            		<label for="scrtNo">비밀번호</label>
	            		<input name="scrtNo" id="scrtNo" type="password">
	            	</div>
	            	<a class="btn_login btn_Blue" href="javascript:fn_login();">로그인</a>
	            </form>
       		</div>  
        </div>
	</form>
</div>
<!-- end contents -->
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