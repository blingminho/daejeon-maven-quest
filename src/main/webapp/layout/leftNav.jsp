<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<ul class="nav nav-sidebar">
				<c:choose>
					<c:when test="${pageChoose == 'BoardList'}">
						<li class='active'><a href="${pageContext.request.contextPath }/boardList">BoardList</a></li>
						<li><a href="${pageContext.request.contextPath }/tboardList">BoardControl</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath }/boardList">BoardList</a></li>
						<li class='active'><a href="${pageContext.request.contextPath }/tboardList">BoardControl</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>
