<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
	    #main{
	     margin: 50px;
	    }
	    form {
	     display: inline;
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
</style>
<head>
<meta charset="UTF-8">
<title>신고글 정보</title>
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
					<form action="/BaCode/SOSSuccess.SOS" method="post">
					<input type="hidden" value="${SOS.stNum }" name="stnum">
					<h1>${SOS.stTitle }</h1>
					신고유저 : <b>${SOS.uId }</b><br/> 
					<textarea class="form-control" rows="10">${SOS.stContent }</textarea><br/>
					신고글 작성날짜 : ${SOS.stBdate } <br/>
					수정날짜 : ${SOS.stMdate } <br/>
					</form>
				
					<form action="/BaCode/SOSSuccess.SOS" method="post">
					<input type="hidden" value="${SOS.stNum }" name="stNum">
					<button type="submit" class="btn" id="btn-filed">처리완료</button>
					</form>
					<a href="http://localhost:52525/BaCode/getSOSList.SOS"><button class="btn" id="btn-filed">신고 목록 보러가기</button></a>
		    </div>
		    <div class="col-3">
		    </div>
		  </div>
		</div>
</body>
</html>