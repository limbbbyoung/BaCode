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
	     color : black;
	     text-decoration-line : none;
	  }
	a:hover { color:white; }
</style>
<meta charset="UTF-8">
<title>신고 목록</title>
</head>
<body>
	${SOSList }
    <h1 style="color : #8789C6;">신고목록 페이지</h1>
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
    ${buttons }
      <!-- foreach문의 start, end속성을 이용해 숫자를 알맞게 깔아주세요. -->
    <nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		  <!-- 이전 10개 페이지 조회버튼을 출력합니다.
          현재 조회중인 페이지가 1~10 페이지가 아닐때만, 첫페이지 -1을 목표주소로 해서 prev 버튼을 만들면 됩니다. -->
          <c:if test="${buttons.startPage ne 1}">
		    <li class="page-item"><a class="page-link" href="http://localhost:52525/BaCode/getSOSList.SOS?pageNum=${buttons.startPage-1 }">Previous</a></li>
		  </c:if>
		    <c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }"> 
				    <li class="page-item ${(buttons.currentPage eq pageNum) ? 'active' : ' '}" aria-current="page"><a class="page-link" href="http://localhost:52525/BaCode/getSOSList.SOS?pageNum=${pageNum}">${pageNum }</a></li>
		    </c:forEach> 
          <c:if test="${buttons.endPage ne buttons.totalPages}">
		    <li class="page-item"><a class="page-link" href="http://localhost:52525/BaCode/getSOSList.SOS?pageNum=${buttons.endPage+1 }">Next</a></li>
		  </c:if>
		  </ul>
	</nav>
    <a class="btn" href="http://localhost:52525/BaCode/user/mainSearch.jsp" role="button" aria-disabled="false" style="background-color : #8789C6; color: white;">홈으로</a>
    <c:if test="${managerId ne null}">
	<a class="btn" href="http://localhost:52525/BaCode/user/mainSearchManagerVer.jsp" role="button" aria-disabled="false" style="background-color : #8789C6; color: white;">관리자 홈으로</a>
	</c:if>
</body>
</html>