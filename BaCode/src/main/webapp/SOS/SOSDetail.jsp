<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<style>
  body{margin: 20px;}
</style>
<head>
<meta charset="UTF-8">
<title>신고글 정보</title>
</head>
<body>
	${SOS }</br>
	세션아이디 : ${s_id }</br>
	<form action="/BaCode/SOSUpdateForm" method="post">
	<input type="hidden" value="${SOS.stNum }" name="stnum">
	신고글 제목 : ${SOS.stTitle }<br/> 
	신고유저 : ${SOS.uId }<br/> 
	<textarea cols="50" rows="20">${SOS.stContent }</textarea><br/>
	신고글 작성날짜 : ${SOS.stBdate } <br/>
	수정날짜 : ${SOS.stMdate } <br/>
	<input type="submit" value="수정하기">
	</form>

	<form action="/BaCode/SOSSuccess" method="post">
	<input type="hidden" value="${SOS.stNum }" name="stNum">
	<input type="submit" value="처리완료">
	</form>
	
	<a href="http://localhost:52525/BaCode/getSOSList"><button>신고 목록 보러가기</button></a>
</body>
</html>