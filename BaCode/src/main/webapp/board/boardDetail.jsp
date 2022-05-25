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
    #btn-filed {
        display: inline-block;
        padding: 13px 20px;
        background-color:#6667AB; 
        color: white;
        border-radius: 20px;
        text-align: center;
        line-height: 100%;
    }
    #del {
        display: inline-block;
        padding: 13px 20px;
        background-color:#6667AB; 
        color: white;
        border-radius: 20px;
        text-align: center;
        line-height: 100%;
    }
</style>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
	<div class="container">
		  <div class="row">
	        <div class="col">
		    </div>
		    <div class="col">
		   		<p>
		   		<!-- 글제목 --><b style="font-size: 25px;">${board.title }</b>
				<form action="/BaCode/boardUpdateForm.board" method="post">
				<input type="hidden" value="${board.postNum }" name="postnum">
				Category : ${board.catego}<br/>
				작성자 : ${board.uId }<br/>
				작성날짜 : ${board.bdate }
				<textarea  class="form-control" disabled>${board.content }</textarea><br/>
				수정날짜 : <input type="text" class="form-control" value="${board.mdate }">
				조회수 : ${board.hit } <br/>
				<c:if test="${sessionScope.s_id eq board.uId}">
					<button type="submit" class="btn" id="btn-filed">수정하기</button>
				</c:if>
				</form>
				<!--<c:if test="${board.postNum ne buy.postNum }">
				<form action="/BaCode/buyInsert.buy" method="post">
				<input type="hidden" value="${board.postNum }" name="postNum">
				<input type="hidden" value="${board.title }" name="title"> 
				<input type="hidden" value="${s_id }" name="s_id">
				<button type="submit" class="btn" id="btn-filed">구매하기</button>
				</form>
				</c:if> -->
				<c:if test="${sessionScope.s_id eq board.uId}">
					<form id="deleteSub" action="/BaCode/boardDelete.board" method="post">
						<input type="hidden" value="${board.postNum }" name="postNum">	
						<button type="submit" class="btn" id="del" onclick="test()">삭제하기</button>
					</form>
				</c:if>
				<br/>
				<a href="http://localhost:52525/BaCode/getBoardList.board"><button type="button" class="btn" id="btn-filed">판매 목록 보러가기</button></a>
				</p>
				<c:if test="${sessionScope.s_id ne pick.uId }">
				<form action="/BaCode/pickInsert.pick" method="post">
					<button type="submit" class="btn" id="btn-filed">찜하기</button>
					<input type="hidden" value="${board.postNum}" name="postNum">
					<input type="hidden" value="${s_id }" name="pickId">
					<input type="hidden" value="${board.title }" name="title">
				</form>
				</c:if>
				<c:if test="${sessionScope.s_id eq pick.uId }">
				<form action="/BaCode/pickDelete.pick" method="post">
					<button type="submit" class="btn" id="btn-filed">찜하기 취소</button>
					<input type="hidden" value="${pick.pkNum}" name="pkNum">
					<input type="hidden" value="${pick.pkTitle}" name="pickTitle">
					<input type="hidden" value="${board.postNum }" name="postNum">
				</form>
				</c:if>
				<br/>
				<c:if test="${sessionScope.s_id eq buy.uId }">
				<form action="/BaCode/reviewInsertForm.review" method="get">
					<button type="submit" class="btn" id="btn-filed">리뷰쓰기</button>
					<input type="hidden" value="${buy.postNum }" name="postNum">
					<input type="hidden" value="${s_id }" name="s_id">
				</form>
				</c:if>
				<br/>
				<form action="/BaCode/SOSInsertForm.SOS" method="post">
				<input type="hidden" value=${board.postNum } name="postNum">
				<input type="hidden" value=${s_id } name="s_id">
				<button type="submit" class="btn" id="btn-filed">신고하기</button>
				</form>
		    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
	
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