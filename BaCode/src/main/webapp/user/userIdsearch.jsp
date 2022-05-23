<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 찾는 화면입니다.
<form id="search" action="/BaCode/userIdPw.do" method="post">
	<input type="text" name="nick" placeholder="닉네임을 입력하세요">
	<input type="submit" id="sub" onclick="test()" value="아이디 찾기">
</form>
</body>
</html>