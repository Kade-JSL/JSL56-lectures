$(function(){
	var fullHeight = function() {
		$(".adm-left").css('height', $(window).height());
		$(window).resize(function(){
			$(".adm-left").css('height', $(window).height())
		})
	};
	
	fullHeight();	
})
