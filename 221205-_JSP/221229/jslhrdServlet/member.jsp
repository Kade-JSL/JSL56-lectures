<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<!-- sub content -->
<div class="sub_title">
	<h2>회원가입 약관</h2>
	<div class="container">
		<div class="location">
			<ul>
				<li class="btn_home"><a href="/main.do"> <i
						class="fa fa-home btn_plus"></i>
				</a></li>
				<li class="dropdown"><a href="">회원가입<i
						class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="memberterms.do">회원가입 약관</a>
					</div></li>
			</ul>
		</div>
	</div>
	<!-- container end -->
</div>

<div class="container">
	<div class="con_title">
		<h1>내정보(개인회원)</h1>
		<p>HOME / 마이페이지 / 내정보(개인회원)</p>
	</div>
	<div class="join_write col_989">
		<div class="list_con">
			<ul class="icon_type1">
				<li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게
					제공되지 않습니다.</li>
			</ul>
		</div>
		<form name="member" id="member" method="post" enctype="multipart/form-data" action="member.do" onsubmit="return check()">
		<table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
			<caption>회원가입을 위한 정보입력표</caption>
			<colgroup>
				<col width="160px">
				<col width="auto">
			</colgroup>
			<tbody id="joinDataBody">
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" id="name" class="w300">
					<span id="namemsg"></span>
					</td>
				</tr>
				<tr>
					<th><label for="name">닉네임</label></th>
					<td><input type="text" name="nickname" id="nickname" class="w300">
					<span id="nickmsg"></span>
					</td>
				</tr>
				<tr>
					<th><label for="id">아이디<span class="must"><b>필수입력</b></span></label></th>
					<td><input type="text" name="id" id="id" class="w300">
					<span id="idmsg"></span>
					</td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호<span class="must"><b>필수입력</b></span></label></th>
					<td><input type="password" name="pw1" id="pw1" class="w300">
						<p class="guideTxt">
							<span class="tc_point">영문(대문자 구분), 숫자, 특수문자의 조합</span>으로 9~13자로	작성해 주십시오.
						</p>
					</td>
				</tr>
				<tr>
					<th><label for="pw_confirm">비밀번호확인<span class="must"><b>필수입력</b></span></label></th>
					<td><input type="password" name="pw2" id="pw2" class="w300">
						<p class="guideTxt">
							<span class="tc_point">비밀번호 미입력시 기존비밀번호가 유지됩니다.</span>
						</p></td>
				</tr>

				<tr>
					<th><label for="phone">전화번호<span class="must"><b>필수입력</b></span></label></th>
					<td><input type="text" name="phone" id="phone" class="w300">
					</td>
				</tr>
				<tr>
					<th><label for="email">이메일<span class="must"><b>필수입력</b></span></label></th>
					<td>
						<input type="text" name="email" id="email" class="w300"/>
						<input type="button" value="인증번호 전송"/><br>
						<input type="password" name="certnumber" id="certnumber" class="w300"/>
						<input type="button" value="인증번호 확인"/><br>
					</td>
				</tr>
				<tr>
					<th><label for="profileimg">프로파일 이미지</label></th>
					<td><input type="file" name="profileimg" id="profileimg" class="w300"></td>
				</tr>
			</tbody>
		</table>
		<div class="btnArea Acenter pt60 pb100">
			<input type="reset"	class="btn_round btn_large btn_BlueGray w180" value="다시쓰기">
			<input type="submit" class="btn_round btn_large btn_pointColor w180" value="회원가입">
		</div>
		</form>
	</div>
</div>
<!-- end contents -->

<script>
	$(function() {
		$(".location  .dropdown > a").on("click", function(e) {
			e.preventDefault();
			if ($(this).next().is(":visible")) {
				$(".location  .dropdown > a").next().hide();
			} else {
				$(".location  .dropdown > a").next().hide();
				$(this).next().show();
			}
		});
		
		$("#name").blur(function(){
			if(!$("#name").val()) {
				$("#namemsg").html("<span style='color:#f00;'>이름을 입력하세요</span>");
			} else {
				$("#namemsg").html("");
			}
		})
		
		$("#nickname").blur(function(){
			if(!$("#nickname").val()) {
				$("#nickmsg").html("<span style='color:#f00;'>닉네임을 입력하세요</span>");
			} else {
				$("#nickmsg").html("");
			}
			
			$.ajax({
				type:"post",
				url:"nicknamecheck.do",
				data:{nickname:$("#nickname").val()},
				success:function(data){
					if(data == -1) {
						if($("#nickname").val() != "") {
							$("#nickmsg").html("사용 가능한 닉네임입니다.");
						}
					} else if (data == 1) {
						if($("#nickname").val() != "") {
							$("#nickmsg").html("<span style='color:#f00;'>이미 사용중인 닉네임입니다.</span>");
						}
					}
				},
				error: function(xhr, status, error) {
					alert("통신 에러");
				}
			})
		})
		
		$("#id").blur(function(){
			if(!$("#id").val()) {
				$("#idmsg").html("<span style='color:#f00;'>아이디를 입력하세요</span>");
			} else {
				$("#idmsg").html("");
			}
			
			$.ajax({
				type:"post",
				url:"memberidcheck.do",
				data:{id:$("#id").val()},
				success:function(data){
					if(data == -1) {
						if($("#id").val() != "") {
							$("#idmsg").html("사용 가능한 아이디입니다.");
						}
					} else if (data == 1) {
						if($("#id").val() != "") {
							$("#idmsg").html("<span style='color:#f00;'>이미 사용중인 아이디입니다.</span>");
						}
					}
				},
				error: function(xhr, status, error) {
					alert("통신 에러");
				}
			})
		})
		
	});
</script>

<%@ include file="../footer.jsp"%>