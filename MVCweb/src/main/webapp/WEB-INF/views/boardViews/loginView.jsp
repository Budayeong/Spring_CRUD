<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<!-- css 수동 설정 -->
<style>
        /* CSS 스타일링 */
        nav {
            width: 70%; /* 가로 길이를 원하는 값으로 조정 */
            margin: 0 auto; /* 가운데 정렬을 위해 필요한 부분 */
            background-color: #f0f0f0; /* 배경색 설정 */
            padding: 10px; /* 내부 여백 설정 */
        }
</style>
<title>Insert title here</title>
</head>
<body>

<!-- 네비게이션 바  -->	
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="getBoardList.do">청년지원 사업</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
      <form class="d-flex">
        <a href = "login.do"><button type="button" class="btn btn-outline-primary">로그인</button></a>&ensp; &ensp; 
	    <a href = "memberJoin.do"><button type="button" class="btn btn-outline-primary">회원가입</button></a>
      </form>
  </div>
</nav>
	


<!-- 로그인 폼 -->
<div class="mb-3 text-center mb-5">
  <h1 class="display-4">로그인</h1>
</div>

<div class="d-flex justify-content-center">
	<form action="loginProcBoard.do" method="post">
		<table border="1px solid gray" style="border-collaps:collapse;">
			<tr align="center" height="50">
				<td width="200">아이디</td>
				<td width="200">
					<input type="text" name="id">
				</td>
			</tr>
			<tr align="center" height="50">
				<td width="200">비밀번호</td>
				<td width="200">
					<input type ="text" name="password">
				</td>
			</tr>
			<tr align="center" height="50">
				<td colspan="2">
					<input type="submit" value="확인">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</div>


</body>
</html>