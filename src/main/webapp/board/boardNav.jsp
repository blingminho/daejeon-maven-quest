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

<link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
<script type="text/javascript">
	

</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">${MemberVO.mem_alias}</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">BoardList</a></li>
					<li><a href="#">BoardControl</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="">BoardList</a></li>
					<li><a href="">BoardControl</a></li>
				</ul>
			</div>
		</div>
	</div>
	<%String choosePage = (String)request.getAttribute("choosePage"); %>
	<%if(choosePage.equals("tboardList")){%>
		<%@ include file="tboardList.jsp"%>
	<%} else if(choosePage.equals("boardList")){%>
		<%@ include file="boardList.jsp"%>
	<%} %>
	
</body>
</html>