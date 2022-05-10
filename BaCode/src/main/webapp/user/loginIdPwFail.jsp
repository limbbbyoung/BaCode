<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<head>
<style>
	.login {
		text-align : center;
		}
	img{width : 400px; height : 400px;}
	#insertForm { padding : 5px;
	              margin: 0px 0px 0px 200px;}
	#idInsert{margin: 0px 0px 0px 15px;}
	.footer{
	height : 100px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
	<h1>아이디 또는 비밀번호가 틀렸습니다. 다시 로그인해주세요</h1>
	</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6 login">
		    <img src="${pageContext.request.contextPath}/Images/Logo.jpg" class="img-responsive" alt="">
			<form action="/BaCode/userLoginCheck" method="post">
			  <div class="col">
			    <div class="row g-3 align-items-center" id="insertForm">
				  <div class="col-auto">
				    <label for="BaCodeId" class="col-form-label">아이디</label>
				  </div>
				  <div class="col-auto" id="idInsert">
				    <input type="text" name="userId" class="form-control" aria-describedby="idHelpInline" placeholder="20자 이내로 작성">
				  </div>
				  <div class="col-auto">
				    <span id="idHelpInline" class="form-text">
				    </span>
				  </div>
                </div>
			  </div>
			  <div class="col">
			     <div class="row g-3 align-items-center" id="insertForm">
				  <div class="col-auto">
				    <label for="BaCodePw" class="col-form-label">비밀번호</label>
				  </div>
				  <div class="col-auto">
				    <input type="password" name="userPw" class="form-control" aria-describedby="passwordHelpInline" placeholder="20자 이내로 작성">
				  </div>
				  <div class="col-auto">
				    <span id="passwordHelpInline" class="form-text">
				    </span>
				  </div>
                </div>
			  </div><br/>
			  <button type="submit" class="btn btn-success">로그인</button>
			</form>
			<br/>
			<a class="btn btn-success" href="/BaCode/dvCheck" role="button" aria-disabled="false">회원가입</a>
		</div>
		<div class="col-md-3"></div>
	</div>
</div><!-- div.container 끝나는 지점 -->
<div class="footer"></div>
</body>
</html>