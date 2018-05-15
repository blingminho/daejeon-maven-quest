<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 - 리스트</title>
<%@include file="/include/jquery.jsp"%>
<%@include file="/include/bootstrap.jsp"%>

<link href="${pageContext.request.contextPath }/css/dashboard.css"
	rel="stylesheet">
<script type="text/javascript">
	$(function() {

	})
</script>
</head>
<body>
	<%@ include file="/layout/header.jsp" %>
	<%@ include file="/layout/leftNav.jsp" %>
	
	<div class="container-fluid">
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h2 class="sub-header">게시판 관리</h2>
			<a
				href="${pageContext.request.contextPath }/board/tboardInsert.jsp"
				class="">게시판 추가</a>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>게시판 번호</th>
							<th>게시판 이름</th>
							<th>게시판 작성일자</th>
							<th>게시판 사용유무</th>
							<th>게시판 작성자아이디</th>
							<th>게시판 사용여부결정</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tboardList}" var="tboardVO">
							<tr>
								<td>${tboardVO.tboard_seq }</td>
								<td>${tboardVO.tboard_title }</td>
								<td><fmt:formatDate value="${tboardVO.tboard_reg_dt }"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>${tboardVO.tboard_del_yn }</td>
								<td>${tboardVO.tboard_mem_id }</td>
								<td>
									<form action="${pageContext.request.contextPath }/tboardUpdate">
										<input type="hidden" value="${tboardVO.tboard_seq}"
											name="tboard_seq">

										<c:if test="${tboardVO.tboard_del_yn == 'Y'}">
										활성:<input type="radio" value="Y" name="tboard_del_yn" checked>
										비활성:<input type="radio" value="N" name="tboard_del_yn">
										</c:if>
										<c:if test="${tboardVO.tboard_del_yn == 'N'}">
										활성:<input type="radio" value="Y" name="tboard_del_yn">
										비활성:<input type="radio" value="N" name="tboard_del_yn" checked>
										</c:if>
										<button type="submit">변경</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>