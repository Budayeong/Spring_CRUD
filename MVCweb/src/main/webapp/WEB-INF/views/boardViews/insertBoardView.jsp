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
	<h2> 게시글 추가 </h2>
	<hr>
	<form action="insertProcBoard.do" method="post">
		<table border="1px solid gray" style="border-collaps:collapse;">
			<tr align="center" height="50">
				<td width="200">제목</td>
				<td width="400">
					<input type="text" style="width:300px;" name="title">
				</td>
			</tr>
			<tr align="center" height="50">
				<td width="200">주관 기관</td>
				<td width="200">
					<input type ="text" style="width:300px;" name="writer">
				</td>
			</tr>
			<tr align="center" height="50">
				<td width="200">내용</td>
				<td width="400">
					<textarea name="content" style="width:300px; height:50px;"></textarea>					
					<!-- <input type="text" style="width:300px; height:50px;" name="content"> -->
				</td>
			</tr>
			 <tr align="center" height="50">
                <td width="200">신청 기간</td>
                <td width="200">
                    <input type="text" style="width: 300px;" name="time">
                </td>
            </tr>
            <tr align="center" height="50">
                <td width="200">신청 마감</td>
                <td width="200">
                    <input type="date" style="width: 300px;" name="endtime">
                </td>
            </tr>
            <tr align="center" height="50">
                <td width="200">신청 사이트</td>
                <td width="200">
                    <input type="text" style="width: 300px;" name="webname">
                    <input type="text" style="width: 300px;" name="website">
                </td>
            </tr>
            
			<tr align="center" height="50">
				<td colspan="2">
					<input type="submit" value="추가하기">
					<input type="reset" value="취소하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>