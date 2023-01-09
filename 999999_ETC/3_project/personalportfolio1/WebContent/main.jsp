<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ブログ</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/common.css" rel="stylesheet" />
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body style="font-family: sans-serif;">
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
							<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a>
							</li>
							<li><a href="#">Link</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-expanded="false">Dropdown <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
									<li class="divider"></li>
									<li><a href="#">One more separated link</a></li>
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
			</nav>
		</div>
	</header>
	<section class="container-fluid">
		<div id="generic" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#generic" data-slide-to="0" class="active"></li>
				<li data-target="#generic" data-slide-to="1"></li>
				<li data-target="#generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="images/m1.png" alt="야옹">
				</div>
				<div class="item">
					<img src="images/m2.png" alt="냐옹">
				</div>
				<div class="item">
					<img src="images/m3.jpg" alt="먀옹">
				</div>
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#generic" role="button"
				data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#generic" role="button"
				data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</section>
	
	<section class="container">
		<h2 class="text-center pd30">何度だってHere we go(Here we go)最高更新し続けるんだ</h2>
		<div class="row">
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c1.jpg" alt="">
		      <div class="caption">
		        <h3>제목1이다냥</h3>
		        <p>내용1이다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c2.jpg" alt="">
		      <div class="caption">
		        <h3>제목2다냥</h3>
		        <p>내용2다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c3.jpg" alt="">
		      <div class="caption">
		        <h3>제목3이다냥</h3>
		        <p>내용3이다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c4.jpg" alt="">
		      <div class="caption">
		        <h3>제목4다냥</h3>
		        <p>내용4다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c5.jpg" alt="">
		      <div class="caption">
		        <h3>제목5다냥</h3>
		        <p>내용5다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c6.jpg" alt="">
		      <div class="caption">
		        <h3>제목6이다냥</h3>
		        <p>내용6이다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		</div>
	</section>
	
	<section class="container">
		<h2 class="text-center pd30">オススメポスト</h2>
		<div class="row">
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c1.jpg" alt="">
		      <div class="caption">
		        <h3>제목1이다냥</h3>
		        <p>내용1이다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c2.jpg" alt="">
		      <div class="caption">
		        <h3>제목2다냥</h3>
		        <p>내용2다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c3.jpg" alt="">
		      <div class="caption">
		        <h3>제목3이다냥</h3>
		        <p>내용3이다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c4.jpg" alt="">
		      <div class="caption">
		        <h3>제목4다냥</h3>
		        <p>내용4다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c5.jpg" alt="">
		      <div class="caption">
		        <h3>제목5다냥</h3>
		        <p>내용5다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-sm-6 col-md-4">
		    <div class="thumbnail">
		      <img src="images/c6.jpg" alt="">
		      <div class="caption">
		        <h3>제목6이다냥</h3>
		        <p>내용6이다냥</p>
		        <p><a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>
		  </div>
		</div>
	</section>
	
	<section class="main-right">
		<p>
			${msg}
		</p>
	</section>
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