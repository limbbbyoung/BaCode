<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/BaCode/userUpdate.do" method="post">
		아이디 : <input type="text" name="uId" value="${user.uId}" readonly> <br/>
		비밀번호 : <input type="password" name="uPw" /> <br/>
		이름 : <input type="text" name="uName" value="${ user.uName}" readonly /> <br/>
		이메일 : <input type="text" name="email" value="${ user.email}"/> <br/> <!--  value를 사용하면 디폴트값으로 저장해줍니다. -->
		핸드폰번호 : <input type="tel" name="pNum" value="${user.pNum}"/><br/>
		주소 : <input type="text" name="addr" value="${ user.addr}" /> <br/>
		닉네임 : <input type="text" name="nckName" value="${user.nckName}" /><br/>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>