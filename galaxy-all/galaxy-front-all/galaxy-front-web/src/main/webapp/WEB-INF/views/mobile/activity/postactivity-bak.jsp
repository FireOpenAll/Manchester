<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin-top: 50px;
	font-size: 16px;
	font-family: "Myriad Pro", "Hiragino Sans GB", "Microsoft YaHei",
		"å¾®è½¯é›…é»‘", Calibri, Helvetica, tahoma, arial, simsun, "å®‹ä½“",
		sans-serif;
	line-height: 1.5;
	-webkit-font-smoothing: antialiased;
}

.jumbotron {
	background: transparent url(../images/banner.jpg) repeat-x 50% 0%;
	color: #fff;
	text-shadow: 1px 1px 1px #3b3262;
	margin-bottom: 0;
}

.jumbotron .container {
	position: relative;
}

.jumbotron .github-btns {
	position: absolute;
	bottom: 0;
	right: 0;
}

.fetature {
	margin-top: 30px;
}

.page-body {
	min-height: 450px;
}

.page-container {
	margin-top: 10px;
}

.page-container h1,.page-container h2,.page-container h3 {
	padding-top: 70px;
	margin-top: -50px;
}

.logo {
	position: relative;
	padding-left: 60px;
}

.logo span {
	position: absolute;
	left: 15px;
	top: 8px;
	font-size: 2em;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}

.logo.active {
	color: #fff;
}

@media ( min-width : 768px) {
	.fetature .row .col-lg-4 {
		min-height: 250px;
	}
}

.footer {
	width: 100%;
	overflow: hidden;
	color: #f2f2f2;
	background: #212121;
	margin-top: 50px;
}

.footer-fixed-bottom {
	position: fixed;
	bottom: 0;
}

.footer a {
	color: #f2f2f2;
}

.footer .footer-inner {
	margin: 15px;
}

.wu-example {
	position: relative;
	padding: 45px 15px 15px;
	margin: 15px 0;
	background-color: #fafafa;
	box-shadow: inset 0 3px 6px rgba(0, 0, 0, .05);
	border-color: #e5e5e5 #eee #eee;
	border-style: solid;
	border-width: 1px 0;
}

.wu-example:after {
	content: "ç¤ºä¾‹";
	position: absolute;
	top: 15px;
	left: 15px;
	font-size: 12px;
	font-weight: bold;
	color: #bbb;
	text-transform: uppercase;
	letter-spacing: 1px;
}

@media ( min-width : 768px) {
	.bs-example {
		margin-left: 0;
		margin-right: 0;
		background-color: #fff;
		border-width: 1px;
		border-color: #ddd;
		border-radius: 4px 4px 0 0;
		box-shadow: none;
	}
}

.post-toc {
	margin-top: 30px;
	margin-bottom: 30px;
	padding-top: 10px;
	padding-bottom: 10px;
	text-shadow: 0 1px 0 #fff;
	background-color: #f7f5fa;
	border-radius: 5px;
}

.post-toc .nav>li>a {
	display: block;
	color: #716b7a;
	padding: 5px 20px;
}

.post-toc .nav .nav>li>a {
	padding-top: 3px;
	padding-bottom: 3px;
	padding-left: 30px;
	font-size: 90%;
}

.post-toc.affix {
	position: static;
}

.post-toc .nav .nav {
	display: none;
	margin-bottom: 8px;
}

@media ( min-width : 992px) {
	.post-toc.affix {
		position: fixed;
		width: 213px;
		top: 50px;
	}
	.post-toc .nav>.active>ul {
		display: block;
	}
}

@media ( min-width : 1200px) {
	.post-toc.affix {
		width: 263px;
	}
	.post-toc .nav>.active>ul {
		display: block;
	}
}

.post-toc .nav>.active>a,.post-toc .nav>.active:hover>a,.post-toc .nav>.active:focus>a
	{
	font-weight: bold;
	color: #563d7c;
	background-color: transparent;
	border-right: 1px solid #563d7c;
}

.friends-links {
	margin: 0;
	padding: 0;
	list-style: none;
}

.weixin {
	text-align: center;
	display: inline-block;
}

.weixin img {
	width: 80px;
}

