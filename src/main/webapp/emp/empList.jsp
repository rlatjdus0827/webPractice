<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Insert title here</title>
<style>
button{
	margin: 5px;
}
#sub{
	margin: 5px;
}
th, td{
	text-align: center;
}
</style>
<script>
function f_insert() {
	location.href='empInsert.do';
}
</script>
</head>
<body>
<%--include지시자 : jsp를 합쳐서 컴파일한다. / include액션 태그 : 각각 컴파일해서 합친다. --%>
<%-- <%@ include file="../common/loginHeader.jsp" %>--%>
<jsp:include page="../common/loginHeader.jsp"></jsp:include>

<h2>접속인원:${total_user }</h2>
<ul>
  <c:forEach var="user" items="${user_list}">
    <li>${user}</li>
  </c:forEach>
</ul>

<!-- <a href="../auth/logout.do">로그아웃</a>
<h1>세션에서 읽기(id) : ${memberId}</h1>
<h1>세션에서 읽기(pass) : ${memberPass}</h1>
<h1>myInfo(다른 서블릿의 request 접근불가) : ${myInfo}</h1>
<h1>myInfo2(같은 브라우저로 접근하면 session 접근가능) : ${myInfo2}</h1>
<h1>myInfo3(Servlet Context는 모든 서블릿에서 접근 가능, 사용자가 공유) : ${myInfo3}</h1>

<h1>직원목록</h1>
<p>주소창에 주소를 바꾸는 방법(재요청)</p>
<a href="empInsert.do">신규직원등록1</a>
<a href="javascript:location.href='empInsert.do'">신규직원등록2</a>
<button onclick="location.href='empInsert.do'">신규직원등록3</button>
<button onclick="f_insert()">신규직원등록4</button>
 -->
<form action="empInsert.do">
	<input type="submit" value="신규직원등록" id="sub" class="btn btn-dark">
</form>
<table border="1px solid gray" class="table">
	<thead>
		<tr class="table-success">
			<th>직원번호</th>
			<th>이름</th>
			<th>성</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>직책</th>
			<th>급여</th>
			<th>부서</th>
			<th>매니져</th>
			<th>커미션</th>
			<th>입사일</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${emplist}" var="emp">
			<tr>
				<td><a href="empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</td>
				<td>${emp.first_name}</td>
				<td>${emp.last_name}</td>
				<td>${emp.email}</td>
				<td>${emp.phone_number}</td>
				<td>${emp.job_id}</td>
				<td>${emp.salary}</td>
				<td>${emp.department_id}</td>
				<td>${emp.manager_id}</td>
				<td>${emp.commission_pct}</td>
				<td>${emp.hire_date}</td>
				<td><button onclick="location.href='empDelete.do?empid=${emp.employee_id}'">삭제</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>