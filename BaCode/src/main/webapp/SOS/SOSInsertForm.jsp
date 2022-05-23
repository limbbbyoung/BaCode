<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<head>
<script>
</script>
<style>
   input { margin : 10px;}
   body { padding : 20px;}
   a {
	     color : black;
	     text-decoration-line : none;
	  }
   nav { width : 400px;}
   .Categori { width : 400px;}
</style>
<meta charset="UTF-8">
<title>신고글 등록</title>
</head>
<body>
		<div class="container">
		  <div class="row">
		    <div class="col">
		    </div>
		    <div class="col">
		    ${postNum }
		      <h1>신고글 작성</h1>
			     <hr/>
			     <!-- 드롭다운에서 선택된 항목을 기본값으로 가져오기 위한 기능 추가 -->
			     <form action="http://localhost:52525/BaCode/SOSInsert.SOS" method="post">
			     <input type="hidden" value=${postNum } name="postNum">
			     제목 : <input type="text" name="stTitle" placeholder="제목을 입력해주세요."><br/>
			     작성자 : ${uId }<br/>
			     <p>신고글 내용 : </p> <textarea cols="50" rows="12" name="stContent"></textarea><br/><br/>
			     <button type="submit" class="btn btn-success">신고 등록</button>
			     </form><br/>
			     <a href="http://localhost:52525/BaCode/user/mainSearch.jsp"><button class="btn btn-success">돌아가기</button></a>
		    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
</body>
</html>