<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>上传结果</title>
</head>
<body>
<h1>上传结果 <%= request.getAttribute("fileUrl")%></h1>

<img alt="" src="${fileUrl }" />
</body>
</html>