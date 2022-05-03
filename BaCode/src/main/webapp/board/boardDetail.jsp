<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
 p {
 text-align : center;
 }
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${board }
	<p>
	<form action="/BaCode/boardUpdateForm" method="post">
	<input type="hidden" value="${board.postNum }" name="postNum">
	카테고리 : <input type="text" value="${board.catego }">
	글 제목<input type="text" style="width:300px;height:25px;" value="${board.title }"><br/>
	작성자 : <input type="text" value="${board.uId }"><br/> 
	작성날짜 : <input type="text" value="${board.bdate }">조회수 : ${board.hit }<br/>
	<textarea cols="50" rows="20">${board.content }</textarea><br/>
	수정날짜 : <input type="text" value="${board.mdate }"><br/>
	<input type="submit" value="수정하기">
	</form>
	<form action="/BaCode/boardDelete" method="post">
	<input type="hidden" value="${board.postNum }" name="postNum">
	<input type="submit" value="삭제하기">
	</form>
	</p>
	
	
</body>
</html>