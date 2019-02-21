<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function insertSubmit(){
	var title = document.getElementById("title").value
	var content =document.getElementById("content").value
	var writer = document.getElementById("writer").value
	var password = document.getElementById("password").value
	if(title==""||content==""||writer==""||password==""){
		alert("모든 항목을 입력하세요");
		return false;
	}
	frm.submit();
}
</script>
</head>
<body>
	<div align=center>
		<h2>작성 글 등록하기</h2>
		<form action="InsertBoard" id=frm method=post>
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
					<td colspan=4><textarea id=content name=content rows=20 cols=60></textarea></td>
				</tr>
			</table>
			<input type = "button" onclick = "insertSubmit()" value = "제출">
			<input type = "button" onclick = "location.href='ListBoard'" value = "글목록">
			<input type = "reset" value="다시작성">
		</form>
	</div>
</body>
</html>