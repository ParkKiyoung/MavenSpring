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
function upBtn(){
	var password = document.getElementById("password").value
	var seq = document.getElementById("seq").value
	if(password==""){
		alert("비밀번호를 입력해주세요");
		return false;
	}
	frm.submit();
}
function opinionBtn(num,title,boardlevel,steps,groups){
	location.href="opinion?seq="+num+"&title="+title+"&boardlevel="+boardlevel+"&steps="+steps+"&groups="+groups
}
function replyBtn(){
	var name = document.getElementById("name").value
	var password = document.getElementById("pass").value
	var reply = document.getElementById("reply").value
	if(name==""||password==""||reply==""){
		alert("내용을 모두 입력 하세요")
		return false;
	}
	re_frm.submit();
}
</script>
</head>
<body>
	<div align=center>
		<h2>작성 글 보기</h2>
		<form action="passcheck" id=frm method=post>
			<table>
				<tr>
					<td>글 제목</td>
					<th colspan=3><input type=hidden id=seq name=seq
						value="${dto.seq }"> <input type=hidden id=boardlevel
						name=boardlevel value="${dto.boardlevel}"> <input
						type=hidden id=steps name=steps value="${dto.steps}"> <input
						type=hidden id=steps name=steps value="${dto.groups}">
						${dto.title }</th>
				</tr>
				<tr>
					<td>작성자</td>
					<th>${dto.writer }</th>
					<td>비밀번호</td>
					<th><input type="password" id=password name=password size=10></th>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${dto.regdate }</td>
					<td>조회수</td>
					<td>${dto.hitcount }</td>
				</tr>
				<tr>
					<td colspan=4 align=center>글 내용</td>
				</tr>
				<tr>
					<td colspan=4><textarea id=content name=content rows=20
							cols=60 readonly>${dto.content }</textarea></td>
				</tr>
			</table>
		</form>
		<input type="button" onclick="upBtn()" value="수정"> <input
			type="button" onclick="location.href='ListBoard'" value="글목록">
		<input type="button"
			onclick="opinionBtn(${dto.seq},'${dto.title }',${dto.boardlevel},${dto.steps},${dto.groups})"
			value="답글"> <br> <br>
		<form action="replyAction" id=re_frm>
			<input type=hidden id=boardnum name=boardnum value="${dto.seq }">
			<table>
				<tr>
					<td colspan=3>이름 <input type=text id=name name=name size=10>
						비밀번호 <input type=password id=pass name=pass size=10></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan=3><input type=text id=reply name=reply size=40></td>
					<td><input type=button value="댓글쓰기" onclick="replyBtn()">
					</td>
				</tr>
			</table>
		</form>
		<table>
			<tr>
				<th>이름</th>
				<th>내용</th>
				<th>작성시간</th>
			</tr>
			<c:forEach items="${arr }" var="i">
				<tr>
					<td>${i.name }</td>
					<td width=200>${i.reply }</td>
					<td>${fn:replace(i.re_date,' ','<br>')}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script>
if(${checknum}==0){
	alert("비밀번호가 다릅니다.")
	history.back();
};
</script>
</html>
