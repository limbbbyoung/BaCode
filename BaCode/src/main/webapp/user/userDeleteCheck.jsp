<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${user} 
	<form id="de" action="/BaCode/userDelete" method="post">
		<input type="hidden" name="uId" value="${user.uId }">
	    <input type="hidden" id="password1" value="${user.uPw }" ><br/>
	    비밀번호확인 : <input type="password" id="password2" >
	    <button type="submit" id="delete" onclick="test()" class="btn btn-success">비밀번호 확인</button>
  	</form>
  <a href="/BaCode/getUserDetail"><button>돌아가기</button></a>
 
		<script type="text/javascript">
		$( "#delete" ).click(function( event ) {
			event.preventDefault();
			var p1 = document.getElementById("password1").value;
			var p2 = document.getElementById("password2").value;
			if(p1 === p2) {
				$("#de").submit()
			} else {
				alert("비밀번호가 다릅니다.");
			}

		});
		</script>
</body>
</html>