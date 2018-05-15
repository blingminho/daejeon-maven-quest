<%@page import="quest.board.first.vo.TboardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 - 리스트</title>
<%@include file="/include/jquery.jsp"%>
<%@include file="/include/bootstrap.jsp"%>

<link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
<script type="text/javascript">
	$(function() {
		$('#changeTboard').on('click', function(){
			$('#tboardSelectForm').submit();
		})
		
	})
</script>
</head>
<body>
	<%@ include file="/layout/header.jsp" %>
	<%@ include file="/layout/leftNav.jsp" %>

	<div class="container-fluid">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2 class="sub-header">${tboardVO.tboard_title }</h2>
			<form action="${pageContext.request.contextPath }/boardList" id="tboardSelectForm">
				<select id="tboardSelect" name="board_tboard_seq">
					<c:forEach items="${tboardList }" var="tboardVOtemp">
						<option value="${tboardVOtemp.tboard_seq }">${tboardVOtemp.tboard_title }</option>
					</c:forEach>
				</select>
				<button type="button" id="changeTboard" class="btn btn-sm btn-primary">게시판 이동</button>
			</form>
			<a href="${pageContext.request.contextPath }/board/boardInsert.jsp">게시글 추가</a>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>등록일자</th>
							<th>글쓴이</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList }" var="boardVO">
							<tr>
								<td>${boardVO.board_seq }</td>
								<td>
									<c:forEach begin="1" end="${boardVO.LEVEL }" var="i">
										<c:choose>
											<c:when test="${i == boardVO.LEVEL && i != 1}">
												<c:out value="L"/>
											</c:when>
											<c:otherwise>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:otherwise>
										</c:choose>
									</c:forEach>
										${boardVO.board_title }
								</td>
								<td><fmt:formatDate value="${boardVO.board_reg_dt }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${boardVO.board_mem_id }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<!-- pagenation -->
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<%
						int pageCount = (Integer)request.getAttribute("pageCount");
						String pageNumStr = (String)request.getAttribute("pageNum");
						int pageNum = Integer.valueOf(pageNumStr);
						
						String code = "";
						
						if(pageCount != 0){
							TboardVO tboardVO = (TboardVO)request.getAttribute("tboardVO");
							String tboard_seq = tboardVO.getTboard_seq();
							
							if(pageNum != 1){
								code += "<li class='page-item'>";
								code += "	<a class='page-link' href='boardList?pageNum=1&board_tboard_seq=" + tboard_seq + "' aria-label='Previous'>";
								code += "		<span aria-hidden='true'>&laquo;</span>";
								code += "		<span class='sr-only'>Previous</span>";
								code += "	</a>";
								code += "</li>";
								code += "<li class='page-item'>";
								code += "	<a class='page-link' href='boardList?pageNum=" + (pageNum-1) +"&board_tboard_seq=" + tboard_seq + "'>Prev</a>";
								code += "</li>";
							}
							
							
							for(int i = 1; i <= pageCount; i++){
								code += "<li class='page-item'><a class='page-link' href='boardList?pageNum="
										+ i + "&board_tboard_seq=" + tboard_seq + "'>" + i + "</a></li>";
							}
							
							
							if(pageNum != pageCount){
								code += "<li class='page-item'>";
								code += "	<a class='page-link' href='boardList?pageNum=" + (pageNum+1) +"&board_tboard_seq=" + tboard_seq + "'>Next</a>";
								code += "</li>";
								code += "<li class='page-item'>";
								code += "	<a class='page-link' href='boardList?pageNum=" + pageCount + "&board_tboard_seq=" + tboard_seq + "' aria-label='Next'>";
								code += "		<span aria-hidden='true'>&raquo;</span>";
								code += "		<span class='sr-only'>Next</span>";
								code += "	</a>";
								code += "</li>";
							}
						}
						out.print(code);
					%>
							
				</ul>
			</nav>

		</div>
	</div>
</body>
</html>