<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<html>
<head>
<style>
	#c {
		display: inline-block;
        padding: 13px 20px;
        background-color:#6667AB; 
        color: white;
        border-radius: 20px;
        text-align: center;
        line-height: 100%;
	}
	#header {
		height : 250px;
	}
	.question {
		
	}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header"></div>
<div id="container">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-5 question">
			<p>한국에서 가장 많이 쓰는 프로그래밍 언어는?(영문 입력)</p>
			<form action="/BaCode/answerRight.do" method="post">
			정답 : <input type="text" name="answer" placeholder="카멜케이스로 입력해주세요" style="width:300px;">
			<input type="submit" id="c" class="btn" value="제출" onKeypress="javascript:if(event.keyCode==13) {search_onclick_submit}"> 
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
</body>
</html>