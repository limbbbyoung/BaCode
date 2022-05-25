<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<style>
	 #btn-filed {
	        display: inline-block;
	        padding: 13px 20px;
	        background-color:#6667AB; 
	        color: white;
	        border-radius: 20px;
	        text-align: center;
	        line-height: 100%;
	    }
	    
	  .header {
        padding-left: 10px;
        padding-right: 10px;
        padding-top: 10px;
        padding-bottom: 10px;
		text-align : right;
		width: 100%;
        border-bottom: 1px solid gray;
        background-color: white;
        }
        
        #btn-outlined {
        display: inline-block;
        padding: 13px 20px;
        background-color : white; 
        border : 1px solid #6667AB;
        color: #6667AB;
        border-radius: 20px;
        text-align: center;
        line-height: 100%;
        }
        
        .container{
         margin-top: 30px;
        }
        
</style>
<head>
<meta charset="UTF-8">
<title>구매 완료 페이지</title>
</head>
<body>
	<div class="header">
	        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: white;">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="/BaCode/mainSearch.do">BaCode</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="/BaCode/userLogout.do"><button class="btn" id="btn-outlined">로그아웃</button></a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="/BaCode/getUserDetail.do"><button class="btn" id="btn-filed">내정보</button></a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="http://localhost:52525/BaCode/getBoardList.board"><button class="btn" id="btn-filed">상품 목록</button></a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
	</div>
	<div class="container">
		  <div class="row">
	        <div class="col-3">
		    </div>
		    <div class="col-6" id="main">
		   		<h1>
		   		<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
				  <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
				</svg>
		   		구매 완료</h1>
		   		<h3>상품 거래에 대한 리뷰를 작성해주세요.</h3>
				<c:if test="${sessionScope.s_id eq buy.uId }">
				<form action="/BaCode/reviewInsertForm.review" method="get">
					<button type="submit" class="btn" id="btn-filed">리뷰쓰기</button>
					<input type="hidden" value="${buy.postNum }" name="postNum">
					<input type="hidden" value="${s_id }" name="s_id">
				</form>
				</c:if>
				<br/>
				<c:if test="${sessionScope.s_id eq buy.uId }">
				<form action="/BaCode/getBuyList.buy" method="get">
					<input type="hidden" value="${buy.postNum }" name="postNum">
					<input type="hidden" value="${s_id }" name="s_id">
					<button type="submit" class="btn" id="btn-filed">내 구매 목록</button>
				</form>
				</c:if>
		    </div>
		    <div class="col-3">
		    </div>
		  </div>
		</div>
</body>
</html>