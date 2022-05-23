<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
	<form action="/BaCode/boardUpdateForm.board" method="post">
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
	<input type="hidden" value="${board.postNum }" name="postNum">
	<input type="hidden" value="${board.title }" name="title"> 
	<input type="hidden" value="${s_id }" name="s_id">
	<input type="submit" value="구매하기">
	</form>
	<form id="deleteSub" action="/BaCode/boardDelete.board" method="post">
	<input type="hidden" value="${board.postNum }" name="postNum">
	<input type="submit" id="del" onclick="test()" value="삭제하기">
	</form>
	<a href="http://localhost:52525/BaCode/getBoardList"><button>판매 목록 보러가기</button></a>
	</p>
	<form action="/BaCode/pick" method="post">
		<input type="submit" value="찜하기">
		<input type="hidden" value="${board.postNum}" name="postNum">
		<input type="hidden" value="${s_id }" name="pickId">
		<input type="hidden" value="${board.title }" name="title">
	</form>

	<c:if test="${sessionScope.s_id eq buy.uId }">
	<form action="/BaCode/reviewInsertForm" method="get">
		<input type="submit" value="리뷰쓰러가기">
		<input type="hidden" value="${buy.postNum }" name="postNum">
		<input type="hidden" value="${s_id }" name="s_id">
	</form>
	</c:if>
	<form action="/BaCode/SOSInsertForm.SOS" method="post">
	<input type="hidden" value=${board.postNum } name="postNum">
	<input type="hidden" value=${s_id } name="s_id">
	<button type="submit" class="btn btn-success">신고하기</button>
	</form>
	
	<script type="text/javascript">
		$( "#del" ).click(function( event ) {
			event.preventDefault();
			var dialog = confirm("글을 삭제하시겠습니까?");
			if(dialog) {
				$("#deleteSub").submit()
			}
		});
		</script>
</body>
</html>