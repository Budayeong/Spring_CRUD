<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 전체 게시판 데이터 보기 (getBoardListView.jsp) </h2>
	<hr>
	<a href = "insertBoard.do"> 새로운 데이터 추가 </a> <br>
	<a href = "memberJoin.do"> 회원 가입 </a> <br>
	<a href = "login.do"> 로그인 </a>
	<!-- 검색 -->
	<form action="searchBoardList.do" method="post" id="searchFoam" name="search-form">
        <select name="type" class="type-box">
			<option value="">검색 유형 선택</option>
			<option value="title">제목</option>
			<option value="writer">작성자</option>
			<option value="content">글내용</option>
		</select>
		<td colspan="2">
          <input class="inputId" type="text" name="keyword" placeholder="검색어 입력">
        </td>
		<td>
          <input class="submitBtn" type="submit" value="검색하기">
		</td>
	</form>

	<table border="1px solid gray" style="border-collaps:collapse;">
		<tr align="center" height="50">
			<td width="200">번호</td>
			<td width="200">글제목</td>
			<td width="200">글작성자</td>
			<td width="200">글내용</td>
		</tr>
		<!-- jstl을 이용하여 데이터 출력 -->
		<c:forEach items="${bList}" var="board">
			<tr align="center" height="50">
			<td width="200">${board.seq}</td>
			<td width="200">
				<a href="getBoard.do?seq=${board.seq}">${board.title}</a>
			</td>
			<td width="200">${board.writer}</td>
			<td width="200">${board.content}</td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>