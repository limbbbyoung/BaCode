<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${reUrl ne null }">
<% response.sendRedirect("http://localhost:52525/BaCode/user/mainSearchManagerVer.jsp"); %>
</c:when>
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
	/* 공통 요소 (버튼) */
    #btn-filed {
        display: inline-block;
        padding: 13px 20px;
        background-color:#6667AB; 
        color: white;
        border-radius: 20px;
        text-align: center;
        line-height: 100%;
    }

    #btn-outlined {
        display: inline-block;
        padding: 13px 20px;
        background-color : white; 
        border : 1px solid #6667AB;
        color: #6667AB;
        border-radius: 20px;
        text-align: center;
        line-height: 100%;
    }

/* 컴포넌트 1) 헤더 */
    .header {
        padding-left: 10px;
        padding-right: 10px;
        padding-top: 10px;
        padding-bottom: 10px;
		text-align : right;
		width: 100%;
        border-bottom: 1px solid gray;
        background-color: white;
    }

    h3 {
        display: inline-block;
        float: left;
    }

/* 컴포넌트 2) 컨텐츠 */

    .search-sec {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .search-form {
        margin: 0 auto;
        padding-top: 200px;
        padding-bottom: 50px;
    }

    .submit-btn {
        border: 0;
        background-color: black;
        color: white;
        height: 40px;
        width: auto;
        padding-left: 10px;
        padding-right: 10px;
    }

    .search-sec-btn-bottom {
        display: flex;
        flex-direction: row;
    }

    .search-sec-btn-bottom button {
        margin: 10px;
    }
/* 컴포넌트 3) 푸터 */

    #footer {
        position: fixed;
        width: 100%;
        bottom: 0;
        border-top: 1px solid gray;
    }

    #footer > p:after {
        content: '';
        position: absolute;
        top: 30px;
        left: 0;
        right: 0;
        height: 1px;
        background-color: gray;
    }

    a {
        color: inherit; 
        text-decoration: none;
    }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="header">
        <h3>로고 들어갈 자리(추가) 계정 : ${reUrl }</h3> <!-- 코드 추가 -->
<a href="/BaCode/userLogout.do"><button class="btn" id="btn-outlined">로그아웃</button></a> <!-- 1.id 선택자 추가, 2.스타일 프로퍼티 css로 옮겼습니다. -->
<a href="/BaCode/getUserDetail.do"><button class="btn" id="btn-filed">내정보</button></a> <!-- id 선택자 추가 -->
</div>
<div id="container">
	<div class="row">
        <div class="search-sec"> <!-- 코드 추가 -->
		    <!-- <div class="col-md-3">.col-md-3</div> 삭제 -->
		    <!-- <div class="col-md-6"> 삭제 -->
			    <form action="/BaCode/searchWhat" method="post" class="search-form"> <!-- class 선택자 추가했습니다. -->
			        <input type="text" name="search_name" style="width:750px;height:40px;" placeholder="검색어를 입력하세요" onKeypress="javascript:if(event.keyCode==13) {search_onclick_submit}"/>
			        <input type="submit" class="submit-btn" id="btn-filed" style="background-color:black;" value="검색"> <!-- 1.class 선택자 추가, 2.스타일 프로퍼티 추가하였습니다. -->
			    </form>
			<br/>

                <div class="search-sec-btn-bottom"> <!-- 아래 두개 버튼 div로 묶었습니다. -->
		            <a href="/BaCode/getBoardList"><button class="btn" id="btn-filed">등록된상품보러가기</button></a><br/><br/> <!-- 1.id 선택자 추가, 2.스타일 프로퍼티 css로 옮겼습니다. -->
			        <a href="/BaCode/boardInsertForm"><button class="btn" id="btn-filed">상품등록하기</button></a> <!-- 1.id 선택자 추가, 2.스타일 프로퍼티 css로 옮겼습니다. -->
                </div>
		</div>
	</div>
	<div class="row empty"></div>
</div>
<div id="footer">
	<p> 서울시 신촌역 7번출구 ict학원 </p>
	<!-- <hr/> 삭제하고 css에서 가상요소로 대체하였습니다. (레이아웃-퍼블리싱 이슈)-->
	<div class="final">
		<a href="intro.jsp">회사소개</a>
		<a href="help.jsp">고객센터</a>
		<a href="help.jsp">이용약관</a>
	</div>
</div>
</body>
</html> 
