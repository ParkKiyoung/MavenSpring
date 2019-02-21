<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function updateSubmit(){
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
function deleteBoard(num){
	if(confirm("정말 삭제하시겠습니까?")){
		location.href="deleteBoard?seq="+num
	}
}
</script>
</head>
<body>
	<div align=center>
		<h2>작성 글 수정하기</h2>
		<form action="update" id=frm method=post>
			<table>
				<tr>
					<td><input type = hidden id = seq name=seq value="${dto.seq }">글 제목</td>
					<td><input type="text" id=title name="title" value = "${dto.title }"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" id=writer name="writer" value="${dto.writer }"></td>
					<td>비밀번호</td>
					<td><input type="password" id=password name="password"></td>
				</tr>
				<tr>
					<td colspan=4 align=center>글 내용</td>
				</tr>
				<tr>
					<td colspan=4><textarea id=content name=content rows=20 cols=60>${dto.content }</textarea></td>
				</tr>
			</table>
			<input type = "button" onclick = "updateSubmit()" value = "수정">
			<input type = "button" onclick = "location.href='ListBoard'" value = "글목록">
			<input type = "button" onclick = "deleteBoard(${dto.seq})" value = "삭제">
			<input type = "reset" value="다시작성">
		</form>
	</div>
</body>
</html>