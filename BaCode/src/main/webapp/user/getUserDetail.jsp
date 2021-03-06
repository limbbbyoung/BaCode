<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<style>
	
	#header { height : 150px; }
	img{width : 150px; height : 150px;}
	#btn-filed {
        display: inline-block;
        padding: 13px 20px;
        background-color:#6667AB; 
        color: white;
        border-radius: 20px;
        text-align: center;
        line-height: 100%;
    }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<img src="${pageContext.request.contextPath}/Images/Logo.jpg" class="img-responsive" alt="">
		</div>
	</div>
</div>
<div id="container">
	<div class="row">
		<div class="col-md-2 offset-md-2 first">
			<br/>
			<h2>${user.uId}님의 정보</h2><br/>
			<img src="${pageContext.request.contextPath}/Images/my.jpg" id="my" class="img-responsive" alt="">
		</div>
		<div class="col-md-4 offset-md-1 center">
		이름 : ${user.uName } <br/>
		닉네임 : ${user.nckName } <br/>
		<hr>
		주소 : ${user.addr } <br/>
		<hr>
		좋아요 지수 : ${user.heart } <meter min="-10" max="10" low="-3" value="${user.heart }"></meter> <br/>
		휴대폰 번호 : ${user.pNum }<br/>
		이메일 : ${user.email}<br/>
		<form action="/BaCode/userUpdateForm.do" method="post">
			<input type="hidden" name="uId" value="${user.uId }"><br/>
			<button type="submit" id="btn-filed" class="btn">회원정보 수정하기</button> 
		</form>
		<form action="/BaCode/userDeleteCheck.do" method="post">
			<input type="hidden" name="uId" value="${user.uId }"><br/>
			<button type="submit" id="btn-filed" class="btn">회원탈퇴</button>
		</form>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</div>
	<br/>
	
	
	
	<hr/>
	<!-- <a href="http://localhost:8181/BaCode/boardList"><buttion>목록으로</buttion></a> -->
	<form action="/BaCode/getPickList.pick" method="get">
		<input type="hidden" name="uId" value="${user.uId }">
		<button class="btn" id="btn-filed">찜목록으로 </button>
	</form>
	<form action="/BaCode/getBuyList.buy" method="get">
		<input type="hidden" name="uId" value="${user.uId }">
		<button class="btn" id="btn-filed">구매목록으로 </button>
	</form>
	<form action="http://localhost:52525/BaCode/mainSearch.do" method="post">
	<input type="hidden" name="uId" value="${user.uId }">
	<input type="submit" id="btn-filed" class="btn" value="홈으로" />
	</form>
	<c:if test="${managerId ne null}">
	<form action="http://localhost:52525/BaCode/mainSearchManagerVer.do" method="post">
	<input type="submit" id="btn-filed" class="btn" value="관리자 홈으로" />
	</form>
	</c:if>
</body>
</html>