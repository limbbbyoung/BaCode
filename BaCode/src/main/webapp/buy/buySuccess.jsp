<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 구매완료 임시 페이지 </h1>
	${s_id }
	${buy }
	<c:if test="${sessionScope.s_id eq buy.uId }">
	<form action="/BaCode/reviewInsertForm" method="get">
		<input type="submit" value="리뷰쓰러가기">
		<input type="hidden" value="${buy.postNum }" name="postNum">
		<input type="hidden" value="${s_id }" name="s_id">
	</form>
	</c:if>
	<a href="http://localhost:52525/BaCode/getBoardList"><button>판매 목록 보러가기</button></a>
	<c:if test="${sessionScope.s_id eq buy.uId }">
	<form action="/BaCode/getBuyList" method="get">
		<input type="submit" value="구매목록 보러가기">
		<input type="hidden" value="${buy.postNum }" name="postNum">
		<input type="hidden" value="${s_id }" name="s_id">
	</form>
	</c:if>
</body>
</html>