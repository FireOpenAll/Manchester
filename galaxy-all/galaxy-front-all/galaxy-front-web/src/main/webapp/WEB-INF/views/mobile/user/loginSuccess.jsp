<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0047)http://www.o2olive.net/demo/index.php?act=login -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>注册活动平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/resources/themes/jquery.mobile.icons.red.min.css" />
<link rel="stylesheet"
	href="/resources/themes/jquery.mobile.icons.min.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.3/jquery.mobile.structure-1.4.3.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.3/jquery.mobile-1.4.3.min.js"></script>
<script>
	// Turn off jQuery Mobile transitions for faster use
	$(document).bind("mobileinit", function() {
		$.mobile.defaultPageTransition = 'none';
	});
	// Allow swiping to open menu panels
	$(document).on("pageinit", ".ui-page", function() {
		var $page = $(this);
		$page.on("swipeleft swiperight", function(e) {
			if ($page.jqmData("panel") !== "open") {
				if (e.type === "swipeleft") {
					$page.find(".right-panel").panel("open");
				} else if (e.type === "swiperight") {
					$page.find(".left-panel").panel("open");
				}
			}
		});
	});
</script>
<script src="/resources/js/jquery.mobile-1.4.4.min.js"></script>
</head>
<body>
	<h1>登录成功</h1>
</html>