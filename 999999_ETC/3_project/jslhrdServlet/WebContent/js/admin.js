$(function(){
	var fullHeight = function() {
		$(".adm-left").css('height', $(window).height());
		$(window).resize(function(){
			$(".adm-left").css('height', $(window).height())
		})
	};
	fullHeight();
	
//	$(".adm-right").hide();
//	$("#welcome").show();
//	$(".adm-box .adm-left nav ul li a").on("click", function(e){
//		e.preventDefault();
//		$(".adm-box aside").removeClass("active");
//		$(this).addClass("active");
//		$(".adm-right").hide();
//		$($(this).attr("href")).show();
//	})
	
//	$("#notice").on("click", function() {
//		$.ajax({
//			type: "get",
//			url: "notice.do&p=1&a=10"
//		})
//	})
})
