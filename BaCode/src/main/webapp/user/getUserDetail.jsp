<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<style>
	#header { height : 150px; }
	img{width : 150px; height : 150px;}
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
		
		<h1>${user.uId}님의 정보</h1><br/>
		<h2>사진</h2>
		</div>
		<div class="col-md-4 offset-md-1 center">
		이름 : ${user.uName } <br/>
		닉네임 : ${user.nckName } <br/>
		<hr>
		주소 : ${user.addr } <br/>
		<hr>
		좋아요 지수 : ${user.heart } <br/>
		휴대폰 번호 : ${user.pNum }<br/>
		이메일 : ${user.email}<br/>
		<form action="http://localhost:52525/BaCode/userUpdateForm" method="post">
			<input type="hidden" name="uId" value="${user.uId }"><br/>
			<button type="submit" class="btn btn-success">회원정보 수정하기</button> 
		</form>
		<form action="http://localhost:52525/BaCode/userDeleteCheck" method="post">
			<input type="hidden" name="uId" value="${user.uId }"><br/>
			<button type="submit" class="btn btn-success">회원탈퇴</button>
		</form>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</div>
	<br/>
	
	
	
	<hr/>
	<!-- <a href="http://localhost:8181/BaCode/boardList"><buttion>목록으로</buttion></a> -->
	
	<form action="http://localhost:52525/BaCode/user/mainSearch.jsp" method="post">
	<input type="hidden" name="uId" value="${user.uId }"><br/>
	<input type="submit" value="홈으로" />
	</form>
	
</body>
</html>