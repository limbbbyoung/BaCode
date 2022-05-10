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
		<form action="/BaCode/reviewUpdateForm" method="post">
	<input type="hidden" value="${review.rvNum }" name="rvNum">
	리뷰 제목<input type="text" style="width:300px;height:25px;" value="${review.title }"><br/>
	작성자 : <input type="text" value="${review.uId }"><br/> 
	작성날짜 : <input type="text" value="${review.bdate }"><br/>
	<textarea cols="50" rows="20">${review.content }</textarea><br/>
	수정날짜 : <input type="text" value="${review.mdate }"><br/>
	<input type="submit" value="수정하기">
	</form>
	<form action="/BaCode/reviewDelete" method="post">
	<input type="hidden" value="${review.rvNum }" name="rvNum">
	<input type="submit" value="삭제하기">
	</form>
	<a href="http://localhost:52525/BaCode/getBoardList"><button>판매 목록 보러가기</button></a>
	</p>
</body>
</html>