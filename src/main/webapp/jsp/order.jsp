<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>주문선택</h1>
	<form action="order.go" method="post">
		 메뉴 : 
		 <input type="radio" value="김밥" name="lunch">김밥
		 <input type="radio" value="짜장면" name="lunch">짜장면
		 <input type="radio" value="초밥" name="lunch">초밥
		 <input type="radio" value="햄버거" name="lunch">햄버거
		 <input type="radio" value="파스타" name="lunch">파스타
		<input type="number" value="1" name="count">
		<input type="submit" value="주문">
	</form>
	
</body>
</html>