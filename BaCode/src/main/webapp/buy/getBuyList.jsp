<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/buyList 임시 페이지</h1>
	    ${buyList }
    <table class="table table-primary table-hover">
       <thead>
           <tr>
              <th>번호</th>
              <th>제목</th>
              <th>ID</th>
              <th>구매날짜</th>
           </tr>
       </thead>
        <tbody>
         <c:forEach var="buy" items="${buyList }">
	          <tr>
	             <td>${buy.buyNum}</td>
	             <td>${buy.title}</td>
	             <td>${buy.buyBdate}</td>
	          </tr>
        </c:forEach>
       </tbody>
    </table>
</body>
</html>