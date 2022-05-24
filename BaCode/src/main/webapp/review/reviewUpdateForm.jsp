<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/BaCode/reviewUpdate.review" method="post">
	제목 : <input type="text" name="title" value="${review.rvTitle }"/> <br/>
	작성자 : <input type="text" name="uId" value="${review.uId }" readonly/> <br/>
	글내용 : <textarea cols="50" rows="15" name="content"/>${review.rvContent } </textarea>
	<hr/>
	<input type="submit" value="수정하기" />
	<input type="hidden" name="rvNum" value="${review.rvNum }"> <br/>
	</form>
</body>
</html>