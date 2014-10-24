<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th>请求URL</th><th>请求方法</th><th>传递变量</th></tr>
<c:forEach var="model" items="${modelList}">
<tr>
  <td><c:out value="${model.url}"/></td><td><c:out value="${model.method}"/></td>
  <td><c:forEach var="item" items="${model.paramters}"><c:out value="${item.name}"/>,</c:forEach></td>
 </tr>
</c:forEach>
</table>
</body>
</html>