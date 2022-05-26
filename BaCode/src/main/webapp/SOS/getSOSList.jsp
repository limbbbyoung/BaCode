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
<title>신고 목록</title>
</head>
<body>
	<div class="container">
    <h1 style="color : #3E408F;">
    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-whatsapp" viewBox="0 0 16 16">
	  <path d="M13.601 2.326A7.854 7.854 0 0 0 7.994 0C3.627 0 .068 3.558.064 7.926c0 1.399.366 2.76 1.057 3.965L0 16l4.204-1.102a7.933 7.933 0 0 0 3.79.965h.004c4.368 0 7.926-3.558 7.93-7.93A7.898 7.898 0 0 0 13.6 2.326zM7.994 14.521a6.573 6.573 0 0 1-3.356-.92l-.24-.144-2.494.654.666-2.433-.156-.251a6.56 6.56 0 0 1-1.007-3.505c0-3.626 2.957-6.584 6.591-6.584a6.56 6.56 0 0 1 4.66 1.931 6.557 6.557 0 0 1 1.928 4.66c-.004 3.639-2.961 6.592-6.592 6.592zm3.615-4.934c-.197-.099-1.17-.578-1.353-.646-.182-.065-.315-.099-.445.099-.133.197-.513.646-.627.775-.114.133-.232.148-.43.05-.197-.1-.836-.308-1.592-.985-.59-.525-.985-1.175-1.103-1.372-.114-.198-.011-.304.088-.403.087-.088.197-.232.296-.346.1-.114.133-.198.198-.33.065-.134.034-.248-.015-.347-.05-.099-.445-1.076-.612-1.47-.16-.389-.323-.335-.445-.34-.114-.007-.247-.007-.38-.007a.729.729 0 0 0-.529.247c-.182.198-.691.677-.691 1.654 0 .977.71 1.916.81 2.049.098.133 1.394 2.132 3.383 2.992.47.205.84.326 1.129.418.475.152.904.129 1.246.08.38-.058 1.171-.48 1.338-.943.164-.464.164-.86.114-.943-.049-.084-.182-.133-.38-.232z"/>
	</svg>
    신고 목록</h1>
    <table class="table table-hover" style="color : #8789C6;">
       <thead>
           <tr>
              <th>신고글 번호</th>
              <th>신고글 제목</th>
              <th>신고 아이디</th>
              <th>쓴날짜</th>
              <th>수정날짜</th>
           </tr>
       </thead>
       <!-- JSTL c:forEach와 ${boardList}를 활용하면 됩니다.
       전체 글 정보를 테이블 형식으로 보내주세요. -->
       <tbody>
         <c:forEach var="SOS" items="${SOSList }">
	          <tr>
	             <td>${SOS.stNum}</td>
	             <td><a href="http://localhost:52525/BaCode/getSOSDetail.SOS?stNum=${SOS.stNum}" style="color : #8789C6;">
	             ${SOS.stTitle}
	             <c:if test="${SOS.postCheck eq 'true' }">
	             [처리 완료된 글]
	             </c:if></a></td>
	             <td>${SOS.uId}</td>
	             <td>${SOS.stBdate}</td>
	             <td>${SOS.stMdate}</td>
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
		    <li class="page-item"><a class="page-link" href="http://localhost:52525/BaCode/getSOSList.SOS?pageNum=${buttons.startPage-1 }" style="color: #8789C6;">Previous</a></li>
		  </c:if>
		    <c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }"> 
				    <li class="page-item ${(buttons.currentPage eq pageNum) ? 'active' : ' '}" aria-current="page"><a class="page-link" href="http://localhost:52525/BaCode/getSOSList.SOS?pageNum=${pageNum}" style="color : #3E408F;">${pageNum }</a></li>
		    </c:forEach> 
          <c:if test="${buttons.endPage ne buttons.totalPages}">
		    <li class="page-item"><a class="page-link" href="http://localhost:52525/BaCode/getSOSList.SOS?pageNum=${buttons.endPage+1 }" style="color: #8789C6;">Next</a></li>
		  </c:if>
		  </ul>
	</nav>
    <a class="btn" href="http://localhost:52525/BaCode/user/mainSearch.jsp" role="button" aria-disabled="false" id="btn-filed">홈으로</a>
    <c:if test="${managerId ne null}">
	<a class="btn" href="http://localhost:52525/BaCode/user/mainSearchManagerVer.jsp" role="button" aria-disabled="false" id="btn-filed">관리자 홈으로</a>
	</c:if>
	</div><!-- container 끝나는 지점 -->
</body>
</html>