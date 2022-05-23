<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${reUrl ne null }">
<% 
Object objManagerId = session.getAttribute("managerId");
String managerId = (String)objManagerId;
System.out.println("매니저 아이디 : " + managerId);
response.sendRedirect("http://localhost:52525/BaCode/user/mainSearchManagerVer.jsp"); %>
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
    
    Img{width : 400px; height : 400px;
    }

    .search-sec {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        padding-bottom: 400px;
    }

    .search-form {
        margin: 0 auto;
        padding-top: 10px;
        padding-bottom: 30px;
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
        width: 100%;
        bottom: 0;
        border-top: 1px solid gray;
        text-align: center;
    }

    #footer > p :after {
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
    
    .final {
    	text-align: center;
    
    }

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="header">
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: white;">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="/BaCode/user/mainSearch.jsp">BaCode</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="/BaCode/userLogout.do"><button class="btn" id="btn-outlined">로그아웃</button></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="/BaCode/getUserDetail.do"><button class="btn" id="btn-filed">내정보</button></a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
</div>
<div id="container">
	<div class="row">
        <div class="search-sec"> <!-- 코드 추가 -->
		    <!-- <div class="col-md-3">.col-md-3</div> 삭제 -->
		    <!-- <div class="col-md-6"> 삭제 -->
		    	<img src="${pageContext.request.contextPath}/Images/Logo.jpg" class="img-responsive" alt="">
			    <form action="/BaCode/searchWhat.board" method="post" class="search-form"> <!-- class 선택자 추가했습니다. -->
				        <input type="text" class="form-control" name="search_name" style="width:750px;height:40px;" placeholder="검색어를 입력하세요." onKeypress="javascript:if(event.keyCode==13) {search_onclick_submit}"/>
			    </form>
			<br/>

                <div class="search-sec-btn-bottom"> <!-- 아래 두개 버튼 div로 묶었습니다. -->
		            <a href="/BaCode/getBoardList.board"><button class="btn" id="btn-filed">등록된상품보러가기</button></a><br/><br/> <!-- 1.id 선택자 추가, 2.스타일 프로퍼티 css로 옮겼습니다. -->
			        <a href="/BaCode/boardInsertForm.board"><button class="btn" id="btn-filed">상품등록하기</button></a> <!-- 1.id 선택자 추가, 2.스타일 프로퍼티 css로 옮겼습니다. -->
			        <a href="/BaCode/getReviewList"><button class="btn" id="btn-filed">리뷰보러가기</button></a>
                </div>
		</div>
	</div>
	<div class="row empty"></div>
</div>
<div id="footer">
	<p>주소 : 서울시 신촌역 7번출구 ict학원</p>
	<!-- <hr/> 삭제하고 css에서 가상요소로 대체하였습니다. (레이아웃-퍼블리싱 이슈)-->
	<div class="final">
		<p>developers : 임병영, 이충현, 박재현
		<b>©BaCode Corp.</b></p>
		<a href="intro.jsp">회사소개</a>
		<a href="help.jsp">고객센터</a>
		<a href="help.jsp">이용약관</a>
	</div>
</div>
</body>
</html> 
