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
<title>BaCode 상품 등록</title>
</head>
<body>
		<div class="container">
		  <div class="row">
		    <div class="col">
		    </div>
		    <div class="col">
		      <h1>상품 등록</h1>
			     <hr/>
			     <!-- 드롭다운에서 선택된 항목을 기본값으로 가져오기 위한 기능 추가 -->
					   <div class="Categori">
				       <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="Categori">
						  <option selected>Categori</option>
						  <option value="노트북">노트북</option>
						  <option value="마우스">마우스</option>
						  <option value="키보드">키보드</option>
					   </select>
					   </div>
			     <form action="http://localhost:8181/BaCode/boardInsert" method="post">
			     글제목 : <input type="text" name="title" placeholder="제목을 입력해주세요."><br/>
			     작성자 : 로그인 후 받아온 정보로 닉네임 보여주기<br/>
			     <p>글내용 : </p> <textarea cols="50" rows="15" name="content"></textarea><br/><br/>
			     <button type="submit" class="btn btn-success">상품 등록하기</button>
			     </form>
			     <!-- <a href="http://localhost:8181/BaCode/" ><button>내 상품 목록 보러가기</button></a> -->
		    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
</body>
</html>