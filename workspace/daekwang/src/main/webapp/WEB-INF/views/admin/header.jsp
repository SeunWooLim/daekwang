<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:useBean id="now" class="java.util.Date" />
		<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH:mm" var="today" />

		<div class="header">
			<div class="head_right">
				<ul class="">
					<li>관리자님 환영합니다.</li>
					<li><c:out value="${today}"/></li>
					<li class="nav_button"><a href="logout.do">로그아웃</a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>