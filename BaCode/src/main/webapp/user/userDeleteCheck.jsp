<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${user} 
	 <form action="/BaCode/userDelete" method="post">
	 <input type="hidden" name="uId" value="${user.uId }">
    <input type="hidden" id="password1" value="${user.uPw }" ><br/>
    비밀번호확인 : <input type="password" id="password2" >
    <input type="submit" onclick="test()" value="비밀번호 확인">
  </form>
  <a href="/BaCode/getUserDetail"><button>돌아가기</button></a>
 
  <script type="text/javascript">
  function test() {
      var p1 = document.getElementById("password1").value;
      var p2 = document.getElementById("password2").value;
      if( p1 != p2 ) {
        alert("비밀번호가 일치 하지 않습니다");
        return false;
      } else{
        alert("비밀번호가 일치합니다");
        
        return true;
      }

    }
  </script>
</body>
</html>