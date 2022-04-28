<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<head>
<style>
   input { margin : 10px;}
   body { padding : 20px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="container">
		  <div class="row">
	        <div class="col">
		    </div>
		    <div class="col">
		         <h1>회원가입</h1>
			     <hr/>
			     <form action="http://localhost:52525/BaCode/userInsert" method="post">
			     아이디 : <input type="text" name="uId" placeholder="아이디"><br/>
			     비밀번호 : <input type="password" name="uPw" placeholder="비밀번호"><br/>
			     이름 : <input type="text" name="uName" placeholder="이름"><br/>
			     닉네임 : <input type="text" name="uckName" placeholder="닉네임"><br/>
			     이메일 : <input type="email" name="email" placeholder="이메일"><br/>
			     휴대폰 번호 : <input type="tel" name="pNum" placeholder="휴대폰번호"><br/>
			     주소 : <input type="text" name="addr" placeholder="주소"><br/>
			     <button type="submit" class="btn btn-success">회원가입</button>
			     </form>
		    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
</body>
</html>