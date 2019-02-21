<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function searchBtn() {
		var field = document.getElementById("field").value;
		var word = document.getElementById("word").value;
		if (field == "") {
			alert("검색 항목을 선택해주세요")
			return false;
		}
		location.href = "ListBoard?field=" + field + "&word=" + word

	}
</script>
</head>
<body>
	<div align=center>
		<h2>게 시 판</h2>
		<p>게시글수 : ${count }</p>
		<table>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${arr }" var="i">
				<tr>
					<td>${i.seq }</td>
					
					<td><c:if test="${i.boardlevel>0}">
						<img src="resources/level.gif" width="${i.boardlevel*5}" height="16">
						<img src="resources/re.gif">
					</c:if><a href="ViewBoard?seq=${i.seq }">${i.title }</a></td>
					
					<td>${i.writer }</td>
					<td>${i.hitcount }</td>
					<td>${i.regdate }</td>
				</tr>
			</c:forEach>
		</table>
		<br> ${pageHtml } <br> <select id=field name=field>
			<option value="">선택</option>
			<option value=writer>작성자</option>
			<option value=title>제목</option>
			
			<option value=content>내용</option>
		</select> <input type=text id="word" name="word"> <input type="button"
			value="검색" onclick="searchBtn()"><br> <input type=button
			value="전체보기" onclick="location.href='ListBoard'"> <input
			type=button value="글 등록" onclick="location.href='InsertBoard'">
	</div>
</body>
</html>