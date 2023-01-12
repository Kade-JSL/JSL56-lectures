<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

</header>
<!-- sidebar end -->
<section class="col-md-9">
    <div class="col-md-8 col-xs-12">
	<h1 class="text-center">お帰りなさいませ、ご主人様。</h1>
	<form class="form-horizontal" name="login" method="post" action="kade.do">
		<div class="form-group">
			<label for="kade-email" class="col-xs-10 col-xs-offset-1 col-md-3 col-md-offset-0 control-label">ナマエ</label>
			<div class="col-xs-10 col-xs-offset-1 col-md-9 col-md-offset-0">
				<input type="text" name="kade-email" class="form-control" id="kade-email" placeholder="Kade様">
			</div>
		</div>
		<div class="form-group">
			<label for="kade-pw" class="col-xs-10 col-xs-offset-1 col-md-3 col-md-offset-0 control-label">ぱすわーど</label>
			<div class="col-xs-10 col-xs-offset-1 col-md-9 col-md-offset-0">
				<input type="password" name="kade-pw" class="form-control" id="kade-pw" placeholder="ご暗証番号">
			</div>
		</div>
		<div class="form-group">
			<div class="text-center">
				<button type="submit" class="btn btn-default">こちらへ</button>
			</div>
		</div>
	</form>
	</div>
</section>
<%@ include file="../footer.jsp"%>