/********************************
*
*  COMMENTS
*
********************************/
.comment {
	background-color: transparent;
	border-color: #CACACA;
	border-style: solid;
	border-width: 1px;
	color: black;
	display: block;
	margin-bottom: 10px;
	margin-top: 10px;
	padding: 0px;
	width: 100%;
}

.comment .commentheader {
	border-bottom-color: #CACACA;
	border-bottom-style: solid;
	border-bottom-width: 1px;
	color: black;
	background-image: -webkit-linear-gradient(#F8F8F8, #E1E1E1);
	background-image: -moz-linear-gradient(#F8F8F8, #E1E1E1);
	color: black;
	display: block;
	float: left;
	font-family: helvetica, arial, freesans, clean, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-variant: normal;
	font-weight: normal;
	height: 33px;
	line-height: 33px;
	margin: 0px;
	overflow-x: hidden;
	overflow-y: hidden;
	padding: 0px;
	text-overflow: ellipsis;
	text-shadow: rgba(255, 255, 255, 0.699219) 1px 1px 0px;
	white-space: nowrap;
	width: 100%;
}

.comment .commentheader .commentgravatar {
	background-attachment: scroll;
	background-clip: border-box;
	background-color: white;
	background-image: none;
	background-origin: padding-box;
	border-color: #C8C8C8;
	border-style: solid;
	border-width: 1px;
	color: black;
	display: inline-block;
	float: none;
	font-family: helvetica, arial, freesans, clean, sans-serif;
	font-size: 1px;
	font-style: normal;
	font-variant: normal;
	font-weight: normal;
	height: 24px;
	line-height: 1px;
	margin-left: 5px;
	margin-right: 3px;
	margin-top: -2px;
	overflow-x: visible;
	overflow-y: visible;
	padding: 1px;
	text-overflow: clip;
	text-shadow: rgba(255, 255, 255, 0.699219) 1px 1px 0px;
	vertical-align: middle;
	white-space: nowrap;
	width: 24px;
}

.comment .commentheader a:link {
	text-decoration: none;
}

.comment .commentheader a:hover {
	border-bottom: 1px solid;
}

.comment .commentheader .commentuser {
	background-color: transparent;
	color: black;
	display: inline;
	float: none;
	font-family: helvetica, arial, freesans, clean, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-variant: normal;
	font-weight: bold;
	height: 0px;
	line-height: 16px;
	margin-left: 5px;
	margin-right: 10px;
	overflow-x: visible;
	overflow-y: visible;
	padding: 0px;
	text-overflow: clip;
	text-shadow: rgba(255, 255, 255, 0.699219) 1px 1px 0px;
	white-space: nowrap;
	width: 0px;
}

.comment .commentheader .commentdate {
	background-color: transparent;
	color: #777;
	display: inline;
	float: none;
	font-family: helvetica, arial, freesans, clean, sans-serif;
	font-size: 11px;
	font-style: normal;
	font-variant: normal;
	font-weight: normal;
	height: 0px;
	line-height: 33px;
	margin: 0px;
	overflow-x: visible;
	overflow-y: visible;
	padding: 0px;
	text-overflow: clip;
	text-shadow: rgba(255, 255, 255, 0.699219) 1px 1px 0px;
	white-space: nowrap;
	width: 20em;
}

.comment .commentbody {
	background-attachment: scroll;
	background-clip: border-box;
	background-color: transparent;
	background-image: none;
	background-origin: padding-box;
	color: #333;
	display: block;
	margin-bottom: 1em;
	margin-left: 1em;
	margin-right: 1em;
	margin-top: 40px;
	overflow-x: visible;
	overflow-y: visible;
	padding: 0em;
	position: static;
	width: 96%;
	word-wrap: break-word;
}

.comment .commentbody p {
	margin-bottom: 0.5em;
	margin-top: 0.5em;
	margin-left: 0em;
	margin-right: 0em;
}

.comment .commentbody pre {
	border: 0px solid #ddd;
	background-color: #eef;
	padding: 0 .4em;
}

.comment .commentbody pre code {
	border: 0px solid #ddd;
}

.comment .commentbody code {
	border: 1px solid #ddd;
	background-color: #eef;
	font-size: 85%;
	padding: 0 .2em;
}

/*demoæ ·å¼*/
#picker {
	display: inline-block;
	line-height: 1.428571429;
	vertical-align: middle;
	margin: 0 12px 0 0;
}

#picker .webuploader-pick {
	padding: 6px 12px;
	display: block;
}

