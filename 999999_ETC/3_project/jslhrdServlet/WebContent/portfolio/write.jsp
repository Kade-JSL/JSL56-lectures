<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

	<!-- sub content -->
	<div class="sub_title">
		<h2>포트폴리오</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="/"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="greetings.do">기업소개</a>
						<a href="portfolio.do">포트폴리오</a>
						<a href="notice.do">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="portfolio.do">포트폴리오</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">포트폴리오 글쓰기</h2>
	  <form name="portfolio" method="post" action="write.do" enctype="multipart/form-data" onsubmit="return check();">
			<table class="bord_table">
				<caption class="sr-only">포트폴리오 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="content" onkeyup="checkByte(this)"></textarea>
							<span id="nowByte">0</span> / 4000 bytes
						</td>
					</tr>
					<tr>
						<th>첨부</th>
						<td><input type="file" name="imgurl"></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="저장" class="btn_ok">&nbsp;&nbsp;<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;<input type="button" value="목록" class="btn_list" onClick="location.href='portfolio.do';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end content -->
	<script>
		function check() {
			
			if(portfolio.title.value=="") {
				alert("제목을 입력");
				portfolio.title.focus();
				return false;
			}
			if(portfolio.content.value=="") {
				alert("내용을 입력");
				portfolio.content.focus();
				return false;
			}
			var fileName = portfolio.imgurl.value;
			var imgFormat = "\.(jpg|JPG|png|PNG)$"; // 정규표현식
			var reg = new RegExp(imgFormat, 'i');
			if(!reg.test(fileName)) {
				alert("이미지 파일만 첨부 가능합니다!");
				return false;
			}
			return true;
		}

	function checkByte(obj){
	    const maxByte = 4000; //최대 100바이트
	    const text_val = obj.value; //입력한 문자
	    const text_len = text_val.length; //입력한 문자수
	    
	    let totalByte=0;
	    for(let i=0; i<text_len; i++){
	    	const each_char = text_val.charAt(i);
	        const uni_char = escape(each_char); //유니코드 형식으로 변환
	        if(uni_char.length>4){
	        	// 한글 : 2Byte
	            totalByte += 2;
	        }else{
	        	// 영문,숫자,특수문자 : 1Byte
	            totalByte += 1;
	        }
	    }
	    
	    if(totalByte>maxByte){
	    	alert('최대 4000Byte까지만 입력가능합니다.');
	        	document.getElementById("nowByte").innerText = totalByte;
	            document.getElementById("nowByte").style.color = "red";
	        }else{
	        	document.getElementById("nowByte").innerText = totalByte;
	            document.getElementById("nowByte").style.color = "green";
	        }
	}
	</script>
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


<%@ include file="../footer.jsp"%>