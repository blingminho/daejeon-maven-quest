<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">${MemberVO.mem_alias}</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath }/boardList">BoardList</a></li>
				<li><a href="${pageContext.request.contextPath }/tboardList">BoardControl</a></li>
			</ul>
		</div>
	</div>
</nav>