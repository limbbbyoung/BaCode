<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<head>
<style>
   input { margin : 10px;}
   body { padding : 20px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="container">
		  <div class="row">
	        <div class="col">
		    </div>
		    <div class="col">
		         <h1>회원가입</h1>
			     <hr/>
			     <form id="frn" action="http://localhost:52525/BaCode/userInsert" method="post">
			     아이디 : <input type="text" name="uId" placeholder="아이디"><br/>
			     비밀번호 : <input type="password" name="uPw" placeholder="비밀번호"><br/>
			     이름 : <input type="text" name="uName" placeholder="이름"><br/>
			     닉네임 : <input type="text" name="uckName" placeholder="닉네임"><br/>
			     이메일 : <input type="email" name="email" placeholder="이메일"><br/>
			     휴대폰 번호 : <input type="tel" name="pNum" placeholder="휴대폰번호"><br/>
			     주소 : <input type="text" name="addr" placeholder="주소"><br/>
			     <textarea cols="60" rows="4">
여러분을 환영합니다.

바코드사의 서비스와 제품을 이용해 주셔서 감사합니다. 본 약관은 우리의 서비스 이용과 관련하여
도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
가입하실 경우 여러분은 본 약관에 동의하시는것이 되므로 잠시 시간을 내어 본약관을
주의 깊게 살펴봐주시길 바랍니다.
			     </textarea><br/>
			     <label><input type="checkbox" id="isAgree" value="true")>개인정보 수집 및 동의</label></br>
			     <button type="submit" id="frm" onclick="test()" class="btn btn-success">회원가입</button>
			     </form>
		    </div>
		    <div class="col">
		    </div>
		  </div>
		</div>
		<script type="text/javascript">
		$( "#frm" ).click(function( event ) {
			event.preventDefault();
			if(document.getElementById("isAgree").checked) {
				alert("체크");
			} else {
				alert("동의버튼을 누르세요");
			}
			  
			});
		</script>
		<pre id='result'>
</pre>
</body>
</html>