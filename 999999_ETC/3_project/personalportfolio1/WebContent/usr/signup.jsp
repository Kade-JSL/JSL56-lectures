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
	
	<section class="col-md-9 pd30">
		<div class="col-md-8 col-xs-12">
			<h1 class="bolder text-center">会員登録</h1>
			<form id="signup" action="signup.do" method="post" class="form-horizontal" enctype="multipart/form-data" onSubmit="return check();">
				<div class="form-group">
					<label for="email" class="col-xs-10 col-xs-offset-1 col-md-3 col-md-offset-0 control-label">メールアドレス*</label>
					<div class="col-xs-10 col-xs-offset-1 col-md-9 col-md-offset-0">
						<input type="text" name="email" class="form-control" id="email">
					</div>
					<span id="emailchk" class="col-xs-10 col-xs-offset-1 col-md-offset-3" style="color:#a94442;"></span>
				</div>
				<div class="form-group">
					<label for="uname" class="col-xs-10 col-xs-offset-1 col-md-3 col-md-offset-0 control-label">ニックネーム*</label>
					<div class="col-xs-10 col-xs-offset-1 col-md-9 col-md-offset-0">
						<input type="text" name="uname" class="form-control" id="uname">
					</div>
					<span id="unamechk" class="col-xs-10 col-xs-offset-1 col-md-offset-3" style="color:#a94442;"></span>
				</div>
				<div class="form-group">
					<label for="pw" class="col-xs-10 col-xs-offset-1 col-md-3 col-md-offset-0 control-label">パスワード*</label>
					<div class="col-xs-10 col-xs-offset-1 col-md-9 col-md-offset-0">
						<input type="password" name="pw" class="form-control" id="pw">
					</div>
					<span id="pwchk" class="col-xs-10 col-xs-offset-1 col-md-offset-3" style="color:#a94442;"></span>
				</div>
				<div class="form-group">
					<label for="pw-confirm" class="col-xs-10 col-xs-offset-1 col-md-3 col-md-offset-0 control-label">パスワード確認*</label>
					<div class="col-xs-10 col-xs-offset-1 col-md-9 col-md-offset-0">
						<input type="password" name="pw-confirm" class="form-control" id="pw-confirm">
					</div>
					<span id="pwcchk" class="col-xs-10 col-xs-offset-1 col-md-offset-3" style="color:#a94442;"></span>
				</div>
				<div class="form-group">
					<label for="profileimg" class="col-xs-10 col-xs-offset-1 col-md-3 col-md-offset-0 control-label">プロフィール画像</label>
					<div class="col-xs-10 col-xs-offset-1 col-md-9 col-md-offset-0">
						<input type="file" name="profileimg" class="form-control" id="profileimg">
					</div>
					<span id="pimgchk" class="col-xs-10 col-xs-offset-1 col-md-offset-3" style="color:#a94442;"></span>
				</div>
				<div class="form-group">
					<div class="text-center">
						<button type="submit" class="btn btn-default">サインアップ</button>
					</div>
				</div>
			</form>
		</div>
	</section>
<script>
	$(function(){
		$("#email").blur(function(){
			if(!$("#email").val()) {
				$("#emailchk").text("必須フィルドです。");
				$("#email").parent().addClass("has-error");
			} else {
				$("#emailchk").text("");
				$("#email").parent().removeClass("has-error");
			}
			var emailregex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
			var emailval = $("#email").val();
			if(!emailregex.test(emailval)) {
				$("#emailchk").text("メールアドレスの形で入力してください。");
				$("#email").parent().addClass("has-error");
				return;
			} else {
				$("#emailchk").text("");
				$("#email").parent().removeClass("has-error");
			}
		})
		
		$("#uname").blur(function(){
			if(!$("#uname").val()) {
				$("#unamechk").text("必須フィルドです。");
				$("#uname").parent().addClass("has-error");
			} else {
				$("#unamechk").text("");
				$("#uname").parent().removeClass("has-error");
			}
		})
	})
</script>
<%@ include file="../footer.jsp" %>