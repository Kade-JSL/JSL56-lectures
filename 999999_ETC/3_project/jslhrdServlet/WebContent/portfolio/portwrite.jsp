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
						<a href="">기업소개</a>
						<a href="list.do?t=port">포트폴리오</a>
						<a href="list.do?t=notice">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">포트폴리오<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="list.do?t=port">포트폴리오</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">포트폴리오 글쓰기</h2>
	  <form name="portfolio" method="post" action="write.do?t=${tbltype}" onsubmit="return check();">
			<table class="bord_table">
				<caption class="sr-only">포트폴리오 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<c:if test="${form.get(Name.TITLE)}">
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					</c:if>
					<c:if test="${form.get(Name.WRITER)}">
					<tr>
						<th>글쓴이</th>
						<td><input type="text" name="writer"></td>
					</tr>
					</c:if>
					<c:if test="${form.get(Name.CONTENT)}">
					<tr>
						<th>내용</th>
						<td>
							<textarea name="content" id="summernote" onkeyup="checkByte(this)"></textarea>
							<span id="total-characters"></span>
						</td>
					</tr>
					</c:if>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='list.do?t=${tbltype}';">
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
			return true;
		}
	</script>
	<script>
		$(function() {
			$(".location .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location .dropdown > a").next().hide();
				} else {
					$(".location .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
						
			$('#summernote').summernote({
				height : 220,
				focus : true,
				callbacks : {
					onImageUpload : function(files, editor, welEditable) {
						for (var i = files.length - 1; i >= 0; i--) {
							sendFile(files[i], this);
						}
					}
				}
			});

			function sendFile(file, el) {
				var form_data = new FormData();
				form_data.append('file', file);
				$.ajax({ //비동기식 데이터 처리
					data : form_data,
					type : "post",
					url : 'summernote.do',
					cache : false,
					contentType : false,
					encType : 'multipart/form-data',
					processData : false,
					success : function(img_name) {
						//alert(img_name);
						$(el).summernote('editor.insertImage', img_name);
					}
				})
			}
		});
	</script>


<%@ include file="../footer.jsp"%>