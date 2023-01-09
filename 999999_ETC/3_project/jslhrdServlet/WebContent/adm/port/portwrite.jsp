<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admheader.jsp"%>

<aside id="port" class="adm-right">
	  <div class="write_wrap">
	  <h2 class="sr-only">포트폴리오 글쓰기</h2>
	  <form name="portfolio" method="post" action="adm-port-write.do" onsubmit="return check();">
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
							<textarea name="content" id="summernote" onkeyup="checkByte(this)"></textarea>
							<span id="total-characters"></span>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='adm-port.do';">
			</div>
		</form>
	  </div>
	  </aside>
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


<%@ include file="../admfooter.jsp"%>