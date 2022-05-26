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
     #btn-filed {
	        display: inline-block;
	        padding: 13px 20px;
	        background-color:#6667AB; 
	        color: white;
	        border-radius: 20px;
	        text-align: center;
	        line-height: 100%;
	    }
	 .container {
	   	margin-top: 30px; 
	 }

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
		      <h1 style="color: #3E408F;">신고글 작성</h1>
			    <form action="http://localhost:52525/BaCode/SOSInsert.SOS" method="post">
			     <input type="hidden" value=${postNum } name="postNum">
			     <input class="form-control" type="text" name="stTitle" placeholder="제목을 입력해주세요."><br/>
			     작성자 : <b>${uId }</b><br/>
			     <p>신고글 내용 : </p> <textarea class="form-control" cols="50" rows="12" name="stContent"></textarea><br/><br/>
			     <button type="submit" class="btn" id="btn-filed">신고 등록</button>
			     </form><br/>
			     <a href="http://localhost:52525/BaCode/user/mainSearch.jsp"><button class="btn" id="btn-filed">돌아가기</button></a>
		    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
</body>
</html>