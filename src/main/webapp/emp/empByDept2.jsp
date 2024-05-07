<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<table>
	<thead>
		<tr>
			<th>직원번호</th>
			<th>first_name</th>
			<th>last_name</th>
			<th>email</th>
			<th>salary</th>
			<th>hiredate</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="emp" items="${emplist}">
			<tr>
				<td>${emp.employee_id}</td>
				<td>${emp.first_name}</td>
				<td>${emp.last_name}</td>
				<td>${emp.email}</td>
				<td>${emp.salary}</td>
				<td>${emp.hire_date}</td>
			</tr>
		</c:forEach>
	</tbody>

</table>    