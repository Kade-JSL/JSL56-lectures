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
					<td><input type="password" name="pw" id="pw1" class="w300">
						<p class="guideTxt">
							<span class="tc_point">영문(대문자 구분), 숫자, 특수문자의 조합</span>으로 9~13자로	작성해 주십시오.
						</p>
					</td>
				</tr>
				<tr>
					<th><label for="pw_confirm">비밀번호확인<span class="must"><b>필수입력</b></span></label></th>
					<td>
						<input type="password" id="pw2" class="w300">
						<p class="guideTxt"><span class="tc_point">비밀번호를 다시 한 번 입력해 주세요.</span></p>
						<span id="pw2msg" style="color:#f00;"></span>
					</td>
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
						<!-- onchange 속성을 이용하면 select가 되었을 때 거기 있는 value를 앞의 박스에 넘겨줄 수 있게 된다 -->
						<input type="button" id="btn_email" value="인증번호 전송"/>
						<span id="emailmsg"></span><br>
						<!-- 버튼을 클릭했을 때 주소를 검사하고 메일 전송이 되도록 해야 함 -->
						<input type="text" name="authnumber" id="authnumber" class="w300"/>
						<input type="button" id="btn_auth" value="인증번호 확인"/><span id="authmsg"></span><br>
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
							$("#nickmsg").html("<br>사용 가능한 닉네임입니다.");
						}
					} else if (data == 1) {
						if($("#nickname").val() != "") {
							$("#nickmsg").html("<br><span style='color:#f00;'>이미 사용중인 닉네임입니다.</span>");
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
			var idRegExp = /^[a-zA-z0-9]{4,12}$/;
			// 단어의 시작과 끝을 ^와 $로 끊고, [] 안에 조건이 될 문자열 범위를, {} 안에 글자수 범위를 적는다
			var idc = $("#id").val();
			if(!idRegExp.test(idc)) {
				$("#idmsg").html("<span style='color:#f00';>아이디는 영문자 또는 숫자 4~12자리로 입력해 주세요.</span>")
				return; // 조건이 충족되면 프로그램을 여기서 종료하라.
			} else {
				$("#idmsg").html(""); // 조건이 충족되지 않으면(아이디가 조건에 맞으면) 아래로 계속 진행
			}
			
			$.ajax({
				type:"post",
				url:"memberidcheck.do",
				data:{id:$("#id").val()},
				success:function(data){
					if(data == -1) {
						if($("#id").val() != "") {
							$("#idmsg").html("<br>사용 가능한 아이디입니다.");
						}
					} else if (data == 1) {
						if($("#id").val() != "") {
							$("#idmsg").html("<br><span style='color:#f00;'>이미 사용중인 아이디입니다.</span>");
						}
					}
				},
				error: function(xhr, status, error) {
					alert("통신 에러");
				}
			})
		})
		
		$("#pw2").blur(function(){
			var pw1 = $("#pw1").val();
			var pw2 = $("#pw2").val();
			
			if (pw1 != pw2) {
				$("#pw2msg").html("<br>비밀번호를 다시 확인바랍니다.");
			} else if (pw1 == "") {
				$("#pw2msg").html("<br>비밀번호를 입력해 주세요.");
			} else {
				$("#pw2msg").html("<br>비밀번호가 일치합니다.");
			}
		})
		
		$("#btn_email").on("click", function(){
			var email = $("#email").val();
			if (email == "") {
				$("#emailmsg").html("<span style='color:#f00;'>이메일 주소를 입력해 주세요.</span>");
			} else {
				$.ajax({
					type:"post",
					data:{"email":email}, // 위에 var로 email을 전송해 줬으니까!
					url:"sendemail.do",
					dataType:"json", // contentType은 '보내는' 데이터 형식, '받는' 데이터 형식은 dataType
					success:function(data) {
						$("#emailmsg").text(data.msg);
					}, error:function(){
						$("#emailmsg").text("통신 오류");
					}
				})
			}
		})
		
		$("#btn_auth").on("click", function() {
			var auth = $("#authnumber").val();
			if (auth == "") {
				alert("인증번호를 입력해 주세요.");
				$("#authmsg").html("<span style='color:f00;'>인증번호를 입력해 주세요.</span>");
				$("#authnumber").focus();
			} else {
				$.ajax({
					type:"post",
					data:{"authnumber":auth},
					url:"authcheck.do",
					dataType:"json", // 서버에서 처리해서 '받는' 형식이 JSON이다
					success:function(data) {
						if (data.check == "ok") {
							$("#authmsg").text(data.msg);
						} else {
							$("#authmsg").text(data.msg);
						}
					}, error: function() {
						$("#authmsg").text("통신 오류.");
					}
				})
			}
		})
	});
</script>

<%@ include file="../footer.jsp"%>