<%@page import="kr.co.bacode.domain.BoardVO"%>
<%@page import="kr.co.bacode.domain.BoardDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<head>
<style>
	a {
	     color : #8789C6;
	     text-decoration-line : none;
	  }
    .my.pagination > .active > a, 
	.my.pagination > .active > span, 
	.my.pagination > .active > a:hover, 
	.my.pagination > .active > span:hover, 
	.my.pagination > .active > a:focus, 
	.my.pagination > .active > span:focus {
	  background: #DDDDF4;
	  border-color: #DDDDF4;
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
</style>
<meta charset="UTF-8">
<title>카테고리 게시판</title>
</head>
<body>
	<div class="container">
    <h1 style="color: #3E408F;">
    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-mouse2" viewBox="0 0 16 16">
	  <path d="M3 5.188C3 2.341 5.22 0 8 0s5 2.342 5 5.188v5.625C13 13.658 10.78 16 8 16s-5-2.342-5-5.188V5.189zm4.5-4.155C5.541 1.289 4 3.035 4 5.188V5.5h3.5V1.033zm1 0V5.5H12v-.313c0-2.152-1.541-3.898-3.5-4.154zM12 6.5H4v4.313C4 13.145 5.81 15 8 15s4-1.855 4-4.188V6.5z"/>
	</svg>
    마우스 상품 목록</h1>
    <table class="table table-hover" style="color : #8789C6;">
       <thead>
           <tr>
              <th>글번호</th>
              <th>글제목</th>
              <th>글쓴이</th>
              <th>카테고리</th>
              <th>쓴날짜</th>
              <th>수정날짜</th>
              <th>조회수</th>
           </tr>
       </thead>
       <!-- JSTL c:forEach와 ${boardList}를 활용하면 됩니다.
       전체 글 정보를 테이블 형식으로 보내주세요. -->
       <tbody>
         <c:forEach var="board" items="${boardList }">
	          <tr>
	             <td>${board.postNum}</td>
	             <td><a href="http://localhost:52525/BaCode/getBoardDetail.board?postnum=${board.postNum}">${board.title}</a></td>
	             <td>${board.uId}</td>
	             <td>${board.catego}</td>	             
	             <td>${board.bdate}</td>
	             <td>${board.mdate}</td>
	             <td>${board.hit}</td>
	          </tr>
        </c:forEach>
       </tbody>
    </table>
      <!-- foreach문의 start, end속성을 이용해 숫자를 알맞게 깔아주세요. -->
    <nav aria-label="Page navigation example">
		  <ul class="pagination my justify-content-center">
		  <!-- 이전 10개 페이지 조회버튼을 출력합니다.
          현재 조회중인 페이지가 1~10 페이지가 아닐때만, 첫페이지 -1을 목표주소로 해서 prev 버튼을 만들면 됩니다. -->
          <c:if test="${buttons.startPage ne 1}">
		    <li class="page-item"><a class="page-link" href="http://localhost:52525/BaCode/getBoardCategoList.board?pageNum=${buttons.startPage-1 }">Previous</a></li>
		  </c:if>
    <c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }"> 
		    <li class="page-item ${(buttons.currentPage eq pageNum) ? 'active' : ' '}" aria-current="page"><a class="page-link" href="http://localhost:52525/BaCode/getBoardCategoList.board?pageNum=${pageNum}" style="color: #8789C6;" >${pageNum }</a></li>
    </c:forEach> 
          <c:if test="${buttons.endPage ne buttons.totalPages}">
		    <li class="page-item"><a class="page-link" href="http://localhost:52525/BaCode/getBoardCategoList.board?pageNum=${buttons.endPage+1 }">Next</a></li>
		  </c:if>
		  </ul>
	</nav>
    <c:if test="${sessionScope.s_id ne null }"><a class="btn" href="/BaCode/boardInsertForm.board" role="button" aria-disabled="false" id="btn-filed">글쓰기</a></c:if>
    
    <a class="btn" href="http://localhost:52525/BaCode/mainSearch.do" role="button" aria-disabled="false" id="btn-filed">홈으로</a>
    
    <c:if test="${managerId ne null}">
	<a class="btn" href="http://localhost:52525/BaCode/mainSearchManagerVer.do" role="button" aria-disabled="false" id="btn-filed">관리자 홈으로</a>
	</c:if>
	</div><!-- container 끝나는 지점 -->
</body>
</html>