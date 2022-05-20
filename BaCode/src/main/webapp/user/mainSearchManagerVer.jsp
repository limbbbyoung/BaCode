<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

     
<c:choose>
<c:when test="${loginIdFail eq 'id'}">
<% response.sendRedirect("http://localhost:52525/BaCode/user/loginIdPwFail.jsp");%>
</c:when>
<c:when test="${loginPwFail eq 'pw'}">
<% response.sendRedirect("http://localhost:52525/BaCode/user/loginIdPwFail.jsp");%>
</c:when>
<c:when test="${sessionScope.s_id eq null }">
<% response.sendRedirect("/BaCode/userLogin.do"); %>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>


<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<style>
	#header {
		text-align : right;
		height : 250px;
	}
	.empty {
		height : 300px;
	}
	.final {
		text-align : center;
	}
	a {
		text-decoration-line : none;
		color : grey;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">헤더
<a href="/BaCode/getSOSList"><button class="btn" style="border-radius:20px; background-color : #6667AB; color: white;">신고글 목록 보기</button></a>
<a href="/BaCode/userLogout.do"><button class="btn" style="border-radius:20px; background-color : #6667AB; color: white;">로그아웃</button></a>
<a href="/BaCode/getUserDetail.do"><button class="btn" style="border-radius:20px; background-color : #6667AB; color: white;">내정보</button></a>
</div>
<div id="container">
	<div class="row">
		<div class="col-md-3">.col-md-3</div>
		<div class="col-md-6">
			<form action="/BaCode/searchWhat" method="post">
			<input type="text" name="search_name" style="width:750px;height:40px;" placeholder="검색어를 입력하세요" onKeypress="javascript:if(event.keyCode==13) {search_onclick_submit}"/>
			<input type="submit" value="검색">
			</form>
			<br/>
		    <a href="/BaCode/getBoardList"><button class="btn" style="border-radius:20px; background-color : #6667AB; color: white;">등록된상품보러가기</button></a><br/><br/>
			<a href="/BaCode/boardInsertForm"><button class="btn" style="border-radius:20px; background-color : #6667AB; color: white;">상품등록하기</button></a>
		</div>
		<div class="col-md-3">.col-md-3</div>
	</div>
	<div class="row empty"></div>
</div>
<div id="footer">
	<p> 서울시 신촌역 7번출구 ict학원 </p>
	<hr/>
	<div class="final">
		<a href="intro.jsp">회사소개</a>
		<a href="help.jsp">고객센터</a>
		<a href="help.jsp">이용약관</a>
	</div>
</div>
</body>
</html>