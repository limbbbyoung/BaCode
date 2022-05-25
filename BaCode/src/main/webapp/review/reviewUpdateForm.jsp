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
	<form action="/BaCode/reviewUpdate.review" method="post">
	제목 : <input type="text" name="title" value="${review.rvTitle }"/> <br/>
	작성자 : <input type="text" name="uId" value="${review.uId }" readonly/> <br/>
	글내용 : <textarea cols="50" rows="15" name="content"/>${review.rvContent } </textarea>
	<hr/>
	<button type="submit" class="btn" id="btn-filed">수정하기</button>
	<input type="hidden" name="rvNum" value="${review.rvNum }"> <br/>
	</form>
		</p>
			<a href="http://localhost:52525/BaCode/getReviewList.review"><button type="button" class="btn" id="btn-filed">리뷰목록으로</button></a> 
	<a href="http://localhost:52525/BaCode/mainSearch.do"><button type="button" class="btn" id="btn-filed">홈으로</button></a>
			    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
</body>
</html>