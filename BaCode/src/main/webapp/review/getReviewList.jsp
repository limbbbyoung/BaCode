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
</style>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	    <h1>/reviewList 임시 페이지</h1>
	    ${reviewList }
    <table class="table table-primary table-hover">
       <thead>
           <tr>
              <th>번호</th>
              <th>제목</th>
              <th>ID</th>
              <th>쓴날짜</th>
              <th>수정날짜</th>
           </tr>
       </thead>
        <tbody>
         <c:forEach var="review" items="${reviewList }">
	          <tr>
	             <td>${review.rvNum}</td>
	             <td><a href="http://localhost:52525/BaCode/getReviewDetail?rvNum=${review.rvNum}">${review.rvTitle}</a></td>
	             <td>${review.uId}</td>
	             <td>${review.rvBdate}</td>
	             <td>${review.rvUdate}</td>
	          </tr>
        </c:forEach>
       </tbody>
    </table>
</body>
</html>