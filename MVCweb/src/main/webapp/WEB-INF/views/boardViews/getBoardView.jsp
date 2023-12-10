<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 지원 사업 내용보기</h2>
	<hr>
	<table border="1px solid gray" style="border-collaps:collapse;">
		<tr align="center" height="50">
			<td width="200">번호</td>
			<td width="200">${board.seq}</td>
		</tr>
		<tr align="center" height="50">
			<td width="200">제목</td>
			<td width="200">${board.title}</td>
		</tr>
		<tr align="center" height="50">
			<td width="200">주관기관</td>
			<td width="200">${board.writer}</td>
		</tr>
		<tr align="center" height="50">
			<td width="200">내용</td>
			<td width="700">${board.content}</td>
		</tr>
		<tr align="center" height="50">
			<td width="200">신청 기간</td>
			<td width="200">${board.time}</td>
		</tr>
		<tr align="center" height="50">
			<td width="200">신청 마감</td>
			<td width="200">${board.endtime}</td>
		</tr>
		<tr align="center" height="50">
			<td width="200">신청 사이트</td>
			<td width="200"><a href="${board.website}" title="바로가기">${board.webname}</a></td>
		</tr>
		<tr align="center" height="50">
			<td colspan="2">
				<input type="button" value="수정하기" onclick="location.href='modifyBoard.do?seq=${board.seq}'">
				<input type="button" value="삭제하기" onclick="location.href='deleteBoard.do?seq=${board.seq}'">
				<input type="button" value="목록보기" onclick="location.href='getBoardList.do'">
			</td>
		</tr>
	</table>

</body>
</html>