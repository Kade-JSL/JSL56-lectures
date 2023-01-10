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

<body style="font-family: 'Pretendard Variable';">
	<header>

	</header>

	<section>
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
					<p>&copy; Kyuhyun Shim, all rights reserved.</p>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>