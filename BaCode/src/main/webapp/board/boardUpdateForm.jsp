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
        
        input {display: inline; }
        
        .container{
         margin-top: 30px;
        }
        
        hr{color:#6667AB;}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		   		<form action="/BaCode/boardUpdate.board" method="post">
				<b>제목</b><input class="form-control" type="text" name="title" value="${board.title }"/><br/>
				<b>카테고리</b><input class="form-control" type="text" name="catego" value="${board.catego}"/><br/>
				<b>작성자</b><input class="form-control" type="text" name="uId" value="${board.uId }" readonly/><br/>
				<b>본문</b><textarea class="form-control" cols="40" rows="10" name="content">${board.content }</textarea>
				<hr/>
				<button type="submit" class="btn" id="btn-filed">수정하기</button>
				<input type="hidden" name="postnum" value="${board.postNum }"> <br/>
				</form>
		    </div>
		    <div class="col-3">
		    </div>
		  </div>
		</div>
</body>
</html>