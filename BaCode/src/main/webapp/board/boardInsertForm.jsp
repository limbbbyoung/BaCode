<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
			     <form id="bo" action="/BaCode/boardInsert.board" method="post">
					   <div class="Categori">
				       <select id="op" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="categori">
						  <option selected disabled>Categori</option>
						  <option value="노트북">노트북</option>
						  <option value="마우스">마우스</option>
						  <option value="키보드">키보드</option>
					   </select>
					   </div>
			     글제목 : <input type="text" id="tit" name="title" placeholder="제목을 입력해주세요."><br/>
			     작성자 : ${uId }<br/>
			     <p>글내용 : </p> <textarea cols="50" rows="12" name="content"></textarea><br/><br/>
			     <button type="submit" id="boardin" onclick="test()" class="btn btn-success">상품 등록하기</button>
			     </form><br/>
			     <a href="http://localhost:52525/BaCode/user/mainSearch.jsp"><button class="btn btn-success">돌아가기</button></a>
			     <!-- <a href="http://localhost:8181/BaCode/" ><button>내 상품 목록 보러가기</button></a> -->
		    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
		<script type="text/javascript">
		$( "#boardin" ).click(function( event ) {
			event.preventDefault();
			if(document.getElementById("tit").value.length < 1) {
				alert("글 제목을 입력해주세요");
			} else if(document.getElementById("tit").value.length > 30) {
				alert("글 제목은 30자 내외입니다.");
 			} else {
 				$("#bo").submit()	
 			}
		});
		</script>
</body>
</html>