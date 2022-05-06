<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<head>
<style>
	.login {
		text-align : center;}
	img{width : 400px; height : 400px;}
</style>
<meta charset="UTF-8">
<title>BaCode Login</title>
</head>	
<body>
<div id="container">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6 login">
		    <img src="../Images/Logo.jpg" class="img-responsive" alt="">
			<form action="/BaCode/userLoginCheck" method="post">
			  <div class="col">
			    <label for="BaCodeId" class="form-label">아이디</label>
			    <input type="text" name="userId" class="form-control">
			  </div>
			  <div class="col">
			    <label for="BaCodePw" class="form-label">비밀번호</label>
			    <input type="password" name="userPw" class="form-control">
			  </div><br/>
			  <button type="submit" class="btn btn-success">로그인</button>
			</form>
			<br/>
			<a class="btn btn-success" href="/BaCode/dvCheck" role="button" aria-disabled="false">회원가입</a>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
</body>	
</html>