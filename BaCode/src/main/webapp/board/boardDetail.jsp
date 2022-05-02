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
	글 제목<input type="text" style="width:300px;height:25px;" value="${board.title }"><br/>
	작성자 : <input type="text" value="${board.uId }"><br/> 
	작성날짜 : <input type="text" value="${board.bdate }">조회수 : ${board.hit }<br/>
	<textarea cols="50" rows="20">${board.content }</textarea><br/>
	수정날짜 : <input type="text" value="${board.udate }"><br/>
	</p>
	
</body>
</html>