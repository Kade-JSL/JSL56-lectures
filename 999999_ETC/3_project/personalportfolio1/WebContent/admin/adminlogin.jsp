<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ブログ</title>
	<link href="../css/bootstrap.min.css" rel="stylesheet"/>
	<link href="../css/common.css" rel="stylesheet"/>
	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body style="font-family: 'Pretendard Variable';">
	<header>
		<div class="container">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="main.do">ポートフォリオ</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Pieces <span class="sr-only">(current)</span></a>
							</li>
							<li><a href="#">Your Pieces</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-expanded="false">Menu <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="main.do">Start</a></li>
									<li><a href="pieces.do">Pieces</a></li>
									<li><a href="multiverse.do">Your Pieces</a></li>
									<li class="divider"></li>
									<li><a href="notice.do">Notice</a></li>
									<li class="divider"></li>
									<li><a href="kade.do">Kade</a></li>
								</ul>
							</li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<c:choose>
								<c:when test="${not empty session}">
									<li><a href="logout.do">ログアウト</a></li>
									<li><a href="mypage.do">マイページ</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="login.do">ログイン</a></li>
									<li><a href="member.do">会員登録</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div><!-- /.navbar-collapse -->
				</div><!-- /.container-fluid -->
			</nav><!-- /.navbar --> 
		</div><!-- /.container -->
	</header>
	
	<!-- content start -->
	
	<div class="row">
		<div class="col-md-3">
			<h2>作品検索</h2>
			<form action="search.do">
				<input type="text" name="keyword" class="form-control search" placeholder="検索…"/>
				<button type="button" class="btn btn-success">入力</button>
			</form>
		</div>
		<div class="col-md-9">
			<div class="col-md-12 pd30">
				<h2 class="text-center">お帰りなさいませ、ご主人様。</h2>
				<form class="form-horizontal" name="login" method="post" enctype="multipart/form-data" action="return check()">
				  <div class="form-group">
				    <label for="id" class="col-sm-2 control-label">ナマエ</label>
				    <div class="col-sm-6">
				      <input type="text" name="id" class="form-control" id="id" placeholder="Kade様">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="pw1" class="col-sm-2 control-label">ぱすわーど</label>
				    <div class="col-sm-6">
				      <input type="password" name="pw1" class="form-control" id="pw1" placeholder="ご暗証番号">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-4">
				      <button type="submit" class="btn btn-default">こちらへ</button>
				    </div>
				  </div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- content end -->
	
	<footer class="main-bottom container-fluid footer" style="margin-top:40px;">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<h2>ポートフォリオ</h2>
				</div>
				<div class="col-md-8 pd30">
					<p>東京23区のどこか</p>
					<p>&copy; Kyuhyun Shim, all rights reserved.</p>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>