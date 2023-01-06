<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admheader.jsp"%>

<form name="portfolio" method="post" action="adm-port-mod.do" onsubmit="return check()">
	<input type="hidden" name="bno" value="${modify.bno}"/>
	<input type="hidden" name="p" value="${cri.pageNum}"/>
	<input type="hidden" name="a" value="${cri.amount}"/>
	<table class="bord_table">
			<tr class="first">
				<th>글쓴이</th>
				<td><input type="text" name="writer" value="${modify.writer}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${modify.title}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="summernote">${modify.content}</textarea></td>
			</tr>
	</table>
	<div class="btn_wrap">
		<input type="submit" value="저장" class="btn_ok">&nbsp;&nbsp;
		<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
		<input type="button" value="목록" class="btn_list" onClick="location.href='adm-notice.do?p=${cri.pageNum}&a=${cri.amount}';">
	</div>
</form>
	<script>
		function check() {
			if(portfolio.writer.value=="") {
				alert("글쓴이 입력");
				portfolio.writer.focus();
				return false;
			}
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
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
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
				$.ajax({
					data : form_data,
					type : "post",
					url : 'summernote.do',
					cache : false,
					contentType : false,
					encType : 'multipart/form-data',
					processData : false,
					success : function(img_name) {
						$(el).summernote('editor.insertImage', img_name);
					}
				})
			}
		});
	</script>
	
<%@ include file="../admfooter.jsp" %>