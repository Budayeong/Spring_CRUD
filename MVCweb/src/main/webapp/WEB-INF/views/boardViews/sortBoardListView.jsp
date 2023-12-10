<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
    <a class="navbar-brand" href="#">청년지원 사업</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
      <form class="d-flex">
        <a href = "login.do"><button type="button" class="btn btn-outline-primary">로그인</button></a>&ensp; &ensp; 
	    <a href = "memberJoin.do"><button type="button" class="btn btn-outline-primary">회원가입</button></a>
      </form>
  </div>
</nav>



<!-- 메인화면 이미지 -->
<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel"> 
  <div class="carousel-inner">
   <div class="carousel-item active text-center" > <!-- text-center 클래스 추가 -->
      <img src="resources/city.jpg" class="d-block mx-auto" alt="..." width="70%"> <!-- d-block mx-auto 클래스 추가 -->
       <div class="carousel-caption d-none d-md-block">
        <h1>서울특별시 청년지원 사업</h1>
        <p>서울특별시 거주민 대상 청년지원 사업 목록</p>
      </div>
    </div>
  </div>  
</div>



<!-- 게시판 -->
<div class="container mt-4">
	  <!-- 정렬 -->
	<div class="row">
	  <div class="col-md-6">
	    <div class="dropdown">
	      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
	        정렬 기준
	      </button>
	      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
	        <li><a class="dropdown-item" href="sortBoardList.do?sort=신청마감">신청 마감</a></li>
	        <li><a class="dropdown-item" href="sortBoardList.do?sort=사이트">신청 사이트</a></li>
	      </ul>
	    </div>
	  </div>
	  <!-- 검색 -->
	  <div class="col-md-6 text-end">
	    <form action="searchBoardList.do" method="post" id="searchFoam" name="search-form">
	      <select name="type" class="type-box">
	        <option value="">검색 유형 선택</option>
	        <option value="title">제목</option>
	        <option value="writer">주관기관</option>
	        <option value="content">내용</option>
	        <option value="time">신청 기간</option>
	        <option value="endtime">신청 마감</option>
	        <option value="webname">신청 사이트</option>
	      </select>
	      <input class="inputId" type="text" name="keyword" placeholder="검색어 입력">
	      <input class="submitBtn" type="submit" value="검색하기">
	    </form>
	  </div>
	</div>
	<!-- 게시판  내용-->
	<table border="1px solid gray" style="border-collaps:collapse;">
		<tr align="center" height="50">
			<td width="200">번호</td>
			<td width="200">제목</td>
			<td width="200">주관기관</td>
			<td width="400">내용</td>
			<td width="200">신청 기간</td>
			<td width="200">신청 마감</td>
			<td width="200">신청 사이트</td>
		</tr>
		<!-- jstl을 이용하여 데이터 출력 -->
		<c:forEach items="${bList}" var="board">
			<tr align="center" height="50">
			<td width="200">${board.seq}</td>
			<td width="300">
				<a href="getBoard.do?seq=${board.seq}">${board.title}</a>
			</td>
			<td width="200">${board.writer}</td>
			<td width="500">${board.content}</td>
			<td width="200">${board.time}</td>
			<td width="200">${board.endtime}</td>
			<td width="200"><a href="${board.website}" title="바로가기">${board.webname}</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
	
</body>
</html>