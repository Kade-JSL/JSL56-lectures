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
	<div class="container pd60">

		<div class="row">
			<div class="col-md-3">
				<h2>作品検索</h2>
				<form action="search.do">
					<input type="text" name="keyword" class="form-control search" placeholder="検索…"/>
					<button type="button" class="btn btn-success">入力</button>
				</form>
			</div>

			<div class="col-md-9">
				<div class="col-md-12 pieces pd30">
					<a href="piece-view.do" class="img"></a>
					<div class="col-md-12 text">
						<h2>하얀 고래</h2>
						<p>대청호가 말랐다. 어떤 이는 바다가 말랐다고도 한다. 물은커녕, 지필 장작도 없다. </p>
						<div class="col-md-2">
							<a href="" class="authorimg"></a>
						</div>
						<div class="col-md-10">
							<p>Written by</p>
							<p>kade, at fringe | 2023.01.10</p>
							<p>
								<span class="glyphicon glyphicon-heart">210</span>
								<span class="glyphicon glyphicon-eye-open">320</span>
								<span class="glyphicon glyphicon-comment">12</span>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-12 pieces pd30">
					<a href="piece-view.do" class="img"></a>
					<div class="col-md-12 text">
						<h2>하얀 고래</h2>
						<p>대청호가 말랐다. 어떤 이는 바다가 말랐다고도 한다. 물은커녕, 지필 장작도 없다. </p>
						<div class="col-md-2">
							<a href="" class="authorimg"></a>
						</div>
						<div class="col-md-10">
							<p>Written by</p>
							<p>kade, at fringe | 2023.01.10</p>
							<p>
								<span class="glyphicon glyphicon-heart">210</span>
								<span class="glyphicon glyphicon-eye-open">320</span>
								<span class="glyphicon glyphicon-comment">12</span>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-12 pieces pd30">
					<a href="piece-view.do" class="img"></a>
					<div class="col-md-12 text">
						<h2>하얀 고래</h2>
						<p>대청호가 말랐다. 어떤 이는 바다가 말랐다고도 한다. 물은커녕, 지필 장작도 없다. </p>
						<div class="col-md-2">
							<a href="" class="authorimg"></a>
						</div>
						<div class="col-md-10">
							<p>Written by</p>
							<p>kade, at fringe | 2023.01.10</p>
							<p>
								<span class="glyphicon glyphicon-heart">210</span>
								<span class="glyphicon glyphicon-eye-open">320</span>
								<span class="glyphicon glyphicon-comment">12</span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div><!-- /.row (1st) -->

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