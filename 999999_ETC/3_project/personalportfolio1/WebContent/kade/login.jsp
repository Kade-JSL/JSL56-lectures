<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
</header>
<!-- sidebar end -->
<section class="col-md-9">
	<form class="form-horizontal" name="login" method="post"
		enctype="multipart/form-data" action="return check()">
		<div class="form-group">
			<label for="id" class="col-sm-2 control-label">ナマエ</label>
			<div class="col-sm-6">
				<input type="text" name="id" class="form-control" id="id"
					placeholder="Kade様">
			</div>
		</div>
		<div class="form-group">
			<label for="pw1" class="col-sm-2 control-label">ぱすわーど</label>
			<div class="col-sm-6">
				<input type="password" name="pw1" class="form-control" id="pw1"
					placeholder="ご暗証番号">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-default">こちらへ</button>
			</div>
		</div>
	</form>
</section>
<%@ include file="../footer.jsp"%>