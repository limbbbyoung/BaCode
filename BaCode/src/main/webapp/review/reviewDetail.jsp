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
		<form action="/BaCode/reviewUpdateForm.review" method="post">
	<input type="hidden" value="${review.rvNum }" name="rvNum">
	구매했던 물품 : <input type="text" value="${board.title }" readonly> <br/>
	리뷰 제목 : <input type="text" style="width:300px;height:25px;" value="${review.rvTitle }" readonly><br/>
	작성자 : <input type="text" value="${review.uId }" readonly><br/> 
	작성날짜 : <input type="text" value="${review.rvBdate }" readonly><br/>
	<textarea cols="50" rows="20" readonly>${review.rvContent }</textarea><br/>
	수정날짜 : <input type="text" value="${review.rvUdate }" readonly><br/>
	<input type="submit" value="수정하기">
	</form>
	<form action="/BaCode/reviewDelete.review" method="post">
	<input type="hidden" value="${review.rvNum }" name="rvNum">
	<input type="submit" value="삭제하기">
	</form>
	<a href="http://localhost:52525/BaCode/getBoardList.board"><button>판매목록으로</button></a>
	<a href="http://localhost:52525/BaCode/getReviewList.review"><button>리뷰목록으로</button></a>
	</p>
</body>
</html>