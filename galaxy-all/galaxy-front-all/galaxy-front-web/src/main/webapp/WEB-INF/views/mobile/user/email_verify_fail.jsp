<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- saved from url=(0059)http://www.o2olive.net/demo/index.php?act=login&op=register -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>galaxy 邮箱失败</title>
<meta name="keywords" content="galaxy 邮箱失败">
<meta name="description" content="galaxy 邮箱失败">

</head>
<p>邮箱验证失败，从新发送验证邮件！</p>
<a
	href="http://182.92.169.209/v1/api/email/send?email=<%=request.getParameter("email")%>">重新发送</a>
</body>
</html>