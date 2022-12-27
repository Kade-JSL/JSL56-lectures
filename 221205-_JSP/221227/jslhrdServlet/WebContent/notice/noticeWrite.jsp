<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- sub content -->
	<div class="sub_title">
		<h2>공지사항</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="/"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="greetings.do">공지사항</a>
						<a href="allclass.do">학과및모집안내</a>
						<a href="portfolio.do">포트폴리오</a>
						<a href="online.do">온라인접수</a>
						<a href="notice.do">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="greetings.do">공지사항</a>
						<a href="greetings.do">DW인터뷰</a>
						<a href="greetings.do">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">공지사항 글쓰기</h2>
	  <form name="notice" method="post" enctype="multipart/form-data" action="noticewrite.do" onsubmit="return check()">
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
				<input type="button" value="목록" class="btn_list cur" onClick="location.href='notice.do';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end content -->
	<script>
		function check() {
			if(notice.writer.value=="") {
				alert("글쓴이 입력");
				notice.writer.focus();
				return false;
			}
			if(notice.title.value=="") {
				alert("제목을 입력");
				notice.title.focus();
				return false;
			}
			if(notice.content.value=="") {
				alert("내용을 입력");
				notice.content.focus();
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
				height: 300,
				codemirror: {
					theme: 'monokai',
					callbacks: {
						onImageUpload: function(files, editor, welEditable) {
							for (var i = files.length - 1 ; i >= 0; i--) {
								sendFile(files[i], this);
							}
						}
					}
				}
			});
			
			function sendFile(file, el) {
				var form_data = new FormData();
				form_data.append('file', file);
				$.ajax({ // 비동기 처리
					data: form_data,
					type:"post",
					url:'summernote.do',
					cache:false,
					contentType:false,
					encType:'multipart/form-data',
					processType:false,
					success:function(img_name) {
						alert(img_name);
						$(el).summernote('editor.insertImage', img_name);
					}
				})
			}
		});
	</script>

<%@ include file="../footer.jsp" %>