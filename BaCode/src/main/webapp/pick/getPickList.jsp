<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<head>
<style>
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
<title>Insert title here</title>
</head>
<body>
	<h1>/pickList 임시 페이지</h1>
	    ${pickList } <br/>
    <table class="table table-primary table-hover">
       <thead>
           <tr>
              <th>게시글번호</th>
              <th>제목</th>
              <th>찜한날짜</th>
           </tr>
       </thead>
        <tbody>
         <c:forEach var="pick" items="${pickList }">
	          <tr>
	             <td>${pick.postNum}</td>
	             <td><a href="http://localhost:52525/BaCode/getBoardDetail?postnum=${pick.postNum}">${pick.pkTitle}</a></td>
	             <td>${pick.pkBdate}</td>
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
		    <li class="page-item"><a class="page-link" href="http://localhost:52525/BaCode/getPickList?pageNum=${buttons.startPage-1 }">Previous</a></li>
		  </c:if>
		    <c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }"> 
				    <li class="page-item ${(buttons.currentPage eq pageNum) ? 'active' : ' '}" aria-current="page"><a class="page-link" href="http://localhost:52525/BaCode/getPickList?pageNum=${pageNum}">${pageNum }</a></li>
		    </c:forEach> 
          <c:if test="${buttons.endPage ne buttons.totalPages}">
		    <li class="page-item"><a class="page-link" href="http://localhost:52525/BaCode/getPickList?pageNum=${buttons.endPage+1 }">Next</a></li>
		  </c:if>
		  </ul>
	</nav>
    <a href="http://localhost:52525/BaCode/mainSearch" ><button class="btn" id="btn-filed">홈으로</button></a>
</body>
</html>