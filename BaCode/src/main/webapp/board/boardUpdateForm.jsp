<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/BaCode/boardUpdate" method="post">
	제목 : <input type="text" name="title" value="${board.title }"/> <br/>
	카테고리 : <input type="text" name="catego" value="${board.catego}"/>
	작성자 : <input type="text" name="uId" value="${board.uId }" readonly/> <br/>
	본문 : <textarea cols="50" rows="15" name="content"/>${board.content } </textarea>
	<hr/>
	<input type="submit" value="수정하기" />
	<input type="hidden" name="postnum" value="${board.postNum }"> <br/>
	</form>
</body>
</html>