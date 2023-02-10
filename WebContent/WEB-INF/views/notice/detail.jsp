<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세조회(내용보이기)</title>
</head>
<body>
	<h1> 공지사항 상세 정보</h1>
	작성자:  ${notice.noticeWriter} / 작성날짜:  ${notice.noticeDate} / 조회수: ${notice.viewCount}
	<h3>제목: ${notice.noticeSubject}</h3>
	<p>내용: ${notice.noticeContent}</p>
	<a href="/notice/list.do">목록으로</a>
	<a href="/notice/modify.do?notice-no=${notice.noticeNo}">수정하기</a>
	
	
	
<!-- 	<a href="javascript:void(0);" onclick="deleteCheck();">삭제하기</a> -->
	<!-- href="#" 이거 쓰면 동작안함 -->
	<form action = "/notice/remove.do" method="post">
		<input type="hidden" name="notice-no" value="${notice.noticeNo}">
		<input type="submit" value="삭제하기" onclick="return deleteCheck();">
	</form>
	
	<script>
		function deleteCheck(){
// 			if(confirm("진짜삭제?")){
// 				return true;
// 			}else{
// 				return false;
// 			}
			if(!confirm("진짜삭제?")){
				return false;
			} //위에거 이렇게 한번에 처리할수도! return true는 생략 가능하므로 ㅇㅇㅇ
		}
	</script>
	<script>
// 		function deleteCheck(){
// 			//기본 이벤트 제거방법: 페이지 이동 안됨
// 			event.preventDefault();
// 			if(confirm("진짜 삭제할거야?")){
// 				//location.href="/notice/remove.do?notice-no="; 이렇게 하면 쿼리스트링 조작하는대로 삭제돼버릴수있어서 별루래
// 			}else{
// 				console.log("안함");
// 			}
// 		}
	</script>
</body>
</html>