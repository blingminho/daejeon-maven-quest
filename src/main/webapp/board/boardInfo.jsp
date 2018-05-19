<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 - 조회</title>
<%@include file="/include/jquery.jsp"%>
<%@include file="/include/bootstrap.jsp"%>

<link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
<script type="text/javascript">
	$(function(){
		var commentLen = 0;
		$('#comments').on('keyup', function(){
			commentLen = $(this).val().length;
			if (commentLen > 500) {
				commentLen = 500;
			}
			$('#commentLength').text(commentLen);
		})
		
		$('#addComment').on('click', function(){
			var comment = $('#comments').val();
			alert(comment);
			//폼태그에 넣어서 전송~!
			
		})
		
		
	})
</script>
</head>
<body>
	<%@ include file="/layout/header.jsp" %>
	<%@ include file="/layout/leftNav.jsp" %>
	
	<%
		request.setAttribute("tboard_title", request.getParameter("tboard_title"));
	%>
	
	
	<div class="container-fluid">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2 class="sub-header">게시글 조회 - ${boardVO.board_title }</h2>
			<a class="btn btn-sm btn-info" 
			href="board/boardInsert.jsp?tboard_title=${tboard_title }
			&tboard_seq=${boardVO.board_tboard_seq }
			&board_p_seq=${boardVO.board_seq}">게시글 달기</a>
			
			<c:if test="${boardVO.board_mem_id == MemberVO.mem_id}">
				<a class="btn btn-sm btn-warning" href="boardUpdatePage?board_seq=${boardVO.board_seq}">게시글 수정</a>
				<a class="btn btn-sm btn-danger" 
				href="boardDelete?board_tboard_seq=${boardVO.board_tboard_seq}
				&board_seq=${boardVO.board_seq}">게시글 삭제</a>
			</c:if>
			<br><hr>
			<div class="table-responsive">
				<table class="table table-striped">
					<tr>
						<th>부모 게시글 번호</th>
						<td>${boardVO.board_p_seq }</td>
					</tr>
					<tr>
						<th>게시글 제목</th>
						<td>${boardVO.board_title }</td>
					</tr>
					<tr>
						<th>게시글 작성자아이디</th>
						<td>${MemberVO.mem_id}</td>
					</tr>
					<tr>
						<th>게시글 내용</th>
						<td>${boardVO.board_content }</td> 
					</tr>
					<tr>
						<th>첨부파일</th>
						<td></td>
					</tr>
					<tr><td><a href="${pageContext.request.contextPath }/fileDown?fileName=${fileAddVOList[0].file_path }">${fileAddVOList[0].file_path }</a></td><td></td></tr>
					<tr><td><a href="${pageContext.request.contextPath }/fileDown?fileName=${fileAddVOList[1].file_path }">${fileAddVOList[1].file_path }</a></td><td></td></tr>
					<tr><td><a href="${pageContext.request.contextPath }/fileDown?fileName=${fileAddVOList[2].file_path }">${fileAddVOList[2].file_path }</a></td><td></td></tr>
					<tr><td><a href="${pageContext.request.contextPath }/fileDown?fileName=${fileAddVOList[3].file_path }">${fileAddVOList[3].file_path }</a></td><td></td></tr>
					<tr><td><a href="${pageContext.request.contextPath }/fileDown?fileName=${fileAddVOList[4].file_path }">${fileAddVOList[4].file_path }</a></td><td></td></tr>
					
					
					<tr><td></td><td></td></tr>
					<tr><th>댓글</th><td></td></tr>
					<tr>
						<th><p id="commentLength"></p> / 500<br><button type="button" id="addComment">댓글작성</button></th>
						<td><textarea rows="5" cols="120" maxlength="500" id="comments"></textarea></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>