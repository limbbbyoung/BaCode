<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<style>
	body {
		padding : 100px;
	}
	input {
		margin : 10px;
	}
	#btn { 
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
	<div class="container">
		<div class="row">
			<div class="col">
			</div>
			<div class="col">
				<h2>내 정보 수정</h2>
				<form action="/BaCode/userUpdate.do" method="post">
					아이디 : <input type="text" name="uId" value="${user.uId}" readonly> <br/>
					비밀번호 : <input type="password" name="uPw" required/> <br/>
					이름 : <input type="text" name="uName" value="${ user.uName}" readonly /> <br/>
					이메일 : <input type="text" name="email" value="${ user.email}"/> <br/> <!--  value를 사용하면 디폴트값으로 저장해줍니다. -->
					핸드폰번호 : <input type="tel" name="pNum" value="${user.pNum}"/><br/>
					주소 : <input type="text" name="addr" value="${ user.addr}" /> <br/>
					닉네임 : <input type="text" name="nckName" value="${user.nckName}" /><br/>
					<input type="submit" id="btn" class="btn"value="수정하기">
				</form>
			</div>
			<div class="col">
			</div>
		</div>
	</div>
</body>
</html>