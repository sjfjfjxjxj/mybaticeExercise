<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 디테일(내용보이기)</title>
</head>
<body>
	<table>
		<tr>
			<td>${notice.noticeNo}</td>
			<td>${notice.noticeSubject}</td>
			<td>${notice.viewCount}</td>
		</tr>
		<tr>
			<td rowspan="3">${notice.noticeContent}</td>
		</tr>
	</table>
</body>
</html>