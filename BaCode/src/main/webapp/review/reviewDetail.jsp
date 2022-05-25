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
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		 <div class="row">
	        <div class="col">
		    </div>
		    <div class="col">
		   		<p>
		   		<!-- 글제목 --><b style="font-size: 25px;">${review.rvTitle }</b>
		<form action="/BaCode/reviewUpdateForm.review" method="post">
	<input type="hidden" value="${review.rvNum }" name="rvNum">
	구매했던 물품 : <input type="text" value="${board.title }" readonly> <br/>
	리뷰 제목 : <input type="text" style="width:300px;height:25px;" value="${review.rvTitle }" readonly><br/>
	작성자 : <input type="text" value="${review.uId }" readonly><br/> 
	작성날짜 : <input type="text" value="${review.rvBdate }" readonly><br/>
	<textarea cols="50" rows="20" readonly>${review.rvContent }</textarea><br/>
	수정날짜 : <input type="text" value="${review.rvUdate }" readonly><br/>
	<c:if test="${sessionScope.s_id eq review.uId }">
	<button type="submit" class="btn" id="btn-filed">수정하기</button>
	</c:if>
	</form>
	<c:if test="${sessionScope.s_id eq review.uId }">
	<form action="/BaCode/reviewDelete.review" method="post">
	<input type="hidden" value="${review.rvNum }" name="rvNum">
	<button type="submit" class="btn" id="btn-filed">삭제하기</button>
	</form>
	</c:if>
	<a href="http://localhost:52525/BaCode/getBoardList.board"><button type="button" class="btn" id="btn-filed">판매목록으로</button></a>
	<a href="http://localhost:52525/BaCode/getReviewList.review"><button type="button" class="btn" id="btn-filed">리뷰목록으로</button></a>
	</p>
			    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
</body>
</html>