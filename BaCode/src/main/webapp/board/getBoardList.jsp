
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
	<!-- ${boardList } -->
    <h1>/boardList 임시 페이지</h1>
    <table class="table table-primary table-hover">
       <thead>
           <tr>
              <th>글번호</th>
              <th>글제목</th>
              <th>글쓴이</th>
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
	             <td><a href="http://localhost:52525/BaCode/getBoardDetail?postnum=${board.postNum}">${board.title}</a></td>
	             <td>${board.uId}</td>
	             <td>${board.bdate}</td>
	             <td>${board.mdate}</td>
	             <td>${board.hit}</td>
	          </tr>
        </c:forEach>
       </tbody>
    </table>
    <a href="http://localhost:52525/BaCode/userInsertForm" ><button>글 쓰기</button></a>
    <a href="http://localhost:52525/BaCode/mainSearch" ><button>홈으로</button></a>
</body>
</html>