<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 - 입력</title>
<%@include file="/include/jquery.jsp"%>
<%@include file="/include/bootstrap.jsp"%>

<link href="${pageContext.request.contextPath }/css/dashboard.css"
	rel="stylesheet">
<script type="text/javascript">
	$(function() {
		$('#insert').on('click', function() {
			var tboard_title = $('#tboard_title').val().trim();
			
			if (tboard_title == "") {
				alert('제목을 입력해주세요')
			} else {
				$('form').submit();
			}
		})
	})
</script>
</head>
<body>
	<%@ include file="/layout/header.jsp" %>
	<%@ include file="/layout/leftNav.jsp" %>
	
	<div class="container-fluid">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2 class="sub-header">게시글 입력</h2>
			<div class="table-responsive">
				<form action="${pageContext.request.contextPath }/boardInsert" enctype="multipart/form-data">
					<table class="table table-striped">
						<tr>
							<th>게시글 이름</th>
							<td><input type="text" id="board_title" name="board_title"></td>
							<th></th>
						</tr>
						<tr>
							<th>게시글 작성자아이디</th>
							<td>${MemberVO.mem_id}</td>
						</tr>
						<tr>
							<th>게시글 내용</th>
							<td><textarea rows="15" cols="150" id="board_content" name="board_content"></textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td></td>
						</tr>
						<tr><td><input type="file" name="file_path"></td><td></td></tr>
						<tr><td><input type="file" name="file_path"></td><td></td></tr>
						<tr><td><input type="file" name="file_path"></td><td></td></tr>
						<tr><td><input type="file" name="file_path"></td><td></td></tr>
						<tr><td><input type="file" name="file_path"></td><td></td></tr>
					</table>
					<input type="hidden" value="${MemberVO.mem_id}" name="tboard_mem_id">
					<button type="button" id="insert">게시글 작성</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>