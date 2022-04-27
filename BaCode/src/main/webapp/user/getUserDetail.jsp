<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br/>
	<h1>${user.uId}님의 정보</h1><br/>
	닉네임 : ${user.nckName } <br/>
	이름 : ${user.uName } <br/>
	이메일 : ${user.email}<br/>
	좋아요 지수 : ${user.heart } <br/>
	휴대폰 번호 : ${user.pNum }<br/>
	주소 : ${user.addr } <br/>
	<hr/>
	<!-- <a href="http://localhost:8181/BaCode/boardList"><buttion>목록으로</buttion></a> -->
	<form action="http://localhost:8181/BaCode/userDeleteCheck.jsp" method="post">
	<input type="hidden" name="uId" value="${user.uId }"><br/>
	<input type="submit" value="삭제하기" />
	</form>
	<form action="http://localhost:8181/BaCode/userUpdateForm" method="post">
	<input type="hidden" name="uId" value="${user.uId }"><br/>
	<input type="submit" value="수정하기">
	</form>
</body>
</html>