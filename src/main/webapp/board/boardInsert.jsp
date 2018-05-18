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


<link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "<%=request.getContextPath() %>/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$('form').submit();
			}
		}
	})
	
	//파일수 limit
	$('#file').on('change', function() {
		if($('#file')[0].files.length > 5) {
			alert("최대 5개의 파일만 저장 가능합니다");
			$('#file').val('');
		}
	})
	
	
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	var board_title = $('#board_title').val().trim();
	if (board_title == "") {
		alert('제목을 입력해주세요');
		return false;
	}
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}
</script>
</head>
<body>
	<%@ include file="/layout/header.jsp" %>
	<%@ include file="/layout/leftNav.jsp" %>
	<%
		request.setAttribute("board_p_seq", request.getParameter("board_p_seq"));
		request.setAttribute("tboard_title", request.getParameter("tboard_title"));
		request.setAttribute("tboard_seq", request.getParameter("tboard_seq"));
	%>
	<div class="container-fluid">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2 class="sub-header">게시글 입력 - ${tboard_title }</h2>
			<div class="table-responsive">
				<form action="${pageContext.request.contextPath }/boardInsert" enctype="multipart/form-data" method="post">
					<table class="table table-striped">
						<tr>
							<th>부모 게시글 번호</th>
							<td>${board_p_seq }</td>
						</tr>
						<tr>
							<th>게시글 제목</th>
							<td><input type="text" id="board_title" name="board_title" size="145"></td>
						</tr>
						<tr>
							<th>게시글 작성자아이디</th>
							<td>${MemberVO.mem_id}</td>
						</tr>
						<tr>
							<th>게시글 내용</th>
							<td><textarea id="smarteditor" rows="15" cols="150" style="width:766px; height:412px;" name="board_content"></textarea></td> 
						</tr>
						<tr>
							<th>첨부파일</th>
							<td></td>
						</tr>
						<tr><td><input type="file" name="file_path" id="file" multiple></td><td></td></tr>
					</table>
					<input type="hidden" name="board_tboard_seq" value="${tboard_seq }">
					<input type="hidden" name="board_p_seq" value="${board_p_seq }">
					<input type="hidden" value="${MemberVO.mem_id}" name="board_mem_id">
				</form>
				<input type="button" id="savebutton" value="게시글 작성" />
				
			</div>
		</div>
	</div>
</body>
</html>