#uploader-demo .thumbnail {
	width: 110px;
	height: 110px;
}

#uploader-demo .thumbnail img {
	width: 100%;
}

.uploader-list {
	width: 100%;
	overflow: hidden;
}

.file-item {
	float: left;
	position: relative;
	margin: 0 20px 20px 0;
	padding: 4px;
}

.file-item .error {
	position: absolute;
	top: 4px;
	left: 4px;
	right: 4px;
	background: red;
	color: white;
	text-align: center;
	height: 20px;
	font-size: 14px;
	line-height: 23px;
}

.file-item .info {
	position: absolute;
	left: 4px;
	bottom: 4px;
	right: 4px;
	height: 20px;
	line-height: 20px;
	text-indent: 5px;
	background: rgba(0, 0, 0, 0.6);
	color: white;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	font-size: 12px;
	z-index: 10;
}

.upload-state-done:after {
	content: "\f00c";
	font-family: FontAwesome;
	font-style: normal;
	font-weight: normal;
	line-height: 1;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	font-size: 32px;
	position: absolute;
	bottom: 0;
	right: 4px;
	color: #4cae4c;
	z-index: 99;
}

.file-item .progress {
	position: absolute;
	right: 4px;
	bottom: 4px;
	height: 3px;
	left: 4px;
	height: 4px;
	overflow: hidden;
	z-index: 15;
	margin: 0;
	padding: 0;
	border-radius: 0;
	background: transparent;
}

.file-item .progress span {
	display: block;
	overflow: hidden;
	width: 0;
	height: 100%;
	background: #d14 url(../images/progress.png) repeat-x;
	-webit-transition: width 200ms linear;
	-moz-transition: width 200ms linear;
	-o-transition: width 200ms linear;
	-ms-transition: width 200ms linear;
	transition: width 200ms linear;
	-webkit-animation: progressmove 2s linear infinite;
	-moz-animation: progressmove 2s linear infinite;
	-o-animation: progressmove 2s linear infinite;
	-ms-animation: progressmove 2s linear infinite;
	animation: progressmove 2s linear infinite;
	-webkit-transform: translateZ(0);
}

@
-webkit-keyframes progressmove { 0% {
	background-position: 0 0;
}

100%
{
background-position
:
 
17
px
 
0;
}
}
@
-moz-keyframes progressmove { 0% {
	background-position: 0 0;
}

100%
{
background-position
:
 
17
px
 
0;
}
}
@
keyframes progressmove { 0% {
	background-position: 0 0;
}

100%
{
background-position
:
 
17
px
 
0;
}
}
a.travis {
	position: relative;
	top: -4px;
	right: 15px;
}
</style>
<!--引入CSS-->
<link rel="stylesheet" type="text/css"
	href="/resources/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/bootstrap-theme.min.css">
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<!--引入JS-->
<script type="text/javascript"
	src="/resources/webuploader/webuploader.js"></script>
