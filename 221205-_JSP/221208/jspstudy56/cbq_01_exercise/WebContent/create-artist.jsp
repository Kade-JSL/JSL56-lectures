<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오디션 관리 프로그램</title>
<style>
	* { margin: 0; padding: 0; }
	a { text-decoration: none; }
	ul { list-style: none;}
	
	header {
		background: #00f;
		padding: 20px 0;	
	}
	header h1 {
		color: #fff;
		text-align: center;
	}
	
	footer {
		background: #0ff;
		padding: 20px 0;
	}
	footer p {
		font-weight: bold;
		font-size: 20px;
		color: #333;
		text-align: center;
	}
	
	.menu {
		height: 45px;
		background: #33f;
	}
	.menu * { float: left; }
	.menu a {
		padding: 12px 16px;
		color: #ccc;
	}
	
	.content { margin: 60px 0; }
	.content h2 {
		font-weight: bold;
		text-align: center;
		padding-bottom: 24px;
	}
	.content p { padding-left: 60px; }
	.content table { margin: 0 auto; }
	.content th, .content td {
		border: 1px solid #ccc;
	}
	.content .small-text { width: 60px; }
</style>
</head>
<body>
	<header>
	<h1>(과정평가형 정보처리산업기사) 오디션 관리 프로그램 ver 2019-05</h1>
	</header>
	<section class="menu">
	<ul>
	  <li><a href="create-artist.jsp">오디션 등록</a></li>
	  <li><a href="read-artist.jsp">참가자목록조회</a></li>
	  <li><a href="read-mentor.jsp">멘토점수조회</a></li>
	  <li><a href="read-rank.jsp">참가자등수조회</a></li>
	  <li><a href="index.jsp">홈으로</a></li>
	</ul>
	</section>
	<section class="content">
		<h2>오디션 등록</h2>
		<form name="cr1" method="post" action="cr1-action.jsp" onsubmit="return check();">
			<table>
				<tr>
					<th>참가번호</th>
					<td><input type="text" name="artist_id">*참가번호는(A000)의 4자리입니다.</td>
				</tr>
				<tr>
					<th>참가자명</th>
					<td><input type="text" name="artist_name"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>
						<input class="small-text" type="text" name="artist_birth1">년
						<input class="small-text" type="text" name="artist_birth2">월
						<input class="small-text" type="text" name="artist_birth3">일
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="artist_gender" value="M">남성
						<input type="radio" name="artist_gender" value="F">여성
					</td>
				</tr>
				<tr>
					<th>특기</th>
					<td>
						<select name="talent">
							<option>특기선택</option>
							<option value="1">댄스</option>
							<option value="2">랩</option>
							<option value="3">노래</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>소속사</th>
					<td><input type="text" name="agency"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center;">
						<input type="submit" value="오디션등록">
						<input type="reset" value="다시쓰기">
					</td>
				</tr>
			</table>
		</form>
	</section>
	<footer>
	<p>HRDKOREA Copyright &copy; 2019 All rights reserved. Human Resources Development Service of Korea</p>
	</footer>
</body>
<script>
	function check() {
		if(cr1.artist_id.value == "") {
			alert("참가번호가 입력되지 않았습니다.");
			cr1.artist_id.focus();
			return false;
		}
		if(cr1.artist_name.value == "") {
			alert("참가자명이 입력되지 않았습니다.");
			cr1.artist_name.focus();
			return false;
		}
		if(cr1.artist_birth1.value == "" || cr1.artist_birth2.value == "" || cr1.artist_birth3.value == "") {
			alert("생년월일 입력되지 않았습니다.");
			cr1.artist_birth1.focus();
			return false;
		}
		if(!cr1.artist_gender[0].checked && !cr1.artist_gender[1].checked) {
			alert("성별이 선택되지 않았습니다.");
			cr1.artist_gender[0].focus();
			return false;
		}
		if(cr1.talent.value != "1" && cr1.talent.value != "2" && cr1.talent.value != "3") {
			alert("특기가 선택되지 않았습니다.");
			cr1.talent.focus();
			return false;
		}
		if(cr1.agency.value == "") {
			alert("소속사가 입력되지 않았습니다.");
			cr1.agency.focus();
			return false;
		}
		alert("오디션 지원자정보가 등록되었습니다.");
		return true;
	}
</script>
</html>