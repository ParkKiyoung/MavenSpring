<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function insertOpinion() {
		var title = document.getElementById("title").value
		var content = document.getElementById("content").value
		var writer = document.getElementById("writer").value
		var password = document.getElementById("password").value
		if (title == "" || content == "" || writer == "" || password == "") {
			alert("모든 항목을 입력하세요");
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<div align=center>
		<h2>답글 등록하기</h2>

		${title }의 답글 입니다.
		<form action="InsertOpinion" name="frm" id=frm method=post>
			<input type=hidden id=seq name=seq value="${seq }"> 
			<input type=hidden id=boardlevel name=boardlevel value="${boardlevel }">
			<input type=hidden id=steps name=steps value="${steps }">
			<input type=hidden id=groups name=groups value="${groups }">
			<table>
				<tr>
					<td>글 제목</td>
					<td><input type="text" id=title name="title"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" id=writer name="writer"></td>
					<td>비밀번호</td>
					<td><input type="password" id=password name="password"></td>
				</tr>
				<tr>
					<td colspan=4 align=center>글 내용</td>
				</tr>
				<tr>
					<td colspan=4><textarea id=content name=content rows=20
							cols=60></textarea></td>
				</tr>
			</table>
			<input type="button" onclick="insertOpinion()" value="제출"> <input
				type="button" onclick="location.href='ListBoard'" value="글목록">
			<input type="reset" value="다시작성">
		</form>
	</div>
</body>
</html>