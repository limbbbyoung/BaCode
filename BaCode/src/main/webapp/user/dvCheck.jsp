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
dv 체크 페이지 입니다.
<div id="header"></div>
<div id="container">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-5 question">
			<p>개발자를 시작하면서 제일 먼저 실습하는 내용의 문구는 무엇인가?</p>
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