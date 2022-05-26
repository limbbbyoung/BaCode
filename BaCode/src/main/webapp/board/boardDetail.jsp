<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<style>
		 p {
		 text-align : center;
		 }
	    #btn-filed {
	        display: inline-block;
	        padding: 13px 20px;
	        background-color:#6667AB; 
	        color: white;
	        border-radius: 20px;
	        text-align: center;
	        line-height: 100%;
	    }
	    #del {
	        display: inline-block;
	        padding: 13px 20px;
	        background-color:#6667AB; 
	        color: white;
	        border-radius: 20px;
	        text-align: center;
	        line-height: 100%;
	    }
	    #main{
	     margin: 50px;
	    }
	    form {
	     display: inline;
	     }
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
</style>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
	<div class="header">
	        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: white;">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="/BaCode/mainSearch.do">BaCode</a>
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
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="http://localhost:52525/BaCode/getBoardList.board"><button class="btn" id="btn-filed">상품 목록</button></a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
	</div>
	<div class="container">
		  <div class="row">
	        <div class="col-3">
		    </div>
		    <div class="col-6" id="main">
		   		<!-- 글제목 --><b style="font-size: 25px;">${board.title }</b>
				<form class="form" action="/BaCode/boardUpdateForm.board" method="post">
				<input type="hidden" value="${board.postNum }" name="postnum"><br/>
				카테고리 : ${board.catego}<br/>
				작성자 : ${board.uId }<br/>
				작성날짜 : ${board.bdate }
				<textarea class="form-control" style="height:150px; "disabled>${board.content }</textarea>
				수정날짜 : ${board.mdate }<br/>
				조회수 : ${board.hit }<br/>
				<c:if test="${sessionScope.s_id eq board.uId}">
					<button type="submit" class="btn" id="btn-filed">수정하기</button>
				</c:if>
				</form>
				<form class="form" action="/BaCode/buyInsert.buy" method="post">
				<input type="hidden" value="${board.postNum }" name="postNum">
				<input type="hidden" value="${board.title }" name="title"> 
				<input type="hidden" value="${s_id }" name="s_id">
				<button type="submit" class="btn" id="btn-filed">구매하기</button>
				</form>
				
				<c:if test="${sessionScope.s_id eq board.uId}">
					<form id="deleteSub" action="/BaCode/boardDelete.board" method="post">
						<input type="hidden" value="${board.postNum }" name="postNum">	
						<button type="submit" class="btn" id="del" onclick="test()">삭제하기</button>
					</form>
				</c:if>
				<br/><br/>
				<c:if test="${sessionScope.s_id ne pick.uId }">
				<form class="form" action="/BaCode/pickInsert.pick" method="post">
					<button type="submit" class="btn" id="btn-filed">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
					  <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
					</svg>
					</button>
					<input type="hidden" value="${board.postNum}" name="postNum">
					<input type="hidden" value="${s_id }" name="pickId">
					<input type="hidden" value="${board.title }" name="title">
				</form>
				</c:if>
				<c:if test="${sessionScope.s_id eq pick.uId }">
				<form class="form" action="/BaCode/pickDelete.pick" method="post">
					<button type="submit" class="btn" id="btn-filed">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
					</svg>
					</button>
					<input type="hidden" value="${pick.pkNum}" name="pkNum">
					<input type="hidden" value="${pick.pkTitle}" name="pickTitle">
					<input type="hidden" value="${board.postNum }" name="postNum">
				</form>
				</c:if>
				<c:if test="${sessionScope.s_id eq buy.uId }">
				<form class="form" action="/BaCode/reviewInsertForm.review" method="get">
					<button type="submit" class="btn" id="btn-filed">리뷰쓰기</button>
					<input type="hidden" value="${buy.postNum }" name="postNum">
					<input type="hidden" value="${s_id }" name="s_id">
				</form>
				</c:if>
				<form class="form" action="/BaCode/SOSInsertForm.SOS" method="post">
				<input type="hidden" value=${board.postNum } name="postNum">
				<input type="hidden" value=${s_id } name="s_id">
				<button type="submit" class="btn" id="btn-filed">신고하기</button>
				</form>
		    </div>
		    <div class="col-3">
		    </div>
		  </div>
		</div>
	
	<script type="text/javascript">
		$( "#del" ).click(function( event ) {
			event.preventDefault();
			var dialog = confirm("글을 삭제하시겠습니까?");
			if(dialog) {
				$("#deleteSub").submit()
			}
		});
		</script>
</body>
</html>