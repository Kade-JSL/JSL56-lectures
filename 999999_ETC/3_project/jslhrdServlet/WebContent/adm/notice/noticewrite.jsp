<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../admheader.jsp"%>

<aside id="port" class="adm-right">
	<div class="write_wrap">
		<h2 class="sr-only">공지사항 글쓰기</h2>
		<form name="notice" method="post" action="adm-notice-write.do" onsubmit="return check()">
			<!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>글쓴이</th>
						<td><input type="text" name="writer" value="관리자" readonly></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" id="summernote"></textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="저장" class="btn_ok cur">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset cur">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list cur" onClick="location.href='adm-notice.do';">
			</div>
		</form>
	</div>
<!-- end content -->
</aside>
<script>
	function check() {
		if (notice.writer.value == "") {
			alert("글쓴이 입력");
			notice.writer.focus();
			return false;
		}
		if (notice.title.value == "") {
			alert("제목을 입력");
			notice.title.focus();
			return false;
		}
		if (notice.content.value == "") {
			alert("내용을 입력");
			notice.content.focus();
			return false;
		}
		return true;
	}
</script>
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