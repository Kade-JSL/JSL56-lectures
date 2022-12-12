<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오디션 관리 프로그램</title>
<style>
	* {margin: 0; padding: 0}
	a {text-decoration: none;}
	ul, ol {list-style: none;}
	table {border: 1px solid #ccc;}
	
	header {background: #ccc; padding: 20px 0;}
	header h1 {text-align: center;}
	nav {background: #888; overflow: hidden;}
	nav ul li {float: left; padding: 12px 16px;}
	nav ul li a {color: #ccc;}
	section {height: 460px;}
	section h2 {text-align: center; padding: 20px 0;}
	section p {line-height: 180%; padding-left: 20px;}
	section table {margin: 0 auto;}
	footer {background: #333; padding: 20px 0;}
	footer p {text-align: center; color: #ccc;}
</style>
</head>
<body>
	<header>
		<h1>(과정평가형 정보처리산업기사) 오디션 관리 프로그램</h1>
	</header>
	<nav>
		<ul>
			<li><a href="sub1.do">오디션등록</a></li>
			<li><a href="sub2.do">참가자 목록 조회</a></li>
			<li><a href="sub3.do">멘토점수조회</a></li>
			<li><a href="sub4.do">참가자등수조회</a></li>
			<li><a href="main.do">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h2>오디션 등록</h2>
		<form name="my" id="myform" method="post" action="sub1pro.do" onsubmit="return check()">
			<table>
				<tr>
					<th>참가번호</th>
					<td><input type="text" name="artist_id"/></td>
				</tr>
				<tr>
					<th>참가자명</th>
					<td><input type="text" name="artist_name"/></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="artist_gender" value="M"/>남성
					<input type="radio" name="artist_gender" value="F"/>여성
					<input type="radio" name="artist_gender" value="N"/>그 외						
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="artist_birth"/></td>
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
					<td><input type="text" name="agency"/></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center">
					<input type="submit" value="오디션 등록"/>
					<input type="button" onclick="rewrite();" value="다시쓰기"/>
					</td>
				</tr>
			</table>
		</form>
	</section>
	<footer>
		<p>&copy; HRDKOREA</p>
	</footer>
</body>
<script>
	function check() {
		if(my.artist_id.value == "") {
			alert("참가번호가 입력되지 않았습니다.");
			my.artist_id.focus();
			return false;
		}
		if(my.artist_name.value == "") {
			alert("참가자명이 입력되지 않았습니다.");
			my.artist_name.focus();
			return false;
		}
		if(!my.artist_gender[0].checked && !my.artist_gender[1].checked && !my.artist_gender[2].checked) {
			alert("성별이 선택되지 않았습니다.");
			my.artist_gender[0].focus();
			return false;
		}
		if(my.artist_birth.value == "") {
			alert("생년월일 입력되지 않았습니다.");
			my.artist_birth.focus();
			return false;
		}
		if(my.talent.value != "1" && my.talent.value != "2" && my.talent.value != "3") {
			alert("특기가 선택되지 않았습니다.");
			my.talent.focus();
			return false;
		}
		if(my.agency.value == "") {
			alert("소속사가 입력되지 않았습니다.");
			my.agency.focus();
			return false;
		}
		alert("오디션 지원자정보가 등록되었습니다.");
		return true;
	}
	function rewrite() {
		alert("정보를 지우고 처음부터 다시 입력합니다!");
		document.getElementById("myform").reset();
		my.artist_id.focus();
		return;
	}
</script>
</html>