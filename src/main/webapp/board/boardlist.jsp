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
<c:set var="path" value="${pageContext.request.servletContext.contextPath}/board"/>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}"/>


<a href="${path}/boardInsert.do">게시판등록</a>
<h1>Board목록</h1>
<table border="1">
	<tr>
		<th>bno</th>
		<th>title</th>
		<th>content</th>
		<th>writer</th>
		<th>pic</th>
		<th>작성일</th>
	</tr>
	<c:forEach items="${blist}" var="board">
		<tr>
			
			<td><a href="${path}/boardDetail.do?bno=${board.bno}">${board.bno}</td>
			<td>${board.title}</td>
			<td>${board.content}</td>
			<td>${board.writer}</td>
			<td>
				<img alt="${board.pic}" width="50" src="${cpath}/upload/${board.pic}">
			</td>
			<td>${board.create_date}</td>
			<td><button onclick="location.href='${path}/boardDelete.do?bno=${board.bno}'">삭제</button></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>