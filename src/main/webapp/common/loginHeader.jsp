<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>${loginEmp.first_name}님 환영합니다.</h1>
<button onclick="location.href='${pageContext.request.servletContext.contextPath}/auth/logout.do'" class="btn btn-primary">로그아웃</button>