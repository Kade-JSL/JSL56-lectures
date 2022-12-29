<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ include file="../header.jsp" %>

<!-- sub content -->
<div class="sub_title">
	<h2>회원가입 약관</h2>
	<div class="container">
		<div class="location">
			<ul>
				<li class="btn_home">
					<a href="/main.do">
						<i class="fa fa-home btn_plus"></i>
					</a>
				</li>
				<li class="dropdown">
				<a href="">회원가입<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="memberterms.do">회원가입 약관</a>
					</div>
				</li>
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
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                            <input type="text" name="name" id="mbrName" value="박장수" disabled="disabled" class="w300">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="id">아이디<span class="must"><b>필수입력</b></span></label></th>
                        <td>
                            <input type="text" name="userid" id="mbrId" value="jangsem1004" disabled="disabled" class="w300" readonly="">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pw">비밀번호<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="pwd" id="scrtNo" class="w300">
                            <p class="guideTxt"><span class="tc_point">영문(대문자 구분), 숫자, 특수문자의 조합</span>으로 9~13자로 작성해 주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pw_confirm">비밀번호확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="scrtNoConfirm" id="scrtNoConfirm" class="w300">
                            <p class="guideTxt"><span class="tc_point">비밀번호 미입력시 기존비밀번호가 유지됩니다.</span></p>
                        </td>
                    </tr>

					<tr>
                        <th><label for="phone">전화번호<span class="must"><b>필수입력</b></span></label></th>
                        <td>
                            <input type="text" name="phone" id="email" class="w300" value="jangsem04@naver.com">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="email">이메일<span class="must"><b>필수입력</b></span></label></th>
                        <td>
                            <input type="email" name="email" id="email" class="w300" value="jangsem04@naver.com">
                        </td>
                    </tr>           </table>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.go(-1);" class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a>
        <a href="javascript:fn_save();" class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
    </div>
	
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>

<%@ include file="../footer.jsp" %>