<script type="text/javascript">
	//文件上传
	jQuery(function() {
		var $ = jQuery, $list = $('#thelist'), $btn = $('#ctlBtn'), state = 'pending', uploader;

		uploader = WebUploader.create({

			// 不压缩image
			resize : false,

			// swf文件路径
			swf : '/resources/js/Uploader.swf',

			// 文件接收服务端。
			server : 'http://webuploader.duapp.com/server/fileupload.php',

			// 选择文件的按钮。可选。
			// 内部根据当前运行是创建，可能是input元素，也可能是flash.
			pick : '#picker'
		});

		// 当有文件添加进来的时候
		uploader.on('fileQueued', function(file) {
			$list.append('<div id="' + file.id + '" class="item">'
					+ '<h4 class="info">' + file.name + '</h4>'
					+ '<p class="state">等待上传...</p>' + '</div>');
		});

		// 文件上传过程中创建进度条实时显示。
		uploader
				.on(
						'uploadProgress',
						function(file, percentage) {
							var $li = $('#' + file.id), $percent = $li
									.find('.progress .progress-bar');

							// 避免重复创建
							if (!$percent.length) {
								$percent = $(
										'<div class="progress progress-striped active">'
												+ '<div class="progress-bar" role="progressbar" style="width: 0%">'
												+ '</div>' + '</div>')
										.appendTo($li).find('.progress-bar');
							}

							$li.find('p.state').text('上传中');

							$percent.css('width', percentage * 100 + '%');
						});

		uploader.on('uploadSuccess', function(file) {
			$('#' + file.id).find('p.state').text('已上传');
		});

		uploader.on('uploadError', function(file) {
			$('#' + file.id).find('p.state').text('上传出错');
		});

		uploader.on('uploadComplete', function(file) {
			$('#' + file.id).find('.progress').fadeOut();
		});

		uploader.on('all', function(type) {
			if (type === 'startUpload') {
				state = 'uploading';
			} else if (type === 'stopUpload') {
				state = 'paused';
			} else if (type === 'uploadFinished') {
				state = 'done';
			}

			if (state === 'uploading') {
				$btn.text('暂停上传');
			} else {
				$btn.text('开始上传');
			}
		});

		$btn.on('click', function() {
			if (state === 'uploading') {
				uploader.stop();
			} else {
				uploader.upload();
			}
		});
	});

	// 图片上传demo
	jQuery(function() {
		var $ = jQuery, $list = $('#fileList'),
		// 优化retina, 在retina下这个值是2
		ratio = window.devicePixelRatio || 1,

		// 缩略图大小
		thumbnailWidth = 100 * ratio, thumbnailHeight = 100 * ratio,

		// Web Uploader实例
		uploader;

		// 初始化Web Uploader
		uploader = WebUploader.create({

			// 自动上传。
			auto : true,

			// swf文件路径
			swf : '/resources/js/Uploader.swf',

			// 文件接收服务端。
			server : 'http://webuploader.duapp.com/server/fileupload.php',

			// 选择文件的按钮。可选。
			// 内部根据当前运行是创建，可能是input元素，也可能是flash.
			pick : '#filePicker',

			// 只允许选择文件，可选。
			accept : {
				title : 'Images',
				extensions : 'gif,jpg,jpeg,bmp,png',
				mimeTypes : 'image/*'
			}
		});

		// 当有文件添加进来的时候
		uploader
				.on(
						'fileQueued',
						function(file) {
							var $li = $('<div id="' + file.id + '" class="file-item thumbnail">'
									+ '<img>'
									+ '<div class="info">'
									+ file.name + '</div>' + '</div>'), $img = $li
									.find('img');

							$list.append($li);

							// 创建缩略图
							uploader.makeThumb(file, function(error, src) {
								if (error) {
									$img.replaceWith('<span>不能预览</span>');
									return;
								}

								$img.attr('src', src);
							}, thumbnailWidth, thumbnailHeight);
						});

		// 文件上传过程中创建进度条实时显示。
		uploader.on('uploadProgress', function(file, percentage) {
			var $li = $('#' + file.id), $percent = $li.find('.progress span');

			// 避免重复创建
			if (!$percent.length) {
				$percent = $('<p class="progress"><span></span></p>').appendTo(
						$li).find('span');
			}

			$percent.css('width', percentage * 100 + '%');
		});

		// 文件上传成功，给item添加成功class, 用样式标记上传成功。
		uploader.on('uploadSuccess', function(file) {
			$('#' + file.id).addClass('upload-state-done');
		});

		// 文件上传失败，现实上传出错。
		uploader.on('uploadError', function(file) {
			var $li = $('#' + file.id), $error = $li.find('div.error');

			// 避免重复创建
			if (!$error.length) {
				$error = $('<div class="error"></div>').appendTo($li);
			}

			$error.text('上传失败');
		});

		// 完成上传完了，成功或者失败，先删除进度条。
		uploader.on('uploadComplete', function(file) {
			$('#' + file.id).find('.progress').remove();
		});
	});
</script>

</head>
<body>
	<center>
		<form action="/comments/post" method="post">
			标题<input name="title" type="text" /><br /> 照片
			<!--dom结构部分-->
			<div id="uploader-demo">
				<!--用来存放item-->
				<div id="fileList" class="uploader-list"></div>
				<div id="filePicker">选择图片</div>
			</div>
			<br />
			<br />
			<br />
			<br />
			<textarea rows="20" cols="100"></textarea>
			<input type="submit" value="提交" />
		</form>
	</center>
</body>
</html>