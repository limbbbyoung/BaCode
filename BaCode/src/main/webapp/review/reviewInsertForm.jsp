<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
.star-rating {
  display: flex;
  flex-direction: row-reverse;
  font-size: 2.25rem;
  line-height: 2.5rem;
  justify-content: space-around;
  padding: 0 0.2em;
  text-align: center;
  width: 5em;
}
 
.star-rating input {
  display: none;
}
 
.star-rating label {
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 2.3px;
  -webkit-text-stroke-color: #2b2a29;
  cursor: pointer;
}
 
.star-rating :checked ~ label {
  -webkit-text-fill-color: gold;
}
 
.star-rating label:hover,
.star-rating label:hover ~ label {
  -webkit-text-fill-color: #fff58c;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${postNum}
			<div class="container">
		  <div class="row">
		    <div class="col">
		    </div>
		    <div class="col">
		      <h1>Review</h1>
			     <hr/>
			     <div class="star-rating space-x-4 mx-auto">
				 <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
				 <label for="5-stars" class="star pr-4">★</label>
				 <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
				 <label for="4-stars" class="star">★</label>
				 <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
				 <label for="3-stars" class="star">★</label>
				 <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
				 <label for="2-stars" class="star">★</label>
				 <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
				 <label for="1-star" class="star">★</label>
				 </div>
			     <!-- 드롭다운에서 선택된 항목을 기본값으로 가져오기 위한 기능 추가 -->
			     <form action="http://localhost:52525/BaCode/reviewInsert" method="post">
			     <input type="hidden" name="postNum" value="${postNum }">
			     글제목 : <input type="text" name="title" placeholder="제목을 입력해주세요."><br/>
			     작성자 : <input type="text" name="uId" value="${uId }"> <br/>
			     <p>글내용 : </p> <textarea cols="50" rows="15" name="content" placeholder="리뷰를 작성해주세요."></textarea><br/>
			     <button type="submit" class="btn btn-success">등록하기</button>
			     </form>
		    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
</body>
</html>