<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>공지사항 목록</title>
	<style>
		table{
			border: 1px solid black;
			border-collapse: collapse;
		}
		th, td{
			border : 1px solid black;
		}
	</style>
	</head>
	<body>
		<h1>공지사항 목록</h1>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${nList}" var="notice" varStatus="status">
			<tr>
				<th>${status.count}</th>
				<!-- ${notice.noticeNo}이거는 이빠진대로 번호가 나와서 varStatus를 써봄 
				${status.index}로 하면 0번부터 나옴-->
				<th><a href="/notice/detail.do?notice-no=${notice.noticeNo}">${notice.noticeSubject}</a></th>
				<!-- 하이퍼텍스트로 보내는건 두겟으로!! -->
				<th>${notice.noticeWriter}</th>
				<th>${notice.noticeDate}</th>
				<th>${notice.viewCount }</th>
			</tr>
			</c:forEach>
			<tr>
				<td  colspan="5" align = "center">
					${pageNavi} 
					<!-- 달러 달린 애들은 다 컨트롤러에서 넘어오는 값임! -->
				</td>
			</tr>
			
			<tr><!-- 주말에 연습해보기!! -->
				<form action = "" method="post">	
					<td>
						<select>
							<option>제목</option>
							<option>내용</option>
							<option>작성자</option>
						</select>
					</td>
					<td colspan="3">
						<input type="text">
					</td>
					<td>
						<input type="submit" value="검색">
					</td>
				</form>
			</tr>
		</table>
	</body>
</html>