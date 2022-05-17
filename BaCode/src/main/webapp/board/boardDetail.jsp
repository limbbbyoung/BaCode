<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	${board }</br>
	세션아이디 : ${s_id }</br>
	픽2 : ${pick } <br/>
	구매 : ${buy }
	<p>
	<form action="/BaCode/boardUpdateForm" method="post">
	<input type="hidden" value="${board.postNum }" name="postnum">
	카테고리 : <input type="text" value="${board.catego }">
	글 제목<input type="text" style="width:300px;height:25px;" value="${board.title }"><br/>
	작성자 : <input type="text" value="${board.uId }"><br/> 
	작성날짜 : <input type="text" value="${board.bdate }">조회수 : ${board.hit }<br/>
	<textarea cols="50" rows="20">${board.content }</textarea><br/>
	수정날짜 : <input type="text" value="${board.mdate }"><br/>
	<input type="submit" value="수정하기">
	</form>
	<form action="/BaCode/buyInsert" method="post">
	<input type="hidden" value=${board.postNum } name="postNum">
	<input type="hidden" value=${s_id } name="s_id">
	<input type="submit" value="구매하기">
	</form>
	<form action="/BaCode/boardDelete" method="post">
	<input type="hidden" value="${board.postNum }" name="postNum">
	<input type="submit" value="삭제하기">
	</form>
	<a href="http://localhost:52525/BaCode/getBoardList"><button>판매 목록 보러가기</button></a>
	</p>
	<form action="/BaCode/pick" method="post">
		<input type="submit" value="찜하기">
		<input type="hidden" value="${board.postNum}" name="postNum">
		<input type="hidden" value="${s_id }" name="pickId">
	</form>

</body>
</html>