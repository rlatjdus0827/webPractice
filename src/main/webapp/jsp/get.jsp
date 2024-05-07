<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>get.jsp</h1>
<h1>request : ${myInfo}</h1>
<h1>session( 브라우저에 저장됨 ) : ${myInfo2}</h1>
<h1>servlet context ( 서버에 저장됨 ) : ${myInfo3}</h1>
<h1>initParameter : ${initParam['menu_member']}</h1>
<h1>initParameter : ${initParam['menu_order']}</h1>
<ul>
<c:forTokens var="member" items="${initParam['menu_member']}" delims=" ">
	<li>${member}</li>
</c:forTokens>
<c:forTokens var="member" items="${initParam['menu_order']}" delims=" ">
	<li>${member}</li>
</c:forTokens>

</ul>
<p>은행이름 : ${initParam['bankname']}</p>
</body>
</html>